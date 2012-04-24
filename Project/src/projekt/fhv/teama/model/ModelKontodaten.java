package projekt.fhv.teama.model;

import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.hibernate.dao.personen.IKontodatenDao;
import projekt.fhv.teama.hibernate.dao.personen.KontodatenDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.interfaces.IModelKontodaten;


/**
 * Model für den Umgang mit Kontodaten
 * @author Team-A
 * @version 1.5
 */
public class ModelKontodaten implements IModelKontodaten {

	
	IKontodaten kontodatenModel;
	IKontodatenDao kontodatenDao;
	
	public ModelKontodaten() {
		kontodatenDao=KontodatenDao.getInstance();
	}
	
	
	public void save(IKontodaten kontodaten) throws DatabaseException, EmptyParameterException
	{
		if(kontodaten!=null)
		{
			try {
				kontodatenDao.create(kontodaten);
			} catch (DatabaseException e) {
			throw new DatabaseException();
			}
	}
		else
			throw new EmptyParameterException();
	}
}
