package projekt.fhv.teama.controller;

import java.sql.Date;

import projekt.fhv.teama.classes.Aufenthalt;
import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.interfaces.IControllerAufenthalt;
import projekt.fhv.teama.hibernate.dao.AufenthaltDao;
import projekt.fhv.teama.hibernate.dao.IAufenthaltDao;

public class ControllerAufenthalt implements IControllerAufenthalt {

	IAufenthalt aufenthaltModel;
	IAufenthaltDao aufenthaltDao;
	
	public ControllerAufenthalt() {
		aufenthaltDao=AufenthaltDao.getInstance();
	}
	

	public void create(float preis, Date von, Date bis, boolean schluessel, IGast gast, IZimmer zimmer,IPfandtyp pfand,String pfandNr)
	{
		aufenthaltModel=new Aufenthalt(preis, pfandNr, von, bis, schluessel, gast, zimmer, pfand);
		aufenthaltDao.create(aufenthaltModel);
	}
	

	



}
