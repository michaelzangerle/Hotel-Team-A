package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.IBerechtigung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IBerechtigungDao extends IGenericDao<IBerechtigung> {
	public IBerechtigung getBerechtigungByBezeichnung(String bezeichnung) throws DatabaseException;
}
