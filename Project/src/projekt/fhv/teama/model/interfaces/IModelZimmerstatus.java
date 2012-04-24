package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.NotContainExeption;


/**
 * Interface für das Zimmerstatus Model
 * @author Team-A
 * @version 1.5
 */
public interface IModelZimmerstatus {

	/**
	 * Um den Zimmerstatus per Kuerzel zu erhalten
	 * @param string
	 * @return IZimmerstatus
	 * @throws DatabaseException
	 * @throws NotContainExeption
	 */
	IZimmerstatus getStatusByKuerzel(String string)throws DatabaseException, NotContainExeption;

}
