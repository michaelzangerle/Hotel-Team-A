package projekt.fhv.teama.controller.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public interface IControllerPfandTyp {

	List<IPfandtyp> getPfandtyps()throws NoDatabaseEntryFoundException ;

}
