/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.personen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.Person;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

/**
 * @author mike
 *
 */
public class PersonDao<T> extends GenericDao<T>{

	public PersonDao() {
		super("Person");
	}
	
	public List<Person> getPerson(String name) throws DatabaseException {
		
		List<Person> p = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from "+getTable()+" p where p.vorname = :name OR p.nachname = :name");
			query.setString("name", name);
			
			@SuppressWarnings("rawtypes")
			List results = query.list();
			
			if (results.size() == 0) {
				throw new DatabaseNotFoundException("No results found!");
			}	
			
		} catch (HibernateException e) {
			throw new DatabaseException();
		
		}
		
		return p;
	}
	
	public List<Person> getPerson(String firstname, String lastname) throws DatabaseException {
		
		List<Person> p = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from "+getTable()+" p where (p.vorname = :firstname AND p.nachname = :lastname) OR (p.vorname = :lastname AND p.nachname = :firstname)");
			query.setString("firstname", firstname);
			query.setString("lastname", lastname);
			@SuppressWarnings("rawtypes")
			List results = query.list();
			
			if (results.size() == 0) {
				throw new DatabaseNotFoundException();
			}	
			
		} catch (HibernateException e) {
			throw new DatabaseException();
		}
		
		return p;
	}

}
