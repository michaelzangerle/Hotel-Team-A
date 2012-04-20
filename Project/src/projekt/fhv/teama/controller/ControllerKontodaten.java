package projekt.fhv.teama.controller;

import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.controller.interfaces.IControllerKontodaten;
import projekt.fhv.teama.hibernate.dao.personen.IKontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.KontodatenDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;



public class ControllerKontodaten implements IControllerKontodaten {

	
	IKontodaten kontodatenModel;
	IKontodatenDao kontodatenDao;
	
	public ControllerKontodaten() {
		kontodatenDao=KontodatenDao.getInstance();
	}
	
	
	public void save(IKontodaten kontodaten)
	{
		if(kontodaten!=null)
			try {
				kontodatenDao.create(kontodaten);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
