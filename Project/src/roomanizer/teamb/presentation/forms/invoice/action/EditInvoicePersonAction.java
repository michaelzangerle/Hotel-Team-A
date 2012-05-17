/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice.action;

import roomanizer.teamb.presentation.basic.Action;
import roomanizer.teamb.presentation.basic.IActionDetails;
import roomanizer.teamb.presentation.forms.invoice.action.EditInvoicePersonAction.IEditInvoicePersonDetail;
import roomanizer.teamb.service.contract.controller.IInvoiceController;

/**
 *
 * @author Andreas Lorenz
 */
public class EditInvoicePersonAction extends Action<IEditInvoicePersonDetail> {

    /**
     *
     * @author Andreas Lorenz
     */
    public static interface IEditInvoicePersonDetail extends IActionDetails, IInvoiceController.IInvoiceAddress {
    }
    private IInvoiceController controller;

    public EditInvoicePersonAction(IEditInvoicePersonDetail detail, IInvoiceController controller) {
        super(detail);
        this.controller = controller;
    }

    @Override
    public Boolean doAction() {
        controller.setInvoiceAddress(getDetails());
        return true;
    }

    @Override
    public Boolean undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
