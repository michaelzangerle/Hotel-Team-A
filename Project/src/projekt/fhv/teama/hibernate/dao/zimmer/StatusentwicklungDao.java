/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.zimmer.Statusentwicklung;
import projekt.fhv.teama.classes.zimmer.Zimmerstatus;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

/**
 * @author mike
 *
 */
public class StatusentwicklungDao extends GenericDao<Statusentwicklung>{

	public StatusentwicklungDao(String table) {
		super("Statusentwicklung");
	}
	
	public List<Statusentwicklung> getStatusentwicklung(String zimmerNummer) throws DatabaseNotFoundException {

		List<Statusentwicklung> status = null;
		String nummer = "";
		
		try {
			Session session = HibernateHelper.getSession();
			// Zimmerid herausfinden
			
			Query queryZimmerID = session.createQuery("from zimmer z where z.nummer = :zimmerNummer");
			queryZimmerID.setString("zimmerNummer", zimmerNummer);
			nummer = (String) queryZimmerID.list().get(0);
			
			Query query = session.createQuery("from " + getTable()
					+ " z where z.zimmerID = :zimmerNummer");
			query.setString("zimmerNummer", zimmerNummer);

			@SuppressWarnings("rawtypes")
			List results = query.list();

//			if (results.size() == 1) {
//				status = (Zimmerstatus) results.get(0);
//			}
			
			if (results.size() == 1) {
				throw new DatabaseNotFoundException();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return status;
	}
	

}
