package projekt.fhv.teama.model.interfaces;

import java.sql.Date;
import java.util.List;


import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;

/**
 * Interface des Aufenthalts Model, beschreibt die wichtigsten Methden um mit einem Model arbeiten zu können
 * @author Team-A
 * @version 1.5
 */
public interface IModelAufenthalt {

	/**
	 * Um einen Aufenthalt zu erzeugen und in in der Datenbank abzuspeichern
	 * @param preis
	 * @param von
	 * @param bis
	 * @param schluessel
	 * @param gast
	 * @param zimmer
	 * @param pfand
	 * @param pfandNr
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 */
	public void create(float preis, Date von, Date bis, boolean schluessel, IGast gast, IZimmer zimmer,IPfandtyp pfand,String pfandNr) throws DatabaseException, EmptyParameterException;

	/**
	 * Um alle Aufenthalt die zu einem angegebenen Zeitpunkt vorhanden sind abzurufen
	 * @param date
	 * @return List<IAufenthalt>
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 */
	public List<IAufenthalt> getAufenthalte(Date date) throws DatabaseException;
	
}
