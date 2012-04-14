package projekt.fhv.teama.hibernate.dao.personen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;
import projekt.fhv.teama.classes.personen.Berechtigung;

public class BerechtigungDao extends GenericDao<Berechtigung>{

	public BerechtigungDao() {
		super("Berechtigung");
	}
	
	@SuppressWarnings("unchecked")
	public Berechtigung getBerechtigungByBezeichnung(String bezeichnung) throws DatabaseException {
		List<Berechtigung> berechtigungenList = null;
		
		try {
			Session session = HibernateHelper.getSession();
			
			Query query = session.createQuery("from Berechtigung b where b.bezeichnung =:bezeichnung");
			query.setString("bezeichnung", bezeichnung);
			berechtigungenList = query.list();
			
			if (berechtigungenList.size() == 0) {
				throw new DatabaseNotFoundException();
			}
		} catch (HibernateException e) {
			throw new DatabaseException();
		}
		return (Berechtigung) berechtigungenList.get(0);
	}
}
