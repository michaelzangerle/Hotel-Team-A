package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public interface IVertragspartnerDao extends IGenericDao<IVertragspartner> {
	public IVertragspartner getVertragspartnerByName(String name) throws NoDatabaseEntryFoundException;
}
