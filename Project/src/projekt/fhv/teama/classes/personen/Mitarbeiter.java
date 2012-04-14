package projekt.fhv.teama.classes.personen;

import java.util.Date;
import java.util.List;

import projekt.fhv.teama.classes.rechnung.Rechnung;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Mitarbeiter extends Person {
    private int ID;
    private String passwort;
    private Date einstellung;
    private List<Berechtigung> berechtigungen;
    private Rechnung rechnungen;
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public Date getEinstellung() {
        return einstellung;
    }

    public void setEinstellung(Date einstellung) {
        this.einstellung = einstellung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mitarbeiter that = (Mitarbeiter) o;

        if (ID != that.ID) return false;
        if (einstellung != null ? !einstellung.equals(that.einstellung) : that.einstellung != null) return false;
        if (passwort != null ? !passwort.equals(that.passwort) : that.passwort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (passwort != null ? passwort.hashCode() : 0);
        result = 31 * result + (einstellung != null ? einstellung.hashCode() : 0);
        return result;
    }

	public Mitarbeiter(String vorname, String nachname, char geschlecht,
			Adresse adresse, Date geburtsdatum, String telefonnummer,
			String email, Bankverbindung bankverbindung, Land land,
			String passwort, Date einstellung) {
		
		super(vorname, nachname, geschlecht, adresse, geburtsdatum,
				telefonnummer, email, bankverbindung, land);
		this.passwort = passwort;
		this.einstellung = einstellung;
	}

	public Mitarbeiter(String vorname, String nachname, char geschlecht,
			Adresse adresse, Date geburtsdatum, String telefonnummer,
			String email, Bankverbindung bankverbindung, Land land) {
		super(vorname, nachname, geschlecht, adresse, geburtsdatum,
				telefonnummer, email, bankverbindung, land);
		
	}


	public Rechnung getRechnungen() {
		return rechnungen;
	}

	public void setRechnungen(Rechnung rechnungen) {
		this.rechnungen = rechnungen;
	}

	@Override
	public String toString() {
		return "Mitarbeiter [ID=" + ID + ", passwort=" + passwort
				+ ", einstellung=" + einstellung + "]";
	}

	public List<Berechtigung> getBerechtigungen() {
		return berechtigungen;
	}

	public void setBerechtigungen(List<Berechtigung> berechtigungen) {
		this.berechtigungen = berechtigungen;
	}

	public Mitarbeiter() {
		super();
	}
}
