/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import projekt.fhv.teama.classes.personen.Berechtigung;
import projekt.fhv.teama.classes.personen.IBerechtigung;
import projekt.fhv.teama.hibernate.dao.personen.BerechtigungDao;
import projekt.fhv.teama.hibernate.dao.personen.IBerechtigungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 *
 */
public class BerechtigungTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		
		IBerechtigung b1 = new Berechtigung("Check In", "CI", "Check In abwickeln");
		IBerechtigung b2 = new Berechtigung("Check Out", "CO", "Check Out abwickeln");
		IBerechtigung b3 = new Berechtigung("Reservierung erstellen", "RE", "");
		IBerechtigung b4 = new Berechtigung("Administration", "ADM", "Administrative T�tigkeiten");
		
		IBerechtigungDao bDao = BerechtigungDao.getInstance();
		
		// Einf�gen
		
//		bDao.create(b1);
//		bDao.create(b2);
//		bDao.create(b3);
//		bDao.create(b4);
		
		// Alle holen
//		Set<IBerechtigung> brechtigungen = new HashSet<IBerechtigung>(bDao.getAll());
//		for (IBerechtigung b : brechtigungen) {
//			System.out.println(b);
//		}
		
		// 1 holen
//		Systsem.out.println(bDao.getById(1));
//		System.out.println(bDao.getBerechtigungByBezeichnung("Check Out"));
		
		// update
//		IBerechtigung b = bDao.getBerechtigungByBezeichnung("Reservierung erstellen");
//		b.setBeschreibung("Reservierung f�r einen Gast erstellen");
//		bDao.create(b);
		
		// l�schen
//		bDao.remove(bDao.getById(3));
		
		// spezial
		
		

		
		
		
	}

}
