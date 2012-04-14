package projekt.fhv.teama.controller.interfaces.interfacesmodel;

public interface IArtikel {
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	public void setPreis(double preis);
	public double getPreis();
	public void setWarengruppe(IWarengruppe warengruppe);
	public IWarengruppe getWarengruppe();
}
