package projekt.fhv.teama.model;

import java.sql.Date;

import projekt.fhv.teama.classes.AufenthaltLeistung;
import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.IAufenthaltLeistung;
import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.hibernate.dao.AufenthaltLeistungDao;
import projekt.fhv.teama.hibernate.dao.IAufenthaltLeistungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.WrongParameterException;


public class ModelAufenthaltLeistung {
	
	IAufenthaltLeistungDao aufenthaltLeistungDao;
	
	public ModelAufenthaltLeistung() {
		
		aufenthaltLeistungDao=AufenthaltLeistungDao.getInstance();
	}
	
	public void save(ILeistung leistung,IAufenthalt aufenthalt, int anzahl,Date datum) throws WrongParameterException, DatabaseException
	{
		if(leistung==null || aufenthalt==null || anzahl<=0 || datum==null)
			throw new WrongParameterException();
		
		IAufenthaltLeistung aLeistung=new AufenthaltLeistung(leistung, aufenthalt, anzahl, datum);
		
		aufenthaltLeistungDao.create(aLeistung);
	}
	
}
