package projekt.fhv.teama.hibernate.dao;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface für die PfandtypDao-Klasse
 * 
 * @author Team A
 * @version 1.2
 */
public interface IPfandtypDao extends IGenericDao<IPfandtyp> {
	
	/**
	 * Gibt einen Pfandtyp mit der übergebenen Bezeichnung zurück
	 * @param bez String
	 * @return IPfandtyp
	 * @throws DatabaseEntryNotFoundException
	 */
	public IPfandtyp getPfandtypByBez(String bez) throws DatabaseEntryNotFoundException;
}
