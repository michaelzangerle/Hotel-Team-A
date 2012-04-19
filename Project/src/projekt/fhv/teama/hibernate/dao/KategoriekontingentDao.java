/**
 * 
 */
package projekt.fhv.teama.hibernate.dao;

import projekt.fhv.teama.classes.IKategoriekontingent;

/**
 * @author mike
 *
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
