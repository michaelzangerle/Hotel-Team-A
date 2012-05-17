package roomanizer.teamb.presentation.action;

import roomanizer.teamb.service.contract.controller.IController;
import roomanizer.teamb.presentation.basic.Action;
import roomanizer.teamb.presentation.basic.IActionDetails;
import roomanizer.teamb.presentation.detail.IStartControllerDetail;

/**
 * Startet einen Vorgang
 * @author Johannes
 */
public class StartControllerAction extends Action<IStartControllerDetail> {

    private IController controller;

    /**
     * 
     * @param detail
     * @param controller
     */
    public StartControllerAction(IStartControllerDetail detail, IController controller) {
        super(detail);
        this.controller = controller;
    }

    /**
     * 
     * @return
     */
    @Override
    public Boolean doAction() {
        controller.start();
        getDetails().started();
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
