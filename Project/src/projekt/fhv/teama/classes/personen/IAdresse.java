package projekt.fhv.teama.classes.personen;

import java.util.Set;

import projekt.fhv.teama.hibernate.dao.IModel;

public interface IAdresse extends IModel {

	public void setStrasse(String strasse);
	public String getStrasse();
	public void setOrt(String ort);
	public String getOrt();
	public void setPlz(String plz);
	public String getPlz();
	public ILand getLand();
	public void setLand(ILand land);
	public Set<IPerson> getPerson();
	public void setPerson(Set<IPerson> person);
	public Set<IVertragspartner> getVertragspartner();
	public void setVertragspartner(Set<IVertragspartner> vertragspartner);
	
}
