package projekt.fhv.teama.classes.rechnung;

import java.math.BigDecimal;

import projekt.fhv.teama.classes.interfaces.teamb.IBTeilzahlung;
import projekt.fhv.teama.classes.interfaces.teamb.IBZahlungsmethode;
/**
 * Beschreibt eine Teilzahlung
 * @author Team A
 * @version 1.8
 */
public class Teilzahlung implements ITeilzahlung,IBTeilzahlung{
	private int ID;
	private IRechnung rechnung;
	private float betrag;

	private IZahlungsmethode zahlungsmethode;

	public Teilzahlung(IRechnung rechnung, float betrag, IZahlungsmethode zahlungsmethoden) {
		this.rechnung = rechnung;
		this.betrag = betrag;
		this.zahlungsmethode = zahlungsmethoden;
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

	public IZahlungsmethode getZahlungsmethode() {
		return zahlungsmethode;
	}

	public void setZahlungsmethode(IZahlungsmethode zahlungsmethode) {
		this.zahlungsmethode = zahlungsmethode;
	}

	@Override
	public String toString() {
		return "Teilzahlung [ID=" + ID + ", rechnung=" + rechnung.getID() + ", betrag=" + betrag + ", zahlungsmethoden="
				+ zahlungsmethode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + Float.floatToIntBits(betrag);
		result = prime * result + ((rechnung == null) ? 0 : rechnung.getID());
		result = prime * result + ((zahlungsmethode == null) ? 0 : zahlungsmethode.hashCode());
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
		if (zahlungsmethode == null) {
			if (other.zahlungsmethode != null)
				return false;
		} else if (!zahlungsmethode.equals(other.zahlungsmethode))
			return false;
		return true;
	}

	@Override
	public IBZahlungsmethode getBZahlungsmethode() {
		return (IBZahlungsmethode) this.getZahlungsmethode();
	}

	@Override
	public BigDecimal getBBetrag() {
		return new BigDecimal(this.getBetrag());
	}

}
