package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.personen.Adresse;
import projekt.fhv.teama.hibernate.dao.personen.AdresseDao;

/*
 * Testdatum: 17.04
 * Datenbankversion: Harry 2.0 
 */
public class AdresseTest {

	public static void main(String[] args) {
		Adresse adr = new Adresse("Bahnhofstraﬂe 3", "6900", "Bregenz");
		AdresseDao ado = new AdresseDao();
		ado.create(adr);
	}
}
