package projekt.fhv.teama.controller.interfaces.interfacesmodel;

public interface IZimmer {
	public void setNummer(String Nummer);
	public String getNummer();
	public void setKategorie(IKategorie kat);
	public IKategorie getKategorie();
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	public void setAktuellerStratus(IZimmerStatus status);
	public IZimmerStatus getAktuellerStatus();
	public IStatusEntwicklung getStatusEntwicklung();
	public void addReservierung(IReservierung res);
	public void removerReservierung(IReservierung res);
	public IReservierung getReservierung();
	public void addAufenthalt(IAufenthalt aufenthalt);
	public IAufenthalt getAufenthalt();
	public IRechnungsposition getRechnungsposition();
}