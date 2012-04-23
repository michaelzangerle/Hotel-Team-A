package projekt.fhv.teama.hibernate.dao.tests;

import java.util.HashSet;
import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.ISaison;
import projekt.fhv.teama.classes.zimmer.IZimmerpreis;
import projekt.fhv.teama.classes.zimmer.Zimmerpreis;
import projekt.fhv.teama.hibernate.dao.zimmer.IKategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ISaisonDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerpreisDao;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.SaisonDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerpreisDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class ZimmerPreisTest {
	
	public static void main(String[] args) throws DatabaseException {
		
		IZimmerpreisDao zDao = ZimmerpreisDao.getInstance();
		ISaisonDao sDao = SaisonDao.getInstance();
		IKategorieDao kDao = KategorieDao.getInstance();
//		
//		IZimmerpreis z1 = new Zimmerpreis(sDao.getSaison("Frühling"),kDao.getKategorie("Einzelzimmer"), 35.50F);
//		IZimmerpreis z2 = new Zimmerpreis(sDao.getSaison("Winter"),kDao.getKategorie("Einzelzimmer"), 38.50F);
//		IZimmerpreis z3 = new Zimmerpreis(sDao.getSaison("Herbst"),kDao.getKategorie("Einzelzimmer"), 30.50F);
//		IZimmerpreis z4 = new Zimmerpreis(sDao.getSaison("Sommer"),kDao.getKategorie("Einzelzimmer"), 40.50F);
//		
//		IZimmerpreis z5 = new Zimmerpreis(sDao.getSaison("Sommer"),kDao.getKategorie("Doppelzimmer"), 40.50F);
//		IZimmerpreis z6 = new Zimmerpreis(sDao.getSaison("Herbst"),kDao.getKategorie("Doppelzimmer"), 45.50F);
//		IZimmerpreis z7 = new Zimmerpreis(sDao.getSaison("Winter"),kDao.getKategorie("Doppelzimmer"), 48.50F);
//		IZimmerpreis z8 = new Zimmerpreis(sDao.getSaison("Frühling"),kDao.getKategorie("Doppelzimmer"), 42.50F);
//		
//		IZimmerpreis z9 = new Zimmerpreis(sDao.getSaison("Sommer"),kDao.getKategorie("Doppelzimmer + Zusatzbett"), 85.50F);
//		IZimmerpreis z10 = new Zimmerpreis(sDao.getSaison("Herbst"),kDao.getKategorie("Doppelzimmer + Zusatzbett"), 80.50F);
//		IZimmerpreis z11 = new Zimmerpreis(sDao.getSaison("Frühling"),kDao.getKategorie("Doppelzimmer + Zusatzbett"), 79.50F);
//		IZimmerpreis z12 = new Zimmerpreis(sDao.getSaison("Winter"),kDao.getKategorie("Doppelzimmer + Zusatzbett"), 75.50F);
		
		
		// Einfügen
//		zDao.create(z1);
//		zDao.create(z2);
//		zDao.create(z3);
//		zDao.create(z4);
//		zDao.create(z5);
//		zDao.create(z6);
//		zDao.create(z7);
//		zDao.create(z8);
//		zDao.create(z9);
//		zDao.create(z10);
//		zDao.create(z11);
//		zDao.create(z12);
				
		// Alle holen
		Set<IZimmerpreis> preise = new HashSet<IZimmerpreis>(zDao.getAll());
		for (IZimmerpreis z : preise) {
			System.out.println(z);
		}
		
		// 1 holen
//		System.out.println(zDao.getById(5));
		
		// update	
		
		// löschen
//		zDao.remove(zDao.getById(5));
		
		
	}
}
