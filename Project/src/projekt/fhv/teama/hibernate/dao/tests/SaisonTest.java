/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.hibernate.dao.SaisonDao;
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
		
//		Date date = new java.util.Date();
//		Saison s1 = new Saison("Sommer",new Timestamp(date.getTime()), new Timestamp(date.getTime()+100));
//		Saison s2 = new Saison("Winter",new Timestamp(date.getTime()), new Timestamp(date.getTime()+100));
		
		SaisonDao sd = new SaisonDao();
//		sd.create(s1);
//		sd.create(s2);
		
//		System.out.println(sd.getAll().toString());
		
		System.out.println(sd.getSaison("Sommer").toString());
	}

}
