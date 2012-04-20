package projekt.fhv.teama.controller.interfaces;

import java.sql.Date;


import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;


public interface IControllerAufenthalt {

	public void create(float preis, Date von, Date bis, boolean schluessel, IGast gast, IZimmer zimmer,IPfandtyp pfand,String pfandNr);
	
}
