package projekt.fhv.teama.classes;

import java.sql.Date;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.dao.IDao;

public interface IAufenthalt extends IDao {
	public void setPreis(Float preis);

	public Float getPreis();

	public void setPfandtyp(IPfandTyp pfandtyp);

	public IPfandTyp getPfandtyp();

	public void setVon(Date von);

	public Date getVon();

	public void setBis(Date bis);

	public Date getBis();

	public void setSchluessel(boolean schluessel);

	public boolean isSchluessel();

	public void setPfandNr(String pfandNr);

	public String getPfandNr();

	public IGast getGast();

	public void setGast(IGast gast);

	public IZimmer getZimmer();

	public void setZimmer(IZimmer zimmer);

}
