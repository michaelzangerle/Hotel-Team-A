package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;
import java.sql.Timestamp;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IStatusEntwicklung extends IDao {
	
	public void setVon(Date von);
	public Date getVon();
	public void setBis(Date bis);
	public Date getBis();
	
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	
	public void setZimmerStatus(IZimmerStatus zimmerStatus);
	public IZimmerStatus getZimmerStatus();
	
	public void setZimmer(IZimmer zimmer);
	public IZimmer getZimmer();
}
