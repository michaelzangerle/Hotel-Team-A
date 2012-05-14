package projekt.fhv.teama.controller.usecasecontroller;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.MyLittleDate;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerCheckOut;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
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
	private List<IAufenthalt> aufenthalte = new Vector<IAufenthalt>();

	public ControllerCheckOut() {
		modelGast = new ModelGast();
		modelAufenthalt = new ModelAufenthalt();
	}

	@Override
	public void setGast(IGast gast) {
		modelGast.setAktuellGast(gast);
	}

	@Override
	public IGast getGast() throws FokusException {
		return modelGast.getAktuellGast();
	}

	@Override
	public List<IGast> getGaesteVonAuftenhalten() throws DatabaseException {
		if (aufenthalte.size() < 1) {
			aufenthalte.clear();
			getAufenthalte();
		}
		List<IGast> gaeste = new Vector<IGast>();
		for (IAufenthalt aufenthalt : aufenthalte) {
			if (!gaeste.contains(aufenthalt.getGast())
					&& aufenthalt.getGast() != null)
				gaeste.add(aufenthalt.getGast());
		}
		return gaeste;
	}

	@Override
	public void setAufenthalt(IAufenthalt aufenhalt)
			throws EmptyParameterException {
		modelAufenthalt.setAufenthalt(aufenhalt);
	}

	@Override
	public IAufenthalt getAufenthalt() throws FokusException {
		return modelAufenthalt.getAufenthalt();
	}

	@Override
	public List<IAufenthalt> getAufenthalte() throws DatabaseException {
		if (aufenthalte.size() > 0) {
			return aufenthalte;
		} else {
			aufenthalte = modelAufenthalt.getAufenthalte(MyLittleDate.getDate(
					2012, 3, 25));
			return aufenthalte;
		}
	}

	@Override
	public List<IZimmer> getZimmerVonGast() throws FokusException,
			DatabaseException {

		List<IZimmer> zimmers = new Vector<IZimmer>();

		if (aufenthalte.size() <= 0) {
			getAufenthalte();
		}

		for (IAufenthalt aufenthalt : aufenthalte) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see projekt.fhv.teama.controller.usecasecontroller.IControllerCheckOut#
	 * offeneRechnungspositionenVorhanden()
	 */
	@Override
	public boolean offeneRechnungspositionenVorhanden() {
		// TODO Offene Rechnungspositionen noch vorhanden sind
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * projekt.fhv.teama.controller.usecasecontroller.IControllerCheckOut#save()
	 */
	@Override
	public void save() {
		// TODO Speichern des Check Out Vorganges(Schlüssel rückgabe etc)
	}

}
