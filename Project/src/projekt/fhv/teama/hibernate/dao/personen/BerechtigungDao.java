package projekt.fhv.teama.hibernate.dao.personen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;
import projekt.fhv.teama.classes.personen.IBerechtigung;

public class BerechtigungDao extends GenericDao<IBerechtigung> implements IBerechtigungDao {
	private static IBerechtigungDao instance;

	public static IBerechtigungDao getInstance() {
		if (instance == null) {
			instance = new BerechtigungDao();
		}
		return instance;
	}
	
	private BerechtigungDao() {
		super("Berechtigung");
	}
	
	@SuppressWarnings("unchecked")
	public IBerechtigung getBerechtigungByBezeichnung(String bezeichnung) throws DatabaseException {
		List<IBerechtigung> berechtigungenList = null;
		
		try {
			Session session = HibernateHelper.getSession();
			
			Query query = session.createQuery("from Berechtigung b where b.bezeichnung =:bezeichnung");
			query.setString("bezeichnung", bezeichnung);
			berechtigungenList = query.list();
			
			if (berechtigungenList.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}
		} catch (HibernateException e) {
			throw new DatabaseException();
		}
		return (IBerechtigung) berechtigungenList.get(0);
	}
}
