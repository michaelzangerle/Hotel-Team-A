package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface ISaison extends IDao {
	public void setBezeichnung(String Bezeichnung);
	public String getBezeichnung();
	public void setVon(Date von);
	public Date getVon();
	public void setBis(Date bis);
	public Date getBis();
	public IZimmerpreis getZimmerpreis();
}
