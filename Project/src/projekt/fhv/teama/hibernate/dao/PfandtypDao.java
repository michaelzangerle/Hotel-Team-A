/**
 * 
 */
package projekt.fhv.teama.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 * 
 */
public class PfandtypDao extends GenericDao<IPfandtyp> implements IPfandtypDao {

	private static PfandtypDao instance;

	public static IPfandtypDao getInstance() {
		if (instance != null) {
			instance = new PfandtypDao();
		}
		return instance;
	}

	private PfandtypDao() {
		super("Pfandtyp");
	}

	public IPfandtyp getPfandtypByBez(String bez) throws NoDatabaseEntryFoundException {

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " p where p.bezeichnung = :bez");
			query.setString("bez", bez);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 1) {
				return (IPfandtyp) results.get(0);
			}

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return null;
	}

}
