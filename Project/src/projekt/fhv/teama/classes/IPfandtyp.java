package projekt.fhv.teama.classes;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IPfandtyp extends IDao {
	
	public void setBezeichnung(String bezeichnung);

	public String getBezeichnung();

	public void setBeschreibung(String beschreibung);

	public String getBeschreibung();
}
