package projekt.fhv.teama.controller.usecasecontroller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.MyLittleDate;
import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerZusatzleistungBuchen;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.ModelArtikel;
import projekt.fhv.teama.model.ModelAufenthalt;
import projekt.fhv.teama.model.ModelAufenthaltLeistung;
import projekt.fhv.teama.model.ModelGast;
import projekt.fhv.teama.model.ModelLeistung;
import projekt.fhv.teama.model.ModelZimmer;
import projekt.fhv.teama.model.ModelZusatzleistung;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.exception.WrongParameterException;
import projekt.fhv.teama.model.interfaces.IModelArtikel;
import projekt.fhv.teama.model.interfaces.IModelAufenthalt;
import projekt.fhv.teama.model.interfaces.IModelGast;
import projekt.fhv.teama.model.interfaces.IModelLeistung;
import projekt.fhv.teama.model.interfaces.IModelZimmer;
import projekt.fhv.teama.model.interfaces.IModelZusatzleistung;

public class ControllerZusatzleistungBuchen implements IControllerZusatzleistungBuchen {
	
	//ModelRespositorys
	private IModelAufenthalt modelAufenthalt;
	private IModelGast modelGast;
	private IModelLeistung modelLeistung;
	private IModelArtikel modelArtikel;
	private IModelZusatzleistung modelZusatzleistung;
	private IModelZimmer modelZimmer;
	private ModelAufenthaltLeistung modelAufenthaltLeistung;
	
	
	public ControllerZusatzleistungBuchen() {
		modelArtikel=new ModelArtikel();
		modelAufenthalt=new ModelAufenthalt();
		modelLeistung=new ModelLeistung();
		modelZusatzleistung=new ModelZusatzleistung();
		modelGast=new ModelGast();
		modelZimmer=new ModelZimmer();
		modelAufenthaltLeistung=new ModelAufenthaltLeistung();
	}
	
	
	private List<IAufenthalt> aufenthalte=new Vector<IAufenthalt>();
	
	private List<ILeistung> artikel=new Vector<ILeistung>();
	private List<ILeistung> zusatzleistungen=new Vector<ILeistung>();
	private List<ILeistung> leistungen=new Vector<ILeistung>();
	
	private HashMap<IZimmer, List<LeistungAnzahl>> gebuchteLeistungen=new HashMap<IZimmer, List<LeistungAnzahl>>();


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
	
	public IZimmer getZimmerByNummer(String nummer) throws EmptyParameterException, DatabaseException, FokusException {
		if (nummer == null)
			throw new EmptyParameterException();
		
		if (aufenthalte.size() <= 0)
			getAufenthalte();
		
		for (IAufenthalt aufenthalt : aufenthalte) {
			if (aufenthalt.getGast().equals(getGast())&&aufenthalt.getZimmer()!=null && aufenthalt.getZimmer().getNummer().equals(nummer)) {
				return aufenthalt.getZimmer();
			}
		}
		return null;
	}
	
	public List<IZimmer> getZimmerVonGast() throws FokusException, DatabaseException
	{
		List<IZimmer> zimmers=new Vector<IZimmer>();
		if(aufenthalte.size()<=0)
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
		
		if(aufenthalte.size()<=0)
			getAufenthalte();
		
		for (IAufenthalt aufenthalt : aufenthalte) {
			if(aufenthalt.getGast().getNummer().equals(nummer))
				return aufenthalt.getGast();
		}
		
		throw new NotContainExeption();
		
	}
	
	
	public List<ILeistung> getArtikelundZusatzleistungen() throws DatabaseException
	{
		if(artikel.size()<=0 ||zusatzleistungen.size()<=0)
		{
			artikel=modelArtikel.getArtikel();
			zusatzleistungen=modelZusatzleistung.getZusatzleistungen();
		}
		
		leistungen.addAll(artikel);
		leistungen.addAll(zusatzleistungen);
		
		return leistungen;
		
	}
	
	public void setAktuellesZimmer(IZimmer zimmer) throws EmptyParameterException
	{
		modelZimmer.setAktullesZimmer(zimmer);
		
	}
	
	public IZimmer getAktuellesZimmer() throws FokusException
	{
		return modelZimmer.getAktullesZimmer();
	}
	
	public void addLeistung(ILeistung leistung,int anzahl) throws FokusException, EmptyParameterException
	{
		if(leistung!=null && anzahl>0)
		{
			if(gebuchteLeistungen.containsKey(getAktuellesZimmer()))
			{
				gebuchteLeistungen.get(getAktuellesZimmer()).add(new LeistungAnzahl(leistung, anzahl));
			}
			else {
				List<LeistungAnzahl> l=new Vector<LeistungAnzahl>();
				l.add(new LeistungAnzahl(leistung, anzahl));
				gebuchteLeistungen.put(getAktuellesZimmer(), l);
			}
		} 
		else {
			throw new EmptyParameterException();
		}
		
		
	}
	
	public void removeLeistung(ILeistung leistung) throws FokusException, EmptyParameterException
	{
		if(leistung!=null)
		{
			if(gebuchteLeistungen.containsKey(getAktuellesZimmer()) && gebuchteLeistungen.get(getAktuellesZimmer()).contains(leistung))
			{
				gebuchteLeistungen.get(getAktuellesZimmer()).remove(leistung);
			}
			else {
				throw new FokusException();
			}
		}
		else {
			throw new EmptyParameterException();
		}
	}
	
	public HashMap<IZimmer, List<LeistungAnzahl>> getGebuchteLeistungen()
	{
		return gebuchteLeistungen;
	}
	
	
	public void saveLeistungen() throws FokusException, WrongParameterException, DatabaseException, NotContainExeption
	{
		for (IZimmer z : gebuchteLeistungen.keySet()) {
			
			for (LeistungAnzahl l : gebuchteLeistungen.get(z)) {
				
				ILeistung leistung=l.getLeistung();
				int anzahl=l.getAnzahl();
				IAufenthalt aufenthalt=getAufenhaltbyZimmer(z);
				java.util.Date date=new java.util.Date();
				Date datum=new Date(date.getTime());
				
				modelAufenthaltLeistung.save(leistung, aufenthalt, anzahl, datum);
			}
		}
	}
	
	public ILeistung getLeistungByBezeichnung(String bez) throws DatabaseException, NotContainExeption
	{
		if(leistungen.size()<1)
		{
			getArtikelundZusatzleistungen();
		}
		
		for (ILeistung leistung : leistungen) {
			if(leistung.getBezeichnung().equals(bez))
				return leistung;
		}
		
		throw new NotContainExeption();
	}

	
	private IAufenthalt getAufenhaltbyZimmer(IZimmer zimmer) throws FokusException, NotContainExeption
	{
		for (IAufenthalt auf : aufenthalte) {
			
			if(auf.getGast().equals(getGast())&&auf.getZimmer().equals(zimmer))
				return auf;
		}
		
		throw new NotContainExeption();		
		
	}


	
	
	

}
