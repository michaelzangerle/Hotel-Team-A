package projekt.fhv.teama.model.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.integration.IAModelZusatzleistung;

public interface IModelZusatzleistung extends IAModelZusatzleistung{

	
	/**
	 * Methode um alle Zusatzleistungen aus der Datenbank zu bekommen
	 * @return List<IZusatzleistung>
	 * @throws DatabaseException
	 */
	public List<ILeistung> getZusatzleistungen() throws DatabaseException;
}
