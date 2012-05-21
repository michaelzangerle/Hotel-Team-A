/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import roomanizer.teamb.presentation.basic.IActionResult;
import roomanizer.teamb.service.contract.controller.IInvoiceController;

/**
 *
 * @author Lucia
 */
public class DateCellEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, IActionResult {
    SimpleDateFormat date = new SimpleDateFormat("dd.MM.YYYY");
    
    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Date d = (Date) value;
        JLabel lbl = new JLabel(date.format(d));
        
        return lbl;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return getTableCellEditorComponent(table, value, isSelected, row, column);
    }

    @Override
    public void fail() {
    }

    @Override
    public void success() {
    }
    
}
