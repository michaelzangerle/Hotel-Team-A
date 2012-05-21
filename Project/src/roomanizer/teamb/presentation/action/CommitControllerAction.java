package roomanizer.teamb.presentation.action;

import java.util.logging.Level;
import java.util.logging.Logger;
import roomanizer.teamb.service.contract.controller.IController;
import roomanizer.teamb.presentation.basic.Action;
import roomanizer.teamb.presentation.basic.IActionDetails;
import roomanizer.teamb.presentation.forms.invoice.InvoiceStep3;

/**
 * Beendet einen Controller
 *
 * @author Johannes
 */
public class CommitControllerAction extends Action<IActionDetails> {

    private IController controller;

    /**
     *
     * @param controller
     */
    public CommitControllerAction(IController controller) {
        super(null);
        this.controller = controller;
    }

    /**
     *
     * @return
     */
    @Override
    public Boolean doAction() {
        try {
            controller.commit();
            return true;
        } catch (Exception ex) {
            //Logger.getLogger(CommitControllerAction.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Boolean undo() {
        return true;
    }
}
