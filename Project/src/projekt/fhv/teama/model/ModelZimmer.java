package projekt.fhv.teama.model;

import java.awt.image.RescaleOp;
import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IStatusentwicklung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.classes.zimmer.Zimmerstatus;
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerDao;
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerStatusDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerstatusDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.interfaces.IModelZimmer;
import projekt.fhv.teama.model.interfaces.IModelZimmerstatus;

public class ModelZimmer implements IModelZimmer {

	IZimmer zimmerModel;
	IZimmerDao zimmerDao;

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
	public List<IZimmer> getVerfügbareZimmer() throws DatabaseException {

		List<IZimmer> verfügbare = new Vector<IZimmer>();
		List<IZimmer> alle = null;
		try {
			alle = new Vector<IZimmer>(zimmerDao.getAll());
		} catch (DatabaseException e) {
			throw new DatabaseException();
		}

		for (IZimmer zi : alle) {
			if (zi.getZimmerstatus().getKuerzel().equals("fuck")) {
				verfügbare.add(zi);
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

}
