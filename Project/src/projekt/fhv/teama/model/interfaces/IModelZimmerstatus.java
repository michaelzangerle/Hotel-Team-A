package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.NotContainExeption;

public interface IModelZimmerstatus {

	IZimmerstatus getStatusByKuerzel(String string)throws DatabaseException, NotContainExeption;

}
