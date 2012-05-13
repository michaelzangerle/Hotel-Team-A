package projekt.fhv.teama.classes.rechnung;

import java.util.Set;

import projekt.fhv.teama.classes.interfaces.teamb.IBTeilzahlung;
import projekt.fhv.teama.classes.interfaces.teamb.IBZahlungsmethode;

/**
 * Beschreibt eine Teilzahlung
 * @author Team A
 * @version 1.8
 */
public class Teilzahlung implements ITeilzahlung,IBTeilzahlung {
	private int ID;
	private IRechnung rechnung;
	private float betrag;

	private Set<IZahlungsmethode> zahlungsmethoden;

	public Teilzahlung(IRechnung rechnung, float betrag, Set<IZahlungsmethode> zahlungsmethoden) {
		this.rechnung = rechnung;
		this.betrag = betrag;
		this.zahlungsmethoden = zahlungsmethoden;
	}

	public Teilzahlung() {
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public IRechnung getRechnung() {
		return rechnung;
	}

	public void setRechnung(IRechnung rechnung) {
		this.rechnung = rechnung;
	}

	public float getBetrag() {
		return betrag;
	}

	public void setBetrag(float betrag) {
		this.betrag = betrag;
	}

	public Set<IZahlungsmethode> getZahlungsmethoden() {
		return zahlungsmethoden;
	}

	public void setZahlungsmethoden(Set<IZahlungsmethode> zahlungsmethoden) {
		this.zahlungsmethoden = zahlungsmethoden;
	}

	@Override
	public String toString() {
		return "Teilzahlung [ID=" + ID + ", rechnung=" + rechnung.getID() + ", betrag=" + betrag + ", zahlungsmethoden="
				+ zahlungsmethoden + "]";
	}

	@Override
	public void addZahlungsmethode(IZahlungsmethode zahlungsmethode) {
		this.zahlungsmethoden.add(zahlungsmethode);

	}

	@Override
	public void removeZahlungsmethode(IZahlungsmethode zahlungsmethode) {
		if (this.zahlungsmethoden.contains(zahlungsmethode)) {
			this.zahlungsmethoden.remove(zahlungsmethode);
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + Float.floatToIntBits(betrag);
		result = prime * result + ((rechnung == null) ? 0 : rechnung.getID());
		result = prime * result + ((zahlungsmethoden == null) ? 0 : zahlungsmethoden.hashCode());
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
		Teilzahlung other = (Teilzahlung) obj;
		if (ID != other.ID)
			return false;
		if (Float.floatToIntBits(betrag) != Float.floatToIntBits(other.betrag))
			return false;
		if (rechnung == null) {
			if (other.rechnung != null)
				return false;
		} else if (rechnung.getID() != other.rechnung.getID())
			return false;
		if (zahlungsmethoden == null) {
			if (other.zahlungsmethoden != null)
				return false;
		} else if (!zahlungsmethoden.equals(other.zahlungsmethoden))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see projekt.fhv.teama.classes.interfaces.teamb.IBTeilzahlung#getBZahlungsmethode()
	 */
	@Override
	public IBZahlungsmethode getBZahlungsmethode() {
		// TODO Auto-generated method stub
		return null;
	}

}
