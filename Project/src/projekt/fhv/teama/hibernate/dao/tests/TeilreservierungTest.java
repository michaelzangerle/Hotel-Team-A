package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.classes.zimmer.Teilreservierung;
import projekt.fhv.teama.hibernate.dao.zimmer.IKategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ITeilreservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ReservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.TeilreservierungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class TeilreservierungTest {
	public static void main (String[] args) throws DatabaseException {
		ITeilreservierungDao teilreservierungdao = TeilreservierungDao.getInstance();
		IKategorieDao kategoriedao = KategorieDao.getInstance();
		IReservierungDao rnd = ReservierungDao.getInstance();
		
		IKategorie kategorie = kategoriedao.getById(6);
		ITeilreservierung teilreservierung = new Teilreservierung(kategorie, rnd.getById(2), 5);
		
		teilreservierungdao.create(teilreservierung);
	
	}
}
