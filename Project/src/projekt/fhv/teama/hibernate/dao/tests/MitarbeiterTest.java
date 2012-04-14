package projekt.fhv.teama.hibernate.dao.tests;

import java.util.Date;

import projekt.fhv.teama.classes.personen.Adresse;
import projekt.fhv.teama.classes.personen.Bankverbindung;
import projekt.fhv.teama.classes.personen.Land;
import projekt.fhv.teama.classes.personen.Mitarbeiter;
import projekt.fhv.teama.hibernate.dao.personen.LandDao;
import projekt.fhv.teama.hibernate.dao.personen.MitarbeiterDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class MitarbeiterTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		Adresse adr = new Adresse("Dorf 46", "6491", "Schönwies");
		Bankverbindung bank = new Bankverbindung("123456789", "123456", "32165498", "12345");
		LandDao<Land> ld = new LandDao<Land>();
		Land aut1 = ld.getLand("Österreich");
		MitarbeiterDao md = new MitarbeiterDao();
		
		
//		Mitarbeiter ma = new Mitarbeiter("mavorname", "manachname", 'm', adr, new Date(1989, 12, 7), "06769470089", "michael.zangerle@gmail.com", bank, aut1, "passwort", new Date(2012, 3, 24));
//		md.create(ma);
		
		Mitarbeiter ma2 = md.getById(6);
		System.out.print(ma2.toString());
		
	}

}
