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
import projekt.fhv.teama.integrate.IAAufenthalt;
import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.integrate.IAPfandtyp;
import projekt.fhv.teama.integrate.IAZimmer;
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
	

	public void create(float preis, Date von, Date bis, boolean schluessel, IAGast gast, IAZimmer zimmer,IAPfandtyp pfand,String pfandNr) throws DatabaseException, EmptyParameterException
	{
		if(von!=null&&bis!=null&&gast!=null&&zimmer!=null&&pfand!=null&&pfandNr!=null)
		{
		aufenthaltModel=new Aufenthalt(preis, pfandNr, von, bis, schluessel,(IGast) gast, (IZimmer)zimmer, (IPfandtyp)pfand);
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
	public List<IAAufenthalt> getAufenthalte(Date date) throws DatabaseException {
		if(date!=null)
		{
			List<IAAufenthalt> currentAufenthalte=new Vector<IAAufenthalt>();
			List<IAAufenthalt> alleAufenthalte=new Vector<IAAufenthalt>(aufenthaltDao.getAll());
			for (IAAufenthalt auf : alleAufenthalte) {
				if((auf.getAVon().before(date)||auf.getAVon().equals(date))&&(auf.getABis().after(date)||auf.getABis().equals(date)))
				{
					currentAufenthalte.add(auf);
				}
			}
			return currentAufenthalte;
		}
		return null;
	}
	
	
	public List<IAGast> getGaesteZumAufenhalt() throws FokusException
	{
		if(aufenthaltModel!=null)
		{
			List<IAGast> gaeste=new Vector<IAGast>();
				if(!gaeste.contains(aufenthaltModel.getGast())&&aufenthaltModel.getGast()!=null)
						gaeste.add(aufenthaltModel.getGast());
			
				return gaeste;
		}
		throw new FokusException();
	}


	@Override
	public void setAufenthalt(IAAufenthalt aufenhalt) throws EmptyParameterException {
		if(aufenhalt!=null)
		aufenthaltModel=(IAufenthalt)aufenhalt;
		else
			throw new EmptyParameterException();
	}


	@Override
	public IAAufenthalt getAufenthalt() throws FokusException {
		if(aufenthaltModel!=null)
			return aufenthaltModel;
		else
			throw new FokusException();
	}



	



}
