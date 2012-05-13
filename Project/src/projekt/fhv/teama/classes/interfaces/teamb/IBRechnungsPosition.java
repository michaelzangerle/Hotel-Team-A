/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.fhv.teama.classes.interfaces.teamb;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author Johannes
 */
public interface IBRechnungsPosition {

    public BigDecimal getBrutto();

    public String getInvoiceLine();

    public Timestamp getDate();

    public Integer getAmount();

    public BigDecimal getUnitPrice();

    public BigDecimal getTotalPrice();

    public short getTaxRate();
    
    public IBGast getGuest();

    public IBZimmer getRoom();
    
    public IBLeistung getBLeistung();
    
    public BigDecimal getSteuerbetrag();
}
