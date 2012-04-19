package projekt.fhv.teama.hibernate.dao.leistungen;

import projekt.fhv.teama.classes.leistungen.IArtikel;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public interface IArtikelDao extends IGenericDao<IArtikel> {
	public IArtikel getArtikel (String bez) throws NoDatabaseEntryFoundException ;
}
