package projekt.fhv.teama.controller.interfaces.interfacesmodel;

import java.sql.Timestamp;

public interface IStatusEntwicklung {
	public void setVon(Timestamp von);
	public Timestamp getVon();
	public void setBis(Timestamp bis);
	public Timestamp getBis();
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	public void setZimmerStatus(IZimmerStatus status);
	public IZimmerStatus getZimmerStatus();
	public void setZimmer(IZimmer zimmer);
	public IZimmer getZimmer();
}
