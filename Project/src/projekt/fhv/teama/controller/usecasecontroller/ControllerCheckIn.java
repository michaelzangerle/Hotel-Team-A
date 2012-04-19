package projekt.fhv.teama.controller.usecasecontroller;

import java.util.List;

import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.controller.ControllerReservierung;
import projekt.fhv.teama.controller.interfaces.IControllerReservierung;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerCheckIn;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;

public class ControllerCheckIn implements IControllerCheckIn {
	
	
	IControllerReservierung controllerReservierung;
	private List<IReservierung> reservierungen;
	private int aktuelleReservierung;

	
	public ControllerCheckIn() {
		
		controllerReservierung=new ControllerReservierung();
	}
	
	public List<IReservierung> getAllReservierungen()
	{
		reservierungen = controllerReservierung.getAllReservierungen();
		return reservierungen;
	}
	
	public IReservierung getReservierungByListId(int id) throws Exception
	{
		if(reservierungen.get(id)!=null)
		{
			aktuelleReservierung=id;
			return reservierungen.get(id);
		}
		else {
			throw new Exception("Fehler");
		}
	}

	public void setVorname(String vorname)
	{
		reservierungen.get(aktuelleReservierung).getPerson().setVorname(vorname);
	}
	public void setNachname(String nachname)
	{
		reservierungen.get(aktuelleReservierung).getPerson().setNachname(nachname);
	}
	
	
}
