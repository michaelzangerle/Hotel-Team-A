package projekt.fhv.teama.controller.interfaces;

import java.sql.Date;
import java.util.List;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;

public interface IControllerReservierung {

	List<IReservierung> getAllReservierungen();

	void setAktuelleReservierung(IReservierung reservierung);

	IReservierung getAktuelleReservierung();

	List<ITeilreservierung> getTeilreservierungen();

	void setVon(Date date);

	void setBis(Date date);

	List<IGast> getGaeste();
	
	boolean containsGast(IGast gast);

}
