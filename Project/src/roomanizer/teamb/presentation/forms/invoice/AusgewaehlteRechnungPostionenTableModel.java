/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.AbstractTableModel;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.IBRechnungsPosition;

/**
 *
 * @author Johannes
 */
public class AusgewaehlteRechnungPostionenTableModel extends AbstractTableModel implements Observer {

    IInvoiceController controller;
    private String[] colNames = {"Invoice Line", "Date", "Amount", "Unit Price", "Total Price", "Taxes", "Brutto Price"};
    private int max = 6;

    public AusgewaehlteRechnungPostionenTableModel(IInvoiceController controller) {
        this.controller = controller;
        controller.addObserver(this);
    }

    @Override
    public int getRowCount() {
        return (controller == null) ? 0 : controller.getAusgewaehlte().size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex <= this.max) {
            return String.class;
        }
        return IBRechnungsPosition.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex <= this.max) {
            SimpleDateFormat date = new SimpleDateFormat("dd.MM.YYYY");
            NumberFormat cur = NumberFormat.getCurrencyInstance(Locale.GERMANY);
            switch (columnIndex) {
                case 0:
                    return controller.getAusgewaehlte().get(rowIndex).getInvoiceLine();
                case 1:
                    return date.format(controller.getAusgewaehlte().get(rowIndex).getDate());
                case 2:
                    return controller.getAusgewaehlte().get(rowIndex).getAmount();
                case 3:
                    return cur.format(controller.getAusgewaehlte().get(rowIndex).getUnitPrice());
                case 4:
                    return cur.format(controller.getAusgewaehlte().get(rowIndex).getTotalPrice());
                case 5:
                    return cur.format(controller.getAusgewaehlte().get(rowIndex).getSteuerbetrag());
                case 6:
                    return cur.format(controller.getAusgewaehlte().get(rowIndex).getBrutto());
            }
        }
        return controller.getAusgewaehlte().get(rowIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex <= this.max) {
            return false;
        }
        return true;
    }

    @Override
    public String getColumnName(int column) {
        return (colNames[column]);
    }

    @Override
    public void update(Observable o, Object arg) {
        fireTableDataChanged();
    }
}
