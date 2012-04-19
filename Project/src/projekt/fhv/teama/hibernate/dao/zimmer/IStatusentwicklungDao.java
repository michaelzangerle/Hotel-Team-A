package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IStatusentwicklung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public interface IStatusentwicklungDao extends IGenericDao<IStatusentwicklung> {
	public Set<IStatusentwicklung> getStatusentwicklungByZimmernummer(String nummer)throws NoDatabaseEntryFoundException;
}
