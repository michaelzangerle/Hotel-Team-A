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
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 *
 */
public class PersonDao extends GenericDao<Person>{

	public PersonDao() {
		super("Person");
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getPerson(String name) throws DatabaseException {
		
		List<Person> p = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from "+getTable()+" p where p.vorname = :name OR p.nachname = :name");
			query.setString("name", name);
			
			@SuppressWarnings("rawtypes")
			List results = query.list();
			
			if (results.size() == 0) {
				throw new NoDatabaseEntryFoundException("No results found!");
			}	
			
			p = results;
			
		} catch (HibernateException e) {
			throw new DatabaseException();
		
		}
		
		return p;
	}
	
	@SuppressWarnings("unchecked")
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
				throw new NoDatabaseEntryFoundException();
			}	
			
			p = results;
			
		} catch (HibernateException e) {
			throw new DatabaseException();
		}
		
		return p;
	}

}
