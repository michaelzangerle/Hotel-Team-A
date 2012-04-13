/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.Person;
import projekt.fhv.teama.classes.zimmer.Reservierung;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

/**
 * @author mike
 * 
 */
public class ReservierungDao extends GenericDao<Reservierung> {

	public ReservierungDao(String table) {
		super("Reservierung");

	}

	@SuppressWarnings("unchecked")
	public List<Reservierung> getReservierung(String vorname, String nachname)
			throws DatabaseNotFoundException {

		List<Reservierung> reservierungen = null;

		try {
			Session session = HibernateHelper.getSession();
			// Person -ID herausfinden
			Query queryID = session.createQuery("from person p where (p.vorname = :vorname AND p.nachname= := nachname) OR (p.vorname = :nachname AND p.nachname= := vorname)");
			queryID.setString("vorname", vorname);
			queryID.setString("nachname", nachname);
			List<Person> persons = queryID.list();
			
			if (persons.size() == 0) {
				throw new DatabaseNotFoundException();
			}
			
			int id = persons.get(0).getID();
			
			// die reservierungen mit der entsprechenden id suchen
			Query query = session.createQuery("from " + getTable()
					+ " r where r.personID = :id");
			query.setString("id", String.valueOf(id));

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new DatabaseNotFoundException();
			}
			
			reservierungen = results;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return reservierungen;
	}

}
