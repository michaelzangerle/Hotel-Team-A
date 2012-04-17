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
    private int gastId;
    private String nummer;
    private Zimmer zimmer;
    private List<Reservierung> reservierungen;
    private List<Rechnungsposition> rechnungspositionen;
    private List<Aufenthalt> aufenthalte;
    
    public int getGastId() {
        return gastId;
    }

    public void setGastId(int gastId) {
        this.gastId = gastId;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
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
		if (aufenthalte == null) {
			if (other.aufenthalte != null)
				return false;
		} else if (!aufenthalte.equals(other.aufenthalte))
			return false;
		if (gastId != other.gastId)
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((aufenthalte == null) ? 0 : aufenthalte.hashCode());
		result = prime * result + gastId;
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		result = prime * result + ((rechnungspositionen == null) ? 0 : rechnungspositionen.hashCode());
		result = prime * result + ((reservierungen == null) ? 0 : reservierungen.hashCode());
		result = prime * result + ((zimmer == null) ? 0 : zimmer.hashCode());
		return result;
	}

	public Zimmer getZimmer() {
		return zimmer;
	}

	public void setZimmer(Zimmer zimmer) {
		this.zimmer = zimmer;
	}

	public List<Reservierung> getReservierungen() {
		return reservierungen;
	}

	public void setReservierungen(List<Reservierung> reservierungen) {
		this.reservierungen = reservierungen;
	}

	public List<Rechnungsposition> getRechnungspositionen() {
		return rechnungspositionen;
	}

	public void setRechnungspositionen(List<Rechnungsposition> rechnungspositionen) {
		this.rechnungspositionen = rechnungspositionen;
	}

	public List<Aufenthalt> getAufenthalte() {
		return aufenthalte;
	}

	public void setAufenthalte(List<Aufenthalt> aufenthalte) {
		this.aufenthalte = aufenthalte;
	}

	public Gast() {
		super();
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
	public String toString() {
		return "Gast [gastId=" + gastId + ", nummer=" + nummer + ", zimmer=" + zimmer + ", reservierungen="
				+ reservierungen + ", rechnungspositionen=" + rechnungspositionen + ", aufenthalte=" + aufenthalte
				+ "]";
	}


}
