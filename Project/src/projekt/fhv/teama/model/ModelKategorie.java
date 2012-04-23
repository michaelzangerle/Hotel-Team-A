package projekt.fhv.teama.model;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.hibernate.dao.zimmer.IKategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;
import projekt.fhv.teama.model.interfaces.IModelKategorie;


public class ModelKategorie implements IModelKategorie {

	private IKategorie kategorieModel;
	private IKategorieDao kategorieDao;
	

	public ModelKategorie() {

		kategorieDao=KategorieDao.getInstance();
	}


	@Override
	public IKategorie getKategorie() {
		if(kategorieModel!=null)
		{
			return kategorieModel;
		}
		//TODO Error
		return null;
	}


	@Override
	public void setKategorie(IKategorie kategorie) {
		kategorieModel=kategorie;
		
	}

}
