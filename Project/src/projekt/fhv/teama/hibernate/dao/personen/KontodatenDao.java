package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.hibernate.dao.GenericDao;

/**
 * Regelt die Zugriffe auf die Kontodaten-Tabelle
 * 
 * @author Team A
 * @version 1.2
 */
public class KontodatenDao extends GenericDao<IKontodaten> implements IKontodatenDao {

	private static KontodatenDao instance;

	public static IKontodatenDao getInstance() {
		if (instance == null) {
			instance = new KontodatenDao();
		}
		return instance;
	}

	private KontodatenDao() {
		super("Kontodaten");
	}

}