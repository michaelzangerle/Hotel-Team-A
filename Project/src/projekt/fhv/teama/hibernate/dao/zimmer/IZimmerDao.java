package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * Interface für die Klasse ZimmerDao 
 * @author Team A
 * @version 1.2
 */
public interface IZimmerDao extends IGenericDao<IZimmer> {
	
	/**
	 * Sucht nach einem Zimmer via Zimmernummer
	 * @param nr String
	 * @return IZimmer
	 * @throws DatabaseException
	 */
	public IZimmer getZimmerByNummer(String nr) throws DatabaseException;
	
	/**
	 * Sucht nach Zimmern via Kategorienamen
	 * @param kategorie String
	 * @return Set<IZimmer>
	 * @throws DatabaseException
	 */
	public Set<IZimmer> getZimmerByKategorie(String kategorie) throws DatabaseException;
	
	/**
	 * Sucht nach Zimmern via der KategorieID
	 * @param id int
	 * @return Set<IZimmer>
	 * @throws DatabaseException
	 */
	public Set<IZimmer> getZimmerByKategorieID(int id) throws DatabaseException;
}
