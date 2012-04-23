/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.zimmer.IZimmer;
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
//		IZimmer z1 = new Zimmer("1408", "Doppelzimmer 1408", "A Zimmer halt was sell i da beschreiben?", kDao.getById(6), stdao.getById(1), null, null, null, null, null);
//		IZimmer z2 = new Zimmer("1409", "Doppelzimmer 1409", "1409 Zimmer mit Meerblick", kDao.getById(7), stdao.getById(2), null, null, null, null, null);
//		IZimmer z3 = new Zimmer("1407", "Doppelzimmer + Zusatz 1407", "1408 Zimmer mit Blick aufs Land", kDao.getById(8), stdao.getById(3), null, null, null, null, null);
//
//		zdao.create(z2);
//		zdao.create(z3);
		
		IZimmer z1 = zdao.getById(31);
//		System.out.println(z1);
//		z1.setBeschreibung("1408 Zimmer ohne Fenster");
		z1.addGast(gDao.getById(40));
//		z1.addGast(gDao.getById(42));
//		z1.addReservierung(rDao.getById(2));
		zdao.create(z1);
		
//		System.out.println(zdao.getById(31));
		
	}

}
