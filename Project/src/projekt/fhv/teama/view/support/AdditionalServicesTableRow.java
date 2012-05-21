/**
 * 
 */
package projekt.fhv.teama.view.support;

/**
 * 
 * Daten-Bean für eine TableRow in der Tabellenansicht Zusatzleistungen buchen
 * Hält die Daten und aktualisiert diese bei Eintrag in die Tabelle (Databinding)
 * 
 * @author Team A
 * @version 1.1
 */
public class AdditionalServicesTableRow {
    private int quantity;
    private String type;
    private double amount;
    private double	total;
    private String description;
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public final void setQuantity(String quantity) {
    	if (quantity == null || quantity.length() == 0){
    		setQuantity(0);
        } else {
        	try {
        		int temp = Integer.parseInt(quantity);
        		setQuantity(temp);
        	} catch (NumberFormatException e) {
        		setQuantity(0);
        	}
        }
    }

    public String getType() {

        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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
    
    public AdditionalServicesTableRow () {
    	this.quantity = 0;
        this.type = "";
        this.amount = 0;
        this.total = 0;
        this.description = "";
    }
}