package projekt.fhv.teama.model.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.leistungen.IZusatzleistung;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IModelZusatzleistung {

	
	/**
	 * Methode um alle Zusatzleistungen aus der Datenbank zu bekommen
	 * @return List<IZusatzleistung>
	 * @throws DatabaseException
	 */
	public List<IZusatzleistung> getArtikel() throws DatabaseException;
}
