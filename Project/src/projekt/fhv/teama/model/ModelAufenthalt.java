package projekt.fhv.teama.model;

import java.sql.Date;

import projekt.fhv.teama.classes.Aufenthalt;
import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.dao.AufenthaltDao;
import projekt.fhv.teama.hibernate.dao.IAufenthaltDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.interfaces.IModelAufenthalt;

public class ModelAufenthalt implements IModelAufenthalt {

	IAufenthalt aufenthaltModel;
	IAufenthaltDao aufenthaltDao;
	
	public ModelAufenthalt() {
		aufenthaltDao=AufenthaltDao.getInstance();
	}
	

	public void create(float preis, Date von, Date bis, boolean schluessel, IGast gast, IZimmer zimmer,IPfandtyp pfand,String pfandNr)
	{
		aufenthaltModel=new Aufenthalt(preis, pfandNr, von, bis, schluessel, gast, zimmer, pfand);
		try {
			aufenthaltDao.create(aufenthaltModel);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	



}
