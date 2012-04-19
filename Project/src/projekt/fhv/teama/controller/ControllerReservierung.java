package projekt.fhv.teama.controller;

import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.Reservierung;
import projekt.fhv.teama.controller.interfaces.IControllerReservierung;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;

import projekt.fhv.teama.hibernate.dao.zimmer.ReservierungDao;

public class ControllerReservierung implements IControllerReservierung {
	
	
	IReservierung reservierungModel;
	
	IReservierungDao reservierungsDao;

	
	
	public ControllerReservierung() {

		reservierungsDao=ReservierungDao.getInstance();
	
	}



	@Override
	public void getAllReservierungen() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
