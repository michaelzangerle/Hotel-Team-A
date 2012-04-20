package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.zimmer.ISaison;
import projekt.fhv.teama.classes.zimmer.Saison;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public class SaisonDao extends GenericDao<ISaison> implements ISaisonDao{

	private static SaisonDao instance;
	
	public static ISaisonDao getInstance(){
		if(instance == null) {
			instance = new SaisonDao();
		}
		return instance;
	}
		
	private SaisonDao() {
		super("Saison");
	}

	public Saison getSaison(String saisonsBezeichnung)
			throws DatabaseEntryNotFoundException {

		Saison saison = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable()
					+ " s where s.bezeichnung = :saisonsBezeichnung");
			query.setString("saisonsBezeichnung", saisonsBezeichnung);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 1) {
				saison = (Saison) results.get(0);
			}

			if (results.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return saison;
	}

}
