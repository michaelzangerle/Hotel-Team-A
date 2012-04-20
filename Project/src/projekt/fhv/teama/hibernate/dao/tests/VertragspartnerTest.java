package projekt.fhv.teama.hibernate.dao.tests;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.classes.personen.IVertragspartnertyp;
import projekt.fhv.teama.classes.personen.Vertragspartner;
import projekt.fhv.teama.classes.personen.Vertragspartnertyp;
import projekt.fhv.teama.hibernate.dao.personen.AdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IAdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IKontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.ILandDao;
import projekt.fhv.teama.hibernate.dao.personen.IVertragspartnerDao;
import projekt.fhv.teama.hibernate.dao.personen.IVertragspartnertypDao;
import projekt.fhv.teama.hibernate.dao.personen.KontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.LandDao;
import projekt.fhv.teama.hibernate.dao.personen.VertragspartnerDao;
import projekt.fhv.teama.hibernate.dao.personen.VertragspartnertypDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class VertragspartnerTest {
	public static void main (String[] args) throws NoDatabaseEntryFoundException {
		IVertragspartnerDao vdao = VertragspartnerDao.getInstance();
		ILandDao ldao = LandDao.getInstance();
		IKontodatenDao kdao = KontodatenDao.getInstance();
		IAdresseDao adao = AdresseDao.getInstance();
		IVertragspartnertypDao vtypdao = VertragspartnertypDao.getInstance();
		
		//Set<IAdresse> adr = adao.getAll();
		
		
		IVertragspartner v1 = new Vertragspartner("Doppelmayr", "0664/85635668", "master@doppelmayr.com", ldao.getById(1), kdao.getById(1), adao.getAll(), vtypdao.getById(2));
		IVertragspartner v2 = new Vertragspartner("Alpla", "0664/756464", "master@alpla.com", ldao.getById(1), kdao.getById(1), adao.getAll(), vtypdao.getById(3));

		// Einfügen
//		vdao.create(v1);
//		vdao.create(v2);
		
		
		// Alle holen
//		Set<IVertragspartner> vertragspartner = vdao.getAll();
//		System.out.println(vertragspartner.toString());
//		
		// 1 holen
//		
		IVertragspartner partner = vdao.getById(23);
		//System.out.println(partner.toString());
//		
//		IVertragspartner vertragspartner2 = vdao.getVertragspartnerByName("Alpla");
//		System.out.println(vertragspartner2.toString());
		
		// update 
//		partner.setEmail("doppelmayr@doppelmayr.com");
//		System.out.println(partner);
		
		//spezial
		//vdao.remove(partner);
		
		
		//partner.setKontodaten();
		
	}
}
