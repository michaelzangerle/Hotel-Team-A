/**
 * 
 */
package roomanizer.teamb.test;

import projekt.fhv.teama.hibernate.dao.personen.GastDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import roomanizer.teamb.business.BusinessFactory;
import roomanizer.teamb.presentation.forms.invoice.InvoiceStep1;
import roomanizer.teamb.service.integrate.IBGast;
import roomanizer.teamb.service.integrate.IBKonsument;

/**
 * Beschreibt 
 * @author Team A
 * @version 1.2
 */
public class InvoiceTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		
		IBGast gast = GastDao.getInstance().getById(40);
		IBKonsument konsument = (IBKonsument) gast;
		
		new InvoiceStep1(null, BusinessFactory.newInvoiceController(konsument, gast)).showForm();
	}

}
