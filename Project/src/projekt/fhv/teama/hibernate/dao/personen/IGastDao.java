package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public interface IGastDao extends IGenericDao<IPerson> {
	public IGast getGastByNummer(String gastnummer) throws DatabaseException;
}
