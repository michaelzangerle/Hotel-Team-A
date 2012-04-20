package projekt.fhv.teama.hibernate.dao.tests;

import java.util.Set;

import projekt.fhv.teama.classes.personen.Adresse;
import projekt.fhv.teama.classes.personen.IAdresse;
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
		
//		adao.create(new Adresse("Bahnhofstraße 3", "6900", "Bregenz", lnd.getLandByKuerzel("AT")));
//		adao.create(new Adresse("Dorf 46", "6491", "Schönwies", lnd.getLandByKuerzel("AT")));
//		adao.create(new Adresse("Straßl 36", "3654", "Hintertupfingen", lnd.getLandByKuerzel("AT")));
		
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
		adao.remove(adao.getById(5));
		
		// spezial
		
		
	}
}
