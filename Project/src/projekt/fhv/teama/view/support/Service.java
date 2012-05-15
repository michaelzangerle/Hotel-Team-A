package projekt.fhv.teama.view.support;

import java.util.List;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.adapter.ListAdapter;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.controller.usecasecontroller.ControllerZusatzleistungBuchen;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class Service extends ArrayList<String> {

	public Service(List<ILeistung> leistungen) {
		for (ILeistung leistung : leistungen) {
			this.add(leistung.getBezeichnung());
		}
	}
	
	public Service () {
		
	}
}
