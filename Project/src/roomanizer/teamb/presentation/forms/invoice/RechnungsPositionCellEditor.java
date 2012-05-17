/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import roomanizer.teamb.presentation.basic.IActionResult;
import roomanizer.teamb.presentation.basic.Stylesheet;
import roomanizer.teamb.presentation.eventhandler.ActionEventHandler;
import roomanizer.teamb.presentation.forms.invoice.action.ChangePositionAction;
import roomanizer.teamb.presentation.forms.invoice.action.ClearPositionAction;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.IBRechnungsPosition;

/**
 *
 * @author Johannes
 */
public class RechnungsPositionCellEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, IActionResult {

    private class ChangePositionDetails implements ChangePositionAction.IChangePositionDetails {

        @Override
        public void isFailed() {
            JOptionPane.showMessageDialog(null, "The Guest paid to Much! Reduce the Payment.", "Paid to much", JOptionPane.OK_OPTION);
        }
    }
    IInvoiceController controller;

    public RechnungsPositionCellEditor(IInvoiceController controller) {
        this.controller = controller;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        IBRechnungsPosition position = (IBRechnungsPosition) value;
        JPanel panel = new JPanel();
        JButton clear = new JButton("Clear");
        clear.setPreferredSize(new Dimension(70,20));
        ActionEventHandler clearHandler = new ActionEventHandler(this);
        clearHandler.add(new ClearPositionAction(new ChangePositionDetails(), (IBRechnungsPosition) value, controller));
        clear.addActionListener(clearHandler);

        JCheckBox box = new JCheckBox("");
        box.setBackground(new Color(0,0,0,0));
        if (controller.getAusgewaehlte().contains(position)) {
            box.setSelected(true);
        }
        ActionEventHandler handler = new ActionEventHandler(this);
        handler.add(new ChangePositionAction(new ChangePositionDetails(), position, box, controller));
        box.addActionListener(handler);

        panel.add(box);
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
