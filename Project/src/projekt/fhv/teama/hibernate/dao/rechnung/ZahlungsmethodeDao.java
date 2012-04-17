package projekt.fhv.teama.hibernate.dao.rechnung;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.rechnung.Zahlungsmethode;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class ZahlungsmethodeDao extends GenericDao<Zahlungsmethode> {

	public ZahlungsmethodeDao() {
		super("Zahlungsmethode");
	}
	
	public Zahlungsmethode getZahlungsmethodeByKuerzel(String kuerzel) throws NoDatabaseEntryFoundException {
		
		Zahlungsmethode zahlungsmethode = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from "+getTable()+" z where z.kuerzel = :kuerzel");
			query.setString("kuerzel", kuerzel);
			
			@SuppressWarnings("rawtypes")
			List results = query.list();
			
			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}
			
			zahlungsmethode = (Zahlungsmethode) results.get(0);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return zahlungsmethode;
	}
	

}
