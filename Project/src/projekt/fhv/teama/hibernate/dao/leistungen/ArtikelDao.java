/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.leistungen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.leistungen.Artikel;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

/**
 * @author mike
 *
 */
public class ArtikelDao extends GenericDao<Artikel>{

	public ArtikelDao() {
		super("Artikel");
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Artikel> getArtikel(String bezeichnung) throws DatabaseNotFoundException {
		
		List<Artikel> artikel = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from "+getTable()+" a where a.bezeichnung = :bezeichnung");
			query.setString("bezeichnung", bezeichnung);
			
			@SuppressWarnings("rawtypes")
			List results = query.list();
						
			if (results.size() == 0) {
				throw new DatabaseNotFoundException();
			}
			
			artikel = results;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return artikel;
	}
	

}
