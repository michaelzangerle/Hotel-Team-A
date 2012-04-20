package projekt.fhv.teama.controller;

import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.controller.interfaces.IControllerKontodaten;
import projekt.fhv.teama.hibernate.dao.personen.IKontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.KontodatenDao;



public class ControllerKontodaten implements IControllerKontodaten {

	
	IKontodaten kontodatenModel;
	IKontodatenDao kontodatenDao;
	
	public ControllerKontodaten() {
		kontodatenDao=KontodatenDao.getInstance();
	}
	
	
	public void save(IKontodaten kontodaten)
	{
		if(kontodaten!=null)
		kontodatenDao.create(kontodaten);
	}
	
}
