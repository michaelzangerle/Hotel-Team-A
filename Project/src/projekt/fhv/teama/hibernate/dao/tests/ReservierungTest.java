package projekt.fhv.teama.hibernate.dao.tests;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.classes.zimmer.Kategorie;
import projekt.fhv.teama.classes.zimmer.Reservierung;
import projekt.fhv.teama.classes.zimmer.Teilreservierung;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.personen.IPersonDao;
import projekt.fhv.teama.hibernate.dao.personen.IVertragspartnerDao;
import projekt.fhv.teama.hibernate.dao.personen.PersonDao;
import projekt.fhv.teama.hibernate.dao.personen.VertragspartnerDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IKategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ITeilreservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ReservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.TeilreservierungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class ReservierungTest {
	public static void main (String[] args) throws DatabaseException {
		IReservierungDao rnd = ReservierungDao.getInstance();
		IPersonDao pnd = PersonDao.getInstance();
		IVertragspartnerDao vnd = VertragspartnerDao.getInstance();

//		IReservierung res1 = new Reservierung(getDate(2012, 2, 24), getDate(2012, 2, 28), pnd.getById(1));
//		IReservierung res2 = new Reservierung(getDate(2012, 2, 24), getDate(2012, 2, 28), pnd.getById(2));
//		IReservierung res3 = new Reservierung(getDate(2012, 2, 24), getDate(2012, 2, 28), vnd.getById(27));
		
		
		// Einfügen
		//rnd.create(res1);
		//rnd.create(res2);
		//rnd.create(res3);
		
		
		// Alle holen
//		Set<IReservierung> reservierungen = rnd.getAll();
//		System.out.println(reservierungen.toString());
//		
		
		// 1 holen
		IReservierung reservierung = rnd.getById(2);
//		System.out.println(reservierung);
		
		
		
		// update 
//		reservierung.setBis(getDate(2012, 2, 30));
//		rnd.update(reservierung);
//		System.out.println(reservierung);
		
		//spezial - über person.getReservierungen bzw. vertragspartner.getReservierungen?
		//Set<IReservierung> reservierungbyPerson = rnd.getReservierungByPerson( pnd.getById(1).getVorname(),  pnd.getById(1).getNachname());
		//System.out.println("reservierungen von person -> " + reservierungbyPerson.toString());
		
		
		//Set<IReservierung> reservierungbyVP = rnd.getReservierungByVP(vnd.getById(27).getName());
		//System.out.println("reservierungen von Vertragspartner -> " + reservierungbyVP.toString());
		
		
		
		//remove
		//IReservierung deleteReservierung = rnd.getById(1);
		//rnd.remove(deleteReservierung);
		
		
		//set teilreservierung FEHLERMELDUNG: nested transactions not supported
//		IKategorieDao kategoriedao = KategorieDao.getInstance();
//		ITeilreservierungDao teilreservierungdao = TeilreservierungDao.getInstance();
//		
//		IKategorie kategorie = kategoriedao.getById(2);
//		ITeilreservierung teilreservierung = new Teilreservierung(kategorie, reservierung, 5);
//		
//		reservierung.addTeilreservierung(teilreservierung);
//		
//		Session session = HibernateHelper.getSession();
//		session.beginTransaction();
//		teilreservierungdao.update(teilreservierung);		
//		session.getTransaction().commit();
//		session.close();
		

		
		
		//get teilreservierungen 
//		
//		Set<ITeilreservierung> setreservierung = reservierung.getTeilreservierungen();
//		System.out.println(setreservierung.toString());
	}
	
    private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month, day).getTime().getTime());

    }

}
