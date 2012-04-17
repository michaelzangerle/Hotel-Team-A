package projekt.fhv.teama.classes.personen;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface ILand  extends IDao{
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void setKuerzel(String kuerzel);
	public String getKuerzel();
}
