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
import roomanizer.teamb.service.integrate.IBTeilzahlung;

/**
 *
 * @author Johannes
 */
public class PaymentTableModel extends AbstractTableModel implements Observer {

    private String[] colNames = {"Type of Payment", "Amount", "Options"};
    private int max = 1;
    private IInvoiceController controller;

    public PaymentTableModel(IInvoiceController controller) {
        this.controller = controller;
        controller.addObserver(this);
    }

    @Override
    public int getRowCount() {
        return (controller == null) ? 0 : controller.getTeilzahlungen().size();
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
        return IBTeilzahlung.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex <= this.max) {
            NumberFormat cur = NumberFormat.getCurrencyInstance(Locale.GERMANY);
            switch (columnIndex) {
                case 0:
                    return controller.getTeilzahlungen().get(rowIndex).getBZahlungsmethode().getBezeichnung();
                case 1:
                    return cur.format(controller.getTeilzahlungen().get(rowIndex).getBBetrag());
            }
        }
        return controller.getTeilzahlungen().get(rowIndex);
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
