package projekt.fhv.teama.controller.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IControllerPfandTyp {

	
	public List<IPfandtyp> getPfandtyps() throws DatabaseException;
	public void setAktuellerPfandTyp(IPfandtyp pfandtyp);

	public IPfandtyp getAktuellerPFandtyp();

}
