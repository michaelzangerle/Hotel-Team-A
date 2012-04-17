/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.leistungen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.leistungen.Warengruppe;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 * 
 */
public class WarengruppeDao extends GenericDao<Warengruppe> {

	public WarengruppeDao() {
		super("Warengruppe");
	}

	@SuppressWarnings("unchecked")
	public List<Warengruppe> getLeistung(String bezeichnung) throws NoDatabaseEntryFoundException {
		
		List<Warengruppe> warengruppe = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from "+getTable()+" l where l.bezeichnung = :bezeichnung");
			query.setString("bezeichnung", bezeichnung);
			
			@SuppressWarnings("rawtypes")
			List results = query.list();
						
			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}
			
			warengruppe = results;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return warengruppe;
	}	
	
}
