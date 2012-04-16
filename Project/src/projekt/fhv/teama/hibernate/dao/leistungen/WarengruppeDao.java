/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.leistungen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.leistungen.Artikel;
import projekt.fhv.teama.classes.leistungen.Warengruppe;
import projekt.fhv.teama.classes.leistungen.Zusatzleistung;
import projekt.fhv.teama.classes.zimmer.Kategorie;

import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

/**
 * @author mike
 * 
 */
public class WarengruppeDao extends GenericDao<Warengruppe> {

	public WarengruppeDao() {
		super("Warengruppe");
	}

//	@Override
//	public List<Warengruppe> getAll() throws DatabaseNotFoundException {
//		
//		List<Warengruppe> warengruppen = null;
//
//		try {
//			Session session = HibernateHelper.getSession();
//			Query query = session.createQuery("from "+getTable());
//			
//			@SuppressWarnings({ "unchecked" })
//			List<Warengruppe> results = query.list();
//			
//			if (results.size() == 0) {
//				throw new DatabaseNotFoundException();
//			}
//			
//			for (Warengruppe w : results) {
//				Query queryZusatzleistungen = session.createQuery("from Zusatzleistung z where z.warengruppe = "+w.getID());
//				
//				Query queryArtikel = session.createQuery("from Artikel a where a.warengruppe = "+w.getID());
//				
//				
//				List<Artikel> artikel = (List<Artikel>)queryArtikel.list();
//				List<Zusatzleistung> zusatzleistung = (List<Zusatzleistung>)queryZusatzleistungen.list();
//				
//				// TODO - endlos schleife?
//				if(artikel != null && artikel.size() > 0) {
//				w.setArtikel(artikel);
//				}
//				if(zusatzleistung != null && zusatzleistung.size() > 0) {
//				w.setZusatzleistungen(zusatzleistung);
//				}
//			}
//			
//			warengruppen = results;
//			
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}
//		
//		return warengruppen;
//		
//	}
}
