package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;

import projekt.fhv.teama.classes.IModel;

public interface IStatusentwicklung extends IModel {
	
	public void setVon(Date von);
	public Date getVon();
	public void setBis(Date bis);
	public Date getBis();
	
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	
	public void setZimmerStatus(IZimmerstatus zimmerStatus);
	public IZimmerstatus getZimmerStatus();
	
	public void setZimmer(IZimmer zimmer);
	public IZimmer getZimmer();
}
