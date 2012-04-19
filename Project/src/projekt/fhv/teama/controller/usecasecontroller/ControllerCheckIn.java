package projekt.fhv.teama.controller.usecasecontroller;

import projekt.fhv.teama.controller.ControllerReservierung;
import projekt.fhv.teama.controller.interfaces.IControllerReservierung;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerCheckIn;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;

public class ControllerCheckIn implements IControllerCheckIn {
	
	
	IControllerReservierung controllerReservierung;

	
	public ControllerCheckIn() {
		
		controllerReservierung=new ControllerReservierung();
	}
	
	public void getAllReservierungen()
	{
		controllerReservierung.getAllReservierungen();
	}

}
