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

import projekt.fhv.teama.classes.zimmer.IStatusentwicklung;
import projekt.fhv.teama.classes.zimmer.Statusentwicklung;
import projekt.fhv.teama.classes.zimmer.Zimmer;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 * 
 */
public class StatusentwicklungDao extends GenericDao<IStatusentwicklung> implements IStatusentwicklungDao{

	private static StatusentwicklungDao instance;

	public static IStatusentwicklungDao getInstance() {
		if (instance != null) {
			instance = new StatusentwicklungDao();
		}
		return instance;
	}

	private StatusentwicklungDao() {
		super("Statusentwicklung");
	}

	@SuppressWarnings("unchecked")
	public Set<IStatusentwicklung> getStatusentwicklungByZimmernummer(String zimmerNummer)
			throws NoDatabaseEntryFoundException {

		List<Statusentwicklung> status = null;

		try {
			Session session = HibernateHelper.getSession();

			// Zimmerid durch zimmernummer herausfinden
			Query queryZimmerID = session.createQuery("from zimmer z where z.nummer = :zimmerNummer");
			queryZimmerID.setString("zimmerNummer", zimmerNummer);

			List<Zimmer> zimmer = queryZimmerID.list();

			if (zimmer.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

			int zimmerID = zimmer.get(0).getID();

			// Statusentwicklungen des zimmers finden

			Query query = session.createQuery("from " + getTable() + " z where z.zimmerID = :zimmerID");
			query.setString("zimmerID", String.valueOf(zimmerID));

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

			status = results;

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		Set<IStatusentwicklung> set = new HashSet<IStatusentwicklung>(status);
		return set;
	}

}
