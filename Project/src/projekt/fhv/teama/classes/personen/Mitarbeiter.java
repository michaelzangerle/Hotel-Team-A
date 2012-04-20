package projekt.fhv.teama.classes.personen;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import projekt.fhv.teama.classes.rechnung.IRechnung;


/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Mitarbeiter extends Person implements IMitarbeiter {
//    private int ID;
    private String nummer;
    private String passwort;
    private Date einstellung;
    private Set<IBerechtigung> berechtigungen;
    private Set<IRechnung> rechnungen;
    
//    public int getID() {
//        return ID;
//    }
//
//    public void setID(int ID) {
//        this.ID = ID;
//    }
	
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
    
	public Set<IBerechtigung> getBerechtigungen() {
		return berechtigungen;
	}

	public void setBerechtigungen(Set<IBerechtigung> berechtigungen) {
		this.berechtigungen = berechtigungen;
	}

	public void addBerechtigung (IBerechtigung berechtigung) {
		this.berechtigungen.add(berechtigung);
	}
	
	@Override
	public void removeBerechtigung(IBerechtigung berechtigung) {
		this.berechtigungen.remove(berechtigung);
	}

	public Set<IRechnung> getRechnungen() {
		return rechnungen;
	}

	public void setRechnungen(Set<IRechnung> rechnungen) {
		this.rechnungen = rechnungen;
	}
	
	@Override
	public void addRechnung(IRechnung rechnung) {
		this.rechnungen.add(rechnung);
	}

	@Override
	public void removeRechnung(IRechnung rechnung) {
		if (rechnungen.contains(rechnung)) {
			this.rechnungen.remove(rechnung);
		}
	}
	
	public Mitarbeiter() {
		super();
	}
	
	public Mitarbeiter(String vorname, String nachname, char geschlecht,
			Set<IAdresse> adresse, Date geburtsdatum, String telefonnummer,
			String email, IKontodaten bankverbindung,
			String nummer, String passwort, Date einstellung) {
		super(vorname, nachname, geschlecht, adresse, geburtsdatum,
				telefonnummer, email, bankverbindung);
		this.nummer = nummer;
		this.passwort = passwort;
		this.einstellung = einstellung;
		this.berechtigungen = new HashSet<IBerechtigung>();
		this.rechnungen = new HashSet<IRechnung>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + getID();
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
		if (getID() != other.getID())
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
		return "Mitarbeiter [ID=" + getID() 
				+ ", nummer=" + nummer 
				+ ", passwort=" + passwort 
				+ ", einstellung=" + einstellung
				+ ", berechtigungen=" + berechtigungen 
				+ ", rechnungen=" + rechnungen 
				+ "]";
	}
}
