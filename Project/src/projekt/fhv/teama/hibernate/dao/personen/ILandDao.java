package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface ILandDao extends IGenericDao<ILand> {
	public ILand getLandByBez(String landname);
	public ILand getLandByKuerzel(String kuerzel);
}
