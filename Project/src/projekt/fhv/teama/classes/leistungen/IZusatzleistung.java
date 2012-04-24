package projekt.fhv.teama.classes.leistungen;

import projekt.fhv.teama.hibernate.dao.IModel;

public interface IZusatzleistung extends IModel {
	
	public void setBeschreibung(String beschreibung);

	public String getBeschreibung();

	public void setWarengruppe(IWarengruppe warengruppe);

	public IWarengruppe getWarengruppe();

	public void setPreis(float preis);

	public float getPreis();

	public void setExtern(boolean extern);

	public boolean isExtern();
}
