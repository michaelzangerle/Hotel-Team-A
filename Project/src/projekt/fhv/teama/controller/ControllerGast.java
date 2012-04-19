package projekt.fhv.teama.controller;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.controller.interfaces.IControllerGast;
import projekt.fhv.teama.hibernate.dao.personen.GastDao;
import projekt.fhv.teama.hibernate.dao.personen.IGastDao;

public class ControllerGast implements IControllerGast {

	private IGast gastModel;
	private IGastDao gastDao;
	
	public ControllerGast() {
		gastDao=GastDao.getInstance();
	}

	@Override
	public void setAktuellGast(IGast gast) {
		gastModel=gast;
		
	}
	
	public void setVorname(String vorname)
	{
		gastModel.setVorname(vorname);
	}
	
	
}
