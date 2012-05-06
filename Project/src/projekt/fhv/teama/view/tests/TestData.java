/**
 * 
 */
package projekt.fhv.teama.view.tests;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.wtk.text.List;
import projekt.fhv.teama.view.support.*;

/**
 *  
 *
 * @author Team A
 * @version 1.1
 */
public class TestData {
	
	public ArrayList<AdditionalServicesTableRow> testDataServices = new ArrayList<AdditionalServicesTableRow>();
		
	public void generateTestData() {
		
		for (int i = 0; i < 13; i++) {
			
			testDataServices.add(new AdditionalServicesTableRow());
			testDataServices.get(i).setAmount(i*5/(i+1)*i);
			testDataServices.get(i).setQuantity(i);
			testDataServices.get(i).setDescription(i + "Beschreibung");
			testDataServices.get(i).setType(Services.Hotel);
			testDataServices.get(i).setTotal();				
		}
		
	}

}
