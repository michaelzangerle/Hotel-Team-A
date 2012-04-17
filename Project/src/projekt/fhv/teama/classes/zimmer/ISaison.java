package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;

public interface ISaison {
	public void setBezeichnung(String Bezeichnung);
	public String getBezeichnung();
	public void setVon(Date von);
	public Date getVon();
	public void setBis(Date bis);
	public Date getBis();
	public IZimmerpreis getZimmerpreis();
}
