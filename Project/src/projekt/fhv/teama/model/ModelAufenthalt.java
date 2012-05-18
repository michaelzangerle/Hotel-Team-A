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
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.interfaces.IModelAufenthalt;

/**
 * Model für den Umgang mit einem Aufenthalt
 * @author Team-A
 * @version 1.5
 */
public class ModelAufenthalt implements IModelAufenthalt {

	IAufenthalt aufenthaltModel;
	IAufenthaltDao aufenthaltDao;
	
	public ModelAufenthalt() {
		aufenthaltDao=AufenthaltDao.getInstance();
		//Test
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
	public List<IAufenthalt> getAufenthalte(Date date) throws DatabaseException {
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
		return null;
	}
	
	
	public List<IGast> getGaesteZumAufenhalt() throws FokusException
	{
		if(aufenthaltModel!=null)
		{
			List<IGast> gaeste=new Vector<IGast>();
				if(!gaeste.contains(aufenthaltModel.getGast())&&aufenthaltModel.getGast()!=null)
						gaeste.add(aufenthaltModel.getGast());
			
				return gaeste;
		}
		throw new FokusException();
	}


	@Override
	public void setAufenthalt(IAufenthalt aufenhalt) throws EmptyParameterException {
		if(aufenhalt!=null)
		aufenthaltModel=aufenhalt;
		else
			throw new EmptyParameterException();
	}


	@Override
	public IAufenthalt getAufenthalt() throws FokusException {
		if(aufenthaltModel!=null)
			return aufenthaltModel;
		else
			throw new FokusException();
	}

	



}
