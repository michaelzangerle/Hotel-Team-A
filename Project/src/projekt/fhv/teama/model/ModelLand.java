package projekt.fhv.teama.model;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.hibernate.dao.personen.ILandDao;
import projekt.fhv.teama.hibernate.dao.personen.LandDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.interfaces.IModelLand;


/**
 * Model für den Umgang mit einem Land
 * @author Team-A
 * @version 1.5
 */
public class ModelLand implements IModelLand {

	private ILand landModel;
	private ILandDao landDao;
	
	public ModelLand() {
		landDao=LandDao.getInstance();
	}

	@Override
	public ILand getLandByKuerzel(String kuerzel) throws DatabaseException, EmptyParameterException,NotContainExeption {
		if(kuerzel!=null)
		{
			ILand land=landDao.getLandByKuerzel(kuerzel);
			if(land!=null)
				return land;
			else
				throw new NotContainExeption();
		}
		else
		{
			throw new EmptyParameterException();
		}
	}

	@Override
	public ILand getLandByBezeichnung(String bezeichnung) throws DatabaseException,NotContainExeption,EmptyParameterException{
		if(bezeichnung!=null)
		{
			ILand land=landDao.getLandByBez(bezeichnung);
			if(land!=null)
				return land;
			else
				throw new NotContainExeption();
		}
		else
		{
			throw new EmptyParameterException();
		}
	}

	@Override
	public List<ILand> getLaender() throws DatabaseException {
		return new Vector<ILand>(landDao.getAll());
	}
	
	
	
}
