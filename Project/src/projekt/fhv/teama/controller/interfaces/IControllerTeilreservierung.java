package projekt.fhv.teama.controller.interfaces;

import projekt.fhv.teama.classes.zimmer.ITeilreservierung;

public interface IControllerTeilreservierung {

	public void setAktulleTeilreservierung(ITeilreservierung teilreservierung);
	
	public ITeilreservierung getAktuelleTeilreservierung();
	
}
