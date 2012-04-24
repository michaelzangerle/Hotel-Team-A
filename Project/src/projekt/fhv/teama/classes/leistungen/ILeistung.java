package projekt.fhv.teama.classes.leistungen;

import projekt.fhv.teama.hibernate.dao.IModel;

public interface ILeistung extends IModel {
	
	public void setBezeichnung(String beschreibung);

	public String getBezeichnung();
}
