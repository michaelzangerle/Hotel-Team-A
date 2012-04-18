package projekt.fhv.teama.classes.zimmer;

import java.awt.List;
import java.util.Set;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IKategorie extends IDao {
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void addZimmer(IZimmer zimmer);
	public void removeZimmer(IZimmer zimmer);
	public Set<IZimmer> getZimmer();
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	
	public Set<IZimmerpreis> getZimmerpreise();
	public void setZimmerpreise(Set<IZimmerpreis> zimmerpreise);
	public void addZimmerpreis(IZimmerpreis zimmerpreis);
	public void removeZimmerpreis(IZimmerpreis zimmerpreis);
	
	public Set<Teilreservierung> getTeilreservierungsreservierungen();
	public void setTeilreservierungsreservierungen(Set<Teilreservierung> teilreservierungsreservierungen);
	public void addTeilreservierung(ITeilreservierung teilreservierung);
	public void removeTeilreservierung(ITeilreservierung teilreservierung);
	
}
