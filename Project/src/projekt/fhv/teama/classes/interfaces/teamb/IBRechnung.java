/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.fhv.teama.classes.interfaces.teamb;

import java.math.BigDecimal;
import java.util.Set;

/**
 *
 * @author Johannes
 */
public interface IBRechnung {

    /**
     *
     * @return
     */
    public Integer getID();

    //<editor-fold defaultstate="collapsed" desc="Adresse">
    String getFirstname();

    void setFirstname(String first);

    String getSurname();

    void setSurname(String sur);

    String getPostalCode();

    void setPostalCode(String postal);

    String getAddress();

    void setAddress(String addresse);

    String getLocation();

    void setLocation(String location);

    IBLand getCountry();

    void setCountry(IBLand country);
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Nummer">
    String getRechnungsNummer();

    void setRechnungsNummer(String nummer);
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Positionen">
    Set<IBRechnungsPosition> getRechnungsPositionen();

    void addRechnungsPosition(IBRechnungsPosition position);

    void removeRechnungsPosition(IBRechnungsPosition position);
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Teilzahlungen">
    Set<IBTeilzahlung> getBTeilzahlungen();

    void addBezahlung(IBZahlungsmethode methode, BigDecimal betrag);

    void removeBezahlung(IBTeilzahlung teilzahlung);
    //</editor-fold>
}
