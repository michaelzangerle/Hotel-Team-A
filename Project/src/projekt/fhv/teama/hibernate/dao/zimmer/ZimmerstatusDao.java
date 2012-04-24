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
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Regelt die Zugriffe auf die Zimmerstatus-Tabelle 
 * @author Team A
 * @version 1.2
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

	public IZimmerstatus getZimmerstatus(String statusBezeichnung) throws DatabaseEntryNotFoundException {

		IZimmerstatus status = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " z where z.bezeichnung = :statusName");
			query.setString("statusName", statusBezeichnung);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 1) {
				status = (Zimmerstatus) results.get(0);
			}

			if (results.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return status;
	}

}
