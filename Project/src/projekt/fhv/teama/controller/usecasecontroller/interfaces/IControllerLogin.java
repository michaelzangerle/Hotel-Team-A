package projekt.fhv.teama.controller.usecasecontroller.interfaces;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.controller.exeption.LoginInExeption;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;


/**
 * Interface für die Anmeldung (Login)
 * @author Team-A
 * @version 1.5
 */
public interface IControllerLogin {

   /**
    * Methode um einen eingegebenen Login abzuprüfen
    * @param uid
    * @param pw
    * @return IMitarbeiter
    * @throws DatabaseException
    * @throws LoginInExeption
    */
	public IMitarbeiter checkLogin(String uid,String pw) throws DatabaseException, LoginInExeption;
	
	
}
