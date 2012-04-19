package projekt.fhv.teama.hibernate.dao.personen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class GastDao extends GenericDao<IPerson> implements IGastDao {

	private static IGastDao instance;

	public static IGastDao getInstance() {
		if (instance == null) {
			instance = new GastDao();
		}
		return instance;
	}
	
	private GastDao() {
		super("Gast");
	}

	public IGast getGastByNummer(String nr) throws DatabaseException {

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " g where g.nummer = :nr");
			query.setString("nr", nr);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 1) {
				return (IGast) results.get(0);
			}

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

		} catch (HibernateException e) {
			throw new DatabaseException();
		}

		return null;
	}


}
