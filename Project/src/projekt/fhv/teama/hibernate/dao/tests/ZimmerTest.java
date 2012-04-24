/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.Zimmer;
import projekt.fhv.teama.hibernate.dao.personen.GastDao;
import projekt.fhv.teama.hibernate.dao.personen.IGastDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IKategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IStatusentwicklungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerStatusDao;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ReservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.StatusentwicklungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerstatusDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * @author mike
 *
 */
public class ZimmerTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		
		IZimmerStatusDao stdao = ZimmerstatusDao.getInstance();
		
//		IZimmerstatus st1 = new Zimmerstatus("Frei - Gereinigt", "FG");
//		IZimmerstatus st2 = new Zimmerstatus("Frei - Nicht gereinigt", "FNG");
//		IZimmerstatus st3 = new Zimmerstatus("Belegt - Gereinigt", "BG");
//		IZimmerstatus st4 = new Zimmerstatus("Belegt - Nicht gereinigt", "BNG");
//		IZimmerstatus st5 = new Zimmerstatus("Out of Order", "OOO");
//		
		// Einfügen
//		stdao.create(st1);
//		stdao.create(st2);
//		stdao.create(st3);
//		stdao.create(st4);
//		stdao.create(st5);
		
		// Alle holen
//		for (IZimmerstatus st : stdao.getAll()) {
//			System.out.println(st);
//		}
		
		// 1 holen
//		System.out.println(stdao.getById(1));
		
		// update
//		IZimmerstatus st1 = stdao.getById(5);
//		st1.setBezeichnung("Out Of Order");
//		stdao.create(st1);
		
		// löschen
//		IZimmerstatus st6 = new Zimmerstatus("Bla Bla Blubb", "BBB");
//		stdao.create(st6);
//		stdao.remove(stdao.getZimmerstatus("Bla Bla Blubb"));
		
		IStatusentwicklungDao entw = StatusentwicklungDao.getInstance();
		
//		IStatusentwicklung entw1 = new Statusentwicklung(zimmer, zimmerStatus, von, bis, beschreibung)
		
		IReservierungDao rDao = ReservierungDao.getInstance();
		IGastDao gDao = GastDao.getInstance();
		IKategorieDao kDao = KategorieDao.getInstance();
		IZimmerDao zdao = ZimmerDao.getInstance();
//		
		IZimmer z1 = new Zimmer("1808", "Einzelzimmer 1808", "1808 A Zimmer halt was sell i da beschreiben?", kDao.getById(6), stdao.getById(1), null, null, null);
		IZimmer z2 = new Zimmer("1809", "Doppelzimmer 1809", "1809 Zimmer mit Meerblick", kDao.getById(7), stdao.getById(1), null, null, null);
		IZimmer z3 = new Zimmer("1807", "Doppelzimmer + Zusatz 1807", "1808 Zimmer mit Blick aufs Land", kDao.getById(8), stdao.getById(1), null, null, null);
		IZimmer z4 = new Zimmer("1908", "Einzelzimmer 1908", "1908 A Zimmer halt was sell i da beschreiben?", kDao.getById(6), stdao.getById(1), null, null, null);
		IZimmer z5 = new Zimmer("1909", "Doppelzimmer 1909", "1909 Zimmer mit Meerblick", kDao.getById(7), stdao.getById(1), null, null, null);
		IZimmer z6 = new Zimmer("1907", "Doppelzimmer + Zusatz 1907", "1908 Zimmer mit Blick aufs Land", kDao.getById(8), stdao.getById(1), null, null, null);
		IZimmer z7 = new Zimmer("1008", "Einzelzimmer 1008", "1008 A Zimmer halt was sell i da beschreiben?", kDao.getById(6), stdao.getById(1), null, null, null);
		IZimmer z8 = new Zimmer("1009", "Doppelzimmer 1009", "1009 Zimmer mit Meerblick", kDao.getById(7), stdao.getById(1), null, null, null);
		IZimmer z9 = new Zimmer("1007", "Doppelzimmer + Zusatz 1007", "1008 Zimmer mit Blick aufs Land", kDao.getById(8), stdao.getById(1), null, null, null);
		IZimmer z10 = new Zimmer("2508", "Einzelzimmer 2508", "2508 A Zimmer halt was sell i da beschreiben?", kDao.getById(6), stdao.getById(1), null, null, null);
		IZimmer z11 = new Zimmer("2509", "Doppelzimmer 2509", "2509 Zimmer mit Meerblick", kDao.getById(7), stdao.getById(1), null, null, null);
		IZimmer z12 = new Zimmer("2507", "Doppelzimmer + Zusatz 2507", "2508 Zimmer mit Blick aufs Land", kDao.getById(8), stdao.getById(1), null, null, null);
		IZimmer z13 = new Zimmer("2608", "Einzelzimmer 2608", "2608 A Zimmer halt was sell i da beschreiben?", kDao.getById(6), stdao.getById(1), null, null, null);
		IZimmer z14 = new Zimmer("2609", "Doppelzimmer 2609", "2609 Zimmer mit Meerblick", kDao.getById(7), stdao.getById(1), null, null, null);
		IZimmer z15 = new Zimmer("2607", "Doppelzimmer + Zusatz 2607", "2608 Zimmer mit Blick aufs Land", kDao.getById(8), stdao.getById(1), null, null, null);
		IZimmer z16 = new Zimmer("2708", "Einzelzimmer 2708", "2708 A Zimmer halt was sell i da beschreiben?", kDao.getById(6), stdao.getById(1), null, null, null);
		IZimmer z17 = new Zimmer("2709", "Doppelzimmer 2709", "2709 Zimmer mit Meerblick", kDao.getById(7), stdao.getById(1), null, null, null);
		IZimmer z18 = new Zimmer("2707", "Doppelzimmer + Zusatz 2707", "2708 Zimmer mit Blick aufs Land", kDao.getById(8), stdao.getById(1), null, null, null);
		
		zdao.create(z1);
		zdao.create(z2);
		zdao.create(z3);
		zdao.create(z4);
		zdao.create(z5);
		zdao.create(z6);
		zdao.create(z7);
		zdao.create(z8);
		zdao.create(z9);
		zdao.create(z10);
		zdao.create(z11);
		zdao.create(z12);
		zdao.create(z13);
		zdao.create(z14);
		zdao.create(z15);
		zdao.create(z16);
		zdao.create(z17);
		zdao.create(z18);
//		
//		zdao.create(z3);
		
//		IZimmer z1 = zdao.getById(31);
		
//		System.out.println(z1);
//		z1.setBeschreibung("1408 Zimmer ohne Fenster");
//		z1.addGast(gDao.getById(40));
//		z1.addGast(gDao.getById(42));
//		z1.addReservierung(rDao.getById(2));
//		zdao.create(z1);
		
//		System.out.println(zdao.getById(31));
		
	}

}
