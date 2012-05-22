/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.business.invoice;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.*;
import roomanizer.teamb.data.IntegrateFacade;
import roomanizer.teamb.service.integrate.IBHotel;
import roomanizer.teamb.service.integrate.IBRechnung;
import roomanizer.teamb.service.integrate.IBRechnungsPosition;
import roomanizer.teamb.service.integrate.IBTeilzahlung;

/**
 * Klasse um ein PDF aus einer Rechnung zu generieren
 *
 * @author Michael
 */
public class PdfCreator extends AbstractPDFGenerator implements IPDFGenerator {

    private Document doc;
    private String gast_surname;
    private String gast_firstname;
    private String gast_address;
    private String gast_plz;
    private String gast_ort;
    private String gast_land;
    private String rechnungsnummer;
    private List rechnungspositionen;
    private List teilzahlungen;
    private Font standard;
    private Font fett;
    private Font ueberschrift;
    private Font footerFont;
    private NumberFormat euro;
    private DateFormat date;
    private BigDecimal netto;
    private BigDecimal taxesTotal;
    private String footer;
    private IBHotel stammdaten;

    /**
     *
     */
    public PdfCreator() {
        doc = new Document();
        standard = FontFactory.getFont("Verdana", 11);
        fett = FontFactory.getFont("Verdana", 11, Font.BOLD);
        ueberschrift = FontFactory.getFont("Verdana", 15, Font.BOLD | Font.ITALIC);
        footerFont = FontFactory.getFont("Verdana", 8);
        euro = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        date = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMANY);
        netto = new BigDecimal(0);
        taxesTotal = new BigDecimal(0);
        stammdaten = IntegrateFacade.getHotel();


    }

    /**
     * Erstellt das PDF
     *
     * @param filename Dateiname des PDF
     * @param rechnung Rechnung die ausgedruckt werden soll
     * @throws FileNotFoundException Datei wurde nicht Gefunden
     * @throws DocumentException Document konnte nicht erstellt werden
     */
    @Override
    public void create(String filename, IBRechnung rechnung) throws FileNotFoundException, DocumentException {
        if (filename == null || rechnung == null) {
            return;
        } else {

            this.gast_firstname = rechnung.getFirstname();
            this.gast_surname = rechnung.getSurname();
            this.gast_address = rechnung.getAddress();
            this.gast_plz = rechnung.getPostalCode();
            this.gast_ort = rechnung.getLocation();
            this.gast_land = rechnung.getCountry().getBezeichnung();
            this.rechnungsnummer = rechnung.getRechnungsNummer();

            this.teilzahlungen = new ArrayList<IBTeilzahlung>(rechnung.getBTeilzahlungen());
            this.rechnungspositionen = new ArrayList<IBRechnungsPosition>(rechnung.getRechnungsPositionen());
            Collections.sort(this.rechnungspositionen, new RepoDatumComparator());

            File location = new File(filename);
            if (!new File(location.getParent()).exists()) {
                new File(location.getParent()).mkdir();
            }

            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(filename));

            writer.setPageEvent(new FootWriter());

            doc.open();

            insertHeader();
            insertTable();
            insertSum();
            insertPartPayment();

            doc.close();
        }
    }

    /**
     * @deprecated Veraltet
     * @param filename
     * @param rechnung
     */
    @Override
    public void createPreview(String filename, IBRechnung rechnung) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void insertHeader() throws DocumentException {
        Paragraph hotelP = new Paragraph();
        hotelP.setFont(standard);

        hotelP.add(new Chunk(stammdaten.getName() + "\n", ueberschrift));
        hotelP.add(stammdaten.getStrasse() + ", " + stammdaten.getPlz() + " " + stammdaten.getOrt() + ", " + stammdaten.getLand() + "\n");
        hotelP.add("Phone: " + stammdaten.getTelefonummer() + ", Fax: " + stammdaten.getFaxnummer() + "\n");
        hotelP.add("_________________________________________________________");
        hotelP.setAlignment(Element.ALIGN_CENTER);
        hotelP.setSpacingAfter(35);
        doc.add(hotelP);

        Paragraph gastP = new Paragraph();
        gastP.setFont(standard);
        gastP.add(new Chunk(gast_firstname + " " + gast_surname + "\n", fett));
        gastP.add(gast_address + "\n");
        gastP.add(gast_plz + " " + gast_ort + "\n");
        gastP.add(gast_land);
        doc.add(gastP);

        Paragraph rechnungsNrP = new Paragraph();
        rechnungsNrP.setFont(standard);
        rechnungsNrP.add("Invoice Number: " + rechnungsnummer + "\n");
        rechnungsNrP.add("Invoice Date: " + date.format(new Date()));
        rechnungsNrP.setAlignment(Element.ALIGN_RIGHT);
        doc.add(rechnungsNrP);

    }

    private void insertTable() throws DocumentException {
        Paragraph rechnungP = new Paragraph();
        rechnungP.setFont(ueberschrift);
        rechnungP.add("Invoice");
        rechnungP.setSpacingBefore(30);
        rechnungP.setSpacingAfter(15);
        doc.add(rechnungP);

        float[] colsWidth = {0.8f, 0.6f, 2f, 0.6f, 0.5f, 0.8f, 0.8f};
        PdfPTable positionen = new PdfPTable(colsWidth);
        positionen.getDefaultCell().setPadding(5);

        positionen.addCell(new Phrase("Date", standard));
        positionen.addCell(new Phrase("Amount", standard));
        positionen.addCell(new Phrase("Invoice Line", standard));
        positionen.addCell(new Phrase("Room", standard));
        positionen.addCell(new Phrase("Taxrate", standard));
        positionen.addCell(new Phrase("Unit Price", standard));
        positionen.addCell(new Phrase("Total Price", standard));

        HashMap<Timestamp, HashMap<String, RechnungsposHelper>> summary = summarizeRechnungspositionen();
        PdfPCell priceCell = new PdfPCell();
        priceCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        priceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        for (Timestamp t : summary.keySet()) {
            HashMap<String, RechnungsposHelper> pos = summary.get(t);

            for (RechnungsposHelper rp : pos.values()) {

                BigDecimal summe = rp.getEinzelpreis().multiply(new BigDecimal(rp.getAnzahl()));
                positionen.addCell(new Phrase(date.format(t), standard));
                positionen.addCell(new Phrase(Integer.toString(rp.getAnzahl()), standard));
                positionen.addCell(new Phrase(rp.getBezeichnung(), standard));
                positionen.addCell(new Phrase(rp.getZimmer(), standard));
                positionen.addCell(new Phrase(String.valueOf(rp.getUst_satz()) + "%", standard));
                priceCell.setPhrase(new Phrase(euro.format(rp.getEinzelpreis().doubleValue()), standard));
                positionen.addCell(priceCell);
                priceCell.setPhrase(new Phrase(euro.format(summe.doubleValue()), standard));
                positionen.addCell(priceCell);
            }

        }

        positionen.setWidthPercentage(100);
        doc.add(positionen);
    }

    private HashMap<Timestamp, HashMap<String, RechnungsposHelper>> summarizeRechnungspositionen() {

        LinkedHashMap summary = new LinkedHashMap<Timestamp, HashMap<String, RechnungsposHelper>>();
        Iterator i = rechnungspositionen.iterator();

        while (i.hasNext()) {
            IBRechnungsPosition tempR = (IBRechnungsPosition) i.next();

            if (summary.get(tempR.getDate()) == null) {
                summary.put(tempR.getDate(), new HashMap<String, RechnungsposHelper>());
            }

            HashMap thisDate = (HashMap<String, RechnungsposHelper>) summary.get(tempR.getDate());

            String key = tempR.getBLeistung().getBezeichnung() + " ("
                    + tempR.getUnitPrice().toString() + ", " + tempR.getBZimmer().getNumber() + ")";

            RechnungsposHelper temp = (RechnungsposHelper) thisDate.get(key);
            if (temp == null) {
                temp = new RechnungsposHelper(tempR.getAmount(), tempR.getBLeistung().getBezeichnung(),
                        tempR.getUnitPrice(), tempR.getBZimmer().getNumber(), tempR.getTaxRate());
            } else {
                temp.increaseAnzahl(tempR.getAmount());
            }

            thisDate.put(key, temp);
            summary.put(tempR.getDate(), thisDate);
        }

        return summary;
    }

    private void insertSum() throws DocumentException {

        float[] colsWidth = {1f, 1f};
        PdfPTable sum = new PdfPTable(colsWidth);
        sum.setSpacingBefore(10);
        sum.setWidthPercentage(50);
        sum.setHorizontalAlignment(Element.ALIGN_RIGHT);
        sum.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        sum.addCell(new Phrase("Subtotal:", standard));
        PdfPCell priceCell = new PdfPCell();
        priceCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        priceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        priceCell.setBorder(Rectangle.NO_BORDER);
        priceCell.setPhrase(new Phrase(euro.format(calculateSumNetto().doubleValue()), standard));
        sum.addCell(priceCell);

        List<String> taxes = calculateTaxes();
        for (int i = 0; i < taxes.size(); i++) {

            if (i % 2 == 0) {
                sum.addCell(new Phrase(taxes.get(i), standard));
            } else {
                priceCell.setPhrase(new Phrase(taxes.get(i), standard));
                sum.addCell(priceCell);
            }

        }

        PdfPCell total = new PdfPCell();
        total.setHorizontalAlignment(Element.ALIGN_LEFT);
        total.setVerticalAlignment(Element.ALIGN_MIDDLE);
        total.setBorder(Rectangle.TOP);
        total.setPhrase(new Phrase("Total:", standard));
        sum.addCell(total);

        total.setHorizontalAlignment(Element.ALIGN_RIGHT);
        total.setPhrase(new Phrase(euro.format(calculateSumBrutto().doubleValue()), fett));
        sum.addCell(total);
        doc.add(sum);

    }

    private BigDecimal calculateSumNetto() {

        Iterator i = rechnungspositionen.iterator();
        BigDecimal sum = new BigDecimal(0);
        while (i.hasNext()) {
            IBRechnungsPosition tempR = (IBRechnungsPosition) i.next();
            sum = sum.add(tempR.getTotalPrice());
        }

        netto = sum;
        return sum;

    }

    private List<String> calculateTaxes() {

        List<String> taxCells = new LinkedList<String>();
        HashMap<Short, LinkedList<IBRechnungsPosition>> tax = new HashMap<Short, LinkedList<IBRechnungsPosition>>();

        // organize all Positions in a Hashmap corresponding do their taxrate
        Iterator i = rechnungspositionen.iterator();
        while (i.hasNext()) {
            IBRechnungsPosition tempR = (IBRechnungsPosition) i.next();

            if (tempR.getTaxRate() != 0) {
                LinkedList<IBRechnungsPosition> temp = tax.get(tempR.getTaxRate());

                if (temp == null) {
                    temp = new LinkedList<IBRechnungsPosition>();
                }

                temp.add(tempR);
                tax.put(tempR.getTaxRate(), temp);
            }

        }


        for (Short s : tax.keySet()) {
            LinkedList<IBRechnungsPosition> taxP = tax.get(s);
            taxCells.add("+" + s + "% VAT");
            BigDecimal sum = new BigDecimal(0);

            for (IBRechnungsPosition r : taxP) {
                sum = sum.add(r.getSteuerbetrag());
            }

            taxesTotal = taxesTotal.add(sum);

            taxCells.add(euro.format(sum.doubleValue()));
        }

        return taxCells;
    }

    private BigDecimal calculateSumBrutto() {
        return netto.add(taxesTotal);
    }

    private void insertPartPayment() throws DocumentException {

        Paragraph teilzahlung = new Paragraph();
        teilzahlung.setFont(ueberschrift);
        teilzahlung.add("Part Payments");
        teilzahlung.setSpacingBefore(30.0f);

        doc.add(teilzahlung);

        float[] colsWidth = {1f, 1f};
        PdfPTable teilzahlungenTable = new PdfPTable(colsWidth);
        teilzahlungenTable.setSpacingBefore(10.0f);
        teilzahlungenTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        PdfPCell priceCell = new PdfPCell();
        priceCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        priceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        priceCell.setBorder(Rectangle.NO_BORDER);

        Iterator i = teilzahlungen.iterator();
        while (i.hasNext()) {
            IBTeilzahlung temp = (IBTeilzahlung) i.next();

            teilzahlungenTable.addCell(new Phrase(temp.getBZahlungsmethode().getBezeichnung(), standard));
            priceCell.setPhrase(new Phrase(euro.format(temp.getBBetrag().doubleValue()), standard));
            teilzahlungenTable.addCell(priceCell);
        }

        teilzahlungenTable.setHorizontalAlignment(Element.ALIGN_LEFT);
        teilzahlungenTable.setWidthPercentage(25.0f);

        doc.add(teilzahlungenTable);
    }

    private class RepoDatumComparator implements Comparator<IBRechnungsPosition> {

        @Override
        public int compare(IBRechnungsPosition o1, IBRechnungsPosition o2) {
            if (o1.getBErstellung().before(o2.getBErstellung())) {
                return -1;
            } else if (o1.getBErstellung().after(o2.getBErstellung())) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private class FootWriter extends PdfPageEventHelper {

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            try {

                Rectangle page = document.getPageSize();
                PdfPTable head = new PdfPTable(1);

                PdfPCell tmp = new PdfPCell(new Phrase("CEO: " + stammdaten.getChef() + " | " + "Phone: " + stammdaten.getTelefonummer() + " | "
                        + "Fax: " + stammdaten.getFaxnummer() + " | " + "Email: " + stammdaten.getEmail(), footerFont));
                tmp.setBorder(Rectangle.NO_BORDER);
                tmp.setHorizontalAlignment(Element.ALIGN_CENTER);
                head.addCell(tmp);

                tmp.setPhrase(new Phrase("Account number: " + stammdaten.getKontonummer() + " | " + "Bank code: " + stammdaten.getBlz() + " | "
                        + "IBAN: " + stammdaten.getIban() + " | " + "BIC: " + stammdaten.getBic(), footerFont));
                tmp.setHorizontalAlignment(Element.ALIGN_CENTER);
                tmp.setBorder(Rectangle.NO_BORDER);
                head.addCell(tmp);

                tmp.setPhrase(new Phrase("VAT number: " + stammdaten.getUid() + " | " + "Commercial register number: " + stammdaten.getFbn(), footerFont));
                tmp.setBorder(Rectangle.NO_BORDER);
                tmp.setHorizontalAlignment(Element.ALIGN_CENTER);
                head.addCell(tmp);

                head.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
                head.writeSelectedRows(0, -3, document.leftMargin(), document.bottomMargin(),
                        writer.getDirectContent());
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }
}
