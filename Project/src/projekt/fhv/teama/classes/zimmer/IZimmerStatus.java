package projekt.fhv.teama.classes.zimmer;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IZimmerStatus extends IDao {
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void setKuerzel(String kuerzel);
	public String getKuerzel();
}
