package projekt.fhv.teama.model;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerStatusDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerstatusDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.interfaces.IModelZimmerstatus;

/**
 * Model für den Umgang mit einem Zimmerstatus
 * @author Team-A
 * @version 1.5
 */
public class ModelZimmerstatus implements IModelZimmerstatus{

	IZimmerstatus zimmerModel;
	IZimmerStatusDao zimmerDao;
	
	public ModelZimmerstatus() {
	zimmerDao=ZimmerstatusDao.getInstance();

	}
	
	@Override
	public IZimmerstatus getStatusByKuerzel(String string) throws DatabaseException, NotContainExeption {
		
		List<IZimmerstatus> statis=new Vector<IZimmerstatus>(zimmerDao.getAll());
		for (IZimmerstatus status : statis) {
			if(status.getKuerzel().equals(string))
			return status;
		}
		throw new NotContainExeption();
	}

	
}
