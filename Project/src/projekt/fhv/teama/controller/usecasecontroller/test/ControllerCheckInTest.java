package projekt.fhv.teama.controller.usecasecontroller.test;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.controller.ControllerAdresse;
import projekt.fhv.teama.controller.ControllerAufenthalt;
import projekt.fhv.teama.controller.ControllerGast;
import projekt.fhv.teama.controller.ControllerKategorie;
import projekt.fhv.teama.controller.ControllerKontodaten;
import projekt.fhv.teama.controller.ControllerPfandTyp;
import projekt.fhv.teama.controller.ControllerReservierung;
import projekt.fhv.teama.controller.ControllerTeilreservierung;
import projekt.fhv.teama.controller.ControllerZimmer;
import projekt.fhv.teama.controller.ControllerZimmerstatus;
import projekt.fhv.teama.controller.interfaces.IControllerAdresse;
import projekt.fhv.teama.controller.interfaces.IControllerAufenthalt;
import projekt.fhv.teama.controller.interfaces.IControllerGast;
import projekt.fhv.teama.controller.interfaces.IControllerKategorie;
import projekt.fhv.teama.controller.interfaces.IControllerKontodaten;
import projekt.fhv.teama.controller.interfaces.IControllerPfandTyp;
import projekt.fhv.teama.controller.interfaces.IControllerReservierung;
import projekt.fhv.teama.controller.interfaces.IControllerTeilreservierung;
import projekt.fhv.teama.controller.interfaces.IControllerZimmer;
import projekt.fhv.teama.controller.interfaces.IControllerZimmerstatus;
import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckIn;

public class ControllerCheckInTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IControllerReservierung cres=new ControllerReservierung();
		IControllerAufenthalt cauf=new ControllerAufenthalt();
		IControllerGast cgast=new ControllerGast();
		IControllerTeilreservierung ctres=new ControllerTeilreservierung();
		IControllerKategorie ckat=new ControllerKategorie();
		IControllerKontodaten ckonto=new ControllerKontodaten();
		IControllerPfandTyp cpfandTyp=new ControllerPfandTyp();
		IControllerZimmer czimmer=new ControllerZimmer();
		IControllerZimmerstatus czimmerStatus=new ControllerZimmerstatus();
		IControllerAdresse cadr=new ControllerAdresse();
		
		//TODO Exeption von Datebank wenn kein eintrag
		ControllerCheckIn controllerCheckIn=new ControllerCheckIn(cres, cauf, cgast, ctres, ckat, ckonto, cpfandTyp, czimmer, czimmerStatus, cadr);
		
		try {
			List<IReservierung> reservierungs=controllerCheckIn.getAllReservierungen();
			
			for (IReservierung r : reservierungs) {
				
				System.out.println(String.format("ReservierungsId: %s\nVon: %s\nBis: %s\nPerson: %s %s",r.getID(),r.getVon(),r.getBis(),r.getPerson().getVorname(),r.getPerson().getNachname()));
//				List<IGast> gaesteGasts=new Vector<IGast>(r.getGaeste());
//				for (IGast g : gaesteGasts) {
//					System.out.println(String.format("Gast: %s %s %s\n",g.getVorname(),g.getNachname(),g.getEmail()));
//				}
				
			}
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
		
		

	}

}
