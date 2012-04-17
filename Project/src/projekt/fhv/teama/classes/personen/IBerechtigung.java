package projekt.fhv.teama.classes.personen;

public interface IBerechtigung {
	public int getId();
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	public void setKuerzel(String kuerzel);
	public String getKuerzel();
}
