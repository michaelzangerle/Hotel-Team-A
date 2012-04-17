package projekt.fhv.teama.hibernate.dao.zimmer;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.zimmer.ReservierungsOption;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class OptionDao extends GenericDao<ReservierungsOption> {

	public OptionDao() {
		super("Option");

	}
	
	@SuppressWarnings("unchecked")
	public List<ReservierungsOption> getOptionen(Date datum)
			throws NoDatabaseEntryFoundException {

		List<ReservierungsOption> options = null;
		
		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable()
					+ " o where o.erfuellung = :datum");
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

		return options;
	}

}
