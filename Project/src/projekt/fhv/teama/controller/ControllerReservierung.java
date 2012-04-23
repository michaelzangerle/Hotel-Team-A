package projekt.fhv.teama.controller;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.controller.interfaces.IControllerReservierung;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;

import projekt.fhv.teama.hibernate.dao.zimmer.ReservierungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

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
			
		} catch (DatabaseEntryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public void setAktuelleReservierung(IReservierung reservierung)
	{
			reservierungModel=reservierung;
		
	}
	public IReservierung getAktuelleReservierung()
	{
		return reservierungModel;
	}


	@Override
	public List<ITeilreservierung> getTeilreservierungen() {
		if(reservierungModel!=null)
			return new Vector<ITeilreservierung>(reservierungModel.getTeilreservierungen());
			return null;
	}

	@Override
	public void setVon(Date date) {
		if(reservierungModel!=null)
		{
			reservierungModel.setVon(date);
		}
		
	}

	@Override
	public void setBis(Date date) {
		if(reservierungModel!=null)
		{
			reservierungModel.setBis(date);
		}
	}


	@Override
	public List<IGast> getGaeste() {
		if(reservierungModel!=null)
		{
			List<IGast> list=new Vector<IGast>(reservierungModel.getGaeste());
			return list;
		}
		else {
			//TODO Exeption
			return null;
		}
	}
	
	@Override
	public boolean containsGast(IGast gast) {
		if(reservierungen.contains(gast))
			return true;
		else
		return false;
	}

	
	
	
	
	
	
}
