/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.zimmer.Statusentwicklung;
import projekt.fhv.teama.classes.zimmer.Zimmer;
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
	
	@SuppressWarnings("unchecked")
	public List<Statusentwicklung> getStatusentwicklungByZimmernummer(String zimmerNummer) throws DatabaseNotFoundException {

		List<Statusentwicklung> status = null;
		
		
		try {
			Session session = HibernateHelper.getSession();
			
			// Zimmerid durch zimmernummer herausfinden
			Query queryZimmerID = session.createQuery("from zimmer z where z.nummer = :zimmerNummer");
			queryZimmerID.setString("zimmerNummer", zimmerNummer);

			List<Zimmer> zimmer = queryZimmerID.list();
			
			if (zimmer.size() == 0) {
				throw new DatabaseNotFoundException();
			}
			
			int zimmerID = zimmer.get(0).getID();
			
			// Statusentwicklungen des zimmers finden
			
			Query query = session.createQuery("from " + getTable() + " z where z.zimmerID = :zimmerID");
			query.setString("zimmerID", String.valueOf(zimmerID));

			@SuppressWarnings("rawtypes")
			List results = query.list();
			
			if (results.size() == 0) {
				throw new DatabaseNotFoundException();
			}
			
			status = results;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return status;
	}
	

}
