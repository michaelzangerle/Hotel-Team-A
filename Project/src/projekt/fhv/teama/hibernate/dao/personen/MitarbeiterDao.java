package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.Mitarbeiter;
import projekt.fhv.teama.hibernate.dao.GenericDao;

public class MitarbeiterDao extends GenericDao<Mitarbeiter> {

	
	public MitarbeiterDao() {
		super("Mitarbeiter");
	}
}
