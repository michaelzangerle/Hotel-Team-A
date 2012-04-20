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
import org.hibernate.Transaction;

import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 * 
 */
public abstract class GenericDao<T> implements IGenericDao<T> {

	private String table;

	protected String getTable() {
		return table;
	}

	public GenericDao(String table) {
		this.table = table;
	}

	@Override
	public void create(T obj) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateHelper.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(obj);
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

	@SuppressWarnings("unchecked")
	@Override
	public Set<T> getAll() throws NoDatabaseEntryFoundException {
		Session session = null;
		List<T> results = null;

		try {
			session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + this.table);

			results = query.list();

			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		Set<T> set = new HashSet<T>(results);
		return set;
	}

	@Override
	public T getById(int id) {

		T object = null;
		Session session = null;

		try {
			session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + this.table + " t where t.ID = :id");
			query.setString("id", id + "");

			@SuppressWarnings("unchecked")
			List<T> results = query.list();

			if (results.size() == 1) {
				object = (T) results.get(0);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return object;
	}

	@Override
	public void removeById(int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateHelper.getSession();
			tx = session.beginTransaction();
			session.delete(id);
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

	@Override
	public void update(T obj) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateHelper.getSession();
			tx = session.beginTransaction();
			session.update(obj);
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

}
