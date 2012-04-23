package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IModelZimmerstatus {

	IZimmerstatus getStatusByKuerzel(String string)throws DatabaseException;

}
