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
public class CustomTableRow {
    private CalendarDate calendarDate = null;
    private ExpenseType type = null;
    private double amount = 0;
    private String description = null;

    public CalendarDate getDate() {
        return calendarDate;
    }

    public void setDate(CalendarDate calendarDate) {
        this.calendarDate = calendarDate;
    }

    public final void setDate(String calendarDate) {
        setDate(new CalendarDate());
    }

    public ExpenseType getType() {
        return type;
    }

    public void setType(ExpenseType type) {
        this.type = type;
    }

    public final void setType(String type) {
        setType(ExpenseType.valueOf(type));
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}