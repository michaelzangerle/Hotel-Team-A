package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface ISaison extends IDao {
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void setVon(Date von);
	public Date getVon();
	public void setBis(Date bis);
	public Date getBis();
	
	public Set<IZimmerpreis> getZimmerpreise();
	public void setZimmerpreise(Set<Zimmerpreis> zimmerpreise);
	public void addZimmerpreis(IZimmerpreis zimmerpreis);
	public void removeZimmerpreis(IZimmerpreis zimmerpreis);
}
