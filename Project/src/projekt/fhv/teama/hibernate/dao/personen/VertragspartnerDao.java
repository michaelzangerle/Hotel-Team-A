/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.personen;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import projekt.fhv.teama.classes.IKontingent;
import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.dao.IKontingentDao;
import projekt.fhv.teama.hibernate.dao.KontingentDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 *
 */
public class VertragspartnerDao extends GenericDao<IVertragspartner> implements IVertragspartnerDao {


	private static IVertragspartnerDao instance;

	
	public static IVertragspartnerDao getInstance() {
		if (instance == null) {
			instance = new VertragspartnerDao();
		}
		return instance;
	}
	
	@Override
	public void remove(IVertragspartner vertragspartner) throws DatabaseException {
		Session session = null;
		Transaction tx = null;
		
		Set<IKontingent> kontingente = vertragspartner.getKontingente(); 
		IKontingentDao kontingentDao = KontingentDao.getInstance();
		
		for (IKontingent kontingent : kontingente) {
			kontingentDao.remove(kontingent);
		}
		
		try {
			session = HibernateHelper.getSession();
			tx = session.beginTransaction();
			session.delete(vertragspartner);
			tx.commit();
			tx = null;
			// session.getTransaction().commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}
	
	public VertragspartnerDao() {
		super("Vertragspartner");
	}
	
	public IVertragspartner getVertragspartnerByName(String name) throws NoDatabaseEntryFoundException {
		
		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " p where p.name = :name");
			query.setString("name", name);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 1) {
				return (IVertragspartner) results.get(0);
			}

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return null;
	}

}
