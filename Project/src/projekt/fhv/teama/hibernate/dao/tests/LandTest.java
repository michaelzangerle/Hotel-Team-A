/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.util.List;
import java.util.Set;

import projekt.fhv.teama.classes.personen.Land;
import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.hibernate.dao.personen.ILandDao;
import projekt.fhv.teama.hibernate.dao.personen.LandDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 *
 */
public class LandTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		
		ILandDao lnd = LandDao.getInstance();
		// Einfügen
		
//		lnd.create(new Land("Österreich", "AT"));
//		lnd.create(new Land("Schweiz", "CH"));
//		lnd.create(new Land("Australien", "AU"));
		
		// Alle holen
		
//		Set<ILand> laender = lnd.getAll();
//		for (ILand l : laender) {
//			System.out.println(l.toString());
//		}
		
		// 1 holen
		
//		System.out.println(lnd.getById(1));
		
		// update
		
//		ILand l1 = lnd.getById(3);
//		l1.setKuerzel("AU");
//		lnd.update(l1);
		
		// spezial
		
//		System.out.println(lnd.getLandByBez("Österreich"));
//		System.out.println(lnd.getLandByKuerzel("AT"));
		
	}

}
