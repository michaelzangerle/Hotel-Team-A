/**
 * 
 */
package projekt.fhv.teama.hibernate.dao;

import projekt.fhv.teama.classes.IAufenthaltLeistung;
import projekt.fhv.teama.hibernate.dao.IAufenthaltLeistungDao;

/**
 * Beschreibt 
 * @author Team A
 * @version 1.2
 */
public class AufenthaltLeistungDao extends GenericDao<IAufenthaltLeistung> implements IAufenthaltLeistungDao{

	/**
	 * @param table
	 */
	public AufenthaltLeistungDao() {
		super("aufenthaltLeistung");
	}
	
	

}
