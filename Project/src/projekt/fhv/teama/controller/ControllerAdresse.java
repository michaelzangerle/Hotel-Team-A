package projekt.fhv.teama.controller;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.controller.interfaces.IControllerAdresse;
import projekt.fhv.teama.hibernate.dao.personen.AdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IAdresseDao;



public class ControllerAdresse implements IControllerAdresse {


	IAdresse adressModel;
	IAdresseDao adressDao;
	
	public ControllerAdresse() {
		adressDao=AdresseDao.getInstance();
	}
	
	@Override
	public void save(IAdresse adr) {
		if(adr!=null)
			adressDao.create(adr);
		
	}

}
