package projekt.fhv.teama.classes.personen;

import java.sql.Date;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IMitarbeiter extends IDao {
	public void setPasswort(String passwort);
	public String getPasswort();
	public void setEingestelltAm(Date einstellDat);
	public Date getEingestelltAm();
}
