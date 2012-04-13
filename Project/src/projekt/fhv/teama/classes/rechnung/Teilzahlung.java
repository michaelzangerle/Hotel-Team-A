package projekt.fhv.teama.classes.rechnung;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Teilzahlung {
    private int ID;
    private Rechnung rechnung;
    private float betrag;
    
    private List<Zahlungsmethode> zahlungsmethoden;

	public Teilzahlung(Rechnung rechnung, float betrag,
			List<Zahlungsmethode> zahlungsmethoden) {
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

	public Rechnung getRechnung() {
		return rechnung;
	}

	public void setRechnung(Rechnung rechnung) {
		this.rechnung = rechnung;
	}

	public float getBetrag() {
		return betrag;
	}

	public void setBetrag(float betrag) {
		this.betrag = betrag;
	}

	public List<Zahlungsmethode> getZahlungsmethoden() {
		return zahlungsmethoden;
	}

	public void setZahlungsmethoden(List<Zahlungsmethode> zahlungsmethoden) {
		this.zahlungsmethoden = zahlungsmethoden;
	}

	@Override
	public String toString() {
		return "Teilzahlung [ID=" + ID + ", rechnung=" + rechnung + ", betrag="
				+ betrag + ", zahlungsmethoden=" + zahlungsmethoden + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + Float.floatToIntBits(betrag);
		result = prime * result
				+ ((rechnung == null) ? 0 : rechnung.hashCode());
		result = prime
				* result
				+ ((zahlungsmethoden == null) ? 0 : zahlungsmethoden.hashCode());
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
		} else if (!rechnung.equals(other.rechnung))
			return false;
		if (zahlungsmethoden == null) {
			if (other.zahlungsmethoden != null)
				return false;
		} else if (!zahlungsmethoden.equals(other.zahlungsmethoden))
			return false;
		return true;
	}

	
}