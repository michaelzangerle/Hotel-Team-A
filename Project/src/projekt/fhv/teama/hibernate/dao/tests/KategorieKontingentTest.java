package projekt.fhv.teama.hibernate.dao.tests;

import java.util.Set;

import projekt.fhv.teama.classes.IKategoriekontingent;
import projekt.fhv.teama.classes.Kategoriekontingent;
import projekt.fhv.teama.hibernate.dao.IKategoriekontingentDao;
import projekt.fhv.teama.hibernate.dao.IKontingentDao;
import projekt.fhv.teama.hibernate.dao.KategoriekontingentDao;
import projekt.fhv.teama.hibernate.dao.KontingentDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IKategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class KategorieKontingentTest {
	public static void main (String[] args) throws DatabaseException {
		IKategoriekontingentDao kdao = KategoriekontingentDao.getInstance();
		IKategorieDao kategorieDao = KategorieDao.getInstance();
		IKontingentDao kontingentDao = KontingentDao.getInstance();
		
		
		//IKategoriekontingent kontingent = new Kategoriekontingent(kategorieDao.getKategorie("Doppelzimmer"), kontingentDao.getById(8), 80, 40);
		//IKategoriekontingent kontingent2 = new Kategoriekontingent(kategorieDao.getKategorie("Einzelzimmer"), kontingentDao.getById(9), 80, 40);
		//erstellen
		//kdao.create(kontingent);
		//kdao.create(kontingent2);
		
		//get all
//		Set<IKategoriekontingent> kontingente = kdao.getAll();
//		System.out.println(kontingente.toString());
		
		//get by id
		//IKategoriekontingent k = kdao.getById(1);
		//System.out.println(k.toString());
		
		//remove
		//kdao.remove(k);
	}
}
