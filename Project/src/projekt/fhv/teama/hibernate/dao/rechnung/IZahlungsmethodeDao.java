package projekt.fhv.teama.hibernate.dao.rechnung;

import projekt.fhv.teama.classes.rechnung.IZahlungsmethode;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public interface IZahlungsmethodeDao extends IGenericDao<IZahlungsmethode> {
	public IZahlungsmethode getZahlungsmethodeByKuerzel(String kz) throws DatabaseEntryNotFoundException;
	public IZahlungsmethode getZahlungsmethodeByBezeichnung(String bez) throws DatabaseEntryNotFoundException;
} 
