package projekt.fhv.teama.hibernate.dao.rechnung;

import projekt.fhv.teama.classes.rechnung.IZahlungsmethode;
import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface IZahlungsmethodeDao extends IGenericDao<IZahlungsmethode> {
	public IZahlungsmethode getZahlungsmethodeByKuerzel(String kz);
	public IZahlungsmethode getZahlungsmethodeByBezeichnung(String bez);
}
