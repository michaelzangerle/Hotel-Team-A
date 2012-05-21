package projekt.fhv.teama.model;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.rechnung.IRechnungsposition;
import projekt.fhv.teama.hibernate.dao.rechnung.IRechnungspositionDao;
import projekt.fhv.teama.hibernate.dao.rechnung.RechnungspositionDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.integrate.IARechnungsposition;
import projekt.fhv.teama.model.interfaces.IModelRechnungspositon;



public class ModelRechnungsposition implements IModelRechnungspositon {
	
	private IRechnungsposition rechnungspositionModel;
	private IRechnungspositionDao rechnungspositionDao;
	
	public ModelRechnungsposition() {
		rechnungspositionDao=RechnungspositionDao.getInstance();
	}

	@Override
	public boolean sindNochPostionenoffen(IAGast gast) throws DatabaseException {
		
		List<IARechnungsposition> list=new Vector<IARechnungsposition>(rechnungspositionDao.getAll());
		for (IARechnungsposition pos : list) {
			if(pos.getGast().equals(gast)&&pos.getBeglichen()==false)
				return true;
		}
		
		return false;
		
		
	}
	
	

}
