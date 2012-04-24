package projekt.fhv.teama.model;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.Aufenthalt;
import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.dao.AufenthaltDao;
import projekt.fhv.teama.hibernate.dao.IAufenthaltDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.interfaces.IModelAufenthalt;

/**
 * Model f�r den Umgang mit einem Aufenthalt
 * @author Team-A
 * @version 1.5
 */
public class ModelAufenthalt implements IModelAufenthalt {

	IAufenthalt aufenthaltModel;
	IAufenthaltDao aufenthaltDao;
	
	public ModelAufenthalt() {
		aufenthaltDao=AufenthaltDao.getInstance();
	}
	

	public void create(float preis, Date von, Date bis, boolean schluessel, IGast gast, IZimmer zimmer,IPfandtyp pfand,String pfandNr) throws DatabaseException, EmptyParameterException
	{
		if(von!=null&&bis!=null&&gast!=null&&zimmer!=null&&pfand!=null&&pfandNr!=null)
		{
		aufenthaltModel=new Aufenthalt(preis, pfandNr, von, bis, schluessel, gast, zimmer, pfand);
		try {
			aufenthaltDao.create(aufenthaltModel);
		} catch (DatabaseException e) {
			throw new DatabaseException();
		}
		}
		else
			throw new EmptyParameterException();
	}


	@Override
	public List<IAufenthalt> getAufenthalte(Date date) throws DatabaseException,EmptyParameterException {
		if(date!=null)
		{
			List<IAufenthalt> currentAufenthalte=new Vector<IAufenthalt>();
			List<IAufenthalt> alleAufenthalte=new Vector<IAufenthalt>(aufenthaltDao.getAll());
			for (IAufenthalt auf : alleAufenthalte) {
				if((auf.getVon().before(date)||auf.getVon().equals(date))&&(auf.getBis().after(date)||auf.getBis().equals(date)))
				{
					currentAufenthalte.add(auf);
				}
			}
			return currentAufenthalte;
		}
		else {
			throw new EmptyParameterException();
		}
	}
	

	



}
