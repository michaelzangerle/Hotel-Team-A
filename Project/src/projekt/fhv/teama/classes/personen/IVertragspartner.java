package projekt.fhv.teama.classes.personen;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.hibernate.dao.IDao;

public interface IVertragspartner extends IDao {
	public void setName(String name);
	public String getName();
	public void setTelefonNummer(String telefonnummer);
	public String getTelefonNummer();
	public void setEmail(String email);
	public String getEmail();
	public void setKontodaten(IKontodaten kontodaten);
	public IKontodaten getKontodaten();
	public void addAdresse(IAdresse adresse);
	public Set<IAdresse> getAdressen();
	public void removeAdresse(IAdresse adresse);
	public void setAdressen(Set<IAdresse> adresse);
}
