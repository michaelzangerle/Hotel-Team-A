/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.personen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.classes.personen.Vertragspartner;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 *
 */
public class VertragspartnerDao extends GenericDao<IVertragspartner> implements IVertragspartnerDao {


	private static IVertragspartnerDao instance;

	public static IVertragspartnerDao getInstance() {
		if (instance != null) {
			instance = new VertragspartnerDao();
		}
		return instance;
	}
	
	
	public VertragspartnerDao() {
		super("Vertragspartner");
	}
	
	public IVertragspartner getVertragspartnerByName(String name) throws NoDatabaseEntryFoundException {
		
		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " p where p.name = :name");
			query.setString("name", name);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 1) {
				return (IVertragspartner) results.get(0);
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
