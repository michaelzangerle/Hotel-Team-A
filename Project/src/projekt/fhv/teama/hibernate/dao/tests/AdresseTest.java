package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.personen.Adresse;
import projekt.fhv.teama.hibernate.dao.personen.AdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IAdresseDao;

/*
 * Testdatum: 17.04
 * Datenbankversion: Harry 2.0 
 */
public class AdresseTest {

	public static void main(String[] args) {
		IAdresseDao adao = AdresseDao.getInstance();
		
		adao.create(new Adresse("Bahnhofstraﬂe 3", "6900", "Bregenz"));
		
	}
}
