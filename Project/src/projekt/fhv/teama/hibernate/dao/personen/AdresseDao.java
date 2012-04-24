package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.hibernate.dao.GenericDao;

/**
 * Regelt die Zugriffe auf die Adresse-Tabelle
 * 
 * @author Team A
 * @version 1.2
 */
public class AdresseDao extends GenericDao<IAdresse> implements IAdresseDao {
	private static IAdresseDao instance;

	public static IAdresseDao getInstance() {
		if (instance == null) {
			instance = new AdresseDao();
		}
		return instance;
	}

	private AdresseDao() {
		super("Adresse");
	}
}
