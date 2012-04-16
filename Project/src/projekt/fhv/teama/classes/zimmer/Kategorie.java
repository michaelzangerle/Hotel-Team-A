package projekt.fhv.teama.classes.zimmer;

import java.util.Set;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Kategorie {

	private int ID;
	private String bezeichnung;
	private String beschreibung;
	private Set<Zimmerpreis> zimmerpreise;
	private Set<Reservierung> reservierungen;

	public Kategorie(String bezeichnung, String beschreibung, Set<Zimmerpreis> zimmerpreise,
			Set<Reservierung> reservierungen) {
		this.bezeichnung = bezeichnung;
		this.beschreibung = beschreibung;
		this.zimmerpreise = zimmerpreise;
		this.reservierungen = reservierungen;
	}

	public Kategorie() {
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Set<Zimmerpreis> getZimmerpreise() {
		return zimmerpreise;
	}

	public void setZimmerpreise(Set<Zimmerpreis> zimmerpreise) {
		this.zimmerpreise = zimmerpreise;
	}

	public Set<Reservierung> getReservierungen() {
		return reservierungen;
	}

	public void setReservierungen(Set<Reservierung> reservierungen) {
		this.reservierungen = reservierungen;
	}

	@Override
	public String toString() {
		return "Kategorie [ID=" + ID + ", bezeichnung=" + bezeichnung + ", beschreibung=" + beschreibung
				+ ", zimmerpreise=" + zimmerpreise + ", reservierungen=" + reservierungen + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + ((reservierungen == null) ? 0 : reservierungen.hashCode());
		result = prime * result + ((zimmerpreise == null) ? 0 : zimmerpreise.hashCode());
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
		Kategorie other = (Kategorie) obj;
		if (ID != other.ID)
			return false;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		} else if (!beschreibung.equals(other.beschreibung))
			return false;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (reservierungen == null) {
			if (other.reservierungen != null)
				return false;
		} else if (!reservierungen.equals(other.reservierungen))
			return false;
		if (zimmerpreise == null) {
			if (other.zimmerpreise != null)
				return false;
		} else if (!zimmerpreise.equals(other.zimmerpreise))
			return false;
		return true;
	}

}
