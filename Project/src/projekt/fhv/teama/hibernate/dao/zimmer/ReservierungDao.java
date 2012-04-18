/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.Person;
import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.classes.zimmer.Reservierung;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 * 
 */
public class ReservierungDao extends GenericDao<Reservierung> {

	public ReservierungDao(String table) {
		super("Reservierung");

	}

	@SuppressWarnings("unchecked")
	public List<IReservierung> getReservierungByPerson(String vorname, String nachname)
			throws NoDatabaseEntryFoundException {

		List<IReservierung> reservierungen = null;

		try {
			Session session = HibernateHelper.getSession();
			// Person -ID herausfinden
			Query queryID = session
					.createQuery("from person p where (p.vorname = :vorname AND p.nachname= := nachname) OR (p.vorname = :nachname AND p.nachname= := vorname)");
			queryID.setString("vorname", vorname);
			queryID.setString("nachname", nachname);
			List<Person> persons = queryID.list();

			if (persons.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

			int id = persons.get(0).getID();

			// die reservierungen mit der entsprechenden id suchen
			Query query = session.createQuery("from " + getTable() + " r where r.personID = :id");
			query.setString("id", String.valueOf(id));

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

			reservierungen = results;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return reservierungen;
	}

	@SuppressWarnings("unchecked")
	public List<IReservierung> getReservierungByVP(String name) throws NoDatabaseEntryFoundException {

		List<IReservierung> reservierungen = null;

		try {
			Session session = HibernateHelper.getSession();
			// Person -ID herausfinden
			Query queryID = session.createQuery("from vertragsPartner p where p.name = :name");
			queryID.setString("name", name);
			List<IVertragspartner> vertragspartner = queryID.list();
			int id = -1;

			if (vertragspartner.size() == 1) {
				id = vertragspartner.get(0).getID();
			} else {
				throw new NoDatabaseEntryFoundException();
			}

			// die reservierungen mit der entsprechenden id suchen
			Query query = session.createQuery("from " + getTable() + " r where r.vertragsPartnerID = :id");
			query.setString("id", String.valueOf(id));

			List<IReservierung> results2 = query.list();

			if (results2.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

			reservierungen = results2;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return reservierungen;
	}

}
