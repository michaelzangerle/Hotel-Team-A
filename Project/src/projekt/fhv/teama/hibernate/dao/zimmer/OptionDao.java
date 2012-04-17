package projekt.fhv.teama.hibernate.dao.zimmer;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.zimmer.Option;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

public class OptionDao extends GenericDao<Option> {

	public OptionDao() {
		super("Option");

	}
	
	// TODO Option: getOptionen(Date date)
	@SuppressWarnings("unchecked")
	public List<Option> getOptionen(Date datum)
			throws DatabaseNotFoundException {

		List<Option> options = null;
		
		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable()
					+ " o where o.erfuellung = :datum");
			query.setString("datum", datum.toString());

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new DatabaseNotFoundException();
			}
			
			options = results;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return options;
	}

}
