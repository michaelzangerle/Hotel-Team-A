package projekt.fhv.teama.model;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAZimmer;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.interfaces.IModelZimmer;
/**
 * Model für den Umgang mit einem Zimmer
 * @author Team-A
 * @version 1.5
 */
public class ModelZimmer implements IModelZimmer {

	IZimmer zimmerModel;
	IZimmerDao zimmerDao;
	IAZimmer zimmerModelA;

	public ModelZimmer() {
		zimmerDao = ZimmerDao.getInstance();
	}

	@Override
	public List<IZimmer> getVerfuegbareZimmerFürGegebeneKategorie(
			IKategorie ausgewählteKategorie, IReservierung aktulleReservierung)
			throws DatabaseException {

		List<IZimmer> verfügbare = new Vector<IZimmer>();
		List<IZimmer> alle = null;
		try {
			alle = new Vector<IZimmer>(zimmerDao.getAll());

		} catch (DatabaseException e) {
			throw new DatabaseException();
		}

		for (IZimmer zi : alle) {
			if (zi.getKategorie().equals(ausgewählteKategorie)
					&& zi.getZimmerstatus().getKuerzel().equals("FG")) {
				List<IReservierung> zimmerreserierungen = new Vector<IReservierung>(
						zi.getReservierungen());
				if (zimmerreserierungen.size() > 0) {
					for (IReservierung res : zimmerreserierungen) {
						if (res.getVon().after(aktulleReservierung.getBis())
								|| res.getBis().before(
										aktulleReservierung.getVon()))
							verfügbare.add(zi);
					}
				} else {
					verfügbare.add(zi);
				}

			}
		}
		return verfügbare;

	}

	@Override
	public void save(IZimmer zimmer) throws DatabaseException, EmptyParameterException {
		if (zimmer != null)
			try {
				zimmerDao.create(zimmer);
			} catch (DatabaseException e) {
				throw new DatabaseException();
			}
		else
			throw new EmptyParameterException();

	}

	@Override
	public List<IZimmer> getVerfügbareZimmer(IReservierung aktulleReservierung) throws DatabaseException {

		List<IZimmer> verfügbare = new Vector<IZimmer>();
		List<IZimmer> alle = null;
		try {
			alle = new Vector<IZimmer>(zimmerDao.getAll());
		} catch (DatabaseException e) {
			throw new DatabaseException();
		}

		for (IZimmer zi : alle) {
			if (zi.getZimmerstatus().getKuerzel().equals("FG")) {
				List<IReservierung> zimmerreserierungen = new Vector<IReservierung>(
						zi.getReservierungen());
				if (zimmerreserierungen.size() > 0) {
					for (IReservierung res : zimmerreserierungen) {
						if (res.getVon().after(aktulleReservierung.getBis())
								|| res.getBis().before(
										aktulleReservierung.getVon()))
							verfügbare.add(zi);
					}
				} else {
					verfügbare.add(zi);
				}

			}
		}
		return verfügbare;
	}

	@Override
	public void setStatus(IZimmerstatus status) throws EmptyParameterException {
		if (status != null) {
			zimmerModel.setZimmerstatus(status);
		}
		else
			throw new EmptyParameterException();

	}

	@Override
	public void setAktullesZimmer(IZimmer zimmer) throws EmptyParameterException {
		if(zimmer!=null)
		zimmerModel = zimmer;
		else {
			throw new EmptyParameterException();
		}

	}

	@Override
	public IZimmer getAktullesZimmer() throws FokusException {
		if(zimmerModel!=null)
		return zimmerModel;
		else {
			throw new FokusException();
		}
		}

	
	@Override
	public void setAktullesZimmer(IAZimmer zimmer) {
		this.zimmerModel = (IZimmer) zimmer;
	}

	@Override
	public IAZimmer getAAktullesZimmer() throws FokusException {
		return (IAZimmer) this.getAktullesZimmer();
	}
	
	public List<IZimmer> getVerfügbareZimmer(IKategorie kategorie,Date von,Date bis) throws DatabaseException
	{
		List<IZimmer> verfügbare = new Vector<IZimmer>();
		List<IZimmer> alle = null;
		try {
			alle = new Vector<IZimmer>(zimmerDao.getAll());

		} catch (DatabaseException e) {
			throw new DatabaseException();
		}

		for (IZimmer zi : alle) {
			if (zi.getKategorie().equals(kategorie)
					&& zi.getZimmerstatus().getKuerzel().equals("FG")) {
				List<IReservierung> zimmerreserierungen = new Vector<IReservierung>(
						zi.getReservierungen());
				if (zimmerreserierungen.size() > 0) {
					for (IReservierung res : zimmerreserierungen) {
						if (res.getVon().after(bis)
								|| res.getBis().before(
										von))
							verfügbare.add(zi);
					}
				} else {
					verfügbare.add(zi);
				}

			}
		}
		return verfügbare;
	}



}
