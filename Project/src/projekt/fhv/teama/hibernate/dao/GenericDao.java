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
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseConstraintViolationException;

/**
 * Regelt die grundlegenden Abfragen auf die Datenbank welcher bei allen Tabellen die selben sind 
 * @author Team A
 * @version 1.9
 * @param <T> Typ von IModel
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

		} catch (ConstraintViolationException e) {

			throw new DatabaseConstraintViolationException("ERROR: Probaly trying to insert a not allowed null value or unique value twice!");

		} catch (HibernateException e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
			throw new DatabaseException("ERROR: Error occured while trying to create some entry!");

		} catch (Exception e) {

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
				throw new DatabaseEntryNotFoundException();
			}

		} catch (HibernateException e) {
			
//			e.printStackTrace();
			throw new DatabaseException("ERROR: Error occured while trying to get all entries!");

		} catch (Exception e) {

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

			if (results.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

			if (results.size() == 1) {
				object = (T) results.get(0);
			}

		} catch (HibernateException e) {
			
			throw new DatabaseException("ERROR: Error occured while trying to get some entry by ID!");

		} catch (Exception e) {

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

		} catch (ConstraintViolationException e) {

			throw new DatabaseConstraintViolationException();

		} catch (HibernateException e) {

			if (tx != null) {
				tx.rollback();
			}

			throw new DatabaseException("ERROR: Error occured while trying to remove some entry!");

		} catch (Exception e) {

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
			
		} catch (ConstraintViolationException e) {

			throw new DatabaseConstraintViolationException("ERROR: Probaly trying to insert a unique value twice!");

		} catch (HibernateException e) {

			if (tx != null) {
				tx.rollback();
			}

			throw new DatabaseException("ERROR: Error occured while trying to update some entry!");

		} catch (Exception e) {

			throw new DatabaseException("FATAL ERROR: Error occured while trying to update some entry!");

		} finally {

			session.close();
		}

	}

}
