/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.leistungen;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.leistungen.IWarengruppe;
import projekt.fhv.teama.classes.leistungen.Warengruppe;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Regelt die Zugriffe auf die Warengruppe-Tabelle
 * 
 * @author Team A
 * @version 1.2
 */
public class WarengruppeDao extends GenericDao<IWarengruppe> implements IWarengruppeDao {

	private static WarengruppeDao instance;

	public static IWarengruppeDao getInstance() {
		if (instance == null) {
			instance = new WarengruppeDao();
		}
		return instance;
	}

	private WarengruppeDao() {
		super("Warengruppe");
	}

	@SuppressWarnings("unchecked")
	public IWarengruppe getWarengruppeByBezeichnung(String bezeichnung) throws DatabaseEntryNotFoundException {

		List<Warengruppe> warengruppe = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " l where l.bezeichnung = :bezeichnung");
			query.setString("bezeichnung", bezeichnung);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

			warengruppe = results;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return warengruppe.get(0);
	}
}
