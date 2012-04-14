package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.leistungen.Artikel;
import projekt.fhv.teama.classes.leistungen.Leistung;
import projekt.fhv.teama.classes.leistungen.Warengruppe;
import projekt.fhv.teama.hibernate.dao.leistungen.ArtikelDao;
import projekt.fhv.teama.hibernate.dao.leistungen.LeistungDao;
import projekt.fhv.teama.hibernate.dao.leistungen.WarengruppeDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

public class LeistungTest {
	
	public static void main(String[] args) throws DatabaseNotFoundException {
		
		ArtikelDao ad = new ArtikelDao();
		LeistungDao ld = new LeistungDao();
		WarengruppeDao wd = new WarengruppeDao();
		
		Warengruppe w1 = new Warengruppe("Erste Warengruppe", (short) 20, "Beschreibung der ersten Warengruppe", null, null);
		Leistung l1 = new Leistung("Erste Leistung");
		Artikel a1 = new Artikel(111F, "Erster Artikel", w1);
		
		//ld.create(l1);
		//ad.create(a1);
		wd.create(w1);
		
		//System.out.println(ld.getLeistung("Erste Leistung").toString());
		
	}
}
