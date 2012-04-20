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
		
		// Einf�gen
		
//		adao.create(new Adresse("Bahnhofstra�e 3", "6900", "Bregenz", lnd.getLandByKuerzel("AT")));
//		adao.create(new Adresse("Dorf 46", "6491", "Sch�nwies", lnd.getLandByKuerzel("AT")));
//		adao.create(new Adresse("Stra�l 36", "3654", "Hintertupfingen", lnd.getLandByKuerzel("AT")));
		
		// Alle holen
//		Set<IAdresse> adr = adao.getAll();
//		for (IAdresse iAdresse : adr) {
//			System.out.println(iAdresse);
//		}
		
		// 1 holen
//		System.out.println(adao.getById(1));
		
		// update
//		IAdresse a1 = adao.getById(2);
//		a1.setStrasse("Oberh�user 18");
//		a1.setOrt("Sch�nwies");
//		adao.update(a1);
		
		//
		adao.remove(adao.getById(5));
		
		// spezial
		
		
	}
}
