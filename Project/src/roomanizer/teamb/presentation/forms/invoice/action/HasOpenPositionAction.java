/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice.action;

import roomanizer.teamb.presentation.basic.Action;
import roomanizer.teamb.presentation.basic.IActionDetails;
import roomanizer.teamb.service.contract.controller.IInvoiceController;

/**
 *
 * @author Amann
 */
public class HasOpenPositionAction extends Action<IActionDetails> {

    private IInvoiceController controller;

    public HasOpenPositionAction(IInvoiceController controller) {
        super(null);
        this.controller = controller;
    }

    @Override
    public Boolean doAction() {
        return controller.hasOpenPositions();
    }

    @Override
    public Boolean undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
