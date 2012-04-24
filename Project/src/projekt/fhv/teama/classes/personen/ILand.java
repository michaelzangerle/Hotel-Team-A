package projekt.fhv.teama.classes.personen;

import projekt.fhv.teama.hibernate.dao.IModel;

public interface ILand  extends IModel{
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void setKuerzel(String kuerzel);
	public String getKuerzel();
}
