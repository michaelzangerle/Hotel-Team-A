package projekt.fhv.teama.classes;

import java.sql.Date;

import projekt.fhv.teama.classes.zimmer.IZimmerpreis;

public interface IAufenthalt {
	public void setPreis(IZimmerpreis ziPreis);
	public IZimmerpreis getZimmerpreis();
	public void setPfandtyp(IPfandTyp pfandtyp);
	public IPfandTyp getPfandtyp();
	public void setVon(Date von);
	public Date getVon();
	public void setBis(Date bis);
	public Date getBis();
	public void setSchluessel(boolean schluessel);
	public boolean getSchluessel();
	public void setPfandnummer(String pfandnr);
	public String getPfandnummer();
}
