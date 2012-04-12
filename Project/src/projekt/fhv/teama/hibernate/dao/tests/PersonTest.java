/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.util.Date;

import projekt.fhv.teama.classes.Bankverbindung;
import projekt.fhv.teama.classes.Land;
import projekt.fhv.teama.classes.personen.Adresse;
import projekt.fhv.teama.classes.personen.Person;
import projekt.fhv.teama.hibernate.dao.LandDao;
import projekt.fhv.teama.hibernate.dao.personen.PersonDao;

/**
 * @author mike
 *
 */
public class PersonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		LandDao<Land> ld = new LandDao<Land>();
		ld.create(new Land("Österreich", "AT"));
		ld.create(new Land("Deutschland", "DE"));
		ld.create(new Land("Schweiz", "CH"));
		
//		Adresse adr = new Adresse("Dorf 46", "6491", "Schönwies");
//		Bankverbindung bank = new Bankverbindung("123456789", "123456", "32165498", "12345");
//		Person pers = new Person("Michael", "Zangerle", "xas", adr, new Date(1989, 12, 7), "06769470089", "michael.zangerle@gmail.com", bank, land);
//		
//		
//		PersonDao<Person> pd = new PersonDao<>();
//		pd.create(pers);
		

	}

}
