/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice.action;

import roomanizer.teamb.presentation.basic.Action;
import roomanizer.teamb.presentation.basic.IActionDetails;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.IBTeilzahlung;

/**
 *
 * @author Johannes
 */
public class RemovePaymentAction extends Action<IActionDetails> {

    private IBTeilzahlung teil;
    private IInvoiceController controller;

    public RemovePaymentAction(IInvoiceController controller, IBTeilzahlung teil) {
        this.teil = teil;
        this.controller = controller;
    }

    @Override
    public Boolean doAction() {
        controller.removeBezahlung(teil);
        return true;
    }

    @Override
    public Boolean undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
