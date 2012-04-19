/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.rechnung;

import projekt.fhv.teama.classes.rechnung.ITeilzahlung;
import projekt.fhv.teama.hibernate.dao.GenericDao;

/**
 * @author mike
 * 
 */
public class TeilzahlungDao extends GenericDao<ITeilzahlung> implements ITeilzahlungDao {

	private static TeilzahlungDao instance;

	public static ITeilzahlungDao getInstance() {
		if (instance != null) {
			instance = new TeilzahlungDao();
		}
		return instance;
	}

	private TeilzahlungDao() {
		super("Teilzahlung");

	}

}
