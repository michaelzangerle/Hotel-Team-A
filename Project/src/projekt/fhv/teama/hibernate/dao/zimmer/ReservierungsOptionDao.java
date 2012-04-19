package projekt.fhv.teama.hibernate.dao.zimmer;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.zimmer.IReservierungsOption;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class ReservierungsOptionDao extends GenericDao<IReservierungsOption> implements IReservierungsOptionDao {

	private static ReservierungsOptionDao instance;

	public IReservierungsOptionDao getInstance() {
		if (instance != null) {
			instance = new ReservierungsOptionDao();
		}
		return instance;
	}

	private ReservierungsOptionDao() {
		super("Option");
	}

	@SuppressWarnings("unchecked")
	public Set<IReservierungsOption> getOptionen(Date datum) throws NoDatabaseEntryFoundException {

		List<IReservierungsOption> options = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " o where o.erfuellung = :datum");
			query.setString("datum", datum.toString());

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

			options = results;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		Set<IReservierungsOption> set = new HashSet<IReservierungsOption>(options);
		return set;
	}
}
