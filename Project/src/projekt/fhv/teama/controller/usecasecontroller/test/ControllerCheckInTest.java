package projekt.fhv.teama.controller.usecasecontroller.test;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
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
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerDao;

public class ControllerCheckInTest {

	private static IReservierung res;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IControllerReservierung cres = new ControllerReservierung();
		IControllerAufenthalt cauf = new ControllerAufenthalt();
		IControllerGast cgast = new ControllerGast();
		IControllerTeilreservierung ctres = new ControllerTeilreservierung();
		IControllerKategorie ckat = new ControllerKategorie();
		IControllerKontodaten ckonto = new ControllerKontodaten();
		IControllerPfandTyp cpfandTyp = new ControllerPfandTyp();
		IControllerZimmer czimmer = new ControllerZimmer();
		IControllerZimmerstatus czimmerStatus = new ControllerZimmerstatus();
		IControllerAdresse cadr = new ControllerAdresse();

		// TODO Exeption von Datebank wenn kein eintrag
		ControllerCheckIn controllerCheckIn = new ControllerCheckIn(cres, cauf, cgast, ctres, ckat, ckonto, cpfandTyp,
				czimmer, czimmerStatus, cadr);

		// 1. Schritt - hole alle Reservierungen
		
		
		try {
			List<IReservierung> reservierungs = controllerCheckIn.getAllReservierungen();

			// 2. Schritt - zeige alle Reservierungen

			for (IReservierung r : reservierungs) {

				System.out.println(String.format("ReservierungsId: %s\nVon: %s\nBis: %s\nPerson: %s %s", r.getID(),
						r.getVon(), r.getBis(), r.getPerson().getVorname(), r.getPerson().getNachname()));

				List<IGast> gaesteGasts = new Vector<IGast>(r.getGaeste());
				for (IGast g : gaesteGasts) {
					System.out
							.println(String.format("Gast: %s %s %s\n", g.getVorname(), g.getNachname(), g.getEmail()));

					List<IAdresse> adressen = new Vector<IAdresse>(g.getAdressen());

					for (IAdresse adr : adressen) {
						System.out.println(String.format("Adresse: %s %s %s %s\n", adr.getOrt(), adr.getPlz(),
								adr.getStrasse(), adr.getLand().getBezeichnung()));
					}
				}

				System.out.println(r.getTeilreservierungen());

			}

			// 3. Schritt - wähle Reservierung aus
			if(reservierungs != null && reservierungs.size() > 0){
				
				controllerCheckIn.setAktuelleReservierung(reservierungs.get(0));
				res = controllerCheckIn.getAktuelleReservierung();
								
			} else {
				System.out.println("Keine Reservierung gefunden!");
			}
						
			// 4. Schritt - Daten des Reservierenden anzeigen
			
			System.out.println("1. Screen - Personendaten: "+res.getPerson());
			
			// 5. Schritt - hole Gästedaten
			for (IGast g : res.getGaeste()) {
				System.out.println("2. Screen - Gästedaten: "+g.getVorname()+ " "+g.getNachname());
				controllerCheckIn.setGast(g);
			}
			
			List<IZimmer> ausgewaehlteZimmer = new Vector<IZimmer>();
			for (ITeilreservierung t : res.getTeilreservierungen()) {
				
				// 6. Schritt - hole Teilreservierungen
				System.out.println("3. Screen - Teilreservierung: "+t);	
				// 7. Schritt - hole verfügbare Zimmer für Teilreservierung
				//TODO Verfügbare Zimmer funkt nicht
				List<IZimmer> verfuegbareZimmer = controllerCheckIn.getVerfügbareZimmerFürGegebeneKategorie(t.getKategorie());
				System.out.println("3.Screen - Zimmer: "+ verfuegbareZimmer);
				
				for (int i = 0; i < t.getAnzahl(); i++) {
					ausgewaehlteZimmer.add(verfuegbareZimmer.get(i));	
				}
				
			}

			// 8. Schritt - hole Pfandtyp
			System.out.println("Pfandtypen: "+controllerCheckIn.getPfandtyps());
			IPfandtyp pfand = controllerCheckIn.getPfandtyps().get(0);			
			
			// 9. Schritt - speichere Aufenthalt
			for (IZimmer z : ausgewaehlteZimmer) {
				controllerCheckIn.saveAufenthalt(999.00F, res.getVon(), res.getBis(), true, controllerCheckIn.getGast(), z, pfand, "77");
			}
			
			

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}
