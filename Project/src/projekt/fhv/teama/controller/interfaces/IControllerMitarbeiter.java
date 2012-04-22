package projekt.fhv.teama.controller.interfaces;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.controller.exeption.LoginInExeption;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IControllerMitarbeiter {

	IMitarbeiter getMitarbeiterByUid(String uid,String pw)throws DatabaseException,LoginInExeption;

}
