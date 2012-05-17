package roomanizer.teamb.presentation.action;

import roomanizer.teamb.presentation.basic.AbstractForm;
import roomanizer.teamb.presentation.basic.Action;
import roomanizer.teamb.presentation.basic.IActionDetails;

/**
 * Leitet auf eine bestimmt Form weiter
 * 
 * @author And
 */
public class RedirectAction extends Action<IActionDetails> {

	AbstractForm form;

	/**
	 * 
	 * @param form
	 */
	public RedirectAction(AbstractForm form) {
		this.form = form;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Boolean doAction() {
		this.form.showForm();

		return true;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Boolean undo() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
