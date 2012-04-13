/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.Saison;
import projekt.fhv.teama.classes.zimmer.Kategorie;
import projekt.fhv.teama.classes.zimmer.Zimmerpreis;
import projekt.fhv.teama.hibernate.dao.SaisonDao;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerpreisDao;

/**
 * @author mike
 *
 */
public class ZimmerpreisTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		SaisonDao sd = new SaisonDao();
		Saison s1 = sd.getById(2);
		
		KategorieDao kd = new KategorieDao();
		Kategorie kat1 = kd.getById(6);
		
		float preis = 991.58F;
		Zimmerpreis zp = new Zimmerpreis(s1, kat1, preis);
		ZimmerpreisDao zpd = new ZimmerpreisDao();
		zpd.create(zp);
		
		
		

	}

}
