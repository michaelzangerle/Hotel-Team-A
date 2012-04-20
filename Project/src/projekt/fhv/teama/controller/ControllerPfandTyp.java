package projekt.fhv.teama.controller;


import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.controller.interfaces.IControllerPfandTyp;
import projekt.fhv.teama.hibernate.dao.IPfandtypDao;
import projekt.fhv.teama.hibernate.dao.PfandtypDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;


public class ControllerPfandTyp implements IControllerPfandTyp {
	
	private IPfandtyp pfandModel;
	private IPfandtypDao pfandDao;
	
	public ControllerPfandTyp() {
		pfandDao=PfandtypDao.getInstance();
	}
	
	

	@Override
	public List<IPfandtyp> getPfandtyps() throws NoDatabaseEntryFoundException {
		
		return new Vector<IPfandtyp>(pfandDao.getAll());
	}

	
}
