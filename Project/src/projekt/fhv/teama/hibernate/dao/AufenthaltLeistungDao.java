/**
 * 
 */
package projekt.fhv.teama.hibernate.dao;

import projekt.fhv.teama.classes.IAufenthaltLeistung;
import projekt.fhv.teama.hibernate.dao.IAufenthaltLeistungDao;

/**
 * Regelt den Zugriff auf die Aufenthalt-Leistung-Tabelle 
 * @author Team A
 * @version 1.2
 */
public class AufenthaltLeistungDao extends GenericDao<IAufenthaltLeistung> implements IAufenthaltLeistungDao{
	
	private static AufenthaltLeistungDao instance;
	
	/**
	 * @param table
	 */
	public AufenthaltLeistungDao() {
		super("AufenthaltLeistung");
	}
	
	public static IAufenthaltLeistungDao getInstance() {
		if (instance == null) {
			instance = new AufenthaltLeistungDao();
		}
		return instance;
	}


}
