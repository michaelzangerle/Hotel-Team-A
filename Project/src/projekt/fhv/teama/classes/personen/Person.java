package projekt.fhv.teama.classes.personen;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Person {
	private int ID;
	private String vorname;
	private String nachname;
	private char geschlecht;
	private Set<Adresse> adressen;
	private Date geburtsdatum;
	private String telefonnummer;
	private String email;
	private Kontodaten kontodaten;
	private Land land;

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

	public char getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}

	public Set<Adresse> getAdressen() {
		return adressen;
	}

	public void setAdressen(Set<Adresse> adresse) {
		this.adressen = adresse;
	}

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
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

	public Kontodaten getKontodaten() {
		return kontodaten;
	}

	public void setKontodaten(Kontodaten kontodaten) {
		this.kontodaten = kontodaten;
	}

	public Land getLand() {
		return land;
	}

	public void setLand(Land land) {
		this.land = land;
	}
	
	public Person() {
		adressen = new HashSet<Adresse>();
	}
	
	public Person(String vorname, String nachname, char geschlecht,
			Date geburtsdatum, String telefonnummer, String email,
			Kontodaten kontodaten, Land land) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geschlecht = geschlecht;
		this.geburtsdatum = geburtsdatum;
		this.telefonnummer = telefonnummer;
		this.email = email;
		this.kontodaten = kontodaten;
		this.land = land;
	}
	
	public Person(String vorname, String nachname, char geschlecht,
			Set<Adresse> adresse, Date geburtsdatum, String telefonnummer,
			String email, Kontodaten bankverbindung, Land land) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geschlecht = geschlecht;
		this.adressen = new HashSet<Adresse>();		
		this.geburtsdatum = geburtsdatum;
		this.telefonnummer = telefonnummer;
		this.email = email;
		this.kontodaten = bankverbindung;
		this.land = land;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result
				+ ((adressen == null) ? 0 : adressen.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((geburtsdatum == null) ? 0 : geburtsdatum.hashCode());
		result = prime * result + geschlecht;
		result = prime * result
				+ ((kontodaten == null) ? 0 : kontodaten.hashCode());
		result = prime * result + ((land == null) ? 0 : land.hashCode());
		result = prime * result
				+ ((nachname == null) ? 0 : nachname.hashCode());
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
		if (adressen == null) {
			if (other.adressen != null)
				return false;
		} else if (!adressen.equals(other.adressen))
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
		if (land == null) {
			if (other.land != null)
				return false;
		} else if (!land.equals(other.land))
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
				+ nachname + ", geschlecht=" + geschlecht + ", adressen="
				+ adressen + ", geburtsdatum=" + geburtsdatum
				+ ", telefonnummer=" + telefonnummer + ", email=" + email
				+ ", kontodaten=" + kontodaten + ", landID=" + land + "]";
	}


}
