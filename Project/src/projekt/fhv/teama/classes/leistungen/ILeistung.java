package projekt.fhv.teama.classes.leistungen;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface ILeistung extends IDao {
	public void setBezeichnung(String beschreibung);
	public String getBezeichnung();
}
