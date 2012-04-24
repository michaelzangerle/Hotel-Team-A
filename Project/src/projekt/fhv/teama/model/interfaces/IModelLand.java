package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.NotContainExeption;

/**
 * Beschreibt das Interface des Model Land
 * @author Team-A
 * @version 1.5
 */
public interface IModelLand {

	/**
	 * Um das Land anhand eines Kuerzel abzurufen
	 * @param kuerzel
	 * @return ILand 
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 * @throws NotContainExeption
	 */
	ILand getLandByKuerzel(String kuerzel) throws DatabaseException, EmptyParameterException, NotContainExeption ;

}
