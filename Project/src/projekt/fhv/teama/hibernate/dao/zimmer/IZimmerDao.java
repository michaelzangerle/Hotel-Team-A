package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IZimmerDao extends IGenericDao<IZimmer> {
	public IZimmer getZimmerByNummer(String nr) throws DatabaseException;
	public Set<IZimmer> getZimmerByKategorie(String kategorie) throws DatabaseException;
	public Set<IZimmer> getZimmerByKategorieID(int id) throws DatabaseException;
}
