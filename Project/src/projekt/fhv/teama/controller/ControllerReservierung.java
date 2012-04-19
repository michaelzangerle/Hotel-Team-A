package projekt.fhv.teama.controller;

import java.util.List;

import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.Reservierung;
import projekt.fhv.teama.controller.interfaces.IControllerReservierung;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;

import projekt.fhv.teama.hibernate.dao.zimmer.ReservierungDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class ControllerReservierung implements IControllerReservierung {
	
	
	IReservierung reservierungModel;
	
	IReservierungDao reservierungsDao;

	
	
	public ControllerReservierung() {

		reservierungsDao=ReservierungDao.getInstance();
	
	}



	@Override
	public List<IReservierung> getAllReservierungen() {
		
		  try {
			List<IReservierung> reservierungen=reservierungsDao.getAll();
			return reservierungen;
			
		} catch (NoDatabaseEntryFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	
	
}
