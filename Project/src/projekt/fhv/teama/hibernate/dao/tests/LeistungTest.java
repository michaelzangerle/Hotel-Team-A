package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.leistungen.Artikel;
import projekt.fhv.teama.hibernate.dao.leistungen.ArtikelDao;
import projekt.fhv.teama.hibernate.dao.leistungen.WarengruppeDao;
import projekt.fhv.teama.hibernate.dao.leistungen.ZusatzleistungDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class LeistungTest {
	
	public static void main(String[] args) throws NoDatabaseEntryFoundException {
		
//		short s1 = 20;
//		short s2 = 15;
//		short s3 = 10;
		
		/*
		 * Erstellen der Datensätze
		 */

		
//		WarengruppeDao wd = new WarengruppeDao();
//		Warengruppe w1 = new Warengruppe("Hoteleigenen Produkte", s1, "Hoteleigene Produkte produziert im laufenden Wirtschaftsjahr", null, null);
//		Warengruppe w2 = new Warengruppe("Alkohol", s2, "Zugekaufte Produkte von regionalen Händlern", null, null);
//		Warengruppe w3 = new Warengruppe("Bücher", s3, "Hoteleigene Produkte produziert im laufenden Wirtschaftsjarh", null, null);
//		Warengruppe w4 = new Warengruppe("Externe Produkte", s3, "Hotelexterne Angebote", null, null);
		
//		wd.create(w1);
//		wd.create(w2);
//		wd.create(w3);
//		wd.create(w4);
				
//		ZusatzleistungDao zd = new ZusatzleistungDao();
//		Zusatzleistung z1 = new Zusatzleistung(45, "Wandertour Fortgeschritten", "Geführte Wandertour für Fortgeschrittene", true, wd.getById(4));
//		Zusatzleistung z2 = new Zusatzleistung(15, "Kajak", "Organisierte Kajakfahrt", true, wd.getById(4));
//		Zusatzleistung z3 = new Zusatzleistung(15, "Bogenschießen", "Bogenschießkurs von extern", true, wd.getById(4));
//		zd.create(z1);
//		zd.create(z2);
//		zd.create(z3);
//		
//		ArtikelDao ad = new ArtikelDao();
//		Artikel a1 = new Artikel(35, "Starkbier", "Starkbier Fohrenburger", wd.getById(1));
//		Artikel a2 = new Artikel(20, "Kellerbier Bier", "Mohrenbräu", wd.getById(2));
//		Artikel a3 = new Artikel(40, "Playboy 09/12", "Hoteleigenes Shooting", wd.getById(3));
//		ad.create(a1);
//		ad.create(a2);
//		ad.create(a3);
		

		/*
		 * Auslesen der Datensätze
		 */
		
//		List<Zusatzleistung> zl = zd.getAll();
//		for (Leistung z : zl) {
//			System.out.println(z);
//		}
//		
//		List<Warengruppe> wl = wd.getAll();
//		for (Warengruppe z : wl) {
//			System.out.println(z);
//		}
//		
//		List<Artikel> al = ad.getAll();
//		for (Artikel z : al) {
//			System.out.println(z);
//		}
		
		/*
		 * Auslesen eines Datensatzes per ID
		 */
//		System.out.println(wd.getById(1));
//		System.out.println(ad.getById(12));
//		System.out.println(zd.getById(15));
		
		
		/*
		 * Auslesen eines Datensatzes per Bezeichnung
		 */
		
//		System.out.println(wd.getLeistung("Bücher"));
//		System.out.println(ad.getArtikel("Hotelbier"));
//		System.out.println(zd.getZusatzleistung("Wandertour"));
		
		/*
		 * Updaten eines Datensatzes
		 */
		
//		Artikel a = ad.getArtikel("Playboy 09/12").get(0);
//		a.setBezeichnung("Playboy 10/12");
//		ad.update(a);
		
		
		
	}
}
