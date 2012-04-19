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
		
		adao.create(new Adresse("Bahnhofstraße 3", "6900", "Bregenz", lnd.getLandByKuerzel("AT")));
		adao.create(new Adresse("Dorf 46", "6491", "Schönwies", lnd.getLandByKuerzel("AT")));
		adao.create(new Adresse("Marktstraße 18", "6850", "Dornbirn", lnd.getLandByKuerzel("AT")));
		
		
		// Einfügen
		// Alle holen
		// 1 holen
		// update
		// spezial
		
	}
}
