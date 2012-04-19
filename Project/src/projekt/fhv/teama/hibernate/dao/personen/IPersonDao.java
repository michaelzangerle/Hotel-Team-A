package projekt.fhv.teama.hibernate.dao.personen;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IPersonDao extends IGenericDao<IPerson> {
	public Set<IPerson> getPerson(String name) throws DatabaseException;
	public Set<IPerson> getPerson(String vorname, String nachname) throws DatabaseException;
}
