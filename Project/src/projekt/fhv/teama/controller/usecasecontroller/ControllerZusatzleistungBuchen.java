package projekt.fhv.teama.controller.usecasecontroller;

import java.util.List;
import java.util.Vector;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.MyLittleDate;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.interfaces.IModelAufenthalt;
import projekt.fhv.teama.model.interfaces.IModelGast;
import projekt.fhv.teama.model.interfaces.IModelLand;

public class ControllerZusatzleistungBuchen {
	
	//ModelRespositorys
	private IModelAufenthalt modelAufenthalt;
	private IModelGast modelGast;
	
	
	
	private List<IAufenthalt> aufenthalte=new Vector<IAufenthalt>();
	

	public List<IAufenthalt> getAufenthalte() throws DatabaseException
	{
		if(aufenthalte.size()>0)
			return aufenthalte;
		else
		{
			aufenthalte=modelAufenthalt.getAufenthalte(MyLittleDate.getDate(2012, 3, 25));
			return aufenthalte;
		}
	}
	
	
	public List<IGast> getGaesteVonAuftenhalten() throws DatabaseException
	{
		if(aufenthalte.size()<1)
		{
			aufenthalte.clear();
			getAufenthalte();
		}
		List<IGast> gaeste=new Vector<IGast>();
		for (IAufenthalt aufenthalt : aufenthalte) {
			if(!gaeste.contains(aufenthalt.getGast())&&aufenthalt.getGast()!=null)
					gaeste.add(aufenthalt.getGast());
		}
			return gaeste;
			
	}
	
	
	public List<IGast> getGaesteZumAufenhalt() throws FokusException
	{
		return modelAufenthalt.getGaesteZumAufenhalt();
	}
	
	public void setAufenthalt(IAufenthalt aufenhalt) throws EmptyParameterException
	{
		modelAufenthalt.setAufenthalt(aufenhalt);
	}
	
	public IAufenthalt getAufenthalt() throws FokusException
	{
		return modelAufenthalt.getAufenthalt();
	}
	
	public void setGast(IGast gast) {
		modelGast.setAktuellGast(gast);
	}

	public IGast getGast() throws FokusException {
		return modelGast.getAktuellGast();
	}
	
	public List<IZimmer> getZimmerVonGast() throws FokusException, DatabaseException
	{
		List<IZimmer> zimmers=new Vector<IZimmer>();
		if(aufenthalte.size()<0)
			getAufenthalte();
		
		for (IAufenthalt aufenthalt : aufenthalte) {
			if(aufenthalt.getGast().equals(getGast())&&aufenthalt.getZimmer()!=null)
				zimmers.add(aufenthalt.getZimmer());
		}
		
		return zimmers;
	}
	
	public IGast getGastByNummer(String nummer) throws DatabaseException, EmptyParameterException, NotContainExeption
	{
		if(nummer==null)
			throw new EmptyParameterException();
		
		if(aufenthalte.size()<0)
			getAufenthalte();
		
		for (IAufenthalt aufenthalt : aufenthalte) {
			if(aufenthalt.getGast().getNummer().equals(nummer))
				return aufenthalt.getGast();
		}
		
		throw new NotContainExeption();
		
	}
	
	

}
