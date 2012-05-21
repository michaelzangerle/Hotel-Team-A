package roomanizer.teamb.service.contract.controller;

import java.math.BigDecimal;
import java.util.List;
import roomanizer.teamb.service.integrate.*;

/**
 * Regelt den Check-In Vorgang
 *
 * @author Johannes
 */
public interface IInvoiceController extends IController {

    /**
     *
     * @return
     */
    public BigDecimal getTaxes();

    /**
     *
     * @return
     */
    List<IBLand> getLaender();

    //<editor-fold defaultstate="collapsed" desc="Interfaces">
    /**
     * Ermöglicht Zugriff auf die höhere Schichten. Daten für die Adresse holen.
     */
    public static interface IInvoiceAddress {

        /**
         *
         * @return
         */
        String getFirstname();

        /**
         *
         * @return
         */
        String getSurname();

        /**
         *
         * @return
         */
        String getPostalCode();

        /**
         *
         * @return
         */
        String getAddress();

        /**
         *
         * @return
         */
        String getLocation();

        /**
         *
         * @return
         */
        IBLand getCountry();
    }
    //</editor-fold>

    /**
     * Gibt eine Liste der Ausgewählten Rechnungsposition zurück
     *
     * @return
     */
    List<IBRechnungsPosition> getAusgewaehlte();

    /**
     * Gibt eine Liste aller ofener Rechungspositionen zurück
     *
     * @return
     */
    List<IBRechnungsPosition> getAlle();

    /**
     * Wählt eine Rechnungsposition aus
     *
     * @param position
     */
    void addPosition(IBRechnungsPosition position);

    /**
     * Löscht eine Rechnungsposition
     *
     * @param position
     * @throws PayToMuchException
     */
    void removePosition(IBRechnungsPosition position) throws PayToMuchException;

    /**
     *
     * @param address
     */
    void setInvoiceAddress(IInvoiceAddress address);

    /**
     *
     * @return
     */
    List<IBTeilzahlung> getTeilzahlungen();

    /**
     *
     * @param methode
     * @param betrag
     * @throws PayToMuchException
     */
    void addBezahlung(IBZahlungsmethode methode, BigDecimal betrag) throws PayToMuchException;

    /**
     *
     * @param teilzahlung
     */
    void removeBezahlung(IBTeilzahlung teilzahlung);

    /**
     *
     * @return
     */
    List<IBZahlungsmethode> getZahlungsmethoden();

    /**
     *
     * @return
     */
    IBRechnung getRechnung();

    /**
     *
     * @return
     */
    IBGast getGast();

    /**
     *
     * @return
     */
    IBKonsument getReservierung();

    /**
     *
     * @return
     */
    String createPreviewPDF();

    /**
     * Erstellt das PDF
     *
     * @return Pfad zur PDF Datei
     */
    String createPDF();

    /**
     *
     * @return
     */
    BigDecimal getTotal();

    /**
     *
     * @return
     */
    BigDecimal getOpen();

    /**
     *
     * @return
     */
    String getFileName();

    /**
     *
     * @return
     */
    java.util.Date getVon();

    /**
     *
     * @return
     */
    java.util.Date getBis();

    /**
     *
     * @return
     */
    List<IBGast> getGaeste();

    /**
     *
     * @return
     */
    List<IBZimmer> getZimmer();

    /**
     * Hat der Konsument noch offene Rechnungspositionen
     *
     * @return
     */
    Boolean hasOpenPositions();

    /**
     * Die Rechnungsposition wurde falsch gebucht
     *
     * @param position
     * @throws PayToMuchException
     */
    void clearPosition(IBRechnungsPosition position) throws PayToMuchException;

    /**
     * Alle auswählen
     *
     * @param ok an oder abwählen
     */
    void chooseAll(boolean ok);

    /**
     * Ladet die Rechnungspositionen neu
     */
    void reload();
}
