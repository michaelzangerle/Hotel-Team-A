package projekt.fhv.teama.controller.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;

public interface IControllerReservierung {

	List<IReservierung> getAllReservierungen();

	void setAktuelleReservierung(IReservierung reservierung);

	IReservierung getAktuelleReservierung();

	boolean containsGast(IGast gast);

	List<ITeilreservierung> getTeilreservierungen();

}
