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
		IZimmer z1 = new Zimmer("1308", "Einzelzimmer 1308", "1308 A Zimmer halt was sell i da beschreiben?", kDao.getById(6), stdao.getById(1), null, null, null, null, null);
		IZimmer z2 = new Zimmer("1309", "Doppelzimmer 1309", "1309 Zimmer mit Meerblick", kDao.getById(7), stdao.getById(1), null, null, null, null, null);
		IZimmer z3 = new Zimmer("1307", "Doppelzimmer + Zusatz 1307", "1308 Zimmer mit Blick aufs Land", kDao.getById(8), stdao.getById(1), null, null, null, null, null);
		IZimmer z4 = new Zimmer("1208", "Einzelzimmer 1208", "1208 A Zimmer halt was sell i da beschreiben?", kDao.getById(6), stdao.getById(1), null, null, null, null, null);
		IZimmer z5 = new Zimmer("1209", "Doppelzimmer 1209", "1209 Zimmer mit Meerblick", kDao.getById(7), stdao.getById(1), null, null, null, null, null);
		IZimmer z6 = new Zimmer("1207", "Doppelzimmer + Zusatz 1207", "1208 Zimmer mit Blick aufs Land", kDao.getById(8), stdao.getById(1), null, null, null, null, null);
		IZimmer z7 = new Zimmer("1108", "Einzelzimmer 1108", "1108 A Zimmer halt was sell i da beschreiben?", kDao.getById(6), stdao.getById(1), null, null, null, null, null);
		IZimmer z8 = new Zimmer("1109", "Doppelzimmer 1109", "1109 Zimmer mit Meerblick", kDao.getById(7), stdao.getById(1), null, null, null, null, null);
		IZimmer z9 = new Zimmer("1107", "Doppelzimmer + Zusatz 1107", "1308 Zimmer mit Blick aufs Land", kDao.getById(8), stdao.getById(1), null, null, null, null, null);
		IZimmer z10 = new Zimmer("1508", "Einzelzimmer 1508", "1508 A Zimmer halt was sell i da beschreiben?", kDao.getById(6), stdao.getById(1), null, null, null, null, null);
		IZimmer z11 = new Zimmer("1509", "Doppelzimmer 1509", "1509 Zimmer mit Meerblick", kDao.getById(7), stdao.getById(1), null, null, null, null, null);
		IZimmer z12 = new Zimmer("1507", "Doppelzimmer + Zusatz 1507", "1508 Zimmer mit Blick aufs Land", kDao.getById(8), stdao.getById(1), null, null, null, null, null);
		IZimmer z13 = new Zimmer("1608", "Einzelzimmer 1608", "1608 A Zimmer halt was sell i da beschreiben?", kDao.getById(6), stdao.getById(1), null, null, null, null, null);
		IZimmer z14 = new Zimmer("1609", "Doppelzimmer 1609", "1609 Zimmer mit Meerblick", kDao.getById(7), stdao.getById(1), null, null, null, null, null);
		IZimmer z15 = new Zimmer("1607", "Doppelzimmer + Zusatz 1607", "1608 Zimmer mit Blick aufs Land", kDao.getById(8), stdao.getById(1), null, null, null, null, null);
		IZimmer z16 = new Zimmer("1708", "Einzelzimmer 1708", "1708 A Zimmer halt was sell i da beschreiben?", kDao.getById(6), stdao.getById(1), null, null, null, null, null);
		IZimmer z17 = new Zimmer("1709", "Doppelzimmer 1709", "1709 Zimmer mit Meerblick", kDao.getById(7), stdao.getById(1), null, null, null, null, null);
		IZimmer z18 = new Zimmer("1707", "Doppelzimmer + Zusatz 1707", "1708 Zimmer mit Blick aufs Land", kDao.getById(8), stdao.getById(1), null, null, null, null, null);
		
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
