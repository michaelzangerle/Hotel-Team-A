/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.util.List;

import projekt.fhv.teama.classes.zimmer.Kategorie;
import projekt.fhv.teama.classes.zimmer.Saison;
import projekt.fhv.teama.classes.zimmer.Zimmerpreis;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.SaisonDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerpreisDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

/**
 * @author mike
 *
 */
public class ZimmerpreisTests {

	/**
	 * @param args
	 * @throws DatabaseNotFoundException 
	 */
	public static void main(String[] args) throws DatabaseNotFoundException {
		
		KategorieDao kd = new KategorieDao();
		SaisonDao sd = new SaisonDao();
		ZimmerpreisDao zd = new ZimmerpreisDao();
//		Zimmerpreis z1 = new Zimmerpreis(sd.getById(1), kd.getById(1), 30.50F);
//		Zimmerpreis z2 = new Zimmerpreis(sd.getById(2), kd.getById(3), 40.50F);
//		Zimmerpreis z3 = new Zimmerpreis(sd.getById(4), kd.getById(2), 50.50F);
//		Zimmerpreis z4 = new Zimmerpreis(sd.getById(3), kd.getById(4), 60.50F);
		
		
		/*
		 * Erstellen der Datensätze
		 */
//		zd.create(z1);
//		zd.create(z2);
//		zd.create(z3);
//		zd.create(z4);
		
		/*
		 * Auslesen der Datensätze
		 */
		
		List<Zimmerpreis> zimmerpreise = zd.getAll();
		for (Zimmerpreis z : zimmerpreise) {
			System.out.println(z);
		}
		
		/*
		 * Auslesen eines Datensatzes per ID
		 */
//		System.out.println(zd.getById(1));
			

	}

}
