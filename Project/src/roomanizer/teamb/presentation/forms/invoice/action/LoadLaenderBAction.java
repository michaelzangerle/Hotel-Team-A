/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice.action;

import java.util.List;
import roomanizer.teamb.presentation.basic.Action;
import roomanizer.teamb.presentation.basic.IActionDetails;
import roomanizer.teamb.presentation.forms.invoice.action.LoadLaenderBAction.ILoadLaenderBDetail;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.IBLand;

/**
 *
 * @author Administrator
 */
public class LoadLaenderBAction extends Action<ILoadLaenderBDetail> {

    public static interface ILoadLaenderBDetail extends IActionDetails {

        /**
         *
         * @param laender
         */
        public void setLaender(List<IBLand> laender);
    }
    private IInvoiceController controller;

    public LoadLaenderBAction(ILoadLaenderBDetail detail, IInvoiceController controller) {
        super(detail);
        this.controller = controller;
    }

    @Override
    public Boolean doAction() {
        getDetails().setLaender(controller.getLaender());
        return true;
    }

    @Override
    public Boolean undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
