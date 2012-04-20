package projekt.fhv.teama.hibernate.dao.zimmer;


import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public interface IKategorieDao extends IGenericDao<IKategorie> {
	public IKategorie getKategorie(String kategoriename)throws DatabaseEntryNotFoundException ;
}
