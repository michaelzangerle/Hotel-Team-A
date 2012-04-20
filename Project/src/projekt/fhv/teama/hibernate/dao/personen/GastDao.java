package projekt.fhv.teama.hibernate.dao.personen;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public class GastDao extends GenericDao<IGast> implements IGastDao {

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
				throw new DatabaseEntryNotFoundException();
			}

		} catch (HibernateException e) {
			throw new DatabaseException();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<IGast> getGastByName(String firstname, String lastname) throws DatabaseException {

		List<IGast> gaeste = null;

		try {
			Session session = HibernateHelper.getSession();

			Query query = session
					.createQuery("from Person p where (p.vorname = :firstname AND p.nachname = :lastname) OR (p.vorname = :lastname AND p.nachname = :firstname)");
			query.setString("firstname", firstname);
			query.setString("lastname", lastname);
			List<IPerson> resultsPersonen = query.list();

			gaeste = new LinkedList<IGast>();

			List<IGast> m;

			for (IPerson pers : resultsPersonen) {
				query = session.createQuery("from " + getTable() + " g where g.ID = " + pers.getID());
				m = query.list();
				if (m != null) {
					gaeste.addAll(m);
				}
			}

			if (gaeste.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

		} catch (HibernateException e) {
			throw new DatabaseException();
		}
		Set<IGast> set = new HashSet<IGast>(gaeste);
		return set;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<IGast> getGastByName(String name) throws DatabaseException {
		List<IGast> gaeste = null;

		try {
			Session session = HibernateHelper.getSession();

			Query query = session.createQuery("from " + getTable() + " g where g.vorname = :name OR g.nachname = :name");
			query.setString("name", name);
			gaeste = query.list();

			if (gaeste.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

		} catch (HibernateException e) {
			throw new DatabaseException();
		}
		Set<IGast> set = new HashSet<IGast>(gaeste);
		return set;
	}

}
