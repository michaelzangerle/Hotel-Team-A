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
//		lnd.create(new Land("Italien", "I"));
//		lnd.create(new Land("Deutschland", "DE"));
//		lnd.create(new Land("Frankreich", "FR"));
//		lnd.create(new Land("Spanien", "E"));
//		lnd.create(new Land("Griechenland", "GR"));
//		lnd.create(new Land("United States of Amerika", "US"));
//		lnd.create(new Land("Brasilien", "BR"));
//		lnd.create(new Land("Großbritanien", "GB"));
//		lnd.create(new Land("Luxemburg", "LX"));
//		lnd.create(new Land("Niederlande", "NL"));
		
		
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
		
		// remove
		
//		lnd.remove(lnd.getById(4));
		
		
		// spezial
		
//		System.out.println(lnd.getLandByBez("Österreich"));
//		System.out.println(lnd.getLandByKuerzel("AT"));
		
	}

}
