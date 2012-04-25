package projekt.fhv.teama.model;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.hibernate.dao.zimmer.IKategorieDao;
import projekt.fhv.teama.hibernate.dao.zimmer.KategorieDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.interfaces.IModelKategorie;

/**
 * Model für den Umgang mit einer Kategorie
 * @author Team-A
 * @version 1.5
 */
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


	@Override
	public List<IKategorie> getKategorieen() throws DatabaseException {
		return new Vector<IKategorie>(kategorieDao.getAll());
	}

}
