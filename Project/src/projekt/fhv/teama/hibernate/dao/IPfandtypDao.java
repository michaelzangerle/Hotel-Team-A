package projekt.fhv.teama.hibernate.dao;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public interface IPfandtypDao extends IGenericDao<IPfandtyp> {
	public IPfandtyp getPfandtypByBez(String bez)throws DatabaseEntryNotFoundException ;
}
