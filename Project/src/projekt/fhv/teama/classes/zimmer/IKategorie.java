package projekt.fhv.teama.classes.zimmer;

public interface IKategorie {
	public void setBezeichnung(String Bezeichnung);
	public String getBezeichnung();
	public void addZimmer(IZimmer zimmer);
	public void removeZimmer(IZimmer zimmer);
	public IZimmer getZimmer();
	public void setBeschreibung(String Beschreibung);
	public String getBeschreibung();
}
