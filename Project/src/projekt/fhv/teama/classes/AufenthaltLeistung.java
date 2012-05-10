/**
 * 
 */
package projekt.fhv.teama.classes;

import java.sql.Date;

import projekt.fhv.teama.classes.leistungen.ILeistung;

/**
 * Beschreibt die Zuordnung von Leistungen zu einem Aufenthalt
 * 
 * @author Team A
 * @version 1.2
 */
public class AufenthaltLeistung {

	private int ID;
	private ILeistung leistung;
	private IAufenthalt aufenthalt;
	private int anzahl;
	private Date datum;

	public AufenthaltLeistung(ILeistung paket, IAufenthalt aufenthalt, int anzahl, Date datum) {
		this.leistung = paket;
		this.aufenthalt = aufenthalt;
		this.anzahl = anzahl;
		this.datum = datum;
	}

	public AufenthaltLeistung() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public ILeistung getPaket() {
		return leistung;
	}

	public void setPaket(ILeistung paket) {
		this.leistung = paket;
	}

	public IAufenthalt getAufenthalt() {
		return aufenthalt;
	}

	public void setAufenthalt(IAufenthalt aufenthalt) {
		this.aufenthalt = aufenthalt;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "AufentLeistung [ID=" + ID + ", paket=" + leistung.getID() + ", aufenthalt=" + aufenthalt.getID() + ", anzahl=" + anzahl
				+ ", datum=" + datum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + anzahl;
		result = prime * result + ((aufenthalt == null) ? 0 : aufenthalt.getID());
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + ((leistung == null) ? 0 : leistung.getID());
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
		AufenthaltLeistung other = (AufenthaltLeistung) obj;
		if (ID != other.ID)
			return false;
		if (anzahl != other.anzahl)
			return false;
		if (aufenthalt == null) {
			if (other.aufenthalt != null)
				return false;
		} else if (aufenthalt.getID() != other.aufenthalt.getID())
			return false;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (leistung == null) {
			if (other.leistung != null)
				return false;
		} else if (leistung.getID() != other.leistung.getID())
			return false;
		return true;
	}

}
