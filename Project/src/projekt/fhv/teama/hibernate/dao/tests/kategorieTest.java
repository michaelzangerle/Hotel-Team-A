/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 *
 */
public class kategorieTest {

	/**
	 * @param args
	 * @throws NoDatabaseEntryFoundException 
	 */
	public static void main(String[] args) throws NoDatabaseEntryFoundException {
		
//		Kategorie kat1 = new Kategorie("Einzelzimmer", "Zimmer f�r eine Person", null , null);
//		Kategorie kat2 = new Kategorie("Doppelzimmer", "Zimmer f�r 2 Personen", null , null);
//		Kategorie kat3 = new Kategorie("Juniorsuit", "Gr��ere Suit f�r den wohlhabenden Gast", null , null);
//		Kategorie kat4 = new Kategorie("Tirolerzimmer", "Luxus auf h�chster Stufe", null , null);
		
		KategorieDao kd = new KategorieDao();
		
		/*
		 * Erstellen der Datens�tze
		 */
//		kd.create(kat1);
//		kd.create(kat2);
//		kd.create(kat3);
//		kd.create(kat4);
		
		/*
		 * Auslesen der Datens�tze
		 */
		
//		List<Kategorie> saison = kd.getAll();
//		for (Kategorie s : saison) {
//			System.out.println(s);
//		}
		
		/*
		 * Auslesen eines Datensatzes per ID
		 */
//		System.out.println(kd.getById(1));
		
		/*
		 * Auslesen eines Datensatzes per Bezeichnung
		 */
		
//		System.out.println(kd.getKategorie("Einzelzimmer"));
		
	}

}
