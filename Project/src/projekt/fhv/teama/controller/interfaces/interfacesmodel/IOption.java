package projekt.fhv.teama.controller.interfaces.interfacesmodel;

import java.sql.Date;

public interface IOption {
	public void setProzentsatz(short prozentsatz);
	public short getProzentsatz();
	public void setErfuellung(boolean optionErf);
	public boolean getErfuellung();
	public void setReservierung(IReservierung res);
	public IReservierung getReservierung();
	public void setErfuelltAm(Date erfuellung);
	public Date getErfuelltAm();
}
