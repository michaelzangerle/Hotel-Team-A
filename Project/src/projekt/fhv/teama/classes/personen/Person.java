package projekt.fhv.teama.classes.personen;

import java.util.Date;

//import projekt.fhv.teama.classes.Bankverbindung;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Person {
	@Override
	public String toString() {
		return "Person [ID=" + ID + ", vorname=" + vorname + ", nachname="
				+ nachname + ", geschlecht=" + geschlecht + ", adresse="
				+ adresse + ", geburtsdatum=" + geburtsdatum
				+ ", telefonnummer=" + telefonnummer + ", email=" + email
				+ ", bankverbindung=" + bankverbindung + ", landID=" + landID
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((bankverbindung == null) ? 0 : bankverbindung.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((geburtsdatum == null) ? 0 : geburtsdatum.hashCode());
		result = prime * result + geschlecht;
		result = prime * result + ((landID == null) ? 0 : landID.hashCode());
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((telefonnummer == null) ? 0 : telefonnummer.hashCode());
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
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (bankverbindung == null) {
			if (other.bankverbindung != null)
				return false;
		} else if (!bankverbindung.equals(other.bankverbindung))
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
		if (landID == null) {
			if (other.landID != null)
				return false;
		} else if (!landID.equals(other.landID))
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

	private int ID;
	private String vorname;
	private String nachname;
	private char geschlecht;
	private Adresse adresse;
	private Date geburtsdatum;
	private String telefonnummer;
	private String email;
	private Bankverbindung bankverbindung;
	private Land landID;

	public int getID() {
		return ID;
	}

	public void setID(int personId) {
		this.ID = personId;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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

	public Bankverbindung getBankverbindung() {
		return bankverbindung;
	}

	public void setBankverbindung(Bankverbindung bankverbindung) {
		this.bankverbindung = bankverbindung;
	}

	public Land getLandID() {
		return landID;
	}

	public void setLandID(Land land) {
		this.landID = land;
	}
	
	
	
	public Person() {
	}

	public Person(String vorname, String nachname, char geschlecht,
			Adresse adresse, Date geburtsdatum, String telefonnummer,
			String email, Bankverbindung bankverbindung, Land land) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geschlecht = geschlecht;
		this.adresse = adresse;
		this.geburtsdatum = geburtsdatum;
		this.telefonnummer = telefonnummer;
		this.bankverbindung = bankverbindung;
		this.email = email;
		this.landID = land;
	}
}
