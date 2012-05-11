/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.IAufenthaltLeistung;
import projekt.fhv.teama.hibernate.dao.AufenthaltDao;
import projekt.fhv.teama.hibernate.dao.AufenthaltLeistungDao;
import projekt.fhv.teama.hibernate.dao.IAufenthaltDao;
import projekt.fhv.teama.hibernate.dao.IAufenthaltLeistungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * Beschreibt
 * 
 * @author Team A
 * @version 1.2
 */
public class AufenthaltLeistungTest {

	public static void main(String[] args) throws DatabaseException {

		IAufenthaltDao aDao = AufenthaltDao.getInstance();
		// IAufenthalt a1 = aDao.getById(218);
		// System.out.println(a1);

		// for (IAufenthalt a : aDao.getAll()) {
		// System.out.println(a);
		// }

		IAufenthaltLeistungDao alDao = AufenthaltLeistungDao.getInstance();

		for (IAufenthaltLeistung al : alDao.getAll()) {
			System.out.println(al);
		}
	}
}
