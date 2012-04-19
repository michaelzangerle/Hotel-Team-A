/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 * @param <T>
 * 
 */
public class KategorieDao extends GenericDao<IKategorie> implements IKategorieDao {

	private static KategorieDao instance;

	public static IKategorieDao getInstance() {
		if (instance != null) {
			instance = new KategorieDao();
		}
		return instance;
	}

	private KategorieDao() {
		super("Kategorie");
	}

	public IKategorie getKategorie(String kategorieName) throws NoDatabaseEntryFoundException {

		IKategorie kategorie = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " k where k.bezeichnung = :kategorieName");
			query.setString("kategorieName", kategorieName);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 1) {
				kategorie = (IKategorie) results.get(0);
			}

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return kategorie;
	}

}
