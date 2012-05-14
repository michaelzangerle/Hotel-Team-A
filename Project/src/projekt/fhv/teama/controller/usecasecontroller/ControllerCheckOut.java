package projekt.fhv.teama.controller.usecasecontroller;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.MyLittleDate;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.ModelAufenthalt;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.interfaces.IModelAufenthalt;
import projekt.fhv.teama.model.interfaces.IModelGast;

/**
 * Controller zur Steuerung des Check Out Vorganges
 * @author Team-A
 * @version 1.0
 */
public class ControllerCheckOut {
	private IModelGast modelGast;
	private IModelAufenthalt modelAufenthalt; 

	private List<IAufenthalt> aufenthalte = new Vector<IAufenthalt>();
	
	/**
	 * 
	 * @param cgast
	 * @param cauf
	 */
	public ControllerCheckOut(IModelGast cgast, IModelAufenthalt cauf) {
		modelGast = cgast;
		modelAufenthalt = cauf;		
	}
	
	/**
	 * Die Referenz auf den aktuellen Gast setzen
	 * @param gast
	 */
	public void setGast(IGast gast) {
		modelGast.setAktuellGast(gast);
	}

	/**
	 * Referenz des aktuellen Gastes erhalten
	 * @return
	 * @throws FokusException
	 */
	public IGast getGast() throws FokusException {
		return modelGast.getAktuellGast();
	}
	
	/**
	 * Liste aller aktuellen Gaeste
	 * @return
	 * @throws DatabaseException
	 */
	public List<IGast> getGaesteVonAuftenhalten() throws DatabaseException
	{
		if(aufenthalte.size() < 1)
		{
			aufenthalte.clear();
			getAufenthalte();
		}
		List<IGast> gaeste=new Vector<IGast>();
		for (IAufenthalt aufenthalt : aufenthalte) {
			if(!gaeste.contains(aufenthalt.getGast())&&aufenthalt.getGast()!=null)
					gaeste.add(aufenthalt.getGast());
		}
			return gaeste;			
	}
	
	/**
	 * Referenz auf den akteullen Aufenthalt setzen
	 * @param aufenhalt
	 * @throws EmptyParameterException
	 */
	public void setAufenthalt(IAufenthalt aufenhalt) throws EmptyParameterException {
		modelAufenthalt.setAufenthalt(aufenhalt);
	}
	
	/**
	 * Referenz des aktellen Aufenthaltes erhalten
	 * @return
	 * @throws FokusException
	 */
	public IAufenthalt getAufenthalt() throws FokusException {
		return modelAufenthalt.getAufenthalt();
	}
	
	/**
	 * Liste aller Aufenthalte
	 * @return
	 * @throws DatabaseException
	 */
	public List<IAufenthalt> getAufenthalte() throws DatabaseException {
		if (aufenthalte.size() > 0) {
			return aufenthalte;
		} else {
			aufenthalte = modelAufenthalt.getAufenthalte(MyLittleDate.getDate(2012, 3, 25));
			return aufenthalte;
		}
	}
	
	/**
	 * Liste der Zimmer eines Gastes 
	 * @return
	 * @throws FokusException
	 * @throws DatabaseException
	 */
	public List<IZimmer> getZimmerVonGast() throws FokusException, DatabaseException {
		List<IZimmer> zimmers=new Vector<IZimmer>();
		if(aufenthalte.size()<=0) {
			getAufenthalte();
		}
		for (IAufenthalt aufenthalt : aufenthalte) {
			if(aufenthalt.getGast().equals(getGast())&&aufenthalt.getZimmer()!=null)
				zimmers.add(aufenthalt.getZimmer());
		}		
		return zimmers;
	}
	
	/**
	 * Rechnung erstellen aufrufen
	 */
	public void aufrufenRechnungErstellen(List<IAufenthalte>, IGast) {
		//TODO
	}
	
	/**
	 * Sind alle Rechnungspositionen beglichen
	 * @return
	 */
	public boolean offeneRechnungspositionenVorhanden() {
		//TODO
		return false;
		
	}
	
	/**
	 * speichern
	 */
	public void save() {
		//TODO
	}
}
	
