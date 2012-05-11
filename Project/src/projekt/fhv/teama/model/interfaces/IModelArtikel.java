package projekt.fhv.teama.model.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.leistungen.IArtikel;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IModelArtikel {

	/**
	 * Methode um alle Artikel aus der Datenbank zu bekommen
	 * @return
	 * @throws DatabaseException
	 */
	public List<IArtikel> getArtikel() throws DatabaseException;
	
}
