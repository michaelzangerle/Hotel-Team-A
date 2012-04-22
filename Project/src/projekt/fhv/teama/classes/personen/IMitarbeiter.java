package projekt.fhv.teama.classes.personen;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.classes.rechnung.IRechnung;

public interface IMitarbeiter extends IPerson {
	public void setPasswort(String passwort);

	public String getPasswort();

	public void setEinstellung(Date einstellung);

	public Date getEinstellung();

	public Set<IBerechtigung> getBerechtigungen();

	public void addBerechtigung(IBerechtigung berechtigung);

	public void removeBerechtigung(IBerechtigung berechtigung);

	public void setBerechtigungen(Set<IBerechtigung> berechtigungen);

	public Set<IRechnung> getRechnungen();

	public void setRechnungen(Set<IRechnung> rechnungen);

	public void addRechnung(IRechnung rechnung);

	public void removeRechnung(IRechnung rechnung);
	
	public String getNummer();
	
	public void setNummer(String nummer);
}
