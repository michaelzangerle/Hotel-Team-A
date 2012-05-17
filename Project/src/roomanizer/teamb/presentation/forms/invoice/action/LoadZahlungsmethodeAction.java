/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.presentation.forms.invoice.action;

import java.util.List;
import roomanizer.teamb.presentation.basic.Action;
import roomanizer.teamb.presentation.basic.IActionDetails;
import roomanizer.teamb.presentation.forms.invoice.action.LoadZahlungsmethodeAction.ILoadZahlungsmethodeDetail;
import roomanizer.teamb.service.contract.controller.IInvoiceController;
import roomanizer.teamb.service.integrate.IBZahlungsmethode;

/**
 *
 * @author Andreas Lorenz
 */
public class LoadZahlungsmethodeAction extends Action<ILoadZahlungsmethodeDetail> {

    /**
     *
     * @author Andreas Lorenz
     */
    public interface ILoadZahlungsmethodeDetail extends IActionDetails {

        void setZahlungsmethode(List<IBZahlungsmethode> zahlungsmethode);
    }
    private IInvoiceController controller;

    public LoadZahlungsmethodeAction(ILoadZahlungsmethodeDetail detail, IInvoiceController controller) {
        super(detail);
        this.controller = controller;
    }

    @Override
    public Boolean doAction() {
        getDetails().setZahlungsmethode(controller.getZahlungsmethoden());
        return true;
    }

    @Override
    public Boolean undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
