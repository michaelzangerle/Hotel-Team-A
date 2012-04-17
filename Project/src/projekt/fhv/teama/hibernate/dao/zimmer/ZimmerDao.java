/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.zimmer.Zimmer;
import projekt.fhv.teama.controller.interfaces.interfacesmodel.IZimmer;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

/**
 * @author mike
 * 
 */
public class ZimmerDao extends GenericDao<Zimmer> {

	public ZimmerDao() {
		super("Zimmer");
	}

	public Zimmer getZimmerByNummer(String nr) throws DatabaseException {

		Zimmer zimmer = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable()
					+ " z where z.nummer = :nr");
			query.setString("nr", nr);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new DatabaseNotFoundException("No results found!");
			}
			
			zimmer = (Zimmer) results.get(0);

		} catch (HibernateException e) {
			throw new DatabaseException();

		}

		return zimmer;
	}
	
	@SuppressWarnings("unchecked")
	public List<Zimmer> getZimmerByKategorie(String kategorie) throws DatabaseException {

		List<Zimmer> zimmer = null;

		try {
			// TODO Zimmer: getZimmerByKategorie(String kategorie)
			// Join auf kategorietabelle
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable()
					+ " z where z.kategorie = :kategorie");
			query.setString("kategorie", kategorie);

			
			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new DatabaseNotFoundException("No results found!");
			}
			
			zimmer = results;

		} catch (HibernateException e) {
			throw new DatabaseException();

		}

		return zimmer;
	}
	
	@SuppressWarnings("unchecked")
	public List<Zimmer> getZimmerByKategorie(int ID) throws DatabaseException {

		List<Zimmer> zimmer = null;

		try {
			
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable()
					+ " z where z.kategorieID = :ID");
			query.setString("ID", String.valueOf(ID));

			
			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new DatabaseNotFoundException("No results found!");
			}
			
			zimmer = results;

		} catch (HibernateException e) {
			throw new DatabaseException();

		}

		return zimmer;
	}

}
