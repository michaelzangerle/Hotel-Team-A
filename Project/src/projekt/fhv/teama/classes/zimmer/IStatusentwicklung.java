package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IStatusentwicklung extends IDao {
	
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
