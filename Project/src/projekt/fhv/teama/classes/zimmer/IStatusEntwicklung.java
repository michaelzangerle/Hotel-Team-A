package projekt.fhv.teama.classes.zimmer;

import java.sql.Timestamp;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IStatusEntwicklung extends IDao {
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
