package projekt.fhv.teama.model;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ReservierungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.WrongParameterException;
import projekt.fhv.teama.model.interfaces.IModelReservierung;
/**
 * Model für den Umgang mit einer Reservierung
 * 
 * @author Team-A
 * @version 1.5
 */
public class ModelReservierung implements IModelReservierung {

	private IReservierung reservierungModel;
	private IReservierungDao reservierungsDao;

	private List<IReservierung> reservierungen=new Vector<IReservierung>();
	private boolean benoetigtNeuLadungReservierung = true;
	
	private List<IReservierung> checkInReservierungen=new Vector<IReservierung>();
	private boolean benoetigtNeuLadungCheckReservierung = true;

	public ModelReservierung() {

		reservierungsDao = ReservierungDao.getInstance();
	}

	@Override
	public List<IReservierung> getAllReservierungen() throws DatabaseException {

		if (benoetigtNeuLadungReservierung == false) {
			return reservierungen;
		} else {
			reservierungen = getAllReservierungDatabase();
			benoetigtNeuLadungReservierung=false;
			return reservierungen;
		}

	}

	private List<IReservierung> getAllReservierungDatabase()
			throws DatabaseException {
		List<IReservierung> resDatabase = new Vector<IReservierung>(
				reservierungsDao.getAll());
		List<IReservierung> alleNichtBearbeiteten = new Vector<IReservierung>();
		for (IReservierung res : resDatabase) {
			if (!res.getBearbeitet()) {
				alleNichtBearbeiteten.add(res);
			}
		}

		return alleNichtBearbeiteten;

	}
	


	public void setAktuelleReservierung(IReservierung reservierung) {
		reservierungModel = reservierung;

	}
	public IReservierung getAktuelleReservierung() throws FokusException {
		if (reservierungModel == null)
			throw new FokusException();

		return reservierungModel;
	}

	@Override
	public List<ITeilreservierung> getTeilreservierungen()
			throws FokusException {
		if (reservierungModel != null)
			return new Vector<ITeilreservierung>(
					reservierungModel.getTeilreservierungen());
		else {
			throw new FokusException();
		}
	}

	@Override
	public void setVon(Date date) {
		if (reservierungModel != null) {
			reservierungModel.setVon(date);
		}

	}

	@Override
	public void setBis(Date date) {
		if (reservierungModel != null) {
			reservierungModel.setBis(date);
		}
	}

	@Override
	public List<IGast> getGaeste() throws FokusException {
		if (reservierungModel != null) {
			List<IGast> list = new Vector<IGast>(reservierungModel.getGaeste());
			return list;
		} else {
			throw new FokusException();
		}
	}

	@Override
	public boolean containsGast(IGast gast) {
		if (reservierungen.contains(gast))
			return true;
		else
			return false;
	}

	public void save(IReservierung r) throws DatabaseException,
			EmptyParameterException {
		if (r != null)
			reservierungsDao.create(r);
		else
			throw new EmptyParameterException();
	}

	@Override
	public List<IReservierung> getCheckInReservierungen(Date date) throws DatabaseException {

			if(benoetigtNeuLadungCheckReservierung==false)
			{
				return checkInReservierungen;
			}
			else
			{
				checkInReservierungen=getCheckInReservierungenDatabase(date);
				benoetigtNeuLadungCheckReservierung=false;
				return checkInReservierungen;
			}

	}
	
	private List<IReservierung> getCheckInReservierungenDatabase(Date date)
			throws DatabaseException {

		List<IReservierung> reservierungen = new Vector<IReservierung>(
				reservierungsDao.getAll());
		List<IReservierung> alleCheckIn = new Vector<IReservierung>();
		for (IReservierung res : reservierungen) {
			if (!res.getBearbeitet() && res.getVon().toString().equals(date.toString())) {
				alleCheckIn.add(res);
			}
		}

		return alleCheckIn;

	}

	@Override
	public void setBearbeitet(boolean b) throws WrongParameterException {
		if (b == true || b == false) {
			reservierungModel.setBearbeitet(b);
			benoetigtNeuLadungReservierung=true;
			benoetigtNeuLadungCheckReservierung=true;
		} else
			throw new WrongParameterException();

	}

}
