/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.leistungen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.leistungen.Artikel;
import projekt.fhv.teama.classes.leistungen.IArtikel;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 * 
 */
public class ArtikelDao extends GenericDao<IArtikel> implements IArtikelDao {
	
	private static ArtikelDao instance;

	public static IArtikelDao getInstance() {
		if (instance == null) {
			instance = new ArtikelDao();
		}
		return instance;
	}

	private ArtikelDao() {
		super("Artikel");

	}

	@SuppressWarnings("unchecked")
	public IArtikel getArtikel(String bezeichnung) throws NoDatabaseEntryFoundException {

		List<Artikel> artikel = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " a where a.bezeichnung = :bezeichnung");
			query.setString("bezeichnung", bezeichnung);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

			artikel = results;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return (IArtikel)artikel.get(0);
	}

}
