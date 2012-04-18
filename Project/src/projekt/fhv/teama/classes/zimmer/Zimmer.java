package projekt.fhv.teama.classes.zimmer;

import java.util.Set;

import projekt.fhv.teama.classes.Aufenthalt;
import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.rechnung.Rechnungsposition;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Zimmer {

	private int ID;
	private String nummer;
	private String beschreibung;
	private Kategorie kategorie;
	private Zimmerstatus zimmerStatus;

	/* Beziehungen */

	private Set<Reservierung> reservierungen;
	private Set<Statusentwicklung> statusenticklungen;
	private Set<Gast> gaeste;
	private Set<Aufenthalt> aufenthalte;
	private Set<Rechnungsposition> rechnungspositionen;

	public Zimmer(String nummer, String beschreibung, Kategorie kategorie, Zimmerstatus zimmerStatus,
			Set<Reservierung> reservierungen, Set<Statusentwicklung> statusenticklungen, Set<Gast> gaeste,
			Set<Aufenthalt> aufenthalte, Set<Rechnungsposition> rechnungspositionen) {
		this.nummer = nummer;
		this.beschreibung = beschreibung;
		this.kategorie = kategorie;
		this.zimmerStatus = zimmerStatus;
		this.reservierungen = reservierungen;
		this.statusenticklungen = statusenticklungen;
		this.gaeste = gaeste;
		this.aufenthalte = aufenthalte;
		this.rechnungspositionen = rechnungspositionen;
	}

	public Zimmer() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Kategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}

	public Zimmerstatus getZimmerStatus() {
		return zimmerStatus;
	}

	public void setZimmerStatus(Zimmerstatus zimmerStatus) {
		this.zimmerStatus = zimmerStatus;
	}

	public Set<Reservierung> getReservierungen() {
		return reservierungen;
	}

	public void setReservierungen(Set<Reservierung> reservierungen) {
		this.reservierungen = reservierungen;
	}

	public Set<Statusentwicklung> getStatusenticklungen() {
		return statusenticklungen;
	}

	public void setStatusenticklungen(Set<Statusentwicklung> statusenticklungen) {
		this.statusenticklungen = statusenticklungen;
	}

	public Set<Gast> getGaeste() {
		return gaeste;
	}

	public void setGaeste(Set<Gast> gaeste) {
		this.gaeste = gaeste;
	}

	public Set<Aufenthalt> getAufenthalte() {
		return aufenthalte;
	}

	public void setAufenthalte(Set<Aufenthalt> aufenthalte) {
		this.aufenthalte = aufenthalte;
	}

	public Set<Rechnungsposition> getRechnungspositionen() {
		return rechnungspositionen;
	}

	public void setRechnungspositionen(Set<Rechnungsposition> rechnungspositionen) {
		this.rechnungspositionen = rechnungspositionen;
	}

	@Override
	public String toString() {
		return "Zimmer [ID=" + ID + ", nummer=" + nummer + ", beschreibung=" + beschreibung + ", kategorie="
				+ kategorie + ", zimmerStatus=" + zimmerStatus + ", reservierungen=" + reservierungen
				+ ", statusenticklungen=" + statusenticklungen + ", gaeste=" + gaeste + ", aufenthalte=" + aufenthalte
				+ ", rechnungspositionen=" + rechnungspositionen + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((aufenthalte == null) ? 0 : aufenthalte.hashCode());
		result = prime * result + ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + ((gaeste == null) ? 0 : gaeste.hashCode());
		result = prime * result + ((kategorie == null) ? 0 : kategorie.hashCode());
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		result = prime * result + ((rechnungspositionen == null) ? 0 : rechnungspositionen.hashCode());
		result = prime * result + ((reservierungen == null) ? 0 : reservierungen.hashCode());
		result = prime * result + ((statusenticklungen == null) ? 0 : statusenticklungen.hashCode());
		result = prime * result + ((zimmerStatus == null) ? 0 : zimmerStatus.hashCode());
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
		Zimmer other = (Zimmer) obj;
		if (ID != other.ID)
			return false;
		if (aufenthalte == null) {
			if (other.aufenthalte != null)
				return false;
		} else if (!aufenthalte.equals(other.aufenthalte))
			return false;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		} else if (!beschreibung.equals(other.beschreibung))
			return false;
		if (gaeste == null) {
			if (other.gaeste != null)
				return false;
		} else if (!gaeste.equals(other.gaeste))
			return false;
		if (kategorie == null) {
			if (other.kategorie != null)
				return false;
		} else if (!kategorie.equals(other.kategorie))
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
		if (statusenticklungen == null) {
			if (other.statusenticklungen != null)
				return false;
		} else if (!statusenticklungen.equals(other.statusenticklungen))
			return false;
		if (zimmerStatus == null) {
			if (other.zimmerStatus != null)
				return false;
		} else if (!zimmerStatus.equals(other.zimmerStatus))
			return false;
		return true;
	}

}
