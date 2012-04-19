/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.sql.Date;
import java.util.GregorianCalendar;

import projekt.fhv.teama.classes.zimmer.ReservierungsOption;
import projekt.fhv.teama.hibernate.dao.zimmer.ReservierungsOptionDao;

/**
 * @author mike
 * 
 */
public class ReservierungsOptionTest {
	
    private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month, day).getTime().getTime());

    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		short s1 = 5;
//		short s2 = 10;
//		short s3 = 15;
//		short s4 = 20;
		
//		System.out.println(getDate(2012, 11, 7));
		
		// TODO Reservierungsoption: Testen funktioniert erst nach Reservierung
//		OptionDao od = new OptionDao();	
//		ReservierungsOption o1 = new ReservierungsOption(getDate(2012, 11, 7), s1,true,  null);
//		ReservierungsOption o2 = new ReservierungsOption(getDate(2012, 10, 7), s2, false, null);
//		ReservierungsOption o3 = new ReservierungsOption(getDate(2012, 9, 7), s3, false, null);
//		ReservierungsOption o4 = new ReservierungsOption(getDate(2012, 9, 7), s4, false, null);

		/*
		 * Erstellen der Datensätze
		 */
//		od.create(o1);
//		od.create(o2);
//		od.create(o3);
//		od.create(o4);

		/*
		 * Auslesen der Datensätze
		 */

		// List<Kategorie> saison = kd.getAll();
		// for (Kategorie s : saison) {
		// System.out.println(s);
		// }

		/*
		 * Auslesen eines Datensatzes per ID
		 */
		// System.out.println(kd.getById(1));

		/*
		 * Auslesen eines Datensatzes per Bezeichnung
		 */

		// System.out.println(kd.getKategorie("Einzelzimmer"));

	}

}
