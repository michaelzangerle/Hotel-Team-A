/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.rechnung.Zahlungsmethode;
import projekt.fhv.teama.hibernate.dao.rechnung.ZahlungsmethodeDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

/**
 * @author mike
 *
 */
public class ZahlungsmethodeTest {

	/**
	 * @param args
	 * @throws DatabaseNotFoundException 
	 */
	public static void main(String[] args) throws DatabaseNotFoundException {
		
		ZahlungsmethodeDao zmd = new ZahlungsmethodeDao();
		Zahlungsmethode z1 = new Zahlungsmethode("Bar", "bar", "Bezahlung erfolgt bar!");
		Zahlungsmethode z2 = new Zahlungsmethode("Kreditkarte", "cc", "Bezahlung erfolgt mittels Kreditkarte!");
		
//		zmd.create(z1);
//		zmd.create(z2);
		
		System.out.println(zmd.getAll().toString());
		
		System.out.println(zmd.getZahlungsmethodeByKuerzel("cc").toString());

	}

}
