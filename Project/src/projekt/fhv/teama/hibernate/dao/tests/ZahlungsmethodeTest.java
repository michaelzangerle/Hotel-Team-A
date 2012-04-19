/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.rechnung.Zahlungsmethode;
import projekt.fhv.teama.hibernate.dao.rechnung.ZahlungsmethodeDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 *
 */
public class ZahlungsmethodeTest {

	/**
	 * @param args
	 * @throws NoDatabaseEntryFoundException 
	 */
	public static void main(String[] args) throws NoDatabaseEntryFoundException {
		
//		ZahlungsmethodeDao zmd = new ZahlungsmethodeDao();
//		Zahlungsmethode z1 = new Zahlungsmethode("Bar", "bar", "Bezahlung erfolgt bar!");
//		Zahlungsmethode z2 = new Zahlungsmethode("Kreditkarte", "cc", "Bezahlung erfolgt mittels Kreditkarte!");
//		Zahlungsmethode z3 = new Zahlungsmethode("Scheck", "sc", "Bezahlung erfolgt mittels Scheck!");

		/*
		 * Erstellen der Datensätze
		 */
//		zmd.create(z1);
//		zmd.create(z2);
//		zmd.create(z3);
//		
		/*
		 * Auslesen der Datensätze
		 */
		
//		List<Zahlungsmethode> zm = zmd.getAll();
//		for (Zahlungsmethode z : zm) {
//			System.out.println(z);
//		}
		
		/*
		 * Auslesen eines Datensatzes per ID
		 */
//		System.out.println(zmd.getById(1));
		
		/*
		 * Auslesen eines Datensatzes per Bezeichnung
		 */
		
//		System.out.println(zmd.getZahlungsmethodeByKuerzel("cc"));
		

	}

}
