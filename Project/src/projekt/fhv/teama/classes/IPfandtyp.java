package projekt.fhv.teama.classes;

import projekt.fhv.teama.hibernate.dao.IModel;

public interface IPfandtyp extends IModel {
	
	public void setBezeichnung(String bezeichnung);

	public String getBezeichnung();

	public void setBeschreibung(String beschreibung);

	public String getBeschreibung();
}
