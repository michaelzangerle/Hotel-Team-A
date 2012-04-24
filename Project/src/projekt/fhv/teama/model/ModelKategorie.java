package projekt.fhv.teama.model;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.hibernate.dao.zimmer.IKategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.interfaces.IModelKategorie;


public class ModelKategorie implements IModelKategorie {

	private IKategorie kategorieModel;
	private IKategorieDao kategorieDao;
	

	public ModelKategorie() {

		kategorieDao=KategorieDao.getInstance();
	}


	@Override
	public IKategorie getKategorie() throws FokusException {
		if(kategorieModel!=null)
		{
			return kategorieModel;
		}
		else
		throw new FokusException();
	}


	@Override
	public void setKategorie(IKategorie kategorie) {
		kategorieModel=kategorie;
		
	}

}
