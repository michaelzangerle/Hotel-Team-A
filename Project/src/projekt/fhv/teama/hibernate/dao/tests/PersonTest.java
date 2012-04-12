/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.util.Date;
import java.util.List;

import projekt.fhv.teama.classes.Bankverbindung;
import projekt.fhv.teama.classes.Land;
import projekt.fhv.teama.classes.personen.Adresse;
import projekt.fhv.teama.classes.personen.Person;
import projekt.fhv.teama.hibernate.dao.LandDao;
import projekt.fhv.teama.hibernate.dao.personen.PersonDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * @author mike
 *
 */
public class PersonTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		
		
		LandDao<Land> ld = new LandDao<Land>();
//		ld.create(new Land("Österreich", "AT"));
//		ld.create(new Land("Deutschland", "DE"));
//		ld.create(new Land("Schweiz", "CH"));
		
//		List<Land> laender = ld.getAll();
		Land aut1 = ld.getById(3);
//		Land aut2 = ld.getLand("Österreich");
		
//		System.out.println(laender.toString());
		System.out.println(aut1.toString());
//		System.out.println(aut2.toString());
//		
		Adresse adr = new Adresse("Dorf 46", "6491", "Schönwies");
		Bankverbindung bank = new Bankverbindung("123456789", "123456", "32165498", "12345");
		@SuppressWarnings("deprecation")
		Person pers = new Person("Michael", "Zangerle", 'm', adr, new Date(1989, 12, 7), "06769470089", "michael.zangerle@gmail.com", bank, aut1);
		
		
		PersonDao<Person> pd = new PersonDao<>();
//		pd.create(pers);
		System.out.println(pd.getById(1).toString());
		//System.out.println(pd.getAll().toString());
		

	}

}
