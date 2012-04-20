/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;


import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.classes.personen.Person;
import projekt.fhv.teama.hibernate.dao.personen.AdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IAdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IKontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.IPersonDao;
import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.hibernate.dao.personen.KontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.PersonDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 *
 */
public class PersonTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		
		IKontodatenDao kdao = KontodatenDao.getInstance();
//		kdao.create(new Kontodaten("123456", "654321", "12345678", "98765"));
//		kdao.create(new Kontodaten("142536", "635241", "87456321", "65478"));
		
		
		
		IAdresseDao adao = AdresseDao.getInstance();
		IPersonDao pdao = PersonDao.getInstance();
//		Set<IAdresse> adr1 = new HashSet<IAdresse>();
//		Set<IAdresse> adr2 = new HashSet<IAdresse>();
//		Set<IAdresse> adr3 = new HashSet<IAdresse>();
//		adr1.add(adao.getById(1));
//
//		adr2.add(adao.getById(1));
//		adr2.add(adao.getById(2));
//
//		adr3.add(adao.getById(1));
//		adr3.add(adao.getById(2));
//		adr3.add(adao.getById(3));
//		
//		IPerson p1 = new Person("Michael", "Zangerle", 'm', adr1, getDate(2012, 11, 7), "06769740099", "michael.zangerle@gmail.com", kdao.getById(1));
//		IPerson p2 = new Person("Thomas", "Gaida", 'm', adr2, getDate(2012, 9, 7), "06649740099", "thomas.gaida@gmail.com", kdao.getById(1));
//		IPerson p3 = new Person("Christoph", "Wirtensohn", 'm', adr3, getDate(2012, 6, 7), "06769740099", "michael.zangerle@gmail.com", kdao.getById(1));
		
		// Einfügen
		
//		pdao.create(p1);
//		pdao.create(p2);
//		pdao.create(p3);
		
		// Alle holen
//		Set<IKontodaten> kdaten = kdao.getAll();
//		for (IKontodaten k : kdaten) {
//			System.out.println(k);
//		}
		
//		Set<IPerson> pers = pdao.getAll();
//		for (IPerson p : pers) {
//			System.out.println(p);
//		}
		
		// 1 holen
//		System.out.println(pdao.getById(2));
//		System.out.println(pdao.getPerson("Michael"));
//		System.out.println(pdao.getPerson("Zangerle", "Michael"));
		
		// update
		Set<IPerson> personen = pdao.getPerson("Michael", "Zangerle");
		List<IPerson> personen2 = new Vector<IPerson>(personen);
		IPerson pers1 = personen2.get(0);
		pers1.setGeschlecht('w');
		pdao.update(pers1);
		// spezial
		
		
		
	}
	
	   private static Date getDate(int year, int month, int day) {

	        return new Date(new GregorianCalendar(year, month-1, day).getTime().getTime());

	    }

}
