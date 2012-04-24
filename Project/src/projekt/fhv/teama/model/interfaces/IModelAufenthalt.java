package projekt.fhv.teama.model.interfaces;

import java.sql.Date;
import java.util.List;


import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;


public interface IModelAufenthalt {

	public void create(float preis, Date von, Date bis, boolean schluessel, IGast gast, IZimmer zimmer,IPfandtyp pfand,String pfandNr) throws DatabaseException, EmptyParameterException;

	public List<IAufenthalt> getAufenthalte(Date date) throws DatabaseException, EmptyParameterException;
	
}
