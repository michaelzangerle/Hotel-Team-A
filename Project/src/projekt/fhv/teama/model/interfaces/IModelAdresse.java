package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IModelAdresse {

	void save(IAdresse adr) throws DatabaseException;

}
