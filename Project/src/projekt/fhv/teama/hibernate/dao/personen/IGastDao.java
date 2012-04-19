package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.IGast;

public interface IGastDao extends IPersonDao {
	public IGast getGastByNummer(String gastnummer);
}
