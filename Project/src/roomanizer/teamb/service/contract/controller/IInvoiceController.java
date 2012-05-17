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

    public BigDecimal getTaxes();

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

    List<IBRechnungsPosition> getAusgewaehlte();

    List<IBRechnungsPosition> getAlle();

    void addPosition(IBRechnungsPosition position);

    void removePosition(IBRechnungsPosition position) throws PayToMuchException;

    void setInvoiceAddress(IInvoiceAddress address);

    List<IBTeilzahlung> getTeilzahlungen();

    void addBezahlung(IBZahlungsmethode methode, BigDecimal betrag) throws PayToMuchException;

    void removeBezahlung(IBTeilzahlung teilzahlung);

    List<IBZahlungsmethode> getZahlungsmethoden();

    IBRechnung getRechnung();

    IBGast getGast();

    IBKonsument getReservierung();

    String createPreviewPDF();

    String createPDF();

    BigDecimal getTotal();

    BigDecimal getOpen();

    String getFileName();

    java.util.Date getVon();

    java.util.Date getBis();

    List<IBGast> getGaeste();

    List<IBZimmer> getZimmer();

    Boolean hasOpenPositions();

    void clearPosition(IBRechnungsPosition position) throws PayToMuchException;
}
