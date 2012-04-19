package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface ILandDao extends IGenericDao<ILand> {
	public ILand getLandByBez(String landname) throws DatabaseException;
	public ILand getLandByKuerzel(String kuerzel) throws DatabaseException;
}
