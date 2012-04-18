package projekt.fhv.teama.classes.personen;

import java.sql.Date;

public interface IMitarbeiter extends IPerson {
	public void setPasswort(String passwort);
	public String getPasswort();
	public void setEingestelltAm(Date einstellDat);
	public Date getEingestelltAm();
}
