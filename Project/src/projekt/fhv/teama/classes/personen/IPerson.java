package projekt.fhv.teama.classes.personen;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.hibernate.dao.IDao;

public interface IPerson extends IDao {
	public void setVorname(String vorname);

	public String getVorname();

	public void setNachname(String nachname);

	public String getNachname();

	public void setGeschlecht(char geschlecht);

	public Character getGeschlecht();

	public void setGeburtsdatum(Date geburtsdatum);

	public Date getGeburtsdatum();

	public void setTelefonnummer(String telefonnummer);

	public String getTelefonnummer();

	public void setEmail(String email);

	public String getEmail();

	public void setLand(ILand land);

	public ILand getLand();

	public void setKontodaten(IKontodaten kontodaten);

	public IKontodaten getKontodaten();

	public void addAdresse(IAdresse adresse);

	public Set<IAdresse> getAdressen();

	public void removeAdresse(IAdresse adresse);

	public void setAdressen(Set<IAdresse> adresse);
	
	public Set<IReservierung> getReservierungen();

	public void removeReservierung(IReservierung reservierung);

	public void setReservierungen(Set<IReservierung> reservierungen);
}
