package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.personen.Kontodaten;
import projekt.fhv.teama.hibernate.dao.personen.KontodatenDao;

/*
 * Testdatum: 17.04
 * Datenbankversion: Harry 2.0 
 */
public class KontodatenTest {
	public static void main(String[] args) {
		Kontodaten konto = new Kontodaten("124533", "AT453", "66942629", "2345");
		KontodatenDao kdao = new KontodatenDao();
		kdao.create(konto);
	}
}
