package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.controller.exeption.LoginInExeption;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;


/**
 * Interface Model Mitarbeiter
 * @author Team-A
 * @version 1.5
 */
public interface IModelMitarbeiter {

	/**
	 * Methode um den Mitarbeiter per Username und Passwort abzurufen
	 * @param uid
	 * @param pw
	 * @return IMitarbeiter
	 * @throws DatabaseException
	 * @throws LoginInExeption
	 */
	IMitarbeiter getMitarbeiterByUid(String uid,String pw)throws DatabaseException,LoginInExeption;

}
