package projekt.fhv.teama.hibernate.dao.tests;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import projekt.fhv.teama.classes.zimmer.ISaison;
import projekt.fhv.teama.classes.zimmer.Saison;
import projekt.fhv.teama.hibernate.dao.zimmer.ISaisonDao;
import projekt.fhv.teama.hibernate.dao.zimmer.SaisonDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class SaisonTest {
	
	public static void main(String[] args) throws DatabaseException {
		ISaisonDao sDao = SaisonDao.getInstance();
		
		ISaison s1 = new Saison("Frühling", getDate(2012, 3, 1), getDate(2012, 5, 30), null);
		ISaison s2 = new Saison("Sommer", getDate(2012, 6, 1), getDate(2012, 8, 30), null);
		ISaison s3 = new Saison("Herbst", getDate(2012, 9, 1), getDate(2012, 11, 30), null);
		ISaison s4 = new Saison("Winter", getDate(2012, 12, 1), getDate(2012, 2, 30), null);
//		
		// Einfügen
		sDao.create(s1);
		sDao.create(s2);
		sDao.create(s3);
		sDao.create(s4);
		
		// Alle holen
//		Set<ISaison> saisons = new HashSet<ISaison>(sDao.getAll());
//		for (ISaison s : saisons) {
//			System.out.println(s);
//		}
		

		// 1 holen
//		System.out.println(sDao.getById(7));
		
		// update
//		ISaison s1 = sDao.getById(7);
//		s1.setBezeichnung("Frühling");
//		sDao.create(s1);
		
		// löschen
//		sDao.remove(sDao.getById(1));
//		sDao.remove(sDao.getById(2));
//		sDao.remove(sDao.getById(3));
//		sDao.remove(sDao.getById(4));
		
		// spezial
//		System.out.println(sDao.getSaison("Frühling"));
		
		
	}
	
	private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month-1, day).getTime().getTime());

    }
}
