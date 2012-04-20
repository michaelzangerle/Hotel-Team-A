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
		
		
		//kdao.create(new Kontodaten("654789", "175867", "98745329", "98765"));
		//kdao.create(new Kontodaten("159843", "365124", "15948732", "15742"));
		
		IKontodaten konto = kdao.getById(1);
		System.out.println(konto.toString());
		Set<IKontodaten> kontos = kdao.getAll();
		System.out.println(kontos.toString());
		
		konto.setIban("123456");
		kdao.update(konto);
		System.out.println(konto);
		
	}
}
