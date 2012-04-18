package projekt.fhv.teama.hibernate.dao.personen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class GastDao extends GenericDao<Gast> {

	public GastDao() {
		super("GAST");
	}

	public IGast getGastByNummer(String nr) throws NoDatabaseEntryFoundException {

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
			e.printStackTrace();
		}

		return null;
	}
}
