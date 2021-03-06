/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.hibernate.dao.personen.AdresseDao;
import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.hibernate.dao.personen.GastDao;
import projekt.fhv.teama.hibernate.dao.personen.IAdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IGastDao;
import projekt.fhv.teama.hibernate.dao.personen.IKontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.IPersonDao;
import projekt.fhv.teama.hibernate.dao.personen.KontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.PersonDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * @author mike
 *
 */
public class GastTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		
		IGastDao gDao = GastDao.getInstance();
		IAdresseDao aDao = AdresseDao.getInstance();
		IKontodatenDao kDao = KontodatenDao.getInstance();
		IPersonDao personDao=PersonDao.getInstance();
		
//	Set<IAdresse> adr1 = new HashSet<IAdresse>();
//		
//		adr1.add(aDao.getById(6));	
//		
		Set<IAdresse> adr2 = new HashSet<IAdresse>();
//		
		adr2.add(aDao.getById(33));	
		//IPerson p=personDao.getById(45);
		
		
	IGast g1 = new Gast("Kai", "von Kotze", 'w',adr2 , getDate(2000, 10, 3), "080033456", "kai.likes@to.ko", kDao.getById(13), "35676");
	//IGast g2 = new Gast("Mr", "Goldfinger", 'm', adr2 , getDate(1975, 5, 6), "0660357951", "finger@gold.cz", kDao.getById(1), "874562");

		// Einf�gen
		gDao.create(g1);
//		gDao.create(g2);
		
		// Alle holen
//		Set<IGast> gaeste = new HashSet<IGast>(gDao.getAll());
//		for (IGast g : gaeste) {
//			System.out.println(g);
//		}
		
		// 1 holen
//		System.out.println(gDao.getById(40));
		
		// update

//		IGast g1 = gDao.getById(41);
//		g1.setEmail("finger@gold.tk");
//		g1.setZimmer(null);
//		g1.setReservierungen(null);
//		gDao.create(g1);
		
		// l�schen
//		gDao.remove(g1);
		// spezial
//		System.out.println(gDao.getGastByName("Goldfinger"));
////		System.out.println(gDao.getGastByName("Mr","Goldfinger");
//		System.out.println(gDao.getGastByNummer("874562"));
		
		
	}
	
	private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month-1, day).getTime().getTime());

    }

}
