package projekt.fhv.teama.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IStatusentwicklung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.classes.zimmer.Statusentwicklung;
import projekt.fhv.teama.hibernate.dao.zimmer.IStatusentwicklungDao;
import projekt.fhv.teama.hibernate.dao.zimmer.StatusentwicklungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.interfaces.IModelStatusentwicklung;

public class ModelStatusentwicklung implements IModelStatusentwicklung {

	private IStatusentwicklung statusentwicklungModel;
	private IStatusentwicklungDao statusentwicklungDao;

	public ModelStatusentwicklung() {

		statusentwicklungDao = StatusentwicklungDao.getInstance();
	}

	@Override
	public void add(IZimmer aktullesZimmer, IZimmerstatus b,
			IReservierung aktulleReservierung) throws DatabaseException {
		if (aktullesZimmer != null && aktulleReservierung != null && b!=null) {
			IStatusentwicklung s = new Statusentwicklung(aktullesZimmer, b,
					aktulleReservierung.getVon(), aktulleReservierung.getBis(),
					"");
			statusentwicklungDao.create(s);
			aktullesZimmer.addStatusentwicklung(s);
			
		}

	}

	@Override
	public void save(IStatusentwicklung statusentwicklung)
			throws DatabaseException {
		if (statusentwicklung != null)
			statusentwicklungDao.create(statusentwicklung);

	}

}
