package projekt.fhv.teama.model;

import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.hibernate.dao.zimmer.ITeilreservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.TeilreservierungDao;
import projekt.fhv.teama.model.interfaces.IModelTeilreservierung;

/**
 * Model für den Umgang mit einer Teilreservierung
 * @author Team-A
 * @version 1.5
 */
public class ModelTeilreservierung implements IModelTeilreservierung {
	
	private ITeilreservierung teilreservierungModel;
	private ITeilreservierungDao teilreservierungsDao;
	

	public ModelTeilreservierung() {

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
