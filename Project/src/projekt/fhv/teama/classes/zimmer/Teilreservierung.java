/**
 * 
 */
package projekt.fhv.teama.classes.zimmer;

/**
 * Beschreibt eine Teilreservierung
 * @author Team A
 * @version 1.2
 */
public class Teilreservierung implements ITeilreservierung {

	private int ID;
	private IKategorie kategorie;
	private IReservierung reservierung;
	private int anzahl;

	public Teilreservierung(IKategorie kategorie, IReservierung reservierung, int anzahl) {
		this.kategorie = kategorie;
		this.reservierung = reservierung;
		this.anzahl = anzahl;
	}

	public Teilreservierung() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public IKategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(IKategorie kategorie) {
		this.kategorie = kategorie;
	}

	public IReservierung getReservierung() {
		return reservierung;
	}

	public void setReservierung(IReservierung reservierung) {
		this.reservierung = reservierung;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	@Override
	public String toString() {
		return "Teilreservierung [ID=" + ID 
				+ ", kategorie=" + kategorie.getBezeichnung() 
//				+ ", reservierung=" + reservierung.getID()
				+ ", anzahl=" + anzahl + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + anzahl;
		result = prime * result + ((kategorie == null) ? 0 : kategorie.getBezeichnung().hashCode());
		result = prime * result + ((reservierung == null) ? 0 : reservierung.getID());
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
		Teilreservierung other = (Teilreservierung) obj;
		if (ID != other.ID)
			return false;
		if (anzahl != other.anzahl)
			return false;
		if (kategorie == null) {
			if (other.kategorie != null)
				return false;
		} else if (kategorie.getID() != other.kategorie.getID())
			return false;
		if (reservierung == null) {
			if (other.reservierung != null)
				return false;
		} else if (reservierung.getID() != other.reservierung.getID())
			return false;
		return true;
	}
}
