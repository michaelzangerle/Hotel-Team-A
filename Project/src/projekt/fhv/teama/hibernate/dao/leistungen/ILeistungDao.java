package projekt.fhv.teama.hibernate.dao.leistungen;

import java.util.Set;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface ILeistungDao extends IGenericDao<ILeistung> {
	public Set<ILeistung> getLeistung(String bezeichnung);
}
