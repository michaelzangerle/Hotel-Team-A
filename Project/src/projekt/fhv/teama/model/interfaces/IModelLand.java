package projekt.fhv.teama.model.interfaces;

import java.util.List;

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

	/**
	 * Methoden um ein Land anhand seiner Bezeichnung zu suchen
	 * @param bezeichnung
	 * @return ILand
	 * @throws DatabaseException
	 * @throws NotContainExeption
	 * @throws EmptyParameterException
	 */
	ILand getLandByBezeichnung(String bezeichnung) throws DatabaseException, NotContainExeption, EmptyParameterException;

	/**
	 * Methode um alle Länder zu holen
	 * @return List<ILand>
	 * @throws DatabaseException
	 */
	List<ILand> getLaender() throws DatabaseException;

}
