package projekt.fhv.teama.hibernate.dao.tests;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import projekt.fhv.teama.classes.personen.Adresse;
import projekt.fhv.teama.classes.personen.Bankverbindung;
import projekt.fhv.teama.classes.personen.Berechtigung;
import projekt.fhv.teama.classes.personen.Land;
import projekt.fhv.teama.classes.personen.Mitarbeiter;
import projekt.fhv.teama.hibernate.dao.personen.BerechtigungDao;
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
		LandDao ld = new LandDao();
		Land aut1 = ld.getLand("Österreich");
		MitarbeiterDao md = new MitarbeiterDao();
		Mitarbeiter ma2 = md.getById(6);
		
//		Mitarbeiter ma = new Mitarbeiter("mavorname", "manachname", 'm', adr, new Date(1989, 12, 7), "06769470089", "michael.zangerle@gmail.com", bank, aut1, "passwort", new Date(2012, 3, 24));
//		md.create(ma);
		
		BerechtigungDao bd = new BerechtigungDao();
//		
//		System.out.print(ma2.toString());
//		
		Berechtigung berechtigung = bd.getBerechtigungByBezeichnung("Checkin");
//		System.out.println(b.toString());
//		
//		Set<Berechtigung> berechtigungen = new HashSet<Berechtigung>();
//		berechtigungen.add(b);
//		md.setBerechtigungen(ma2, berechtigungen);
//		System.out.print(ma2.toString());
		
		Set<Berechtigung> berechtigungen = ma2.getBerechtigungen();
		for (Berechtigung b : berechtigungen) {
			//System.out.println(b.toString());
		}
		if (berechtigungen.contains(berechtigung)) {
			//System.out.println("berechtigt!");
		}
		System.out.println(ma2.toString());
	}

}
