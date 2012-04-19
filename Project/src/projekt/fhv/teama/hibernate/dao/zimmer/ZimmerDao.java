/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.Zimmer;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 * 
 */
public class ZimmerDao extends GenericDao<IZimmer> implements IZimmerDao {

	private static IZimmerDao instance;

	public static IZimmerDao getInstance() {
		if (instance == null) {
			instance = new ZimmerDao();
		}
		return instance;
	}

	private ZimmerDao() {
		super("Zimmer");
	}

	public IZimmer getZimmerByNummer(String nr) throws DatabaseException {

		IZimmer zimmer = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " z where z.nummer = :nr");
			query.setString("nr", nr);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException("No results found!");
			}

			zimmer = (Zimmer) results.get(0);

		} catch (HibernateException e) {
			throw new DatabaseException();

		}

		return zimmer;
	}

	@SuppressWarnings("unchecked")
	public Set<IZimmer> getZimmerByKategorie(String kategorie) throws DatabaseException {

		List<IZimmer> zimmer = null;

		try {

			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from kategorie k where k.bezeichnung = :kategorie");
			query.setString("kategorie", kategorie);

			int id = -1;
			List<IKategorie> results = query.list();
			if (results.size() == 1) {
				id = results.get(0).getID();
			} else {
				throw new NoDatabaseEntryFoundException();
			}

			query = session.createQuery("from " + getTable() + " z where z.kategorieID = :id");
			query.setString("id", String.valueOf(id));

			List<IZimmer> results2 = query.list();

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException("No results found!");
			}

			zimmer = results2;

		} catch (HibernateException e) {
			throw new DatabaseException();

		}
		Set<IZimmer> set = new HashSet<IZimmer>(zimmer);
		return set;
	}

	@SuppressWarnings("unchecked")
	public Set<IZimmer> getZimmerByKategorieID(int ID) throws DatabaseException {

		List<IZimmer> zimmer = null;

		try {

			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " z where z.kategorieID = :ID");
			query.setString("ID", String.valueOf(ID));

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException("No results found!");
			}

			zimmer = results;

		} catch (HibernateException e) {
			throw new DatabaseException();

		}

		Set<IZimmer> set = new HashSet<IZimmer>(zimmer);
		return set;
	}

}
