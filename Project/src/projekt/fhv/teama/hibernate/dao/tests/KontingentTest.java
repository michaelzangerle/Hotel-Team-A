package projekt.fhv.teama.hibernate.dao.tests;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import projekt.fhv.teama.classes.IKontingent;
import projekt.fhv.teama.classes.Kontingent;
import projekt.fhv.teama.hibernate.dao.IKontingentDao;
import projekt.fhv.teama.hibernate.dao.KontingentDao;
import projekt.fhv.teama.hibernate.dao.personen.IVertragspartnerDao;
import projekt.fhv.teama.hibernate.dao.personen.VertragspartnerDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class KontingentTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		IKontingentDao kdao = KontingentDao.getInstance();
		IVertragspartnerDao vdao = VertragspartnerDao.getInstance();
		short kondition = 13;
		short ueberbuchungsgrenze = 30;
		
		IKontingent kontingent = new Kontingent(getDate(2012, 12, 25), getDate(2012, 1, 2), kondition, ueberbuchungsgrenze, vdao.getById(25));
		IKontingent kontingent2 = new Kontingent(getDate(2012, 12, 25), getDate(2012, 1, 2), kondition, ueberbuchungsgrenze, vdao.getById(26));
		
		
		//Einfügen
		kdao.create(kontingent);
		kdao.create(kontingent2);
		//getall
		Set<IKontingent> kontingente = kdao.getAll();
		System.out.println(kontingente.toString());
		
		//getbyid
		
		//IKontingent kontingentid = kdao.getById(3);
		//System.out.println(kontingentid.toString());
		
		//remove
		//kdao.remove(kontingentid);
		
		//special
		
	
	}
	
    private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month, day).getTime().getTime());

    }

}
