package projekt.fhv.teama.controller;

import java.util.List;

import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.controller.interfaces.IControllerTeilreservierung;
import projekt.fhv.teama.hibernate.dao.zimmer.ITeilreservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.TeilreservierungDao;



public class ControllerTeilreservierung implements IControllerTeilreservierung {
	
	private ITeilreservierung teilreservierungModel;
	private ITeilreservierungDao teilreservierungsDao;
	

	public ControllerTeilreservierung() {

		teilreservierungsDao=TeilreservierungDao.getInstance();
	}
	
	public void setAktulleTeilreservierung(ITeilreservierung teilreservierung)
	{
		teilreservierungModel=teilreservierung;
	}
	
	public ITeilreservierung getAktuelleTeilreservierung()
	{
		return teilreservierungModel;
	}



}
