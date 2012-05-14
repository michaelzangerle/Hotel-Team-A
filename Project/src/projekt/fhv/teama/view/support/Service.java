package projekt.fhv.teama.view.support;

import java.util.List;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.adapter.ListAdapter;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.controller.usecasecontroller.ControllerZusatzleistungBuchen;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class Service extends ArrayList<String> {
	private static Service service;
	
	
	public Service(List<ILeistung> leistungen) {
		service = this;
		for (ILeistung leistung : leistungen) {
			this.add(leistung.getBezeichnung());
		}
	}
	
	public Service () {
		
	}
	
	public Service getService () {
		return this;
	}

	
	

//	public Service getService (String name) {
//		return this.get(2);
//	}
}
