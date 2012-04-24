package projekt.fhv.teama.hibernate.dao.rechnung;

import projekt.fhv.teama.classes.rechnung.IZahlungsmethode;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface für die Klasse ZahlungsmethodeDao
 * 
 * @author Team A
 * @version 1.2
 */
public interface IZahlungsmethodeDao extends IGenericDao<IZahlungsmethode> {
	
	/**
	 * Liefert eine Zahlungsmethode mit dem Parameter als Kürzel
	 * @param kz String
	 * @return IZahlungsmethode
	 * @throws DatabaseEntryNotFoundException
	 */
	public IZahlungsmethode getZahlungsmethodeByKuerzel(String kz) throws DatabaseEntryNotFoundException;

	/**
	 * Liefert eine Zahlungsmethode mit dem Parameter als Bezeichnung
	 * @param bez String 
	 * @return IZahlungsmethode
	 * @throws DatabaseEntryNotFoundException
	 */
	public IZahlungsmethode getZahlungsmethodeByBezeichnung(String bez) throws DatabaseEntryNotFoundException;
}
