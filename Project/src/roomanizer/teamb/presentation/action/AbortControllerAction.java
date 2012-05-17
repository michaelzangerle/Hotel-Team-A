package roomanizer.teamb.presentation.action;

import roomanizer.teamb.service.contract.controller.IController;
import roomanizer.teamb.presentation.basic.Action;
import roomanizer.teamb.presentation.basic.IActionDetails;

/**
 * Bricht einen Controller ab
 * @author Andreas Lorenz
 */
public class AbortControllerAction extends Action<IActionDetails> {

    private IController controller;

    /**
     * 
     * @param controller
     */
    public AbortControllerAction(IController controller) {
        super(null);
        this.controller = controller;
    }

    /**
     * 
     * @return
     */
    @Override
    public Boolean doAction() {
        controller.abort();
        return true;
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
