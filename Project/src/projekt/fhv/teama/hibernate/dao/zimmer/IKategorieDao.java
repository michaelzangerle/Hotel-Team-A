package projekt.fhv.teama.hibernate.dao.zimmer;


import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface für die Klasse KategorieDao 
 * @author Team A
 * @version 1.2
 */
public interface IKategorieDao extends IGenericDao<IKategorie> {
	
	/**
	 * Sucht nach einer Kategorie anhand des Kategorienamens
	 * @param kategoriename String
	 * @return IKategorie
	 * @throws DatabaseEntryNotFoundException
	 */
	public IKategorie getKategorie(String kategoriename)throws DatabaseEntryNotFoundException ;
}
