/**
 * 
 */
package projekt.fhv.teama.view.support;

import org.apache.pivot.util.CalendarDate;

/**
 *  
 *
 * @author Team A
 * @version 1.1
 */
public class AdditionalServicesTableRow {
    private int quantity = 0;
    private Services type = null;
    private double amount = 0;
    private double	total = 0;
    private String description = "";

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public final void setQuantity(String quantity) {
    	setQuantity(Integer.valueOf(quantity));
    }

    public Services getType() {
        return type;
    }

    public void setType(Services type) {
        this.type = type;
    }

    public final void setType(String type) {
        setType(Services.valueOf(type));
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public final void setAmount(String amount) {
        if (amount == null || amount.length() == 0) {
            setAmount(0);
        } else {
            setAmount(Double.parseDouble(amount));
        }
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = this.amount*this.quantity;
    }

    public final void setTotal(String total) {
        if (total == null || total.length() == 0) {
            setTotal();
        } else {
            setTotal();
        }
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}