package projekt.fhv.teama.hibernate.dao.rechnung;

import projekt.fhv.teama.classes.rechnung.IZahlungsmethode;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public interface IZahlungsmethodeDao extends IGenericDao<IZahlungsmethode> {
	public IZahlungsmethode getZahlungsmethodeByKuerzel(String kz) throws NoDatabaseEntryFoundException;
	public IZahlungsmethode getZahlungsmethodeByBezeichnung(String bez) throws NoDatabaseEntryFoundException;
} 
