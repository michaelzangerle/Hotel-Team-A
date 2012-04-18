/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;


import java.util.Date;
import java.util.GregorianCalendar;

import projekt.fhv.teama.classes.zimmer.Saison;
import projekt.fhv.teama.hibernate.dao.zimmer.SaisonDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 *
 */
public class SaisonTest {
	
    private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month, day).getTime().getTime());

    }

	/**
	 * @param args
	 * @throws NoDatabaseEntryFoundException 
	 */
	public static void main(String[] args) throws NoDatabaseEntryFoundException {
		
		Date date = new java.util.Date();
//		Saison s1 = new Saison("Sommer",getDate(2012, 9, 7), new Timestamp(date.getTime()+299),null);
//		Saison s2 = new Saison("Winter",getDate(2012, 3, 7), new Timestamp(date.getTime()+599),null);
//		Saison s3 = new Saison("Herbst",getDate(2012, 12, 7), new Timestamp(date.getTime()+899),null);
//		Saison s4 = new Saison("Frühling",getDate(2012, 6, 7), new Timestamp(date.getTime()+1299),null);
		SaisonDao sd = new SaisonDao();
		
		/*
		 * Erstellen der Datensätze
		 */
//		sd.create(s1);
//		sd.create(s2);
//		sd.create(s3);
//		sd.create(s4);
		
		/*
		 * Auslesen der Datensätze
		 */
		
//		List<Saison> saison = sd.getAll();
//		for (Saison s : saison) {
//			System.out.println(s);
//		}
		
		/*
		 * Auslesen eines Datensatzes per ID
		 */
//		System.out.println(sd.getById(1));
		
		/*
		 * Auslesen eines Datensatzes per Bezeichnung
		 */
		
//		System.out.println(sd.getSaison("Sommer"));
		
	}
}
