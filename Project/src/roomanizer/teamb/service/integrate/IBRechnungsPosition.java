/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.service.integrate;

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

    public IBGast getBGast();

    public IBZimmer getBZimmer();

    public IBLeistung getBLeistung();

    public BigDecimal getSteuerbetrag();

    public void setBezahlt(boolean bezahlt);

    public void setRechnung(IBRechnung rechnung);

    public void setFalsch(boolean falsch);
    
    public boolean getFalsch();
    
    public boolean getBezahlt();
    
    public Timestamp getBErstellung();
}
