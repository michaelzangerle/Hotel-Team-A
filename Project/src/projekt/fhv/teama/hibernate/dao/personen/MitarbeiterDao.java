package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.hibernate.dao.GenericDao;

public class MitarbeiterDao extends GenericDao<IMitarbeiter> implements IMitarbeiterDao {

	private static IMitarbeiterDao instance;

	public static IMitarbeiterDao getInstance() {
		if (instance != null) {
			instance = new MitarbeiterDao();
		}
		return instance;
	}
	public MitarbeiterDao() {
		super("Mitarbeiter");
	}
}
