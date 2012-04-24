package projekt.fhv.teama.hibernate.dao;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface f�r die PfandtypDao-Klasse
 * 
 * @author Team A
 * @version 1.2
 */
public interface IPfandtypDao extends IGenericDao<IPfandtyp> {
	
	/**
	 * Gibt einen Pfandtyp mit der �bergebenen Bezeichnung zur�ck
	 * @param bez String
	 * @return IPfandtyp
	 * @throws DatabaseEntryNotFoundException
	 */
	public IPfandtyp getPfandtypByBez(String bez) throws DatabaseEntryNotFoundException;
}
