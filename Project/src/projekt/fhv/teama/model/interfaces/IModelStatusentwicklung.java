package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IStatusentwicklung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IModelStatusentwicklung {

	void add(IZimmer aktullesZimmer, IZimmerstatus b,IReservierung aktulleReservierung)throws DatabaseException ;

	void save(IStatusentwicklung statusentwicklung)throws DatabaseException;

}
