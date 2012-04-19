package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface IZimmerDao extends IGenericDao<IZimmer> {
	public IZimmer getByNummer(String nr);
	public Set<IZimmer> getZimmerByKategorie(String kategorie);
	public Set<IZimmer> getZimmerByKategorieid(Integer id);
}
