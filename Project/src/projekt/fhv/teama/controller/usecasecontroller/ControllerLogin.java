package projekt.fhv.teama.controller.usecasecontroller;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.controller.exeption.LoginInExeption;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerLogin;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.interfaces.IModelMitarbeiter;

public class ControllerLogin implements IControllerLogin {

	
	IModelMitarbeiter controllermitarbeiter;
	
	public ControllerLogin(IModelMitarbeiter cmitarbeiter) {
		
		controllermitarbeiter=cmitarbeiter;
	}
	
	public IMitarbeiter checkLogin(String uid,String pw) throws DatabaseException, LoginInExeption
	{
		return controllermitarbeiter.getMitarbeiterByUid(uid,pw);
	}
	
	
}
