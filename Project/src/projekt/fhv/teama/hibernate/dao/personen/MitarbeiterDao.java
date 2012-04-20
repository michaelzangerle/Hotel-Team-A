package projekt.fhv.teama.hibernate.dao.personen;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public class MitarbeiterDao extends GenericDao<IMitarbeiter> implements IMitarbeiterDao {

	private static IMitarbeiterDao instance;

	public static IMitarbeiterDao getInstance() {
		if (instance == null) {
			instance = new MitarbeiterDao();
		}
		return instance;
	}

	public MitarbeiterDao() {
		super("Mitarbeiter");
	}

	@SuppressWarnings("unchecked")
	public Set<IMitarbeiter> getMitarbeiterByName(String name) throws DatabaseException {

		List<IMitarbeiter> mitarbeiter = null;

		try {
			Session session = HibernateHelper.getSession();

			Query query = session.createQuery("from Person p where (p.vorname = :name) OR (p.nachname = :name)");
			query.setString("name", name);
			List<IPerson> resultsPersonen = query.list();

			mitarbeiter = new LinkedList<IMitarbeiter>();

			List<IMitarbeiter> m;

			for (IPerson pers : resultsPersonen) {
				query = session.createQuery("from " + getTable() + " m where m.ID = " + pers.getID());
				m = query.list();
				if (m != null) {
					mitarbeiter.addAll(m);
				}
			}

			if (mitarbeiter.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

		} catch (HibernateException e) {
			throw new DatabaseException();
		}
		Set<IMitarbeiter> set = new HashSet<IMitarbeiter>(mitarbeiter);
		return set;
	}

	@SuppressWarnings("unchecked")
	public Set<IMitarbeiter> getMitarbeiterByName(String firstname, String lastname) throws DatabaseException {

		List<IMitarbeiter> mitarbeiter = null;

		try {
			Session session = HibernateHelper.getSession();

			Query query = session
					.createQuery("from Person p where (p.vorname = :firstname AND p.nachname = :lastname) OR (p.vorname = :lastname AND p.nachname = :firstname)");
			query.setString("firstname", firstname);
			query.setString("lastname", lastname);
			List<IPerson> resultsPersonen = query.list();

			mitarbeiter = new LinkedList<IMitarbeiter>();

			List<IMitarbeiter> m;

			for (IPerson pers : resultsPersonen) {
				query = session.createQuery("from " + getTable() + " m where m.ID = " + pers.getID());
				m = query.list();
				if (m != null) {
					mitarbeiter.addAll(m);
				}
			}

			if (mitarbeiter.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

		} catch (HibernateException e) {
			throw new DatabaseException();
		}
		Set<IMitarbeiter> set = new HashSet<IMitarbeiter>(mitarbeiter);
		return set;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<IMitarbeiter> getMitarbeiterByNummer(String nr) throws DatabaseException {

		List<IMitarbeiter> mitarbeiter = null;

		try {
			Session session = HibernateHelper.getSession();

			Query query = session.createQuery("from "+getTable()+" m where m.nummer = :nr");
			query.setString("nr", nr);
			mitarbeiter = query.list();

			if (mitarbeiter.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

		} catch (HibernateException e) {
			throw new DatabaseException();
		}
		Set<IMitarbeiter> set = new HashSet<IMitarbeiter>(mitarbeiter);
		return set;
	}

}
