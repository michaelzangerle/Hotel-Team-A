package projekt.fhv.teama.classes.personen;

import java.sql.Date;

import projekt.fhv.teama.classes.rechnung.IKontodaten;
import projekt.fhv.teama.hibernate.dao.IDao;

public interface IPerson extends IDao {
	public void setVorname(String vn);
	public String getVorname();
	public void setNachname(String nn);
	public String getNachname();
	public void setGeschlecht(Character geschlecht);
	public Character getGeschlecht();
	public void setGeburtsdatum(Date gebDat);
	public Date getGeburtsdatum();
	public void setTelefonnummer(String telNr);
	public String getTelefonnummer();
	public void setEmail(String email);
	public String getEmail();
	public void setLand(ILand land);
	public ILand getLand();
	public void setKontodaten(IKontodaten kontodaten);
	public IKontodaten getKontodaten();
	public void setAdresse(IAdresse kontodaten);
	public IAdresse setAdresse();
}
