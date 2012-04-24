package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.classes.IModel;

public interface ISaison extends IModel {
	
	public void setBezeichnung(String bezeichnung);

	public String getBezeichnung();

	public void setVon(Date von);

	public Date getVon();

	public void setBis(Date bis);

	public Date getBis();

	public Set<IZimmerpreis> getZimmerpreise();

	public void setZimmerpreise(Set<IZimmerpreis> zimmerpreise);

	public void addZimmerpreis(IZimmerpreis zimmerpreis);

	public void removeZimmerpreis(IZimmerpreis zimmerpreis);
}
