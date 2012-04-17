/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.util.List;

import projekt.fhv.teama.classes.zimmer.Zimmerstatus;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerstatusDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 *
 */
public class ZimmerstatusTest {
	
	public static void main(String[] args) throws NoDatabaseEntryFoundException {
		
//		Zimmerstatus status = new Zimmerstatus("Guten Morgen", "GM");
		ZimmerstatusDao zd = new ZimmerstatusDao();
		//zd.create(status);
		
		List<Zimmerstatus> stati = zd.getAll();
		System.out.println(stati.toString());
		//System.out.println(zd.getById(1));
		
		
		
		
	}
}
