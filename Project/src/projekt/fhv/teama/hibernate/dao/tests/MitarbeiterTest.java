package projekt.fhv.teama.hibernate.dao.tests;

import java.sql.Date;
import java.util.GregorianCalendar;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.classes.personen.Mitarbeiter;
import projekt.fhv.teama.hibernate.dao.personen.AdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IAdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IKontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.IMitarbeiterDao;
import projekt.fhv.teama.hibernate.dao.personen.KontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.MitarbeiterDao;

public class MitarbeiterTest {
	
	public static void main(String[] args) {
		
		IMitarbeiterDao mdao = MitarbeiterDao.getInstance();
		IKontodatenDao kdao = KontodatenDao.getInstance();
		IAdresseDao adao = AdresseDao.getInstance();
		
		IMitarbeiter m1 = new Mitarbeiter(vorname, nachname, geschlecht, adresse, geburtsdatum, telefonnummer, email, bankverbindung, nummer, passwort, einstellung);
		
		// Einfügen
		// Alle holen
		// 1 holen
		// update
		// spezial
	}
	
	private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month-1, day).getTime().getTime());

    }

}
