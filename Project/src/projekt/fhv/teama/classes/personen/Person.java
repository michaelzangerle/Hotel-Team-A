package projekt.fhv.teama.classes.personen;

import java.util.Date;

//import projekt.fhv.teama.classes.Bankverbindung;
import projekt.fhv.teama.classes.Land;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    private int personId;
    private String vorname;
    private String nachname;
    private char geschlecht;
    //private Adresse adresse;
    private Date geburtsdatum;
    private String telefonnummer;
    private String email;
    //private Bankverbindung bankverbindung;
    private Land land;
    
	public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

//    public Adresse getAdresse() {
//		return adresse;
//	}
//
//	public void setAdresse(Adresse adresse) {
//		this.adresse = adresse;
//	}

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

//    public Bankverbindung getBankverbindung() {
//		return bankverbindung;
//	}
//
//	public void setBankverbindung(Bankverbindung bankverbindung) {
//		this.bankverbindung = bankverbindung;
//	}
	
	public Land getLand() {
		return land;
	}

	public void setLand(Land land) {
		this.land = land;
	}
	
//    public Person(String vorname, String nachname, char geschlecht, Adresse adresse, Date geburtsdatum2, String telefonnummer, String email, Bankverbindung bankverbindung, Land land) {
//    	this.vorname = vorname;
//		this.nachname = nachname;
//		this.geschlecht = geschlecht;
//		this.adresse = adresse;
//		this.geburtsdatum = geburtsdatum2;
//		this.telefonnummer = telefonnummer;
//		this.bankverbindung = bankverbindung;
//	}
}
