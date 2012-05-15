package projekt.fhv.teama.model;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.hibernate.dao.leistungen.ILeistungDao;
import projekt.fhv.teama.hibernate.dao.leistungen.LeistungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.interfaces.IModelLeistung;



public class ModelLeistung implements IModelLeistung{

	private ILeistung modelLeistung;
	private ILeistungDao leistungDao;
	
	public ModelLeistung() {
		leistungDao=LeistungDao.getInstance();
	}
	
	
	public List<ILeistung> getLeistungen() throws DatabaseException
	{
		return new Vector<ILeistung>(leistungDao.getAll());
	}



}
