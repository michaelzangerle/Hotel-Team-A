package projekt.fhv.teama.classes.rechnung;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IZahlungsmethode extends IDao {
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	public void setKuerzel(String kuerzel);
	public String getKuerzel();
}
