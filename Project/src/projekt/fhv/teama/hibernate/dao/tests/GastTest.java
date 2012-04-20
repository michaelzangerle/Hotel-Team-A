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
import projekt.fhv.teama.hibernate.dao.personen.AdresseDao;
import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.hibernate.dao.personen.GastDao;
import projekt.fhv.teama.hibernate.dao.personen.IAdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IGastDao;
import projekt.fhv.teama.hibernate.dao.personen.IKontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.KontodatenDao;
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
		
//		Set<IAdresse> adr1 = new HashSet<IAdresse>();
//		
//		adr1.add(aDao.getById(22));	
//		
//		Set<IAdresse> adr2 = new HashSet<IAdresse>();
//		
//		adr2.add(aDao.getById(21));	
//		
//		IGast g1 = new Gast("James", "Bond", 'm', adr1 , getDate(1975, 5, 6), "0660357951", "james.bond@mi5.co.uk", kDao.getById(10), "987456");
//		IGast g2 = new Gast("Mr", "Goldfinger", 'm', adr2 , getDate(1975, 5, 6), "0660357951", "finger@gold.cz", kDao.getById(10), "874562");

		// Einfügen
//		gDao.create(g1);
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
		
		// löschen
//		gDao.remove(g1);
		// spezial
		System.out.println(gDao.getGastByName("Goldfinger"));
//		System.out.println(gDao.getGastByName("Mr","Goldfinger");
		System.out.println(gDao.getGastByNummer("874562"));
		
		
	}
	
	private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month-1, day).getTime().getTime());

    }

}
