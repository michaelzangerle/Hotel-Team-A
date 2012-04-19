package projekt.fhv.teama.controller;

import java.util.List;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.controller.interfaces.IControllerKategorie;
import projekt.fhv.teama.hibernate.dao.zimmer.IKategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;


public class ControllerKategorie implements IControllerKategorie {

	private IKategorie kategorieModel;
	private IKategorieDao kategorieDao;
	

	public ControllerKategorie() {

		kategorieDao=KategorieDao.getInstance();
	}


	@Override
	public IKategorie getKategorie() {
		if(kategorieModel!=null)
		{
			return kategorieModel;
		}
	}


	@Override
	public void setKategorie(IKategorie kategorie) {
		kategorieModel=kategorie;
		
	}

}
