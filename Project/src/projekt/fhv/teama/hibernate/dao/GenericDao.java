/**
 * 
 */
package projekt.fhv.teama.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

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
		try {
			Session session = HibernateHelper.getSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() throws DatabaseNotFoundException {

		List<T> results = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + this.table);

			results = query.list();
			
			if (results.size() == 0) {
				throw new DatabaseNotFoundException();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return results;
	}

	@Override
	public T getById(int id) {

		T object = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + this.table + " t where t.ID = :id");
			query.setString("id", id + "");

			@SuppressWarnings("unchecked")
			List<T> results = query.list();

			if (results.size() == 1) {
				object = (T) results.get(0);
			}

		} catch (HibernateException e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return object;
	}

	@Override
	public void removeById(int id) {
		try {
			Session session = HibernateHelper.getSession();
			session.beginTransaction();
			session.delete(id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void update(T obj) {
		try {
			Session session = HibernateHelper.getSession();
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
