package projekt.fhv.teama.classes.leistungen;

import java.util.Set;

import projekt.fhv.teama.hibernate.dao.IDao;


public interface IWarengruppe extends IDao {
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	
	public void addArtikel(IArtikel artikel);
	public void removeArtikel(IArtikel artikel);
	public Set<IArtikel> getArtikel();
	public void setArtikel(Set<IArtikel> artikel);
	
	public void setSteuersatz(short steuersatz);
	public short getSteuersatz();
	
	public void addZusatzleistung(IZusatzleistung zusatzleistung);
	public void removeZusatzleistung(IZusatzleistung zusatzleistung);
	public void setZusatzleistungen(Set<IZusatzleistung> zusatzleistungen);
	public Set<IZusatzleistung> getZusatzleistungen();
}
