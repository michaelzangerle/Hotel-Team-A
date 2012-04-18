package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.personen.Adresse;
import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.personen.Kontodaten;
import projekt.fhv.teama.classes.personen.Land;
import projekt.fhv.teama.classes.zimmer.Zimmer;
import projekt.fhv.teama.hibernate.dao.personen.GastDao;
import projekt.fhv.teama.hibernate.dao.personen.LandDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class GastTest {
	public static void main(String[] args) throws DatabaseException {
		Adresse adr = new Adresse("Dorf 46", "6491", "Schönwies");
		Kontodaten bank = new Kontodaten("123456789", "123456", "32165498", "12345");
		LandDao ld = new LandDao();
		Land aut1 = ld.getLandByBez("Österreich");
		GastDao gd = new GastDao();
		Zimmer zimmer = new Zimmer();
		//TODO GastTest: Nochmal durchtesten weil anderer Konstruktor
//		Gast ga = new Gast("gastvorname", "gastnachname", 'm', adr, new Date(1989, 12, 7), "06769470089", "michael.zangerle@gmail.com", bank, aut1, "007", zimmer);
//		gd.create(ga);
		
		Gast ga2 = gd.getById(6);
		System.out.println(ga2.toString());
	}
}
