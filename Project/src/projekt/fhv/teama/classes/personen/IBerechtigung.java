package projekt.fhv.teama.classes.personen;

import java.util.Set;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IBerechtigung extends IDao {
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	public void setKuerzel(String kuerzel);
	public String getKuerzel();
	public Set<IMitarbeiter> getBerechtigte();
	public void setBerechtigte(Set<IMitarbeiter> berechtigte);
	public void addBerechtigter(IMitarbeiter berechtigter);
	public void removeBerechtigter(IMitarbeiter berechtigter);
}
