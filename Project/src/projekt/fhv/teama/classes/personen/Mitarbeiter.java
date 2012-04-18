package projekt.fhv.teama.classes.personen;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private String nummer;
    private String passwort;
    private Date einstellung;
    private Set<Berechtigung> berechtigungen;
    private Set<Rechnung> rechnungen;
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
	
	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
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
    
	public Set<Berechtigung> getBerechtigungen() {
		return berechtigungen;
	}

	public void setBerechtigungen(Set<Berechtigung> berechtigungen2) {
		this.berechtigungen = berechtigungen2;
	}

	public void addBerechtigung (Berechtigung berechtigung) {
		berechtigungen.add(berechtigung);
	}

	public Set<Rechnung> getRechnungen() {
		return rechnungen;
	}

	public void setRechnungen(Set<Rechnung> rechnungen) {
		this.rechnungen = rechnungen;
	}
	
	public Mitarbeiter() {
		super();
	}
	
	public Mitarbeiter(String vorname, String nachname, char geschlecht,
			Set<Adresse> adresse, Date geburtsdatum, String telefonnummer,
			String email, Kontodaten bankverbindung, Land land,
			String nummer, String passwort, Date einstellung) {
		super(vorname, nachname, geschlecht, adresse, geburtsdatum,
				telefonnummer, email, bankverbindung, land);
		this.nummer = nummer;
		this.passwort = passwort;
		this.einstellung = einstellung;
		this.berechtigungen = new HashSet<Berechtigung>();
		this.rechnungen = new HashSet<Rechnung>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ID;
		result = prime * result
				+ ((berechtigungen == null) ? 0 : berechtigungen.hashCode());
		result = prime * result
				+ ((einstellung == null) ? 0 : einstellung.hashCode());
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		result = prime * result
				+ ((passwort == null) ? 0 : passwort.hashCode());
		result = prime * result
				+ ((rechnungen == null) ? 0 : rechnungen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mitarbeiter other = (Mitarbeiter) obj;
		if (ID != other.ID)
			return false;
		if (berechtigungen == null) {
			if (other.berechtigungen != null)
				return false;
		} else if (!berechtigungen.equals(other.berechtigungen))
			return false;
		if (einstellung == null) {
			if (other.einstellung != null)
				return false;
		} else if (!einstellung.equals(other.einstellung))
			return false;
		if (nummer == null) {
			if (other.nummer != null)
				return false;
		} else if (!nummer.equals(other.nummer))
			return false;
		if (passwort == null) {
			if (other.passwort != null)
				return false;
		} else if (!passwort.equals(other.passwort))
			return false;
		if (rechnungen == null) {
			if (other.rechnungen != null)
				return false;
		} else if (!rechnungen.equals(other.rechnungen))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mitarbeiter [ID=" + ID + ", nummer=" + nummer + ", passwort="
				+ passwort + ", einstellung=" + einstellung
				+ ", berechtigungen=" + berechtigungen + ", rechnungen="
				+ rechnungen + "]";
	}
}
