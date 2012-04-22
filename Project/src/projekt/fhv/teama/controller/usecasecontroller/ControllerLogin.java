package projekt.fhv.teama.controller.usecasecontroller;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.controller.exeption.LoginInExeption;
import projekt.fhv.teama.controller.interfaces.IControllerMitarbeiter;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerLogin;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class ControllerLogin implements IControllerLogin {

	
	IControllerMitarbeiter controllermitarbeiter;
	
	public ControllerLogin(IControllerMitarbeiter cmitarbeiter) {
		
		controllermitarbeiter=cmitarbeiter;
	}
	
	public IMitarbeiter checkLogin(String uid,String pw) throws DatabaseException, LoginInExeption
	{
		return controllermitarbeiter.getMitarbeiterByUid(uid,pw);
	}
	
	
}
