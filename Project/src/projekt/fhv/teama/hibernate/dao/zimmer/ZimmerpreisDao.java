package projekt.fhv.teama.hibernate.dao.zimmer;

import projekt.fhv.teama.classes.zimmer.IZimmerpreis;
import projekt.fhv.teama.hibernate.dao.GenericDao;

/**
 * Regelt die Zugriffe auf die Zimmerpreis-Tabelle 
 * @author Team A
 * @version 1.2
 */
public class ZimmerpreisDao extends GenericDao<IZimmerpreis> implements IZimmerpreisDao {

	private static ZimmerpreisDao instance;

	public static IZimmerpreisDao getInstance() {
		if (instance == null) {
			instance = new ZimmerpreisDao();
		}
		return instance;
	}

	private  ZimmerpreisDao() {
		super("Zimmerpreis");
	}
	
	

}
