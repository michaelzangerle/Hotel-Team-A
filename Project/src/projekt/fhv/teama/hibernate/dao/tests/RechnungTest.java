/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.sql.Date;
import java.util.GregorianCalendar;

import projekt.fhv.teama.classes.IAufenthaltLeistung;
import projekt.fhv.teama.classes.leistungen.IWarengruppe;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.classes.rechnung.IRechnung;
import projekt.fhv.teama.classes.rechnung.IRechnungsposition;
import projekt.fhv.teama.classes.rechnung.IZahlungsmethode;
import projekt.fhv.teama.classes.rechnung.Rechnung;
import projekt.fhv.teama.classes.rechnung.Rechnungsposition;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.dao.AufenthaltLeistungDao;
import projekt.fhv.teama.hibernate.dao.IAufenthaltLeistungDao;
import projekt.fhv.teama.hibernate.dao.leistungen.ILeistungDao;
import projekt.fhv.teama.hibernate.dao.leistungen.IWarengruppeDao;
import projekt.fhv.teama.hibernate.dao.leistungen.LeistungDao;
import projekt.fhv.teama.hibernate.dao.leistungen.WarengruppeDao;
import projekt.fhv.teama.hibernate.dao.personen.GastDao;
import projekt.fhv.teama.hibernate.dao.personen.IGastDao;
import projekt.fhv.teama.hibernate.dao.personen.ILandDao;
import projekt.fhv.teama.hibernate.dao.personen.IMitarbeiterDao;
import projekt.fhv.teama.hibernate.dao.personen.LandDao;
import projekt.fhv.teama.hibernate.dao.personen.MitarbeiterDao;
import projekt.fhv.teama.hibernate.dao.rechnung.IRechnungDao;
import projekt.fhv.teama.hibernate.dao.rechnung.IRechnungspositionDao;
import projekt.fhv.teama.hibernate.dao.rechnung.ITeilzahlungDao;
import projekt.fhv.teama.hibernate.dao.rechnung.IZahlungsmethodeDao;
import projekt.fhv.teama.hibernate.dao.rechnung.RechnungDao;
import projekt.fhv.teama.hibernate.dao.rechnung.RechnungspositionDao;
import projekt.fhv.teama.hibernate.dao.rechnung.TeilzahlungDao;
import projekt.fhv.teama.hibernate.dao.rechnung.ZahlungsmethodeDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * Beschreibt
 * 
 * @author Team A
 * @version 1.2
 */
public class RechnungTest {

	/**
	 * @param args
	 * @throws DatabaseException
	 */
	public static void main(String[] args) throws DatabaseException {

		IRechnungspositionDao rpDao = RechnungspositionDao.getInstance();
		IRechnungDao rDao = RechnungDao.getInstance();
		ITeilzahlungDao tDao = TeilzahlungDao.getInstance();
		IZahlungsmethodeDao zDao = ZahlungsmethodeDao.getInstance();
		IAufenthaltLeistungDao alDao = AufenthaltLeistungDao.getInstance();
		IWarengruppeDao wDao = WarengruppeDao.getInstance();
		ILeistungDao lDao = LeistungDao.getInstance();
		IGastDao gDao = GastDao.getInstance();
		ILandDao lDao2 = LandDao.getInstance();
		IMitarbeiterDao mDao = MitarbeiterDao.getInstance();
		IZimmerDao zimmerDao = ZimmerDao.getInstance();
		// for (IZahlungsmethode z : zDao.getAll()) {
		// System.out.println(z);
		// }

		IGast g = gDao.getById(42);
		IAufenthaltLeistung al = alDao.getById(1);

//		IRechnung r1 = new Rechnung("Michael", "Zangerle", "Dorf 46", "Schönwies", "6491", 10000F, "5", mDao.getById(37),
//				lDao2.getById(1), null, null);

		float preis = al.getLeistung().getPreis();
		float gesamt = al.getAnzahl() * al.getLeistung().getPreis();
		short steuer = wDao.getById(2).getSteuersatz();
		
		IRechnungsposition rp1 = new Rechnungsposition(getDate(2012, 4, 12), al.getAnzahl(), preis, gesamt, steuer, false, zimmerDao.getById(30), rDao.getById(1), al.getLeistung(), g);
		IRechnungsposition rp2 = new Rechnungsposition(getDate(2012, 5, 12), al.getAnzahl(), preis, gesamt, steuer, false, zimmerDao.getById(29), rDao.getById(1), al.getLeistung(), g);
		
		rpDao.create(rp1);
		rpDao.create(rp2);
//		rDao.create(r1);
		
	}

	private static Date getDate(int year, int month, int day) {

		return new Date(new GregorianCalendar(year, month - 1, day).getTime().getTime());

	}

}
