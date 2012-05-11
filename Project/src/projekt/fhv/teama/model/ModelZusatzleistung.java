package projekt.fhv.teama.model;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.classes.leistungen.IZusatzleistung;
import projekt.fhv.teama.hibernate.dao.leistungen.IZusatzleistungDao;
import projekt.fhv.teama.hibernate.dao.leistungen.ZusatzleistungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.interfaces.IModelZusatzleistung;



public class ModelZusatzleistung implements IModelZusatzleistung{

	IZusatzleistung modelZusatzleistung;
	IZusatzleistungDao zusatzleistungDao;
	
	public ModelZusatzleistung() {
		zusatzleistungDao=ZusatzleistungDao.getInstance();
	}
	
	public List<ILeistung> getZusatzleistungen() throws DatabaseException
	{
		return new Vector<ILeistung>(zusatzleistungDao.getAll());
	}
}
