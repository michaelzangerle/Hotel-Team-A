package projekt.fhv.teama.hibernate.dao.tests;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

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
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class MitarbeiterTest {
	
	public static void main(String[] args) throws DatabaseException {
		
		IMitarbeiterDao mdao = MitarbeiterDao.getInstance();
		IKontodatenDao kdao = KontodatenDao.getInstance();
		IAdresseDao adao = AdresseDao.getInstance();
		IPersonDao pdao = PersonDao.getInstance();
		
		Set<IAdresse> adr1 = new HashSet<IAdresse>();
		Set<IAdresse> adr2 = new HashSet<IAdresse>();
		Set<IAdresse> adr3 = new HashSet<IAdresse>();
		
//		adr3.add(adao.getById(22));

//		adr1.add(adao.getById(16));
//		adr1.add(adao.getById(10));

//		adr2.add(adao.getById(17));
//		adr2.add(adao.getById(2));
//		adr2.add(adao.getById(3));

//		IMitarbeiter m1 = new Mitarbeiter("Patrick", "Jost", 'm',adr1, getDate(1966, 12, 31), "0650123456", "info@pajo.com", kdao.getById(4), "66", "1234", getDate(2001, 1, 3));
//		IMitarbeiter m2 = new Mitarbeiter("Pamela", "Anderson", 'w',adr2, getDate(1936, 9, 3), "0650123456", "bangpow@pamela.com", kdao.getById(5), "86", "1234", getDate(2001, 1, 3));
//		IMitarbeiter m3 = new Mitarbeiter("Nicki", "Heat", 'w',adr3, getDate(1985, 6, 11), "0650123456", "dingdong@heat.com", kdao.getById(10), "13", "1234", getDate(2001, 1, 3));
//		
		// Einfügen
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

		
//		mdao.remove(mdao.getById(38));
//		mdao.remove(mdao.getById(7));
//		mdao.remove(mdao.getById(7));
//		
		// update
		
		// spezial
		IMitarbeiter m1 = new Vector<IMitarbeiter>(mdao.getMitarbeiterByNummer("13")).get(0);
//		IMitarbeiter m1 = new Vector<IMitarbeiter>(mdao.getMitarbeiterByName("Nicki")).get(0);
//		IMitarbeiter m1 = new Vector<IMitarbeiter>(mdao.getMitarbeiter("Nicki","Heat")).get(0);
		System.out.println(m1.getEmail());
	}
	
	private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month-1, day).getTime().getTime());

    }

}
