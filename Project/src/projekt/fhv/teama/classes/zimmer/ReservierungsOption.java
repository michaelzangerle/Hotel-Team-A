package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;

/**
 * Beschreibt eine Reservierungsoption
 * @author Team A
 * @version 1.2
 */
public class ReservierungsOption implements IReservierungsOption {
	private int ID;
	private Date erfuellung;
	private short prozentsatz;
	private boolean erfuellt;
	private IReservierung reservierung;

	public ReservierungsOption(Date date, short prozentsatz, boolean erfuellt, IReservierung reservierung) {
		this.erfuellung = date;
		this.prozentsatz = prozentsatz;
		this.erfuellt = erfuellt;
		this.reservierung = reservierung;
	}

	public ReservierungsOption() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Date getErfuellung() {
		return erfuellung;
	}

	public void setErfuellung(Date erfuellung) {
		this.erfuellung = erfuellung;
	}

	public short getProzentsatz() {
		return prozentsatz;
	}

	public void setProzentsatz(short prozentsatz) {
		this.prozentsatz = prozentsatz;
	}

	public boolean getErfuellt() {
		return erfuellt;
	}

	public void setErfuellt(boolean erfuellt) {
		this.erfuellt = erfuellt;
	}

	public IReservierung getReservierung() {
		return reservierung;
	}

	public void setReservierung(IReservierung reservierung) {
		this.reservierung = reservierung;
	}

	@Override
	public String toString() {
		return "Option [ID=" + ID + ", erfuellung=" + erfuellung + ", prozentsatz=" + prozentsatz + ", erfuellt="
				+ erfuellt + ", reservierung=" + reservierung.getID() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + (erfuellt ? 1231 : 1237);
		result = prime * result + ((erfuellung == null) ? 0 : erfuellung.hashCode());
		result = prime * result + prozentsatz;
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
		ReservierungsOption other = (ReservierungsOption) obj;
		if (ID != other.ID)
			return false;
		if (erfuellt != other.erfuellt)
			return false;
		if (erfuellung == null) {
			if (other.erfuellung != null)
				return false;
		} else if (!erfuellung.equals(other.erfuellung))
			return false;
		if (prozentsatz != other.prozentsatz)
			return false;
		if (reservierung == null) {
			if (other.reservierung != null)
				return false;
		} else if (reservierung.getID() != other.reservierung.getID())
			return false;
		return true;
	}

	
}
