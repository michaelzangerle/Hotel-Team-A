package projekt.fhv.teama.controller.interfaces;

import java.sql.Date;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.Zimmer;

public interface IControllerAufenthalt {

	public void create(float preis, Date von, Date bis, boolean schluessel, IGast gast, IZimmer zi);
	
}
