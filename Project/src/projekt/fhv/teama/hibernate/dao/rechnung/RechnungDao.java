package projekt.fhv.teama.hibernate.dao.rechnung;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.Mitarbeiter;
import projekt.fhv.teama.classes.rechnung.Rechnung;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class RechnungDao extends GenericDao<Rechnung> {

	public RechnungDao() {
		super("Rechnung");
	}

	
	@SuppressWarnings("unchecked")
	public List<Rechnung> getRechnungByMitarbeiter(String vorname, String nachname)
			throws NoDatabaseEntryFoundException {

		List<Rechnung> rechnungen = null;

		try {
			Session session = HibernateHelper.getSession();
			// TODO Rechnung: getRechnungByMitarbeiter(String vorname, String nachname)
			// Person -ID herausfinden
			Query queryID = session.createQuery("from mitarbeiter m where (m.vorname = :vorname AND m.nachname= := nachname) OR (m.vorname = :nachname AND m.nachname= := vorname)");
			queryID.setString("vorname", vorname);
			queryID.setString("nachname", nachname);
			List<Mitarbeiter> mitarbeiterList = queryID.list();
			
			if (mitarbeiterList.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}
			
			int id = mitarbeiterList.get(0).getID();
			
			
			Query query = session.createQuery("from " + getTable()
					+ " r where r.mitarbeiterID = :id");
			query.setString("id", String.valueOf(id));

			List<Rechnung> results = query.list();

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}
			
			rechnungen = results;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return rechnungen;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rechnung> getRechnungByBezahler(String vorname, String nachname)
			throws NoDatabaseEntryFoundException {

		List<Rechnung> rechnungen = null;

		try {
			Session session = HibernateHelper.getSession();
			// Person -ID herausfinden
			Query queryID = session.createQuery("from "+getTable()+" m where (m.vorname = :vorname AND m.nachname= := nachname) OR (m.vorname = :nachname AND m.nachname= := vorname)");
			queryID.setString("vorname", vorname);
			queryID.setString("nachname", nachname);
			rechnungen = queryID.list();
			
			if (rechnungen.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return rechnungen;
	}
	
}
