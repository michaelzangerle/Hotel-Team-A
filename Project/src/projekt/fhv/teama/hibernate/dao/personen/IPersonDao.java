package projekt.fhv.teama.hibernate.dao.personen;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IPersonDao extends IGenericDao<IPerson> {
	public Set<IPerson> getPersonByName(String name) throws DatabaseException;
	public Set<IPerson> getPersonByName(String vorname, String nachname) throws DatabaseException;
	public Set<IPerson> getPersonByMail(String mail) throws DatabaseException;
}
