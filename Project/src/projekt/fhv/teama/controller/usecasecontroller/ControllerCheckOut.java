package projekt.fhv.teama.controller.usecasecontroller;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.MyLittleDate;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerCheckOut;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAAufenthalt;
import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.integrate.IAZimmer;
import projekt.fhv.teama.model.ModelAufenthalt;
import projekt.fhv.teama.model.ModelGast;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.interfaces.IModelAufenthalt;
import projekt.fhv.teama.model.interfaces.IModelGast;


/**
 * Controller zur Steuerung des Check Out Vorganges
 * 
 * @author Team-A
 * @version 1.0
 */
public class ControllerCheckOut implements IControllerCheckOut {

	// Models
	private IModelGast modelGast;
	private IModelAufenthalt modelAufenthalt;

	// Listen
	private List<IAAufenthalt> aufenthalte = new Vector<IAAufenthalt>();

	public ControllerCheckOut() {
		modelGast = new ModelGast();
		modelAufenthalt = new ModelAufenthalt();
	}

	public void setGast(IAGast gast) {
		modelGast.setAktuellGast(gast);
	}

	public IAGast getGast() throws FokusException {
		return modelGast.getAktuellGast();
	}

	@Override
	public List<IAGast> getGaesteVonAuftenhalten() throws DatabaseException {
		if (aufenthalte.size() < 1) {
			aufenthalte.clear();
			getAufenthalte();
		}
		List<IAGast> gaeste = new Vector<IAGast>();
		for (IAAufenthalt aufenthalt : aufenthalte) {
			if (!gaeste.contains(aufenthalt.getGast())
					&& aufenthalt.getGast() != null)
				gaeste.add(aufenthalt.getGast());
		}
		return gaeste;
	}

	public void setAufenthalt(IAAufenthalt aufenhalt)
			throws EmptyParameterException {
		modelAufenthalt.setAufenthalt(aufenhalt);
	}

	public IAAufenthalt getAufenthalt() throws FokusException {
		return modelAufenthalt.getAufenthalt();
	}

	public List<IAAufenthalt> getAufenthalte() throws DatabaseException {
		if (aufenthalte.size() > 0) {
			return aufenthalte;
		} else {
			aufenthalte = modelAufenthalt.getAufenthalte(MyLittleDate.getDate(
					2012, 3, 25));
			return aufenthalte;
		}
	}

	public List<IAZimmer> getZimmerVonGast() throws FokusException,
			DatabaseException {

		List<IAZimmer> zimmers = new Vector<IAZimmer>();

		if (aufenthalte.size() <= 0) {
			getAufenthalte();
		}

		for (IAAufenthalt aufenthalt : aufenthalte) {
			if (aufenthalt.getGast().equals(getGast()) && aufenthalt.getZimmer() != null) 
				zimmers.add(aufenthalt.getZimmer());
		}
		return zimmers;
	}

	/**
	 * Rechnung erstellen aufrufen
	 */
	public void aufrufenRechnungErstellen() {
		// TODO aufrufenRechnungErstellen Team B
	}


	public boolean offeneRechnungspositionenVorhanden() {
		// TODO Offene Rechnungspositionen noch vorhanden sind
		return false;

	}


	public void save() {
		// TODO Speichern des Check Out Vorganges(Schl�ssel r�ckgabe etc)
	}


}
