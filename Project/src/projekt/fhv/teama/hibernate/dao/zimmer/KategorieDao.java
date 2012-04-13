/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.zimmer.Kategorie;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

/**
 * @author mike
 * @param <T>
 * 
 */
public class KategorieDao extends GenericDao<Kategorie> {

	public KategorieDao() {
		super("Kategorie");
	}

	public Kategorie getKategorie(String kategorieName) throws DatabaseNotFoundException {
		
		Kategorie kategorie = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from "+getTable()+" k where k.bezeichnung = :kategorieName");
			query.setString("kategorieName", kategorieName);
			
			@SuppressWarnings("rawtypes")
			List results = query.list();
			
			if (results.size() == 1) {
				kategorie = (Kategorie) results.get(0);
			}	
			
			if (results.size() == 0) {
				throw new DatabaseNotFoundException();
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return kategorie;
	}
	
}