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
		
//		Kategorie kat1 = new Kategorie("Einzelzimmer", "Zimmer für eine Person", null , null);
//		Kategorie kat2 = new Kategorie("Doppelzimmer", "Zimmer für 2 Personen", null , null);
//		Kategorie kat3 = new Kategorie("Juniorsuit", "Größere Suit für den wohlhabenden Gast", null , null);
//		Kategorie kat4 = new Kategorie("Tirolerzimmer", "Luxus auf höchster Stufe", null , null);
		
		KategorieDao kd = new KategorieDao();
		
		/*
		 * Erstellen der Datensätze
		 */
//		kd.create(kat1);
//		kd.create(kat2);
//		kd.create(kat3);
//		kd.create(kat4);
		
		/*
		 * Auslesen der Datensätze
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
