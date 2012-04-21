/**
 * 
 */
package projekt.fhv.teama.hibernate.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.IKontingent;
import projekt.fhv.teama.classes.Kontingent;
import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * @author mike
 * 
 */
public class KontingentDao extends GenericDao<IKontingent> implements IKontingentDao {

	private static KontingentDao instance;

	public static IKontingentDao getInstance() {
		if (instance == null) {
			instance = new KontingentDao();
		}
		return instance;
	}

	private KontingentDao() {
		super("Kontingent");

	}
	//kiken?
	@SuppressWarnings("unchecked")
	public Set<IKontingent> getKontingentByVPID(int id) throws DatabaseEntryNotFoundException {

		List<Kontingent> kontingente = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " k where k.vertragsPartnerID = :id");
			query.setString("id", String.valueOf(id));

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

			kontingente = results;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		Set<IKontingent> set = new HashSet<IKontingent>(kontingente);
		return set;
	}
	//kiken?
	@SuppressWarnings("unchecked")
	public Set<IKontingent> getKontingentByVPName(String name) throws DatabaseEntryNotFoundException {

		List<IKontingent> kontingente = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from vertragsPartner v where v.name = :name");
			query.setString("name", name);
			List<IVertragspartner> results = query.list();
			int id = results.get(0).getID();

			query = session.createQuery("from " + getTable() + " v where v.vertragsPartnerID = :id");
			query.setString("id", String.valueOf(id));

			List<IKontingent> results2 = query.list();

			if (results.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

			kontingente = results2;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		Set<IKontingent> set = new HashSet<IKontingent>(kontingente);
		return set;
	}

}
