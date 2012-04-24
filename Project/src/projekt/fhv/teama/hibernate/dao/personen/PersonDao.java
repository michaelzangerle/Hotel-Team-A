/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.personen;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Regelt die Zugriffe auf die Person-Tabelle 
 * @author Team A
 * @version 1.2
 */
public class PersonDao extends GenericDao<IPerson> implements IPersonDao {
	
	
	private static IPersonDao instance;

	public static IPersonDao getInstance() {
		if (instance == null) {
			instance = new PersonDao();
		}
		return instance;
	}
	
	private PersonDao() {
		super("Person");
	}
	
	@SuppressWarnings("unchecked")
	public Set<IPerson> getPersonByMail(String mail) throws DatabaseException {
		
		List<IPerson> p = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from "+getTable()+" p where p.email = :mail");
			query.setString("mail", mail);
			
			@SuppressWarnings("rawtypes")
			List results = query.list();
			
			if (results.size() == 0) {
				throw new DatabaseEntryNotFoundException("No results found!");
			}	
			
			p = results;
			
		} catch (HibernateException e) {
			throw new DatabaseException();
		
		}
		Set<IPerson> set = new HashSet<IPerson>(p);
		return set;
	}
	
	@SuppressWarnings("unchecked")
	public Set<IPerson> getPersonByName(String name) throws DatabaseException {
		
		List<IPerson> p = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from "+getTable()+" p where p.vorname = :name OR p.nachname = :name");
			query.setString("name", name);
			
			@SuppressWarnings("rawtypes")
			List results = query.list();
			
			if (results.size() == 0) {
				throw new DatabaseEntryNotFoundException("No results found!");
			}	
			
			p = results;
			
		} catch (HibernateException e) {
			throw new DatabaseException();
		
		}
		Set<IPerson> set = new HashSet<IPerson>(p);
		return set;
	}
	
	@SuppressWarnings("unchecked")
	public Set<IPerson> getPersonByName(String firstname, String lastname) throws DatabaseException {
		
		List<IPerson> p = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from "+getTable()+" p where (p.vorname = :firstname AND p.nachname = :lastname) OR (p.vorname = :lastname AND p.nachname = :firstname)");
			query.setString("firstname", firstname);
			query.setString("lastname", lastname);
			@SuppressWarnings("rawtypes")
			List results = query.list();
			
			if (results.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}	
			
			p = results;
			
		} catch (HibernateException e) {
			throw new DatabaseException();
		}
		Set<IPerson> set = new HashSet<IPerson>(p);
		return set;
	}

}
