/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

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
		
		
//		LandDao<Land> ld = new LandDao<Land>();
//		ld.create(new Land("�sterreich", "AT"));
//		ld.create(new Land("Deutschland", "DE"));
//		ld.create(new Land("Schweiz", "CH"));
		
//		List<Land> laender = ld.getAll();
//		Land aut1 = ld.getLand("�sterreich");
//		Land aut2 = ld.getLand("�sterreich");
		
//		System.out.println(laender.toString());
//		System.out.println(aut1.toString());
//		System.out.println(aut2.toString());
//		
//		Adresse adr = new Adresse("Dorf 46", "6491", "Sch�nwies");
//		Bankverbindung bank = new Bankverbindung("123456789", "123456", "32165498", "12345");
//		@SuppressWarnings("deprecation")
//		Person pers = new Person("�lkj", "Zangerle", 'm', adr, new Date(1989, 12, 7), "06769470089", "michael.zangerle@gmail.com", bank, aut1);
		
		
		PersonDao pd = new PersonDao();
		System.out.println(pd.getById(1).toString());
		System.out.println(pd.getAll().toString());
		

	}

}
