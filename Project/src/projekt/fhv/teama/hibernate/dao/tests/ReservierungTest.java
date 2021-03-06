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
import projekt.fhv.teama.classes.zimmer.IReservierungsOption;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.classes.zimmer.Kategorie;
import projekt.fhv.teama.classes.zimmer.Reservierung;
import projekt.fhv.teama.classes.zimmer.ReservierungsOption;
import projekt.fhv.teama.classes.zimmer.Teilreservierung;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.personen.GastDao;
import projekt.fhv.teama.hibernate.dao.personen.IGastDao;
import projekt.fhv.teama.hibernate.dao.personen.IPersonDao;
import projekt.fhv.teama.hibernate.dao.personen.IVertragspartnerDao;
import projekt.fhv.teama.hibernate.dao.personen.PersonDao;
import projekt.fhv.teama.hibernate.dao.personen.VertragspartnerDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IKategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungsOptionDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ITeilreservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ReservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ReservierungsOptionDao;
import projekt.fhv.teama.hibernate.dao.zimmer.TeilreservierungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class ReservierungTest {
	public static void main(String[] args) throws DatabaseException {

		IReservierungDao rnd = ReservierungDao.getInstance();
		IPersonDao pnd = PersonDao.getInstance();
		IVertragspartnerDao vnd = VertragspartnerDao.getInstance();
		IReservierungsOptionDao odao = ReservierungsOptionDao.getInstance();

		short s1 = 5;
		short s2 = 10;
		short s3 = 15;

		// IReservierungsOption o1 = new ReservierungsOption(getDate(2012, 2,
		// 24), s1, false, rnd.getById(3));
		// IReservierungsOption o2 = new ReservierungsOption(getDate(2012, 2,
		// 20), s2, false, rnd.getById(3));
		// IReservierungsOption o3 = new ReservierungsOption(getDate(2012, 2,
		// 10), s3, false, rnd.getById(3));
		// //
		// odao.create(o1);
		// odao.create(o2);
		// odao.create(o3);

		IReservierung res1 = new Reservierung(getDate(2012, 6, 13),
			getDate(2012, 6, 47), pnd.getById(48));
		// IReservierung res2 = new Reservierung(getDate(2012, 3, 24),
		// getDate(2012, 4, 28), pnd.getById(36));
		// IReservierung res3 = new Reservierung(getDate(2012, 4, 24),
		// getDate(2012, 4, 28), pnd.getById(37));

		// Einf�gen
//		rnd.create(res1);
		// rnd.create(res2);
		// rnd.create(res3);

		// Alle holen
//		 Set<IReservierung> reservierungen = rnd.getAll();
//		 System.out.println(reservierungen.toString());
		 
		IGastDao gDao = GastDao.getInstance();
		
		//IReservierung reservierung=rnd.getById(3);
		res1.addGast(gDao.getById(48));
		rnd.create(res1);
		
//		IReservierung r1 = rnd.getById(4);
//		r1.addGast(gDao.getById(40));
//		rnd.create(r1);
		

		// 1 holen
		// TODO optionen <-> reservierung bug?
//		 IReservierung r1 = rnd.getById(3);
//		 r1.removeOption(odao.getById(4));
//		 r1.removeOption(odao.getById(5));
//		 r1.removeOption(odao.getById(6));
//		 r1.addOption(odao.getById(4));
//		 r1.addOption(odao.getById(5));
//		 r1.addOption(odao.getById(6));
		
//		 rnd.create(r1);

//		Set<IReservierungsOption> optionen = rnd.getById(3).getOptionen();
//
//		System.out.println(optionen);

		// update
		// reservierung.setBis(getDate(2012, 2, 30));
		// rnd.update(reservierung);
		// System.out.println(reservierung);

		// spezial - �ber person.getReservierungen bzw.
		// vertragspartner.getReservierungen?
		
//		Set<IReservierung> reservierungbyPerson = rnd.getReservierungByPerson(pnd.getById(36).getVorname(),
//				pnd.getById(36).getNachname());
//		System.out.println("reservierungen von person -> " + reservierungbyPerson.toString());

//		 Set<IReservierung> reservierungbyVP =
//		 rnd.getReservierungByVP(vnd.getById(37).getName());
//		 System.out.println("reservierungen von Vertragspartner -> " +
//		 reservierungbyVP.toString());

		// remove - database connections lassen l�schen nicht zu
//		 IReservierung deleteReservierung = rnd.getById(3);
//		 System.out.println(deleteReservierung);
//		 rnd.remove(deleteReservierung);

		// set teilreservierung FEHLERMELDUNG: nested transactions not supported
		// IKategorieDao kategoriedao = KategorieDao.getInstance();
		// ITeilreservierungDao teilreservierungdao =
		// TeilreservierungDao.getInstance();
		//
		// IKategorie kategorie = kategoriedao.getById(2);
		// ITeilreservierung teilreservierung = new Teilreservierung(kategorie,
		// reservierung, 5);
		//
		// reservierung.addTeilreservierung(teilreservierung);
		//
		// Session session = HibernateHelper.getSession();
		// session.beginTransaction();
		// teilreservierungdao.update(teilreservierung);
		// session.getTransaction().commit();
		// session.close();

		// get teilreservierungen
		//
		// Set<ITeilreservierung> setreservierung =
		// reservierung.getTeilreservierungen();
		// System.out.println(setreservierung.toString());
	}

	private static Date getDate(int year, int month, int day) {

		return new Date(new GregorianCalendar(year, month, day).getTime().getTime());

	}

}
