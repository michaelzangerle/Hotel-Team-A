package projekt.fhv.teama.controller.interfaces.interfacesmodel;

public interface IBerechtigung {
	public int getId();
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	public void setKuerzel(String kuerzel);
	public String getKuerzel();
}
