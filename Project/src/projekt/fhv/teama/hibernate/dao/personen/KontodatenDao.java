package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.Kontodaten;
import projekt.fhv.teama.hibernate.dao.GenericDao;

public class KontodatenDao extends GenericDao<Kontodaten>{

	public KontodatenDao() {
		super("KONTODATEN");
	}
}
