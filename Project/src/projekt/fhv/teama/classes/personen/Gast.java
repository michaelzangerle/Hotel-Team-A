package projekt.fhv.teama.classes.personen;

import java.util.Date;
import java.util.List;
import java.util.Set;

import projekt.fhv.teama.classes.Aufenthalt;
import projekt.fhv.teama.classes.rechnung.Rechnungsposition;
import projekt.fhv.teama.classes.zimmer.Reservierung;
import projekt.fhv.teama.classes.zimmer.Zimmer;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Gast extends Person {
    private int ID;
    private String nummer;
    private Zimmer zimmer;
    private Set<Reservierung> reservierungen;
    private Set<Rechnungsposition> rechnungspositionen;
    private Set<Aufenthalt> aufenthalte;
    
    public int getGastId() {
        return ID;
    }

    public void setGastId(int gastId) {
        this.ID = gastId;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

	public Zimmer getZimmer() {
		return zimmer;
	}

	public void setZimmer(Zimmer zimmer) {
		this.zimmer = zimmer;
	}

	public Set<Reservierung> getReservierungen() {
		return reservierungen;
	}

	public void setReservierungen(Set<Reservierung> reservierungen) {
		this.reservierungen = reservierungen;
	}

	public Set<Rechnungsposition> getRechnungspositionen() {
		return rechnungspositionen;
	}

	public void setRechnungspositionen(Set<Rechnungsposition> rechnungspositionen) {
		this.rechnungspositionen = rechnungspositionen;
	}

	public Set<Aufenthalt> getAufenthalte() {
		return aufenthalte;
	}

	public void setAufenthalte(Set<Aufenthalt> aufenthalte) {
		this.aufenthalte = aufenthalte;
	}
	

	public Gast() {
		super();
	}
	
	public Gast(String vorname, String nachname, char geschlecht,
			Set<Adresse> adresse, Date geburtsdatum, String telefonnummer,
			String email, Kontodaten bankverbindung, Land land, String nummer) {
		super(vorname, nachname, geschlecht, adresse, geburtsdatum, telefonnummer,
				email, bankverbindung, land);
		this.nummer = nummer;
	}

	public Gast(String vorname, String nachname, char geschlecht,
			Set<Adresse> adresse, Date geburtsdatum, String telefonnummer,
			String email, Kontodaten bankverbindung, Land land, String nummer, Zimmer zimmer) {
		super(vorname, nachname, geschlecht, adresse, geburtsdatum, telefonnummer,
				email, bankverbindung, land);
		this.nummer = nummer;
		this.zimmer = zimmer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ID;
		result = prime * result
				+ ((aufenthalte == null) ? 0 : aufenthalte.hashCode());
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		result = prime
				* result
				+ ((rechnungspositionen == null) ? 0 : rechnungspositionen
						.hashCode());
		result = prime * result
				+ ((reservierungen == null) ? 0 : reservierungen.hashCode());
		result = prime * result + ((zimmer == null) ? 0 : zimmer.hashCode());
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
		Gast other = (Gast) obj;
		if (ID != other.ID)
			return false;
		if (aufenthalte == null) {
			if (other.aufenthalte != null)
				return false;
		} else if (!aufenthalte.equals(other.aufenthalte))
			return false;
		if (nummer == null) {
			if (other.nummer != null)
				return false;
		} else if (!nummer.equals(other.nummer))
			return false;
		if (rechnungspositionen == null) {
			if (other.rechnungspositionen != null)
				return false;
		} else if (!rechnungspositionen.equals(other.rechnungspositionen))
			return false;
		if (reservierungen == null) {
			if (other.reservierungen != null)
				return false;
		} else if (!reservierungen.equals(other.reservierungen))
			return false;
		if (zimmer == null) {
			if (other.zimmer != null)
				return false;
		} else if (!zimmer.equals(other.zimmer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gast [ID=" + ID + ", nummer=" + nummer + ", zimmer=" + zimmer
				+ ", reservierungen=" + reservierungen
				+ ", rechnungspositionen=" + rechnungspositionen
				+ ", aufenthalte=" + aufenthalte + "]";
	}
}
