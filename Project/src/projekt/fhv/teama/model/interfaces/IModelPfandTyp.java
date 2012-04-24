package projekt.fhv.teama.model.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;


/**
 * Interface des PfandTyp Model 
 * @author Team-A
 * @version 1.5
 */
public interface IModelPfandTyp {

	/**
	 * Um alle Pfandtypen zu erhalten
	 * @return List<IPfandtyp>
	 * @throws DatabaseException
	 */
	public List<IPfandtyp> getPfandtyps() throws DatabaseException;

	/**
	 * Um den ausgewählten Pfandtyp im Controller zu setzen
	 * @param pfandtyp IPfandtyp
	 * @throws EmptyParameterException
	 */
	public void setAktuellerPfandTyp(IPfandtyp pfandtyp)
			throws EmptyParameterException;

	/**
	 * Um den ausgewählten Pfandtyp zu abzurufen
	 * @return IPfandtyp
	 * @throws FokusException
	 */
	public IPfandtyp getAktuellerPFandtyp() throws FokusException;

}
