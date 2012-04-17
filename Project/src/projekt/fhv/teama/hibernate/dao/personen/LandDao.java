package projekt.fhv.teama.hibernate.dao.personen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.Land;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

public class LandDao extends GenericDao<Land> {

	public LandDao() {
		super("Land");
	}

	public Land getLandByBez(String bezeichnung) throws DatabaseException {
		Land p = null;

		try {
			Session session = HibernateHelper.getSession();
			Query q = session.createQuery("from Land where bezeichnung= :bezeichnung");
			q.setString("bezeichnung", bezeichnung);
			
			@SuppressWarnings("rawtypes")
			List result = q.list();

			if (result.size() == 1) {
				p = (Land) result.get(0);
			}

			if (result.size() == 0) {
				throw new DatabaseNotFoundException();
			}

		} catch (HibernateException e) {
			throw new DatabaseException();
		}
		return p;
	}
	
	public Land getLandByKuerzel(String kuerzel){
		
		//TODO
		return null;
	}
}
