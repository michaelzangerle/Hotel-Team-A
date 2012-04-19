package projekt.fhv.teama.hibernate.dao.tests;

import java.util.List;

import projekt.fhv.teama.classes.personen.Land;
import projekt.fhv.teama.hibernate.dao.personen.LandDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/*
 * Testdatum: 17.04
 * Datenbankversion: Harry 2.0 
 */
public class LandTest {
	public static void main(String[] args) throws DatabaseException {
		LandDao ld = new LandDao();

		//ld.create(new Land("Österreich", "AT"));
		//ld.create(new Land("Deutschland", "DE"));
		//ld.create(new Land("Schweiz", "CH"));
		
		
		//List<Land> laender = ld.getAll();
		//Land aut1 = ld.getById(3);
		Land aut2 = ld.getLandByBez("Österreich");
		
		System.out.println(laender.toString());
		System.out.println(aut2.toString());
	}
}
