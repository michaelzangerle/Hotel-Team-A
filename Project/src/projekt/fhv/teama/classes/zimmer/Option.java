package projekt.fhv.teama.classes.zimmer;


import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Option {
    private int ID;
    private Timestamp erfuellung;
    private short prozentsatz;
    private boolean erfuellt;
    private Reservierung reservierung;
    
	public Option(Timestamp erfuellung, short prozentsatz,
			boolean erfuellt, Reservierung reservierung) {
		this.erfuellung = erfuellung;
		this.prozentsatz = prozentsatz;
		this.erfuellt = erfuellt;
		this.reservierung = reservierung;
	}
	public Option() {

	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Timestamp getErfuellung() {
		return erfuellung;
	}
	public void setErfuellung(Timestamp erfuellung) {
		this.erfuellung = erfuellung;
	}
	public short getProzentsatz() {
		return prozentsatz;
	}
	public void setProzentsatz(short prozentsatz) {
		this.prozentsatz = prozentsatz;
	}
	public boolean isErfuellt() {
		return erfuellt;
	}
	public void setErfuellt(boolean erfuellt) {
		this.erfuellt = erfuellt;
	}
	public Reservierung getReservierung() {
		return reservierung;
	}
	public void setReservierung(Reservierung reservierung) {
		this.reservierung = reservierung;
	}
	@Override
	public String toString() {
		return "Option [ID=" + ID + ", erfuellung=" + erfuellung
				+ ", prozentsatz=" + prozentsatz + ", erfuellt=" + erfuellt
				+ ", reservierung=" + reservierung + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + (erfuellt ? 1231 : 1237);
		result = prime * result
				+ ((erfuellung == null) ? 0 : erfuellung.hashCode());
		result = prime * result + prozentsatz;
		result = prime * result
				+ ((reservierung == null) ? 0 : reservierung.hashCode());
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
		Option other = (Option) obj;
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
		} else if (!reservierung.equals(other.reservierung))
			return false;
		return true;
	}
    
    
    
   
}
