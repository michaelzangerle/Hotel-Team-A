package projekt.fhv.teama.hibernate.dao.tests;

import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.Kategorie;
import projekt.fhv.teama.hibernate.dao.zimmer.IKategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class KategorieTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		IKategorieDao kategoriedao = KategorieDao.getInstance();
		
		IKategorie kategorie1 = new Kategorie("Einzelzimmer", "Zimmer ausgestattet mit einem Bett.");
		IKategorie kategorie2 = new Kategorie("Doppelzimmer", "Zimmer ausgestattet mit zwei Betten.");
		IKategorie kategorie3 = new Kategorie("Doppelzimmer + Zusatzbett", "Zimmer ausgestattet mit zwei Betten inklusive Zusatzbett.");
		
		
		//einfügen
		kategoriedao.create(kategorie1);
		kategoriedao.create(kategorie2);
		kategoriedao.create(kategorie3);
//		
		
		//get by ID
//		IKategorie kategorie = kategoriedao.getById(1);
//		System.out.println(kategorie.toString());
		
		//get all
//		Set<IKategorie> kategorien = kategoriedao.getAll();
//		System.out.println(kategorien.toString());
		
		
		//spezial
		//System.out.println(kategoriedao.getKategorie("Einzelzimmer"));
		
		//remove
		//kategoriedao.remove(kategoriedao.getKategorie("Einzelzimmer"));
	
	}

}
