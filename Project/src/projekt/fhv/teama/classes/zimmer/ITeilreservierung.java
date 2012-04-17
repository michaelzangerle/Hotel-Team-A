package projekt.fhv.teama.classes.zimmer;

public interface ITeilreservierung {
	public void setReservierung(IReservierung res);
	public IReservierung getReservierung();
	public void setKategorie(IKategorie kat);
	public IKategorie getKategorie();
	public void setAnzhal(int anzhal);
	public int getAnzahl();
}
