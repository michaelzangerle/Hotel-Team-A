package projekt.fhv.teama.model;

import projekt.fhv.teama.classes.leistungen.IArtikel;
import projekt.fhv.teama.hibernate.dao.leistungen.ArtikelDao;
import projekt.fhv.teama.hibernate.dao.leistungen.IArtikelDao;
import projekt.fhv.teama.model.interfaces.IModelArtikel;

public class ModelArtikel implements IModelArtikel{

	IArtikel modelArtikel;
	IArtikelDao artikelDao;
	
	public ModelArtikel() {
		artikelDao=ArtikelDao.getInstance();
	}
	
}
