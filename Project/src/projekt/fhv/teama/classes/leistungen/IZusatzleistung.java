package projekt.fhv.teama.classes.leistungen;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IZusatzleistung extends IDao {
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	public void setWarengruppe(IWarengruppe warengruppe);
	public IWarengruppe getWarengruppe();
	public void setPreis(double preis);
	public double getPreis();
	public void setExtern(boolean extern);
	public boolean getExtern();
}
