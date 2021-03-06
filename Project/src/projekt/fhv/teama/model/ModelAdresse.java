package projekt.fhv.teama.model;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.hibernate.dao.personen.AdresseDao;
import projekt.fhv.teama.hibernate.dao.personen.IAdresseDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.interfaces.IModelAdresse;


/**
 * Model f�r den Umgang mit einer Adresse
 * @author Team-A
 * @version 1.5
 */
public class ModelAdresse implements IModelAdresse {


	IAdresse adressModel;
	IAdresseDao adressDao;
	
	public ModelAdresse() {
		adressDao=AdresseDao.getInstance();
	}
	
	@Override
	public void save(IAdresse adr) throws DatabaseException {
		if(adr!=null)
			try {
				adressDao.create(adr);
			} catch (DatabaseException e) {
				throw new DatabaseException();
			}
		
	}

}
