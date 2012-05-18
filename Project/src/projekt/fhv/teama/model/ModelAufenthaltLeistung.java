package projekt.fhv.teama.model;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import projekt.fhv.teama.classes.AufenthaltLeistung;
import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.IAufenthaltLeistung;
import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.controller.usecasecontroller.LeistungAnzahl;
import projekt.fhv.teama.hibernate.dao.AufenthaltLeistungDao;
import projekt.fhv.teama.hibernate.dao.IAufenthaltLeistungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAAufenthalt;
import projekt.fhv.teama.integrate.IALeistung;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.WrongParameterException;
import projekt.fhv.teama.model.interfaces.IModelAufenhaltLeistung;

public class ModelAufenthaltLeistung implements IModelAufenhaltLeistung {

	IAufenthaltLeistungDao aufenthaltLeistungDao;
	private List<IAufenthaltLeistung> list = new Vector<IAufenthaltLeistung>();

	public ModelAufenthaltLeistung() {

		aufenthaltLeistungDao = AufenthaltLeistungDao.getInstance();
	}

	@Override
	public void save(ILeistung leistung, IAufenthalt aufenthalt, int anzahl, Date datum)
			throws WrongParameterException, DatabaseException {
		if (leistung == null || aufenthalt == null || anzahl <= 0 || datum == null)
			throw new WrongParameterException();

		IAufenthaltLeistung aLeistung = new AufenthaltLeistung(leistung, aufenthalt, anzahl, datum);

		aufenthaltLeistungDao.create(aLeistung);
	}

	@Override
	public List<LeistungAnzahl> getLeistungenByAufenhalt(IAufenthalt auf) throws DatabaseException {

		List<LeistungAnzahl> erg = new Vector<LeistungAnzahl>();

		list = new Vector<IAufenthaltLeistung>(aufenthaltLeistungDao.getAll());

		for (IAufenthaltLeistung auflei : list) {
			if (auflei.getAufenthalt().getID() == auf.getID())
				erg.add(new LeistungAnzahl(auflei.getLeistung(), auflei.getAnzahl()));
		}

		return erg;

	}

	@Override
	public void save(IALeistung leistung, IAAufenthalt aufenthalt, int anzahl, Date datum)
			throws WrongParameterException, DatabaseException {
		if (leistung == null || aufenthalt == null || anzahl <= 0 || datum == null)
			throw new WrongParameterException();

		IAufenthaltLeistung aLeistung = new AufenthaltLeistung((ILeistung) leistung, (IAufenthalt) aufenthalt, anzahl,
				datum);

		aufenthaltLeistungDao.create(aLeistung);

	}

	@Override
	public List<LeistungAnzahl> getLeistungenByAufenhalt(IAAufenthalt auf) throws DatabaseException {
		List<LeistungAnzahl> erg = new Vector<LeistungAnzahl>();

		list = new Vector<IAufenthaltLeistung>(aufenthaltLeistungDao.getAll());

		for (IAufenthaltLeistung auflei : list) {
			if (auflei.getAufenthalt().getID() == auf.getID())
				erg.add(new LeistungAnzahl(auflei.getLeistung(), auflei.getAnzahl()));
		}

		return erg;

	}

}
