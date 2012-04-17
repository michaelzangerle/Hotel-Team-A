/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.sql.Date;
import java.util.GregorianCalendar;

import projekt.fhv.teama.classes.zimmer.Option;
import projekt.fhv.teama.hibernate.dao.zimmer.OptionDao;

/**
 * @author mike
 * 
 */
public class OptionTest {
	
    private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month, day).getTime().getTime());

    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		short s1 = 5;
		short s2 = 10;
		short s3 = 15;
		short s4 = 20;
		
		System.out.println(getDate(2012, 11, 7));
		
		OptionDao od = new OptionDao();	
		Option o1 = new Option(true, getDate(2012, 11, 7), "123",  null);
//		Option o2 = new Option(new Timestamp(date.getTime()), 10, false, null);
//		Option o3 = new Option(new Timestamp(date.getTime()), 15, false, null);
//		Option o4 = new Option(new Timestamp(date.getTime()), 20, false, null);

		/*
		 * Erstellen der Datensätze
		 */
		od.create(o1);
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
