package projekt.fhv.teama.model;

import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.hibernate.dao.personen.ILandDao;
import projekt.fhv.teama.hibernate.dao.personen.LandDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.interfaces.IModelLand;



public class ModelLand implements IModelLand {

	private ILand landModel;
	private ILandDao landDao;
	
	public ModelLand() {
		landDao=LandDao.getInstance();
	}

	@Override
	public ILand getLandByKuerzel(String kuerzel) throws DatabaseException {
		if(kuerzel!=null)
		{
			ILand land=landDao.getLandByKuerzel(kuerzel);
			if(land!=null)
				return land;
			else
				return null;
		}
		else
		{
			//TODO Fehlermeldung
			return null;
		}
	}
	
	
}
