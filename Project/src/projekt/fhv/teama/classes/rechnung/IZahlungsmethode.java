package projekt.fhv.teama.classes.rechnung;

import projekt.fhv.teama.hibernate.dao.IModel;

public interface IZahlungsmethode extends IModel {
	
	public void setBezeichnung(String bezeichnung);

	public String getBezeichnung();

	public void setBeschreibung(String beschreibung);

	public String getBeschreibung();

	public void setKuerzel(String kuerzel);

	public String getKuerzel();
}
