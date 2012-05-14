/**
 * 
 */
package projekt.fhv.teama.view.support;

import java.util.LinkedList;
import java.util.List;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.adapter.ListAdapter;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.content.TableViewRowEditor;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.controller.usecasecontroller.ControllerZusatzleistungBuchen;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.view.ViewAdditionalServices;


/**
 *  
 *
 * @author Team A
 * @version 1.1
 */
public class AdditionalServicesTableRow {
    private int quantity = 0;
    private Service type = null;
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

    public Service getType() {

        return this.type;
    }

    public void setType(Service type) {
        this.type = type;
    }
    
    public final void setType(String type) {
    	
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
    }
    
    
}