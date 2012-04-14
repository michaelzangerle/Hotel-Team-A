package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.leistungen.Leistung;
import projekt.fhv.teama.hibernate.dao.leistungen.LeistungDao;

public class LeistungTest {
	
	public static void main(String[] args) {
		
		
		Leistung l1 = new Leistung("Erste Leistung");
		
		LeistungDao ld = new LeistungDao();
		ld.create(l1);
		
	}
}
