package projekt.fhv.teama.controller;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.controller.interfaces.IControllerAdresse;
import projekt.fhv.teama.hibernate.dao.personen.AdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IAdresseDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;



public class ControllerAdresse implements IControllerAdresse {


	IAdresse adressModel;
	IAdresseDao adressDao;
	
	public ControllerAdresse() {
		adressDao=AdresseDao.getInstance();
	}
	
	@Override
	public void save(IAdresse adr) {
		if(adr!=null)
			try {
				adressDao.create(adr);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
