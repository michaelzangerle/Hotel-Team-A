package projekt.fhv.teama.model;


import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.hibernate.dao.IPfandtypDao;
import projekt.fhv.teama.hibernate.dao.PfandtypDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.interfaces.IModelPfandTyp;


public class ModelPfandTyp implements IModelPfandTyp {
	
	private IPfandtyp pfandModel;
	private IPfandtypDao pfandDao;
	
	public ModelPfandTyp() {
		pfandDao=PfandtypDao.getInstance();
	}
	
	

	@Override
	public List<IPfandtyp> getPfandtyps() throws DatabaseException {
		
		return new Vector<IPfandtyp>(pfandDao.getAll());
	}



	@Override
	public void setAktuellerPfandTyp(IPfandtyp pfandtyp) {
		
		pfandModel=pfandtyp;
	}



	@Override
	public IPfandtyp getAktuellerPFandtyp() {
		if(pfandModel!=null)
			return pfandModel;
		return null;
	}

	
}
