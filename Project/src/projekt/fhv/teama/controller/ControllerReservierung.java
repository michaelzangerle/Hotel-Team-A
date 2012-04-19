package projekt.fhv.teama.controller;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.controller.interfaces.IControllerReservierung;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;

import projekt.fhv.teama.hibernate.dao.zimmer.ReservierungDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class ControllerReservierung implements IControllerReservierung {
	
	
	private IReservierung reservierungModel;
	private IReservierungDao reservierungsDao;
	
	private List<IReservierung> reservierungen;

	
	
	public ControllerReservierung() {

		reservierungsDao=ReservierungDao.getInstance();
	}



	@Override
	public List<IReservierung> getAllReservierungen() {
		
		  try {
			List<IReservierung> reservierungen=new Vector<IReservierung>(reservierungsDao.getAll());
			return reservierungen;
			
		} catch (NoDatabaseEntryFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	public void setAktuelleReservierung(IReservierung reservierung)
	{
		if(reservierungen.contains(reservierung))
		{
			reservierungModel=reservierung;
		}
		
	}
	public IReservierung getAktuelleReservierung()
	{
		return reservierungModel;
	}


	@Override
	public boolean containsGast(IGast gast) {
		if(reservierungen.contains(gast))
			return true;
		else
		return false;
	}


	@Override
	public List<ITeilreservierung> getTeilreservierungen() {
		List<ITeilreservierung>list;
		if(reservierungModel!=null)
			//return list= new Vector<ITeilreservierung>(reservierungModel.getTeilreservierungen());
			
			return null;
		return null;
	}
	
	
	
	
	
	
}
