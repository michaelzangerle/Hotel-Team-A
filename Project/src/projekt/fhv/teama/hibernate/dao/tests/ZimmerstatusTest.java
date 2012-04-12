/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.zimmer.Zimmerstatus;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerstatusDao;

/**
 * @author mike
 * 
 */
public class ZimmerstatusTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ZimmerstatusDao zd = new ZimmerstatusDao();
		Zimmerstatus zs = new Zimmerstatus("Voll im Arsch", "ViM");
		zd.create(zs);
	}

}
