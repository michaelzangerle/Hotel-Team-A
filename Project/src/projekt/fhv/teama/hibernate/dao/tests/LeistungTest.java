package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.leistungen.Warengruppe;
import projekt.fhv.teama.classes.leistungen.Zusatzleistung;
import projekt.fhv.teama.hibernate.dao.leistungen.ZusatzleistungDao;
import projekt.fhv.teama.hibernate.dao.leistungen.ArtikelDao;
import projekt.fhv.teama.hibernate.dao.leistungen.LeistungDao;
import projekt.fhv.teama.hibernate.dao.leistungen.WarengruppeDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

public class LeistungTest {
	
	public static void main(String[] args) throws DatabaseNotFoundException {
		
		ZusatzleistungDao zd = new ZusatzleistungDao();
		ArtikelDao ad = new ArtikelDao();
		LeistungDao ld = new LeistungDao();
		WarengruppeDao wd = new WarengruppeDao();
		
//		Warengruppe w1 = new Warengruppe("Zweite Warengruppe", (short) 20, "Beschreibung der ersten Warengruppe", null, null);
//		Leistung l1 = new Leistung("2 Leistung");
//		Artikel a1 = new Artikel(75F, "Special Artikel 1", "Beschreibung des Artikels 1", wd.getById(3));
//		Artikel a2 = new Artikel(74F, "Special Artikel 2", "Beschreibung des Artikels 2", wd.getById(3));
//		Artikel a3 = new Artikel(75F, "Special Artikel 3", "Beschreibung des Artikels 3", wd.getById(3));
//		Artikel a4 = new Artikel(72F, "Special Artikel 4", "Beschreibung des Artikels 4", wd.getById(3));
//		Artikel a5 = new Artikel(71F, "Special Artikel 5", "Beschreibung des Artikels 5", wd.getById(3));
//		Artikel a6 = new Artikel(70F, "Special Artikel 6", "Beschreibung des Artikels 6", wd.getById(3));
//		
//		ld.create(l1);
//		ad.create(a1);
//		ad.create(a2);
//		ad.create(a3);
//		ad.create(a4);
//		ad.create(a5);
//		ad.create(a6);
//		wd.create(w1);
		
//		wd.getById(1).addArtikel(a1);
		
//		System.out.println(wd.getById(3));
		
//		Zusatzleistung z1 = new Zusatzleistung(100, "Zusatzleistung 1", "Beschreibung der 1. Zusatzleistung", true , wd.getById(1));
//		zd.create(z1);
		
		
		Warengruppe w1 = wd.getById(1);
		System.out.println(w1.toString());

		
		//System.out.println(ld.getLeistung("Erste Leistung").toString());
		
	}
}
