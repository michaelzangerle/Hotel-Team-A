/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.zimmer.Kategorie;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;

/**
 * @author mike
 *
 */
public class kategorieTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Kategorie kat = new Kategorie("Testkategorie2", "Beschreibung der Testkategorie");
		KategorieDao<Kategorie> kd = new KategorieDao<Kategorie>();
		kd.create(kat);
//		Kategorie kat = kd.getById(4);
		 
		
//		kat = kd.getKategorie("Juniorsuit");
//		
//		List<Kategorie> allCat = kd.getAll();
//		System.out.println(allCat.toString()+"\n\n");
		
		System.out.println(kat.toString()+"\n\n");
		
	}

}
