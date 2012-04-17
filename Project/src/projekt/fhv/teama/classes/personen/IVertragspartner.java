package projekt.fhv.teama.classes.personen;

import projekt.fhv.teama.classes.rechnung.IKontodaten;
import projekt.fhv.teama.hibernate.dao.IDao;

public interface IVertragspartner extends IDao {
	public void setName(String name);
	public String getName();
	public void setTelefonNummer(String telNr);
	public String getTelefonNummer();
	public void setEmail(String email);
	public String getEmail();
	public void setLand(ILand land);
	public ILand getLand();
	public void setKontodaten(IKontodaten kontodaten);
	public IKontodaten getKontodaten();
	public void setAdresse(IAdresse kontodaten);
	public IAdresse setAdresse();
}
