/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.AbstractTableModel;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.IBRechnungsPosition;

/**
 * TableModel, Auflistung aller Rechnungspositionen mit Datum, Anzahl,
 * Einzelpreis, Gast
 *
 * @author Johannes
 */
public class AlleRechnungPostionenTableModel extends AbstractTableModel implements Observer {

    IInvoiceController controller;
    private String[] colNames = {"Invoice Line", "Date", "Amount", "Unit Price", "Total Price", "Guest", "Room", "Options"};
    private int max = 6;

    /**
     * 
     * @param controller
     */
    public AlleRechnungPostionenTableModel(IInvoiceController controller) {
        this.controller = controller;
        controller.addObserver(this);
    }

    @Override
    public int getRowCount() {
        return (controller == null) ? 0 : controller.getAlle().size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex <= this.max) {
            if (columnIndex == 1) {
                return Date.class;
            } else if (columnIndex == 3 || columnIndex == 4) {
                return BigDecimal.class;
            } else if (columnIndex == 2) {
                return Integer.class;
            }
            return String.class;
        }
        return IBRechnungsPosition.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex <= this.max) {
            switch (columnIndex) {
                case 0:
                    return controller.getAlle().get(rowIndex).getInvoiceLine();
                case 1:
                    return new Date(controller.getAlle().get(rowIndex).getDate().getTime());
                case 2:
                    return controller.getAlle().get(rowIndex).getAmount();
                case 3:
                    return controller.getAlle().get(rowIndex).getUnitPrice();
                case 4:
                    return controller.getAlle().get(rowIndex).getTotalPrice();
                case 5:
                    if (controller.getAlle().get(rowIndex).getBGast() != null) {
                        return controller.getAlle().get(rowIndex).getBGast().getSurname() + " " + controller.getAlle().get(rowIndex).getBGast().getFirstname();
                    } else {
                        return "";
                    }
                case 6:
                    if (controller.getAlle().get(rowIndex).getBZimmer() != null) {
                        return controller.getAlle().get(rowIndex).getBZimmer().getNumber();
                    } else {
                        return "";
                    }
                default:
                    return "";
            }
        } else {
            return controller.getAlle().get(rowIndex);
        }
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
