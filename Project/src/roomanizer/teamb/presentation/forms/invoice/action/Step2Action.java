/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice.action;

import roomanizer.teamb.presentation.basic.Action;
import roomanizer.teamb.presentation.basic.IActionDetails;
import roomanizer.teamb.presentation.forms.invoice.action.Step2Action.IStep2Details;
import roomanizer.teamb.service.contract.controller.IInvoiceController;

/**
 *
 * @author Johannes
 */
public class Step2Action extends Action<IStep2Details> {

    public static interface IStep2Details extends IActionDetails {

        void isFailed();
    }
    private IInvoiceController controller;

    public Step2Action(Step2Action.IStep2Details detail, IInvoiceController controller) {
        super(detail);
        this.controller = controller;
    }

    @Override
    public Boolean doAction() {
        if (controller.getAusgewaehlte().size() == 0) {
            getDetails().isFailed();
            return false;
        }
        return true;
    }

    @Override
    public Boolean undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
