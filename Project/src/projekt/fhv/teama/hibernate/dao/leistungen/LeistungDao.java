package projekt.fhv.teama.hibernate.dao.leistungen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.leistungen.Leistung;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

public class LeistungDao extends GenericDao<Leistung>{

	public LeistungDao() {
		super("Leistung");
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Leistung> getLeistung(String bezeichnung) throws DatabaseNotFoundException {
		
		List<Leistung> leistungen = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from "+getTable()+" l where l.bezeichnung = :bezeichnung");
			query.setString("bezeichnung", bezeichnung);
			
			@SuppressWarnings("rawtypes")
			List results = query.list();
						
			if (results.size() == 0) {
				throw new DatabaseNotFoundException();
			}
			
			leistungen = results;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return leistungen;
	}
	
}
