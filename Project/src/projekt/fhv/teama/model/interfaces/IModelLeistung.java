package projekt.fhv.teama.model.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;


public interface IModelLeistung{

	/**
	 * Methode um alle Leistungen auszulesen die es gibt
	 * @return List<ILeistung>
	 * @throws DatabaseException
	 */
	public List<ILeistung> getLeistungen() throws DatabaseException;

}
