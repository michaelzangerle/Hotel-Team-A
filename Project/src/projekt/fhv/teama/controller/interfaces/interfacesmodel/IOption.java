package projekt.fhv.teama.controller.interfaces.interfacesmodel;

public interface IOption {
	public void setProzentsatz(short prozentsatz);
	public short getProzentsatz();
	public void setErfuellung(boolean optionErf);
	public boolean getErfuellung();
	public void setReservierung(IReservierung res);
	public IReservierung getReservierung();
}
