package projekt.fhv.teama.classes.leistungen;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface ILeistung extends IDao {
	public void setBeschreigung(String beschreibung);
	public String getBeschreibung();
}
