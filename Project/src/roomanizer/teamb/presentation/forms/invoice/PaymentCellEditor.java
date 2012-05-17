/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice;

import java.awt.Component;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import roomanizer.teamb.presentation.basic.IActionResult;
import roomanizer.teamb.presentation.eventhandler.ActionEventHandler;
import roomanizer.teamb.presentation.forms.invoice.action.ChangePositionAction;
import roomanizer.teamb.presentation.forms.invoice.action.RemovePaymentAction;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.IBRechnungsPosition;
import roomanizer.teamb.service.integrate.IBTeilzahlung;

/**
 *
 * @author Johannes
 */
public class PaymentCellEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, IActionResult {

    IInvoiceController controller;

    public PaymentCellEditor(IInvoiceController controller) {
        this.controller = controller;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        IBTeilzahlung teil = (IBTeilzahlung) value;
        JPanel panel = new JPanel();
        JButton clear = new JButton("Clear");

        ActionEventHandler handler = new ActionEventHandler(this);
        handler.add(new RemovePaymentAction(controller, teil));
        clear.addActionListener(handler);

        panel.add(clear);
        return panel;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return getTableCellRendererComponent(table, value, isSelected, isSelected, row, column);
    }

    @Override
    public void fail() {
    }

    @Override
    public void success() {
    }
}
