/**
 * 
 */
package projekt.fhv.teama.hibernate.dao;

import projekt.fhv.teama.classes.IKategoriekontingent;

/**
 * Regelt den Zugriff auf die Kategoriekontingent-Tabelle 
 * @author Team A
 * @version 1.2
 */
public class KategoriekontingentDao extends GenericDao<IKategoriekontingent> implements IKategoriekontingentDao {

	private static KategoriekontingentDao instance;

	public static IKategoriekontingentDao getInstance() {
		if (instance == null) {
			instance = new KategoriekontingentDao();
		}
		return instance;
	}
	
	
	public KategoriekontingentDao() {
		super("Kategoriekontingent");
	}

}
