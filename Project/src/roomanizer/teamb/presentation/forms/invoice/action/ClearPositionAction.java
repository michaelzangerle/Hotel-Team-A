/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice.action;

import java.util.logging.Level;
import java.util.logging.Logger;
import roomanizer.teamb.presentation.basic.Action;
import roomanizer.teamb.presentation.forms.invoice.action.ChangePositionAction.IChangePositionDetails;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.IBRechnungsPosition;
import roomanizer.teamb.service.integrate.PayToMuchException;

/**
 *
 * @author Johannes
 */
public class ClearPositionAction extends Action<ChangePositionAction.IChangePositionDetails> {

    IBRechnungsPosition position;
    IInvoiceController controller;

    public ClearPositionAction(IChangePositionDetails details, IBRechnungsPosition position, IInvoiceController controller) {
        super(details);
        this.position = position;
        this.controller = controller;
    }

    @Override
    public Boolean doAction() {
        try {
            controller.clearPosition(position);
        } catch (PayToMuchException ex) {
            Logger.getLogger(ClearPositionAction.class.getName()).log(Level.SEVERE, null, ex);
            getDetails().isFailed();
        }
        return true;
    }

    @Override
    public Boolean undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
