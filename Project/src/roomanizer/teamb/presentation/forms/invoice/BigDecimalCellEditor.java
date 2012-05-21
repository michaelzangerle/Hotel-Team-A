/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice;

import java.awt.Component;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.AbstractCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import roomanizer.teamb.presentation.basic.IActionResult;

/**
 *
 * @author Lucia
 */
public class BigDecimalCellEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, IActionResult {
    
    NumberFormat cur = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        BigDecimal bd = (BigDecimal) value;
        JLabel lbl = new JLabel(cur.format(bd));
        
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
