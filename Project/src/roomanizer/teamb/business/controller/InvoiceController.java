/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.business.controller;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import roomanizer.teamb.business.invoice.AbstractPDFGenerator;
import roomanizer.teamb.business.invoice.IPDFGenerator;
import roomanizer.teamb.data.IntegrateFacade;
import roomanizer.teamb.service.contract.Hibernate.IHibernateTransaction;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.*;

/**
 * Controller für den Usecase Rechnung erstellen
 *
 * @author Johannes
 */
public class InvoiceController extends Observable implements IInvoiceController {

    private boolean started = false;
    private IBKonsument reservierung;
    private IBGast gast;
    private Set<IBRechnungsPosition> alle;
    private IBRechnung rechnung;
    private IPDFGenerator generator;
    private String folder;
    private String tempFile;
    private String fileName;
    private BigDecimal total = new BigDecimal(0);
    private BigDecimal totalBezahlt = new BigDecimal(0);
    private BigDecimal taxes = new BigDecimal(0);
    private List<IBGast> gaeste;
    private List<IBZimmer> zimmer;

    /**
     *
     * @param reservierung
     * @param gast
     */
    public InvoiceController(IBKonsument reservierung, IBGast gast) {
        this.reservierung = reservierung;
        this.gast = gast;
    }

    private String generateNummer() {
        // TODO Reicht das?
        SimpleDateFormat format = new SimpleDateFormat("YYY-MM-dd-hh-mm-ss");
        return "R-" + format.format(new java.util.Date());
    }

    //<editor-fold defaultstate="collapsed" desc="Controller Handling">
    @Override
    public void abort() {
        System.out.println("Aborted");
        // TODO Abort
    }

    @Override
    public void commit() throws Exception {
        if (Math.round(total.doubleValue() * 100) / 100.0 == Math.round(totalBezahlt.doubleValue() * 100) / 100.0) {
            // Transaction starten
            IHibernateTransaction tx = IntegrateFacade.getTransaction();
            // Speichere die Rechnung
            this.rechnung.setSumme(total);
            tx.saveOrUpdate(this.rechnung);
            //IntegrateFacade.getRepository(this.rechnung).save(this.rechnung);
            // Rechnungspositionen bezahlt und gespeichert
            for (IBRechnungsPosition position : rechnung.getRechnungsPositionen()) {
                position.setBezahlt(true);
                position.setRechnung(rechnung);
                tx.saveOrUpdate(position);
                //IntegrateFacade.getRepository(position).saveOrUpdate(position);
            }
            // Teilzahlungen speichern
            for (IBTeilzahlung teilzahlung : this.rechnung.getBTeilzahlungen()) {
                tx.saveOrUpdate(teilzahlung);
                //IntegrateFacade.getRepository(teilzahlung).save(teilzahlung);
            }
            // Transaction Commiten
            tx.commit();
            // PDF erstellen
            this.fileName = createPDF();
        } else {
            throw new PayToLessException();
        }
    }

