package projekt.fhv.teama.controller.usecasecontroller.test;

import projekt.fhv.teama.controller.usecasecontroller.ControllerZusatzleistungBuchen;
import projekt.fhv.teama.controller.usecasecontroller.LeistungAnzahl;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerZusatzleistungBuchen;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.integrate.IALeistung;
import projekt.fhv.teama.integrate.IAZimmer;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.exception.WrongParameterException;

public class ControllerZBTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 * @throws EmptyParameterException 
	 * @throws FokusException 
	 */
	public static void main(String[] args) throws DatabaseException, FokusException, EmptyParameterException {
		
		IControllerZusatzleistungBuchen zbController=new ControllerZusatzleistungBuchen();
		
		//Gast holen fokus setzen
		IAGast gast=zbController.getGaesteVonAuftenhalten().get(0);
		zbController.setGast(gast);
		
		//Zimmer holen und fokus setzten
		IAZimmer zimmer=zbController.getZimmerVonGast().get(0);
		zbController.setAktuellesZimmer(zimmer);
		
		//leitsung holen
		IALeistung leistung =zbController.getArtikelundZusatzleistungen().get(0);
		int anzahl=2;
	
		
		//Leistung zur Hashmap hinzufügen
		zbController.addLeistung(leistung, anzahl);
		
		
		
		//leitsung holen
		IALeistung leistung2 =zbController.getArtikelundZusatzleistungen().get(3);
		int anzahl2=5;
	
		
		//Leistung zur Hashmap hinzufügen
		zbController.addLeistung(leistung2, anzahl2);
		
		
		//Speichern der Leistungen
		try {
			zbController.saveLeistungen();
		} catch (FokusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotContainExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Holen der Leistungen für die Overview
		for (LeistungAnzahl la : zbController.bereitsgebuchtLeistungenFuerGast()) {
			System.out.println(la.getLeistung()+" "+la.getAnzahl());
		}
		
	}
	
	
	
	

}
