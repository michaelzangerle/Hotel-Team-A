package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.zimmer.ITeilreservierung;

public interface IModelTeilreservierung {

	/**
	 * Um die Teilreservierung im Model zu setzen
	 * @param teilreservierung
	 */
	public void setAktulleTeilreservierung(ITeilreservierung teilreservierung);
	
	/**
	 * Um die ausgewählte Teilreservierung abzurufen
	 * @return ITeilreservierung
	 */
	public ITeilreservierung getAktuelleTeilreservierung();
	
}
