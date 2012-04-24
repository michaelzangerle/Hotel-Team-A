package projekt.fhv.teama.hibernate.dao.leistungen;

import projekt.fhv.teama.classes.leistungen.IArtikel;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface für die Klasse ArtikelDao
 * @author Team A
 * @version 1.2
 */
public interface IArtikelDao extends IGenericDao<IArtikel> {
	
	/**
	 * Liefert einen Artikel mit dem übergebenen Parameter als Bezeichnung
	 * @param bez String
	 * @return IArtikel
	 * @throws DatabaseEntryNotFoundException
	 */
	public IArtikel getArtikel (String bez) throws DatabaseEntryNotFoundException ;
}
