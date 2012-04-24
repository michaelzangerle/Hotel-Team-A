package projekt.fhv.teama.model.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;

public interface IModelPfandTyp {

	
	public List<IPfandtyp> getPfandtyps() throws DatabaseException;
	public void setAktuellerPfandTyp(IPfandtyp pfandtyp) throws EmptyParameterException;

	public IPfandtyp getAktuellerPFandtyp() throws FokusException;

}
