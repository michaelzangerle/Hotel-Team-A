package projekt.fhv.teama.classes.leistungen;

public interface IZusatzleistung {
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	public void setWarengruppe(IWarengruppe warengruppe);
	public IWarengruppe getWarengruppe();
	public void setPreis(double preis);
	public double getPreis();
	public void setExtern(boolean extern);
	public boolean getExtern();
}
