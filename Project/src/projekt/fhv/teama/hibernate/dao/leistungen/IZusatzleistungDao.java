package projekt.fhv.teama.hibernate.dao.leistungen;

import java.util.Set;

import projekt.fhv.teama.classes.leistungen.IZusatzleistung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public interface IZusatzleistungDao extends IGenericDao<IZusatzleistung> {
	public Set<IZusatzleistung> getZusatzleistung(String bezeichnung) throws DatabaseEntryNotFoundException;
}
