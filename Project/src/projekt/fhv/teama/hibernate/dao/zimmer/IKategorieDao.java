package projekt.fhv.teama.hibernate.dao.zimmer;


import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface IKategorieDao extends IGenericDao<IKategorie> {
	public IKategorie getKategorie(String kategoriename);
}
