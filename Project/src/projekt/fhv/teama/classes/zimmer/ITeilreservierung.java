package projekt.fhv.teama.classes.zimmer;

import projekt.fhv.teama.hibernate.dao.IModel;

public interface ITeilreservierung extends IModel {
	public void setReservierung(IReservierung res);
	public IReservierung getReservierung();
	public void setKategorie(IKategorie kat);
	public IKategorie getKategorie();
	public void setAnzahl(int anzhal);
	public int getAnzahl();
	
}
