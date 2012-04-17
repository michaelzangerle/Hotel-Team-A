/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import projekt.fhv.teama.classes.zimmer.Option;
import projekt.fhv.teama.hibernate.dao.zimmer.OptionDao;

/**
 * @author mike
 * 
 */
public class OptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		short s1 = 5;
		short s2 = 10;
		short s3 = 15;
		short s4 = 20;
		
		byte b = 0;
		Date date = new java.util.Date();
		OptionDao od = new OptionDao();
		Option o1 = new Option(new Timestamp(date.getTime()+10), s1, b, null);
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
