/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.rechnung;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.rechnung.IRechnungsposition;
import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 * 
 */
public class RechnungspositionDao extends GenericDao<IRechnungsposition> implements IRechnungspositionDao {

	private static RechnungspositionDao instance;

	public static IRechnungspositionDao getInstance() {
		if (instance == null) {
			instance = new RechnungspositionDao();
		}
		return instance;
	}

	private RechnungspositionDao() {
		super("Rechnungsposition");
	}

	@SuppressWarnings("unchecked")
	public List<IRechnungsposition> getRechnungspostionenByZimmerNummer(String nummer) throws DatabaseException {

		List<IRechnungsposition> pos = null;

		try {

			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from zimmer z where z.nummer = :nummer");
			query.setString("nummer", nummer);

			int id = -1;
			List<IKategorie> results = query.list();
			if (results.size() == 1) {
				id = results.get(0).getID();
			} else {
				throw new NoDatabaseEntryFoundException();
			}

			query = session.createQuery("from " + getTable() + " z where z.zimmerID = :id");
			query.setString("id", String.valueOf(id));

			List<IRechnungsposition> results2 = query.list();

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException("No results found!");
			}

			pos = results2;

		} catch (HibernateException e) {
			throw new DatabaseException();

		}

		return pos;
	}

}
