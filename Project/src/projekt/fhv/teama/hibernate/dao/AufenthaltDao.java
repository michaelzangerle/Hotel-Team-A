/**
 * 
 */
package projekt.fhv.teama.hibernate.dao;

import java.util.List;

import projekt.fhv.teama.classes.Aufenthalt;

/**
 * @author mike
 *
 */
public class AufenthaltDao extends GenericDao<Aufenthalt>{

	public AufenthaltDao() {
		super("Aufenthalt");
		
	}
	// beide kicken
	public List<Aufenthalt> getAufenthaltByGastName(String vorname, String nachname) {
		// TODO Aufenthalt: getAufenthaltByGastName(String vorname, String nachname)
		return null;
	}
	
	public List<Aufenthalt> getAufenthaltByZimmerNummer(String nr) {
		// TODO Aufenthalt: getAufenthaltByZimmerNummer(String nr)
		return null;
	}
}
