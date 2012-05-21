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
import projekt.fhv.teama.model.ModelRechnungsposition;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.integration.IAModelAufenthalt;
import projekt.fhv.teama.model.integration.IAModelGast;
import projekt.fhv.teama.model.integration.IAModelRechnungspostion;
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
	private IAModelGast modelGast;
	private IAModelAufenthalt modelAufenthalt;
	private IAModelRechnungspostion modelRechnungsposition;

	// Listen
	private List<IAAufenthalt> aufenthalte = new Vector<IAAufenthalt>();

	public ControllerCheckOut() {
		modelGast = new ModelGast();
		modelAufenthalt = new ModelAufenthalt();
		modelRechnungsposition = new ModelRechnungsposition();
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
			if (!gaeste.contains(aufenthalt.getAGast())
					&& aufenthalt.getAGast() != null)
				gaeste.add(aufenthalt.getAGast());
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
			if (aufenthalt.getAGast().equals(getGast())
					&& aufenthalt.getAZimmer() != null)
				zimmers.add(aufenthalt.getAZimmer());
		}
		return zimmers;
	}

	public boolean offeneRechnungspositionenVorhanden()
			throws DatabaseException, FokusException {
		return modelRechnungsposition.sindNochPostionenoffen(getGast());

	}

	public void save() throws FokusException, DatabaseException {
		List<IAZimmer> zimmers=getZimmerVonGast();
		
		for (IAZimmer zi : zimmers) {
			for(IAAufenthalt auf:aufenthalte)
			{
				if(auf.getAZimmer().equals(zi)&&auf.getAGast().equals(getGast()))
				{
					modelAufenthalt.checkOut(auf,true,"");
				}
			}
		}
		
		
	}

}
