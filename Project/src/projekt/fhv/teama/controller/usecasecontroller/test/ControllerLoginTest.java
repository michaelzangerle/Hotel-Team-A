package projekt.fhv.teama.controller.usecasecontroller.test;

import javax.security.auth.login.LoginException;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.controller.ControllerMitarbeiter;
import projekt.fhv.teama.controller.exeption.LoginInExeption;
import projekt.fhv.teama.controller.usecasecontroller.ControllerLogin;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class ControllerLoginTest {

	/**
	 * @param args
	 * @throws LoginInExeption 
	 */
	public static void main(String[] args) {
		
		ControllerLogin controllerLogin=new ControllerLogin(new ControllerMitarbeiter());
		
		try {
			IMitarbeiter loginok=controllerLogin.checkLogin("66", "1234");
			if(loginok!=null)
			{
				System.out.println("Login Ok\nVorname: "+loginok.getVorname()+"\nNachname: "+loginok.getNachname()+"\nEmail: "+loginok.getEmail());
			}
			else {
				System.out.println("Login Not Ok");
			}
			
		} catch (DatabaseException e) {
			System.out.println(e.getMessage());
		}
		 catch (LoginInExeption e) {
				System.out.println(e.getMessage());
			}
		
		

	}

}
