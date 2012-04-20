package projekt.fhv.teama.hibernate.dao.personen;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IGastDao extends IGenericDao<IPerson> {
	public IGast getGastByNummer(String gastnummer) throws DatabaseException;
	public Set<IGast> getGastByName(String vorname, String nachname) throws DatabaseException;
	public Set<IGast> getGastByName(String name) throws DatabaseException;
}
