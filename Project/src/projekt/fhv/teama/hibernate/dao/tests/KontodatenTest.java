package projekt.fhv.teama.hibernate.dao.tests;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.classes.personen.Kontodaten;
import projekt.fhv.teama.hibernate.dao.personen.IKontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.KontodatenDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public class KontodatenTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		IKontodatenDao kdao = KontodatenDao.getInstance();
		
		
		kdao.create(new Kontodaten("E 21 12435753 98754324", "1213255", "98754324", "12435753"));
		kdao.create(new Kontodaten("AT 43 34523452 123098762", "1213255", "123098762", "34523452"));
//		
//		IKontodaten konto = kdao.getById(1);
//		System.out.println(konto.toString());
//		Set<IKontodaten> kontos = kdao.getAll();
//		System.out.println(kontos.toString());
//		
//		konto.setIban("123456");
//		kdao.update(konto);
//		System.out.println(konto);
		
	}
}
