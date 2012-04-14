package projekt.fhv.teama.controller.interfaces.interfacesmodel;

public interface IGast {
	public void setNummer(int nummer);
	public int getNummer();
	public void addRechnungposition(IRechnungsposition rePos);
	public void removeRechnungsposition(IRechnungsposition rePos);
	public IRechnungsposition getRechnungsposition();
	public void addReservierung(IReservierung res);
	public void removeReservierung(IReservierung res);
	public IReservierung getReservierung();
	public void addAufenthalt(IAufenthalt aufenthalt);
	public IAufenthalt getAufenthalt();
	public void setZimmer(IZimmer zimmer);
	public IZimmer getZimmer();
}
