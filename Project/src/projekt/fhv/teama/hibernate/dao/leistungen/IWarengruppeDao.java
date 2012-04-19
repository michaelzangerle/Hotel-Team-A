package projekt.fhv.teama.hibernate.dao.leistungen;

import projekt.fhv.teama.classes.leistungen.IWarengruppe;
import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface IWarengruppeDao extends IGenericDao<IWarengruppe> {
	public IWarengruppe getWarengruppeByBezeichnung(String bez);
}
