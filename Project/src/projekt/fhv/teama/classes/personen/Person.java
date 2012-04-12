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
