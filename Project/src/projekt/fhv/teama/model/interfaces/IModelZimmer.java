package projekt.fhv.teama.model.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;

/**
 * Beschreibt das Interface f�r das Zimmer Model
 * @author Team-A
 * @version 1.5
 */
public interface IModelZimmer {

	/**
	 * Gibt alle Verf�gbaren Zimmer der angegebenen Kategorie als Liste zur�ck
	 * @param ausgew�hlteKategorie
	 * @param iReservierung
	 * @return List<IZimmer>
	 * @throws DatabaseEntryNotFoundException
	 * @throws DatabaseException
	 */
	List<IZimmer> getVerfuegbareZimmerF�rGegebeneKategorie(IKategorie ausgew�hlteKategorie, IReservierung iReservierung)throws DatabaseEntryNotFoundException, DatabaseException ;

	/**
	 * Um das Zimmer in der Datenbank zu speichern
	 * @param zimmer IZimmer
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 */
	void save(IZimmer zimmer) throws DatabaseException, EmptyParameterException;

	/**
	 * Um alle Verf�gbaren Zimmer zu erhalten
	 * @return List<IZimmer>
	 * @throws DatabaseException
	 */
	List<IZimmer> getVerf�gbareZimmer() throws DatabaseException;

	/**
	 * Um den Zimmerstatus zu setzen
	 * @param status IZimmerstatus
	 * @throws EmptyParameterException
	 */
	void setStatus(IZimmerstatus status) throws EmptyParameterException;

	/**
	 * Um das ausgew�hlte Zimmer im Model zu setzen
	 * @param zimmer IZimmer
	 * @throws EmptyParameterException
	 */
	void setAktullesZimmer(IZimmer zimmer) throws EmptyParameterException;

	/**
	 * Um das ausgew�hlte Zimmer zu holen
	 * @return IZimmer
	 * @throws FokusException
	 */
	IZimmer getAktullesZimmer() throws FokusException;
}
