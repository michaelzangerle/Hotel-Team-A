/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import projekt.fhv.teama.classes.zimmer.Saison;
import projekt.fhv.teama.hibernate.dao.zimmer.SaisonDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

/**
 * @author mike
 *
 */
public class SaisonTest {

	/**
	 * @param args
	 * @throws DatabaseNotFoundException 
	 */
	public static void main(String[] args) throws DatabaseNotFoundException {
		
		Date date = new java.util.Date();
		Saison s1 = new Saison("Sommer",new Timestamp(date.getTime()+10), new Timestamp(date.getTime()+299),null);
		Saison s2 = new Saison("Winter",new Timestamp(date.getTime()+300), new Timestamp(date.getTime()+599),null);
		Saison s3 = new Saison("Herbst",new Timestamp(date.getTime()+600), new Timestamp(date.getTime()+899),null);
		Saison s4 = new Saison("Frühling",new Timestamp(date.getTime()+900), new Timestamp(date.getTime()+1299),null);
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
