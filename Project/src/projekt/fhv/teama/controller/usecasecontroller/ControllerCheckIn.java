package projekt.fhv.teama.controller.usecasecontroller;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IReservierungsOption;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.ControllerReservierung;
import projekt.fhv.teama.controller.interfaces.IControllerReservierung;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerCheckIn;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;

public class ControllerCheckIn implements IControllerCheckIn {
	
	
	IControllerReservierung controllerReservierung;
	private List<IReservierung> reservierungen;
	private IReservierung aktuelleReservierung;
	IAufenthalt aufenthalt;

	
	public ControllerCheckIn() {
		
		controllerReservierung=new ControllerReservierung();
	}
	
	public List<IReservierung> getAllReservierungen()
	{
		reservierungen = controllerReservierung.getAllReservierungen();
		return reservierungen;
	}
	
	public void setAktuelleReservierung(IReservierung reservierung) 
	{
		if(reservierungen.contains(reservierung))
		{
			aktuelleReservierung=reservierung;
		}
	}
	
	public IReservierung getAktuelleReservierung()
	{
		
		return aktuelleReservierung;
	
	}
	
	
	public void setVorname(String vorname)
	{
	
	}
	public void setNachname(String nachname)
	{
		aktuelleReservierung.getPerson().setNachname(nachname);
	}
	
	public void setVon(Date date)
	{
		
	}
	
	public void setBis(Date bis)
	{
		
		
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