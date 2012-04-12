/**
 * 
 */
package projekt.fhv.teama.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.Kategorie;
import projekt.fhv.teama.hibernate.HibernateHelper;

/**
 * @author mike
 * @param <T>
 * 
 */
public class KategorieDao<T> extends GenericDao<T> {

	public KategorieDao() {
		super("Kategorie");
	}

	public Kategorie getKategorie(String kategorieName) {
		
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
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return kategorie;
	}
	
}
