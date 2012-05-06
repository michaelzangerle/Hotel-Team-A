package projekt.fhv.teama.controller.usecasecontroller;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.MyLittleDate;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.interfaces.IModelAufenthalt;

public class ControllerZusatzleistungBuchen {
	
	//ModelRespositorys
	private IModelAufenthalt modelAufenthalt;
	
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

}
