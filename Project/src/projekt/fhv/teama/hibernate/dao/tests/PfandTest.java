/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.Pfandtyp;
import projekt.fhv.teama.hibernate.dao.IPfandtypDao;
import projekt.fhv.teama.hibernate.dao.PfandtypDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * @author mike
 *
 */
public class PfandTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
			
		IPfandtypDao pDao = PfandtypDao.getInstance();
		
		IPfandtyp p1 = new Pfandtyp("Pass", "Pass des Gastes");
		IPfandtyp p2 = new Pfandtyp("Führerschein", "Führerschein des Gastes");
		IPfandtyp p3 = new Pfandtyp("Personalausweis", "Personalausweis des Gastes");
		
		pDao.create(p1);
		pDao.create(p2);
		pDao.create(p3);
		
		
	}

}
