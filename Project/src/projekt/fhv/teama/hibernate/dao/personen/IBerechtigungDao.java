package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.IBerechtigung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface IBerechtigungDao extends IGenericDao<IBerechtigung> {
	public IBerechtigung getBerechtigungByBezeichnung(String bezeichnung);
}
