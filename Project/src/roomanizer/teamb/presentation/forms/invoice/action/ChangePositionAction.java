/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice.action;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import roomanizer.teamb.presentation.basic.Action;
import roomanizer.teamb.presentation.basic.IActionDetails;
import roomanizer.teamb.presentation.forms.invoice.action.ChangePositionAction.IChangePositionDetails;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.IBRechnungsPosition;
import roomanizer.teamb.service.integrate.PayToMuchException;

/**
 *
 * @author Johannes
 */
public class ChangePositionAction extends Action<IChangePositionDetails> {

    public static interface IChangePositionDetails extends IActionDetails {

        void isFailed();
    }
    IBRechnungsPosition position;
    JCheckBox box;
    IInvoiceController controller;

    public ChangePositionAction(IChangePositionDetails details, IBRechnungsPosition position, JCheckBox box, IInvoiceController controller) {
        super(details);
        this.position = position;
        this.box = box;
        this.controller = controller;
    }

    @Override
    public Boolean doAction() {
        if (box.isSelected()) {
            controller.addPosition(position);
        } else {
            try {
                controller.removePosition(position);
            } catch (PayToMuchException ex) {
                //Logger.getLogger(ChangePositionAction.class.getName()).log(Level.SEVERE, null, ex);
                getDetails().isFailed();
            }
        }
        return true;
    }

    @Override
    public Boolean undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
