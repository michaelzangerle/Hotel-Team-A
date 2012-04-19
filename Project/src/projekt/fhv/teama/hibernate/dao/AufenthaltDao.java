/**
 * 
 */
package projekt.fhv.teama.hibernate.dao;

import java.util.Set;

import projekt.fhv.teama.classes.IAufenthalt;

/**
 * @author mike
 * 
 */
public class AufenthaltDao extends GenericDao<IAufenthalt> implements IAufenthaltDao {

	private static AufenthaltDao instance;

	public static IAufenthaltDao getInstance() {
		if (instance != null) {
			instance = new AufenthaltDao();
		}
		return instance;
	}

	private AufenthaltDao() {
		super("Aufenthalt");

	}

	// beide kicken
	public Set<IAufenthalt> getAufenthaltByGastName(String vorname, String nachname) {
		// TODO Aufenthalt: getAufenthaltByGastName(String vorname, String
		// nachname)
		return null;
	}

	public Set<IAufenthalt> getAufenthaltByZimmerNummer(String nr) {
		// TODO Aufenthalt: getAufenthaltByZimmerNummer(String nr)
		return null;
	}
}
