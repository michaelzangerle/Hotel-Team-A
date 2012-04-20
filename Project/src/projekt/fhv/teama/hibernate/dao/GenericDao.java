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
import org.hibernate.exception.ConstraintViolationException;

import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;
import projekt.fhv.teama.hibernate.exceptions.RemoveEntryException;

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
	public void create(T obj) throws DatabaseException {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateHelper.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(obj);
			tx.commit();
			tx = null;

		} catch (HibernateException e) {
			
			if (tx != null) {
				tx.rollback();
			}
			
			e.printStackTrace();
			throw new DatabaseException("ERROR: Error occured while trying to create some entry!");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new DatabaseException("FATAL ERROR: Error occured while trying to create some entry!");
			
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<T> getAll() throws DatabaseException {
		
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
			throw new DatabaseException("ERROR: Error occured while trying to get all entries!");
			
		} catch (Exception e) {

			e.printStackTrace();
			throw new DatabaseException("FATAL ERROR: Error occured while trying to get all entries!");
			
		} finally {
			
			session.close();
		}
		
		Set<T> set = new HashSet<T>(results);
		return set;
	}

	@Override
	public T getById(int id) throws DatabaseException {

		T object = null;
		Session session = null;

		try {
			session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + this.table + " t where t.ID = :id");
			query.setString("id", id + "");

			@SuppressWarnings("unchecked")
			List<T> results = query.list();
			
			if(results.size() == 0) {
				throw new NoDatabaseEntryFoundException();
			}
			
			if (results.size() == 1) {
				object = (T) results.get(0);
			}

		} catch (HibernateException e) {

			e.printStackTrace();
			throw new DatabaseException("ERROR: Error occured while trying to get some entry by ID!");
			
		} catch (Exception e) {

			e.printStackTrace();
			throw new DatabaseException("FATAL ERROR: Error occured while trying to get some entry by ID!");
			
		} finally {
			
			session.close();
		}

		return object;
	}

	@Override
	public void remove(T obj) throws DatabaseException {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateHelper.getSession();
			tx = session.beginTransaction();
			session.delete(obj);
			tx.commit();
			tx = null;
			
		}	catch (ConstraintViolationException e) {
			
			throw new RemoveEntryException();
		
		} catch (HibernateException e) {
			
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
			throw new DatabaseException("ERROR: Error occured while trying to remove some entry!");
			
		} catch (Exception e) {

			e.printStackTrace();
			throw new DatabaseException("FATAL ERROR: Error occured while trying to remove some entry!");
			
		} finally {
			
			session.close();
		}

	}

	@Override
	public void update(T obj) throws DatabaseException {

		Session session = null;
		Transaction tx = null;

		try {
			
			session = HibernateHelper.getSession();
			tx = session.beginTransaction();
			session.update(obj);
			tx.commit();
			tx = null;
			
		} catch (HibernateException e) {
			
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
			throw new DatabaseException("ERROR: Error occured while trying to update some entry!");
			
		} catch (Exception e) {

			e.printStackTrace();
			throw new DatabaseException("FATAL ERROR: Error occured while trying to update some entry!");
			
		} finally {
			
			session.close();
		}

	}

}
