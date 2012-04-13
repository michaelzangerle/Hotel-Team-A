/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.rechnung.Rechnung;
import projekt.fhv.teama.classes.rechnung.Teilzahlung;
import projekt.fhv.teama.classes.rechnung.Zahlungsmethode;
import projekt.fhv.teama.hibernate.dao.rechnung.TeilzahlungDao;
import projekt.fhv.teama.hibernate.dao.rechnung.ZahlungsmethodeDao;

/**
 * @author mike
 *
 */
public class TeilzahlungTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ZahlungsmethodeDao zmd = new ZahlungsmethodeDao();
		Zahlungsmethode z1 = zmd.getById(1);
		
		TeilzahlungDao tzd = new TeilzahlungDao();
//		Rechnung r1 = new Rechnung(bezahlerVorname, bezahlerNachname, adresse, summe, nummer, mitarbeiter, rechnungspostitionen, teilzahlungen)
		
		// TODO
//		Teilzahlung tz1 = new Teilzahlung(rechnung, betrag, zahlungsmethoden)
		
	}

}
