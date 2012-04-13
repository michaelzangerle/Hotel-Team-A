package projekt.fhv.teama.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.Saison;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

public class SaisonDao extends GenericDao<Saison> {

	public SaisonDao() {
		super("Saison");
	}

	public Saison getSaison(String saisonsBezeichnung)
			throws DatabaseNotFoundException {

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
				throw new DatabaseNotFoundException();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return saison;
	}

}
