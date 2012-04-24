package projekt.fhv.teama.model.interfaces;

import java.sql.Date;
import java.util.List;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.WrongParameterException;

public interface IModelReservierung {

	List<IReservierung> getAllReservierungen() throws DatabaseException;

	void setAktuelleReservierung(IReservierung reservierung);

	IReservierung getAktuelleReservierung() throws FokusException;

	List<ITeilreservierung> getTeilreservierungen() throws FokusException;

	void setVon(Date date);

	void setBis(Date date);

	List<IGast> getGaeste() throws FokusException;
	
	boolean containsGast(IGast gast);

	void save(IReservierung r) throws DatabaseException, EmptyParameterException ;

	List<IReservierung> getCheckInReservierungen(Date date) throws DatabaseException;

	void setBearbeitet(boolean b) throws WrongParameterException;

}
