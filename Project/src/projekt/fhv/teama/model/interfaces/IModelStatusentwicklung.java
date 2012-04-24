package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IStatusentwicklung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;

public interface IModelStatusentwicklung {

	/**
	 * Um eine Statusentwicklung für ein Zimmer hinzuzufügen
	 * @param aktullesZimmer
	 * @param b 
	 * @param aktulleReservierung
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 */
	void add(IZimmer aktullesZimmer, IZimmerstatus b,IReservierung aktulleReservierung)throws DatabaseException, EmptyParameterException ;

	/**
	 * Um eine Statusentwicklung abzuspeichen
	 * @param statusentwicklung
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 */
	void save(IStatusentwicklung statusentwicklung)throws DatabaseException, EmptyParameterException;

}
