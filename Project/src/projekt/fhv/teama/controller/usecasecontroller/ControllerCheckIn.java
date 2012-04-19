package projekt.fhv.teama.controller.usecasecontroller;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import projekt.fhv.teama.classes.Aufenthalt;
import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IReservierungsOption;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.Zimmer;
import projekt.fhv.teama.controller.ControllerReservierung;
import projekt.fhv.teama.controller.interfaces.IControllerAufenthalt;
import projekt.fhv.teama.controller.interfaces.IControllerGast;
import projekt.fhv.teama.controller.interfaces.IControllerReservierung;
import projekt.fhv.teama.controller.interfaces.IControllerTeilreservierung;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerCheckIn;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;

public class ControllerCheckIn implements IControllerCheckIn {
	
	
	IControllerReservierung controllerReservierung;
	IControllerAufenthalt controllerAufenthalt;
	IControllerGast controllerGast;
	IControllerTeilreservierung controllerTeilreservierung;
	
	IAufenthalt aufenthalt=new Aufenthalt();
	
	//Variablen
	
	

	/**
	 * 
	 * Konstruktor
	 */
	public ControllerCheckIn() {
		
		controllerReservierung=new ControllerReservierung();
	}
	
	
	
	public List<IReservierung> getAllReservierungen()
	{
		return controllerReservierung.getAllReservierungen();
	}
	
	
	
	public void setAktuelleReservierung(IReservierung reservierung) 
	{
		controllerReservierung.setAktuelleReservierung(reservierung);
	}
	
	public IReservierung getAktuelleReservierung()
	{
		return controllerReservierung.getAktuelleReservierung();
	}
	
	public List<ITeilreservierung> getTeilreservierungen()
	{
		List<ITeilreservierung> tres=controllerReservierung.getTeilreservierungen();
		return tres;
		
	}
	
	public void setTeilreservierung(ITeilreservierung teilreservierung)
	{
		controllerTeilreservierung.setAktulleTeilreservierung(teilreservierung);
	}
	
	public void get(ITeilreservierung teilreservierung)
	{
		controllerTeilreservierung.setAktulleTeilreservierung(teilreservierung);
	}
	
	
	public void setGast(IGast gast)
	{
		controllerGast.setAktuellGast(gast);
	}
	
	public IGast getGast()
	{
		return controllerGast.getAktuellGast();
	}
	
	public void setVorname(String vorname)
	{
		controllerGast.setVorname(vorname);
	}
	public void setNachname(String nachname)
	{
		controllerGast.setNachname(nachname);
	}

	public void setVon(Date date)
	{
		
	}
	
	public void setBis(Date bis)
	{
		
		
	}
	
	public void setPreis(float preis)
	{
		
	}
	
	public void setSchluessel(boolean schluesel)
	{
		
	}
	
	public void saveAufenthalt()
	{
		// TODO Muss dynamisch sein
		float preis=0.0f;
		Date von=new Date(1);
		Date bis=new Date(1);
		boolean schluessel=true;

		IGast g=controllerGast.getAktuellGast();
		IGast gast =new Gast(g.getVorname(), g.getNachname(), g.getGeschlecht(), g.getAdressen(), g.getGeburtsdatum(), g.getTelefonnummer(), g.getEmail(), g.getKontodaten(), g.getNummer());		
		
		List<IZimmer> zimmer1=new Vector<IZimmer>();
		for (IZimmer zi : zimmer1) {
			controllerAufenthalt.create(preis, von, bis, schluessel, gast, zi);
		}

	}

	
	/*
	public void addZimmer(IZimmer zimmer);
	public void removeZimmer(IZimmer zimmer);
	public Set<IZimmer> getZimmer();
	
	public void setPerson(IPerson person);
	public IPerson getPerson();
	
	public void addGast(IGast gast);
	public void removeGast(IGast gast);
	public Set<IGast> getGaeste();
	public void setGaeste(Set<IGast> gaeste);
	
	public void addOption(IReservierungsOption option);
	public void removeOption(IReservierungsOption option);
	public Set<IReservierungsOption> getOptionen();
	
	public void setVertragspartner(IVertragspartner partner);
	public IVertragspartner getVertragspartner();
	
	
	
	*/
	
}