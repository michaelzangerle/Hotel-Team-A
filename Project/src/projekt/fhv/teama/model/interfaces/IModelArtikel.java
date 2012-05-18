package projekt.fhv.teama.model.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.leistungen.IArtikel;
import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.integration.IAModelArtikel;

public interface IModelArtikel extends IAModelArtikel {

	/**
	 * Methode um alle Artikel aus der Datenbank zu bekommen
	 * @return List<IArtikel>
	 * @throws DatabaseException
	 */
	public List<ILeistung> getArtikel() throws DatabaseException;
	
}
