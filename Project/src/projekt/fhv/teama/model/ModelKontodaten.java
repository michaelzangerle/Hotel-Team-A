package projekt.fhv.teama.model;

import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.hibernate.dao.personen.IKontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.KontodatenDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.interfaces.IModelKontodaten;



public class ModelKontodaten implements IModelKontodaten {

	
	IKontodaten kontodatenModel;
	IKontodatenDao kontodatenDao;
	
	public ModelKontodaten() {
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
