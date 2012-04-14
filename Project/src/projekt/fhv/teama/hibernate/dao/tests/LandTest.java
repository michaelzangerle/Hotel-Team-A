package projekt.fhv.teama.hibernate.dao.tests;

import java.util.List;

import projekt.fhv.teama.classes.personen.Land;
import projekt.fhv.teama.hibernate.dao.personen.LandDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class LandTest {
	public static void main(String[] args) throws DatabaseException {
		//getestet aber nicht mehr auffindbar?
		
		LandDao<Land> ld = new LandDao<Land>();
//		ld.create(new Land("Österreich", "AT"));
//		ld.create(new Land("Deutschland", "DE"));
//		ld.create(new Land("Schweiz", "CH"));
		
		List<Land> laender = ld.getAll();
		Land aut1 = ld.getById(3);
		Land aut2 = ld.getLand("Österreich");
	
		System.out.println(laender.toString());
		System.out.println(aut1.toString());
		System.out.println(aut2.toString());
	}
}
