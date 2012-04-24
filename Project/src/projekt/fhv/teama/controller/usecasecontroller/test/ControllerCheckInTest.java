package projekt.fhv.teama.controller.usecasecontroller.test;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.Adresse;
import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckIn;
import projekt.fhv.teama.model.ModelAdresse;
import projekt.fhv.teama.model.ModelAufenthalt;
import projekt.fhv.teama.model.ModelGast;
import projekt.fhv.teama.model.ModelKategorie;
import projekt.fhv.teama.model.ModelKontodaten;
import projekt.fhv.teama.model.ModelLand;
import projekt.fhv.teama.model.ModelPfandTyp;
import projekt.fhv.teama.model.ModelReservierung;
import projekt.fhv.teama.model.ModelStatusentwicklung;
import projekt.fhv.teama.model.ModelTeilreservierung;
import projekt.fhv.teama.model.ModelZimmer;
import projekt.fhv.teama.model.ModelZimmerstatus;
import projekt.fhv.teama.model.interfaces.IModelAdresse;
import projekt.fhv.teama.model.interfaces.IModelAufenthalt;
import projekt.fhv.teama.model.interfaces.IModelGast;
import projekt.fhv.teama.model.interfaces.IModelKategorie;
import projekt.fhv.teama.model.interfaces.IModelKontodaten;
import projekt.fhv.teama.model.interfaces.IModelLand;
import projekt.fhv.teama.model.interfaces.IModelPfandTyp;
import projekt.fhv.teama.model.interfaces.IModelReservierung;
import projekt.fhv.teama.model.interfaces.IModelStatusentwicklung;
import projekt.fhv.teama.model.interfaces.IModelTeilreservierung;
import projekt.fhv.teama.model.interfaces.IModelZimmer;
import projekt.fhv.teama.model.interfaces.IModelZimmerstatus;

public class ControllerCheckInTest {

	private static IReservierung res;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IModelReservierung cres = new ModelReservierung();
		IModelAufenthalt cauf = new ModelAufenthalt();
		IModelGast cgast = new ModelGast();
		IModelTeilreservierung ctres = new ModelTeilreservierung();
		IModelKategorie ckat = new ModelKategorie();
		IModelKontodaten ckonto = new ModelKontodaten();
		IModelPfandTyp cpfandTyp = new ModelPfandTyp();
		IModelZimmer czimmer = new ModelZimmer();
		IModelZimmerstatus czimmerStatus = new ModelZimmerstatus();
		IModelAdresse cadr = new ModelAdresse();
		IModelLand cland =new ModelLand();
		IModelStatusentwicklung sentw=new ModelStatusentwicklung();

		// TODO Exeption von Datebank wenn kein eintrag
		ControllerCheckIn controllerCheckIn = new ControllerCheckIn(cres, cauf, cgast, ctres, ckat, ckonto, cpfandTyp,
				czimmer, czimmerStatus, cadr,cland,sentw);

		
		//Hole Check In Reservierungen
//		try {
//			List<IReservierung> reservierungscheckIn = controllerCheckIn.getCheckInReservierungen();
//			for (IReservierung iReservierung : reservierungscheckIn) {
//				System.out.println(iReservierung);
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

		
		
		// 1. Schritt - hole alle Reservierungen
		
		
		try {
			List<IReservierung> reservierungs = controllerCheckIn.getAllReservierungen();

			// 2. Schritt - zeige alle Reservierungen

			for (IReservierung r : reservierungs) {

				System.out.println(String.format("ReservierungsId: %s\nVon: %s\nBis: %s\nPerson: %s %s\nBearbeitet: %s\n", r.getID(),
						r.getVon(), r.getBis(), r.getPerson().getVorname(), r.getPerson().getNachname(),r.getBearbeitet()));

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
			
			//9. Schritt Änderungen Speichern 
//				controllerCheckIn.setVorname("Abdul");
//				controllerCheckIn.addAdresse(new Adresse("Bondstrasse 4", "007", "MI6", controllerCheckIn.getLandByKuerzel("CH")));
			controllerCheckIn.setVorname("Test");
			
			
			// 10. Schritt - speichere Aufenthalt
			for (IZimmer z : ausgewaehlteZimmer) {
				controllerCheckIn.saveAufenthalt(999.00F, res.getVon(), res.getBis(), true, controllerCheckIn.getGast(), z, pfand, "77");
			}
			
			System.out.println("Check In beendet");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
