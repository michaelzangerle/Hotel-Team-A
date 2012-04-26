package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.personen.Adresse;
import projekt.fhv.teama.hibernate.dao.personen.AdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IAdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.ILandDao;
import projekt.fhv.teama.hibernate.dao.personen.LandDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/*
 * Testdatum: 17.04
 * Datenbankversion: Harry 2.0 
 */
public class AdresseTest {

	public static void main(String[] args) throws DatabaseException {
		IAdresseDao adao = AdresseDao.getInstance();
		ILandDao lnd = LandDao.getInstance();
		
		// Einfügen
		
//		adao.create(new Adresse("Platz 114a", "789456", "Bregenz", lnd.getLandByKuerzel("AT")));
//		adao.create(new Adresse("Bahnhofsträßli 98b", "95147", "Bern", lnd.getLandByKuerzel("CH")));
//		adao.create(new Adresse("Bahnhofstraße 57", "47851", "Sao Paolo", lnd.getLandByKuerzel("BR")));
//		adao.create(new Adresse("Via Claudia 94", "36547", "Roma", lnd.getLandByKuerzel("I")));
//		adao.create(new Adresse("Marktplatz 256", "983214", "Berlin", lnd.getLandByKuerzel("DE")));
//		adao.create(new Adresse("Dorf 136", "134679", "Luxemburg", lnd.getLandByKuerzel("LX")));
		adao.create(new Adresse("Klausstrasse 24", "7654", "Klaus", lnd.getLandByKuerzel("AT")));
		
		// Alle holen
//		Set<IAdresse> adr = adao.getAll();
//		for (IAdresse iAdresse : adr) {
//			System.out.println(iAdresse);
//		}
		
		// 1 holen
//		System.out.println(adao.getById(1));
		
		// update
//		IAdresse a1 = adao.getById(2);
//		a1.setStrasse("Oberhäuser 18");
//		a1.setOrt("Schönwies");
//		adao.update(a1);
		
		//
//		adao.remove(adao.getById(5));
		
		// spezial
		
		
	}
}
