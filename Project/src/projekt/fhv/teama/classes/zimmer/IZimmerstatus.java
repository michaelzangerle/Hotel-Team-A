package projekt.fhv.teama.classes.zimmer;

import projekt.fhv.teama.hibernate.dao.IModel;

public interface IZimmerstatus extends IModel {
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void setKuerzel(String kuerzel);
	public String getKuerzel();
}
