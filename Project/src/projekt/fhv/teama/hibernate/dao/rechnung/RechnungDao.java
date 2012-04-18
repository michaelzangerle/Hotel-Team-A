package projekt.fhv.teama.hibernate.dao.rechnung;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.Mitarbeiter;
import projekt.fhv.teama.classes.rechnung.IRechnung;
import projekt.fhv.teama.classes.rechnung.Rechnung;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class RechnungDao extends GenericDao<Rechnung> {

	public RechnungDao() {
		super("Rechnung");
	}

	@SuppressWarnings("unchecked")
	public List<IRechnung> getRechnungByMitarbeiter(String vorname, String nachname)
			throws NoDatabaseEntryFoundException {

		List<IRechnung> rechnungen = null;

		try {
			Session session = HibernateHelper.getSession();

			// Person -ID herausfinden
			Query queryID = session
					.createQuery("from mitarbeiter m where (m.vorname = :vorname AND m.nachname= := nachname) OR (m.vorname = :nachname AND m.nachname= := vorname)");
			queryID.setString("vorname", vorname);
			queryID.setString("nachname", nachname);

			List<Mitarbeiter> mitarbeiterList = queryID.list();
			int id = -1;
			if (mitarbeiterList.size() == 1) {
				id = mitarbeiterList.get(0).getID();

			} else {
				throw new NoDatabaseEntryFoundException();
			}

			Query query = session.createQuery("from " + getTable() + " r where r.mitarbeiterID = :id");
			query.setString("id", String.valueOf(id));

			List<IRechnung> results = query.list();

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
	public List<IRechnung> getRechnungByBezahler(String vorname, String nachname) throws NoDatabaseEntryFoundException {

		List<IRechnung> rechnungen = null;

		try {
			Session session = HibernateHelper.getSession();

			Query query = session
					.createQuery("from "
							+ getTable()
							+ " r where (r.bezahlerVorname = :vorname AND r.bezahlerNachname= := nachname) OR (r.bezahlerVorname = :nachname AND r.bezahlerNachname= := vorname)");
			query.setString("vorname", vorname);
			query.setString("nachname", nachname);
			rechnungen = query.list();

			if (rechnungen.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return rechnungen;
	}

}
