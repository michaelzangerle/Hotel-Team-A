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

    public Integer getBID();

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
    
    String getRechnungsNummer();

    void setRechnungsNummer(String nummer);
 
    Set<IBRechnungsPosition> getRechnungsPositionen();

    void addRechnungsPosition(IBRechnungsPosition position);

    void removeRechnungsPosition(IBRechnungsPosition position);
   
    Set<IBTeilzahlung> getBTeilzahlungen();

    void addBezahlung(IBZahlungsmethode methode, BigDecimal betrag);

    void removeBezahlung(IBTeilzahlung teilzahlung);
    
}
