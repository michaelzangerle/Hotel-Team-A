package projekt.fhv.teama.model;

import projekt.fhv.teama.classes.leistungen.IZusatzleistung;
import projekt.fhv.teama.hibernate.dao.leistungen.IZusatzleistungDao;
import projekt.fhv.teama.hibernate.dao.leistungen.ZusatzleistungDao;



public class ModelZusatzleistung {

	IZusatzleistung modelZusatzleistung;
	IZusatzleistungDao zusatzleistungDao;
	
	public ModelZusatzleistung() {
		zusatzleistungDao=ZusatzleistungDao.getInstance();
	}
}
