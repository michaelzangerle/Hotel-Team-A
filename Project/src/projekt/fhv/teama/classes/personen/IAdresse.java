package projekt.fhv.teama.classes.personen;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IAdresse extends IDao {

	public void setStrasse(String strasse);
	public String getStrasse();
	public void setOrt(String ort);
	public String getOrt();
	public void setPlz(String plz);
	public String getPlz();
	
}
