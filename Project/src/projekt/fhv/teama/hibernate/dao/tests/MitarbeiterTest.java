package projekt.fhv.teama.hibernate.dao.tests;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.classes.personen.Mitarbeiter;
import projekt.fhv.teama.hibernate.dao.personen.AdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IAdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IKontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.IMitarbeiterDao;
import projekt.fhv.teama.hibernate.dao.personen.IPersonDao;
import projekt.fhv.teama.hibernate.dao.personen.KontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.MitarbeiterDao;
import projekt.fhv.teama.hibernate.dao.personen.PersonDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class MitarbeiterTest {
	
	public static void main(String[] args) throws NoDatabaseEntryFoundException {
		
		IMitarbeiterDao mdao = MitarbeiterDao.getInstance();
		IKontodatenDao kdao = KontodatenDao.getInstance();
		IAdresseDao adao = AdresseDao.getInstance();
		IPersonDao pdao = PersonDao.getInstance();
		
//		Set<IAdresse> adr1 = new HashSet<IAdresse>();
//		Set<IAdresse> adr2 = new HashSet<IAdresse>();
//		Set<IAdresse> adr3 = new HashSet<IAdresse>();
//		
//		adr3.add(adao.getById(1));
//
//		adr1.add(adao.getById(1));
//		adr1.add(adao.getById(2));
//
//		adr2.add(adao.getById(1));
//		adr2.add(adao.getById(2));
//		adr2.add(adao.getById(3));

//		IMitarbeiter m1 = new Mitarbeiter("Patrick", "Jost", 'm',adr1, getDate(1966, 12, 31), "0650123456", "info@pajo.com", kdao.getById(1), "66", "1234", getDate(2001, 1, 3));
//		IMitarbeiter m2 = new Mitarbeiter("Pamela", "Anderson", 'w',adr1, getDate(1936, 9, 3), "0650123456", "bangpow@pamela.com", kdao.getById(4), "86", "1234", getDate(2001, 1, 3));
//		IMitarbeiter m3 = new Mitarbeiter("Nicki", "Heat", 'w',adr1, getDate(1985, 6, 11), "0650123456", "dingdong@heat.com", kdao.getById(3), "13", "1234", getDate(2001, 1, 3));
		
		// Einf�gen
//		mdao.create(m1);
//		mdao.create(m2);
//		mdao.create(m3);
				
		// Alle holen
//		Set<IMitarbeiter> mitarbeiters = mdao.getAll();
//		for (IMitarbeiter m : mitarbeiters) {
//			System.out.println(m);
//		}
		
		
		// 1 holen
//		System.out.println(mdao.getById(1));
		
		mdao.removeById(7);
//		mdao.removeById(8);
//		mdao.removeById(9);
//		
		// update
		// spezial
	}
	
	private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month-1, day).getTime().getTime());

    }

}
