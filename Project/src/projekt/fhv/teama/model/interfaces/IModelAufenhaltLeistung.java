package projekt.fhv.teama.model.interfaces;

import java.sql.Date;

import java.util.List;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.controller.usecasecontroller.LeistungAnzahl;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.WrongParameterException;
import projekt.fhv.teama.model.integration.IAModelAufenthaltLeistung;

public interface IModelAufenhaltLeistung extends IAModelAufenthaltLeistung {

	public abstract void save(ILeistung leistung, IAufenthalt aufenthalt,
			int anzahl, Date datum) throws WrongParameterException,
			DatabaseException;

	public abstract List<LeistungAnzahl> getLeistungenByAufenhalt(
			IAufenthalt auf) throws DatabaseException;

}