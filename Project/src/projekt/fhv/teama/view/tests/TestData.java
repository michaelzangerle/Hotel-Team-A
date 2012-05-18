/**
 * 
 */
package projekt.fhv.teama.view.tests;

import java.util.LinkedList;
import java.util.List;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.adapter.ListAdapter;
import org.apache.pivot.wtk.ListButton;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.controller.usecasecontroller.ControllerZusatzleistungBuchen;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IALeistung;
import projekt.fhv.teama.view.support.*;


/**
 *  
 *
 * @author Team A
 * @version 1.1
 */
public class TestData {
	
	public ArrayList<AdditionalServicesTableRow> testDataServices;
		
	public void generateTestData() {
		ControllerZusatzleistungBuchen controller = new ControllerZusatzleistungBuchen();
		List<IALeistung> list = null;
		try {
			list = controller.getArtikelundZusatzleistungen();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		List<String> stringlist = new LinkedList<String>();
		for (IALeistung leistung : list){
			stringlist.add(leistung.getBezeichnung());
			arrayList.add(leistung.getBezeichnung());
		}
		
		
		
		ListAdapter<String> templist = new ListAdapter<String>(stringlist);
		
		ListAdapter<String> la = new ListAdapter<String>(stringlist);
		for (int i = 0; i < 1; i++) {
			
			testDataServices.add(new AdditionalServicesTableRow());
			testDataServices.get(i).setAmount(i*5/(i+1)*i);
			testDataServices.get(i).setQuantity(i);
			testDataServices.get(i).setDescription(i + "Beschreibung");
//			testDataServices.get(i).setType(new Service(stringlist));
			testDataServices.get(i).setTotal("i");				
		}
		
	}


	public TestData(ArrayList<AdditionalServicesTableRow> tableDataService) {
		this.testDataServices = tableDataService;
	}

}
