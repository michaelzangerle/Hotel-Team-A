package projekt.fhv.teama.controller.interfaces.interfacesmodel;

public interface IKategorie {
	public void setBezeichnung(String Bezeichnung);
	public String getBezeichnung();
	public void addZimmer(IZimmer zimmer);
	public void removeZimmer(IZimmer zimmer);
	public IZimmer getZimmer();
	public void setBeschreibung(String Beschreibung);
	public String getBeschreibung();
}
