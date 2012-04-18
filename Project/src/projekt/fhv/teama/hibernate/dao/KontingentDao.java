/**
 * 
 */
package projekt.fhv.teama.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.IKontingent;
import projekt.fhv.teama.classes.Kontingent;
import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 * 
 */
public class KontingentDao extends GenericDao<Kontingent> {

	public KontingentDao() {
		super("Kontingent");

	}

	@SuppressWarnings("unchecked")
	public List<IKontingent> getKontingentByVPID(int id) throws NoDatabaseEntryFoundException {

		List<IKontingent> kontingente = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " k where k.vertragsPartnerID = :id");
			query.setString("id", String.valueOf(id));

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}
			
			kontingente = results;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return kontingente;
	}

	@SuppressWarnings("unchecked")
	public List<IKontingent> getKontingentByVPName(String name) throws NoDatabaseEntryFoundException {

		List<IKontingent> kontingente = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from vertragsPartner v where v.name = :name");
			query.setString("name", name);
			List<IVertragspartner> results = query.list();
			int id = results.get(0).getID();
			
			query = session.createQuery("from " + getTable() + " v where v.vertragsPartnerID = :id");
			query.setString("id", String.valueOf(id));

			List <IKontingent> results2 = query.list();

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}
			
			kontingente = results2;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return kontingente;
	}

}
