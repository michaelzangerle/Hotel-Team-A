package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * Interface für die Klasse LandDao
 * 
 * @author Team A
 * @version 1.2
 */
public interface ILandDao extends IGenericDao<ILand> {

	/**
	 * Sucht nach einem Land mit der übergebenen Bezeichnung
	 * @param landname String
	 * @return ILand
	 * @throws DatabaseException
	 */
	public ILand getLandByBez(String landname) throws DatabaseException;

	/**
	 * Sucht nach einem Land mit übergebenem Kürzel
	 * @param kuerzel String
	 * @return ILand
	 * @throws DatabaseException
	 */
	public ILand getLandByKuerzel(String kuerzel) throws DatabaseException;
}