    @Override
    public void start() {
        System.out.println("Started");
        // TODO Woher kommt das Hotel
        this.folder = IntegrateFacade.getHotel().getRechnungen();
        // TODO Woher bekomme ich die Rechnung?
        this.rechnung = IntegrateFacade.getNewRechnung();
        this.generator = AbstractPDFGenerator.getGenerator();

        this.rechnung.setErstellung(new Timestamp(new Date().getTime()));
        this.rechnung.setAddress(gast.getBAdressen().get(0).getStrasse());
        this.rechnung.setCountry(gast.getBAdressen().get(0).getBLand());
        this.rechnung.setFirstname(gast.getFirstname());
        this.rechnung.setLocation(gast.getBAdressen().get(0).getOrt());
        this.rechnung.setPostalCode(gast.getBAdressen().get(0).getPlz());
        this.rechnung.setSurname(gast.getSurname());

        this.rechnung.setRechnungsNummer(this.generateNummer());

        this.alle = reservierung.getBOffeneRechnungsPositionen();

        this.started = true;

        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        this.setChanged();
        super.notifyObservers();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getter & Setter">
    /**
     *
     * @param address
     */
    @Override
    public void setInvoiceAddress(IInvoiceAddress address) {
        this.rechnung.setAddress(address.getAddress());
        this.rechnung.setCountry(address.getCountry());
        this.rechnung.setFirstname(address.getFirstname());
        this.rechnung.setLocation(address.getLocation());
        this.rechnung.setPostalCode(address.getPostalCode());
        this.rechnung.setSurname(address.getSurname());
        notifyObservers();
    }

    /**
     *
     * @return
     */
    @Override
    public IBRechnung getRechnung() {
        return this.rechnung;
    }

    /**
     *
     * @return
     */
    @Override
    public IBGast getGast() {
        return this.gast;
    }

    /**
     *
     * @return
     */
    @Override
    public IBKonsument getReservierung() {
        return this.reservierung;
    }

    /**
     *
     * @return
     */
    @Override
    public BigDecimal getTotal() {
        return total;
    }

    /**
     *
     * @return
     */
    @Override
    public BigDecimal getOpen() {
        return total.subtract(totalBezahlt);
    }

    /**
     *
     * @return
     */
    @Override
    public BigDecimal getTaxes() {
        return taxes;
    }

    /**
     *
     * @return
     */
    @Override
    public String getFileName() {
        return fileName;
    }

    /**
     *
     * @return
     */
    @Override
    public Date getVon() {
        Date von = new Date();
        for (IBRechnungsPosition position : this.alle) {
            if (position.getDate().before(von)) {
                von = new Date(position.getDate().getTime());
            }
        }
        return von;
    }

    /**
     *
     * @return
     */
    @Override
    public Date getBis() {
        Date bis = new Date(0);
        for (IBRechnungsPosition position : this.alle) {
            if (position.getDate().after(bis)) {
                bis = new Date(position.getDate().getTime());
            }
        }
        return bis;
    }

    /**
     *
     * @return
     */
    @Override
    public List<IBGast> getGaeste() {
        if (this.gaeste == null) {
            Set<IBGast> lgaeste = new HashSet<IBGast>();
            for (IBRechnungsPosition position : this.alle) {
                if (position.getBGast() != null) {
                    lgaeste.add(position.getBGast());
                }
            }
            this.gaeste = new ArrayList<IBGast>(lgaeste);
        }
        return this.gaeste;
    }

    /**
     *
     * @return
     */
    @Override
    public List<IBZimmer> getZimmer() {
        if (this.zimmer == null) {
            Set<IBZimmer> lzimmer = new HashSet<IBZimmer>();
            for (IBRechnungsPosition position : this.alle) {
                if (position.getBZimmer() != null) {
                    lzimmer.add(position.getBZimmer());
                }
            }
            this.zimmer = new ArrayList<IBZimmer>(lzimmer);
        }
        return this.zimmer;
    }

    /**
     * Hat der Konsument neue Rechnungspositionen
     *
     * @return
     */
    @Override
    public Boolean hasOpenPositions() {
        return !reservierung.getBOffeneRechnungsPositionen().isEmpty();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Positionen">
    /**
     * Gibt alle Offenen Rechnungspositionen des Kunsumenten zurück
     *
     * @return Liste aller Offenen Rechnungspositionen
     */
    @Override
    public List<IBRechnungsPosition> getAlle() {
        return new ArrayList<IBRechnungsPosition>(this.alle);
    }

    /**
     * Gibt alle Ausgewählten Rechnungspositionen zurück
     *
     * @return Liste der Ausgewählten Rechnungspositionen
     */
    @Override
    public List<IBRechnungsPosition> getAusgewaehlte() {
        return new ArrayList<IBRechnungsPosition>(this.rechnung.getRechnungsPositionen());
    }

    /**
     * Fügt eine Rechnungsposition hinzu
     *
     * @param position Position die Hinzugefügt werden soll
     */
    @Override
    public void addPosition(IBRechnungsPosition position) {
        if (!this.rechnung.getRechnungsPositionen().contains(position)) {
            this.rechnung.addRechnungsPosition(position);
            total = total.add(position.getBrutto());
            taxes = taxes.add(position.getSteuerbetrag());
            notifyObservers();
        }
    }

    /**
     * Löscht eine Rechnungsposition aus den Ausgewählten Positionen
     *
     * @param position Position die gelöscht werden soll
     * @throws PayToMuchException Wenn der Gast zu viel gezahlt hat
     */
    @Override
    public void removePosition(IBRechnungsPosition position) throws PayToMuchException {
        if (this.rechnung.getRechnungsPositionen().contains(position)) {
            this.rechnung.removeRechnungsPosition(position);
            total = total.subtract(position.getBrutto());
            taxes = taxes.subtract(position.getSteuerbetrag());
            notifyObservers();
            if (totalBezahlt.doubleValue() > total.doubleValue()) {
                throw new PayToMuchException();
            }
        }
    }

    /**
     * Position wurde Falsch gebucht
     *
     * @param position Falsch gebuchte Positino
     * @throws PayToMuchException Wenn der Gast zu viel gezahlt hat
     */
    @Override
    public void clearPosition(IBRechnungsPosition position) throws PayToMuchException {
        IHibernateTransaction tx = IntegrateFacade.getTransaction();
        position.setFalsch(true);
        if (this.alle.contains(position)) {
            this.alle.remove(position);
        }
        if (this.rechnung.getRechnungsPositionen().contains(position)) {
            this.removePosition(position);
        }
        tx.saveOrUpdate(position);
        tx.commit();
        notifyObservers();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Teilzahlungen">
    /**
     * Teilzahlungen die für die Rechnung getätigt wurden
     *
     * @return Liste der Teilzahlungen
     */
    @Override
    public List<IBTeilzahlung> getTeilzahlungen() {
        return new ArrayList<IBTeilzahlung>(this.rechnung.getBTeilzahlungen());
    }

    /**
     * Fügt eine Bezahlung hinzu
     *
     * @param methode Methode mit der Bezhalt wurde
     * @param betrag Betrag der mit der Zahlungsmethode bezahlt wurde
     * @throws PayToMuchException Der Gast hat zu viel Bezahlt
     */
    @Override
    public void addBezahlung(IBZahlungsmethode methode, BigDecimal betrag) throws PayToMuchException {
        if (totalBezahlt.add(betrag).doubleValue() <= total.doubleValue()) {
            this.rechnung.addBezahlung(methode, betrag);
            totalBezahlt = totalBezahlt.add(betrag);
        } else {
            throw new PayToMuchException();
        }
        notifyObservers();
    }

    /**
     * Löscht eine Teilzahlung
     *
     * @param teilzahlung Teilzahlung die gelöscht werden soll
     */
    @Override
    public void removeBezahlung(IBTeilzahlung teilzahlung) {
        if (this.rechnung.getBTeilzahlungen().contains(teilzahlung)) {
            this.rechnung.removeBezahlung(teilzahlung);
            totalBezahlt = totalBezahlt.subtract(teilzahlung.getBBetrag());
        }
        notifyObservers();
    }

    /**
     * Gibt eine Liste der Möglichen Zahlungsmethoden zurück
     *
     * @return Liste der Zahlungsmöglichkeiten
     */
    @Override
    public List<IBZahlungsmethode> getZahlungsmethoden() {
        return IntegrateFacade.getAllZahlungsmethoden();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="PDF">
    /**
     * Erstelle das Vorschau PDF
     *
     * @deprecated
     * @return
     */
    @Override
    public String createPreviewPDF() {
        this.tempFile = this.folder + "temp\\" + this.rechnung.getRechnungsNummer() + ".pdf";
        this.generator.createPreview(this.tempFile, this.rechnung);
        return this.tempFile;
    }

    /**
     * Erstelle das PDF
     *
     * @return Pfad zur PDF Datei
     */
    @Override
    public String createPDF() {
        this.fileName = this.folder + this.rechnung.getRechnungsNummer() + ".pdf";
        try {
            this.generator.create(this.fileName, this.rechnung);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (DocumentException ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return this.fileName;
    }
    //</editor-fold>

    /**
     * Gibt eine Liste alle Länder zurück
     *
     * @return Liste aller Länder
     */
    @Override
    public List<IBLand> getLaender() {
        return IntegrateFacade.getAllLaender();
    }

    /**
     * Alle Rechnungspositionen auswählen
     *
     * @param ok an oder abwählen
     */
    @Override
    public void chooseAll(boolean ok) {
        if (ok) {
            for (IBRechnungsPosition position : alle) {
                if (!getAusgewaehlte().contains(position)) {
                    addPosition(position);
                }
            }
        } else {
            for (IBRechnungsPosition position : alle) {
                if (getAusgewaehlte().contains(position)) {
                    try {
                        removePosition(position);
                    } catch (PayToMuchException ex) {
                    }
                }
            }
        }
        notifyObservers();
    }

    /**
     * Rechnungspositionen neu laden
     */
    @Override
    public void reload() {
        if (started) {
            this.alle = reservierung.getBOffeneRechnungsPositionen();
            notifyObservers();
        }
    }
}
