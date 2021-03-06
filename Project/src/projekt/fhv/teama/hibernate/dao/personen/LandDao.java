package projekt.fhv.teama.hibernate.dao.personen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.classes.personen.Land;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Regelt die Zugriffe auf die Land-Tabelle
 * 
 * @author Team A
 * @version 1.2
 */
public class LandDao extends GenericDao<ILand> implements ILandDao {
	private static ILandDao instance;

	public static ILandDao getInstance() {
		if (instance == null) {
			instance = new LandDao();
		}
		return instance;
	}

	private LandDao() {
		super("Land");
	}

	public ILand getLandByBez(String bezeichnung) throws DatabaseException {
		ILand p = null;

		try {
			Session session = HibernateHelper.getSession();
			Query q = session.createQuery("from Land where bezeichnung= :bezeichnung");
			q.setString("bezeichnung", bezeichnung);

			@SuppressWarnings("rawtypes")
			List result = q.list();

			if (result.size() == 1) {
				p = (Land) result.get(0);
			}

			if (result.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

		} catch (HibernateException e) {
			throw new DatabaseException();
		}
		return p;
	}

	public ILand getLandByKuerzel(String kuerzel) throws DatabaseEntryNotFoundException {

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " p where p.kuerzel = :kuerzel");
			query.setString("kuerzel", kuerzel);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 1) {
				return (ILand) results.get(0);
			}

			if (results.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return null;
	}
}
