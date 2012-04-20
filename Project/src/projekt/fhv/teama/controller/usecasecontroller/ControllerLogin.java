package projekt.fhv.teama.controller.usecasecontroller;

import projekt.fhv.teama.controller.interfaces.IControllerMitarbeiter;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerLogin;

public class ControllerLogin implements IControllerLogin {

	
	IControllerMitarbeiter controllermitarbeiter;
	
	public ControllerLogin(IControllerMitarbeiter cmitarbeiter) {
		
		controllermitarbeiter=cmitarbeiter;
	}
	
	public boolean checkLogin(String uid,String pw)
	{
		return true;
	}
	
	
}
