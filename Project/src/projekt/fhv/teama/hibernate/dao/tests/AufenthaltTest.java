/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.sql.Date;
import java.util.GregorianCalendar;

import projekt.fhv.teama.classes.Aufenthalt;
import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.hibernate.dao.AufenthaltDao;
import projekt.fhv.teama.hibernate.dao.IAufenthaltDao;
import projekt.fhv.teama.hibernate.dao.IPfandtypDao;
import projekt.fhv.teama.hibernate.dao.PfandtypDao;
import projekt.fhv.teama.hibernate.dao.personen.GastDao;
import projekt.fhv.teama.hibernate.dao.personen.IGastDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * @author mike
 *
 */
public class AufenthaltTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		
		IGastDao gDao = GastDao.getInstance();
		IZimmerDao zDao = ZimmerDao.getInstance();
		IAufenthaltDao aDao = AufenthaltDao.getInstance();
		IPfandtypDao pDao = PfandtypDao.getInstance();
		
//		IAufenthalt a1 = new Aufenthalt(355.90F, "Pfandnummer 1", getDate(2012, 10, 1), getDate(2012, 10, 10), true, gDao.getById(42), zDao.getById(29), pDao.getById(1));
//		IAufenthalt a2 = new Aufenthalt(345.90F, "Pfandnummer 2", getDate(2012, 10, 1), getDate(2012, 10, 10), true, gDao.getById(42), zDao.getById(30), pDao.getById(2));
//		IAufenthalt a3 = new Aufenthalt(385.90F, "Pfandnummer 3", getDate(2012, 10, 1), getDate(2012, 10, 10), true, gDao.getById(42), zDao.getById(31), pDao.getById(3));
//		
//		aDao.create(a1);
//		aDao.create(a2);
//		aDao.create(a3);
		
		System.out.println(aDao.getById(218));
		
	}

	
	private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month-1, day).getTime().getTime());

    }
	
}
