package projekt.fhv.teama.classes.personen;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IBerechtigung extends IDao {
	public int getId();
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	public void setKuerzel(String kuerzel);
	public String getKuerzel();
}
