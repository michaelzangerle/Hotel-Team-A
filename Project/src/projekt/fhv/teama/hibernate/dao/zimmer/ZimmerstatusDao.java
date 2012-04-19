/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.classes.zimmer.Zimmerstatus;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 * 
 */
public class ZimmerstatusDao extends GenericDao<IZimmerstatus> implements IZimmerStatusDao {

	private static ZimmerstatusDao instance;

	public static IZimmerStatusDao getInstance() {
		if (instance == null) {
			instance = new ZimmerstatusDao();
		}
		return instance;
	}

	private ZimmerstatusDao() {
		super("Zimmerstatus");
	}

	public IZimmerstatus getZimmerstatus(String statusName) throws NoDatabaseEntryFoundException {

		IZimmerstatus status = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " z where z.bezeichnung = :statusName");
			query.setString("statusName", statusName);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 1) {
				status = (Zimmerstatus) results.get(0);
			}

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return status;
	}

}
