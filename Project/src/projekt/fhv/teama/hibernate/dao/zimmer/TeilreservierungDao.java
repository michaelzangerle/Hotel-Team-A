/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.zimmer;

import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.hibernate.dao.GenericDao;

/**
 * @author mike
 * 
 */
public class TeilreservierungDao extends GenericDao<ITeilreservierung> implements ITeilreservierungDao {

	private static TeilreservierungDao instance;

	public static ITeilreservierungDao getInstance() {
		if (instance == null) {
			instance = new TeilreservierungDao();
		}
		return instance;
	}

	private TeilreservierungDao() {
		super("Teilreservierung");
	}

}
