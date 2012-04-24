package projekt.fhv.teama.hibernate.dao.leistungen;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.classes.leistungen.Leistung;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Regelt die Zugriffe auf die Leistung-Tabelle
 * 
 * @author Team A
 * @version 1.2
 */
public class LeistungDao extends GenericDao<ILeistung> implements ILeistungDao {

	private static LeistungDao instance;

	public static ILeistungDao getInstance() {
		if (instance == null) {
			instance = new LeistungDao();
		}
		return instance;
	}

	private LeistungDao() {
		super("Leistung");

	}

	@SuppressWarnings("unchecked")
	public Set<ILeistung> getLeistung(String bezeichnung) throws DatabaseEntryNotFoundException {

		List<Leistung> leistungen = null;

		try {
			Session session = HibernateHelper.getSession();
			Query query = session.createQuery("from " + getTable() + " l where l.bezeichnung = :bezeichnung");
			query.setString("bezeichnung", bezeichnung);

			@SuppressWarnings("rawtypes")
			List results = query.list();

			if (results.size() == 0) {
				throw new DatabaseEntryNotFoundException();
			}

			leistungen = results;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		Set<ILeistung> set = new HashSet<ILeistung>(leistungen);
		return set;
	}

}
