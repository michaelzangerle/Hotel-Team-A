/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice.action;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import roomanizer.teamb.presentation.basic.Action;
import roomanizer.teamb.presentation.basic.IActionDetails;
import roomanizer.teamb.presentation.forms.invoice.action.AddPaymentAction.IAddPaymentActionDetail;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.IBZahlungsmethode;
import roomanizer.teamb.service.integrate.PayToMuchException;

/**
 *
 * @author Amann
 */
public class AddPaymentAction extends Action<IAddPaymentActionDetail> {

    /**
     *
     * @author Amann
     */
    public static interface IAddPaymentActionDetail extends IActionDetails {

        BigDecimal getAmount();

        public IBZahlungsmethode getZahlungsmethode();
    }
    private IInvoiceController controller;

    public AddPaymentAction(IAddPaymentActionDetail detail, IInvoiceController controller) {
        super(detail);
        this.controller = controller;
    }

    @Override
    public Boolean doAction() {
        try {
            controller.addBezahlung(getDetails().getZahlungsmethode(), getDetails().getAmount());
        } catch (PayToMuchException ex) {
            Logger.getLogger(AddPaymentAction.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public Boolean undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
