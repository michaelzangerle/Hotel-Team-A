package projekt.fhv.teama.classes.personen;

import java.sql.Date;
import java.util.Set;
import projekt.fhv.teama.classes.zimmer.IReservierung;


/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Person implements IPerson {
	private int ID;
	private String vorname;
	private String nachname;
	private char geschlecht;
	private Set<IAdresse> adressen;
	private Date geburtsdatum;
	private String telefonnummer;
	private String email;
	private IKontodaten kontodaten;
	private Set<IReservierung> reservierungen;

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Character getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}

	public Set<IAdresse> getAdressen() {
		return adressen;
	}

	@Override
	public void setAdressen(Set<IAdresse> adressen) {
		this.adressen = adressen;
	}
	
	@Override
	public void addAdresse(IAdresse adresse) {
		this.adressen.add(adresse);
		
	}

	@Override
	public void removeAdresse(IAdresse adresse) {
		if(adressen.contains(adresse)) {
			adressen.remove(adresse);
		}
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public java.sql.Date getGeburtsdatum() {
		return geburtsdatum; 
	}

	@Override
	public void setGeburtsdatum(java.sql.Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
		
	}

	public IKontodaten getKontodaten() {
		return kontodaten;
	}
	
	@Override
	public void setKontodaten(IKontodaten kontodaten) {
		this.kontodaten = kontodaten;
		
	}


	@Override
	public Set<IReservierung> getReservierungen() {
		return reservierungen;
	}
	
	@Override
	public void setReservierungen(Set<IReservierung> reservierungen) {
		this.reservierungen = reservierungen;
	}
	

	@Override
	public void removeReservierung(IReservierung reservierung) {
		if (reservierungen.contains(reservierung)){
			reservierungen.remove(reservierung);
		}
	}

	public Person() {
	}
	
	public Person(String vorname, String nachname, char geschlecht,
			Set<IAdresse> adressen, Date geburtsdatum, String telefonnummer,
			String email, IKontodaten kontodaten) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geschlecht = geschlecht;
		this.adressen = adressen;		
		this.geburtsdatum = geburtsdatum;
		this.telefonnummer = telefonnummer;
		this.email = email;
		this.kontodaten = kontodaten;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((geburtsdatum == null) ? 0 : geburtsdatum.hashCode());
		result = prime * result + geschlecht;
		result = prime * result
				+ ((kontodaten == null) ? 0 : kontodaten.hashCode());
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result
				+ ((telefonnummer == null) ? 0 : telefonnummer.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (ID != other.ID)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (geburtsdatum == null) {
			if (other.geburtsdatum != null)
				return false;
		} else if (!geburtsdatum.equals(other.geburtsdatum))
			return false;
		if (geschlecht != other.geschlecht)
			return false;
		if (kontodaten == null) {
			if (other.kontodaten != null)
				return false;
		} else if (!kontodaten.equals(other.kontodaten))
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (telefonnummer == null) {
			if (other.telefonnummer != null)
				return false;
		} else if (!telefonnummer.equals(other.telefonnummer))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [ID=" + ID + ", vorname=" + vorname + ", nachname="
				+ nachname + ", geschlecht=" + geschlecht + ", geburtsdatum=" + geburtsdatum
				+ ", telefonnummer=" + telefonnummer + ", email=" + email
				+ ", kontodaten=" + kontodaten + "]";
	}
}
