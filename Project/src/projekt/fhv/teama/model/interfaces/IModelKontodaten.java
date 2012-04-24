package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;

public interface IModelKontodaten {

	void save(IKontodaten kontodaten) throws DatabaseException, EmptyParameterException;

}
