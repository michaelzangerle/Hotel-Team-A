package projekt.fhv.teama.classes.zimmer;

import java.util.Date;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Statusentwicklung {

	private int ID;
	private Zimmerstatus zimmerStatus;
	private Date von;
	private Date bis;
	private String beschreibung;
	private Zimmer zimmer;

	public Zimmer getZimmer() {
		return zimmer;
	}

	public void setZimmer(Zimmer zimmer) {
		this.zimmer = zimmer;
	}

	public Date getVon() {
		return von;
	}

	public void setVon(Date von) {
		this.von = von;
	}

	public Date getBis() {
		return bis;
	}

	public void setBis(Date bis) {
		this.bis = bis;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Zimmerstatus getZimmerStatus() {
		return zimmerStatus;
	}

	public void setZimmerStatus(Zimmerstatus zimmerStatus) {
		this.zimmerStatus = zimmerStatus;
	}

	public Statusentwicklung() {
	}
	
	

	public Statusentwicklung(int iD, Zimmerstatus zimmerStatus, Date von,
			Date bis, String beschreibung, Zimmer zimmer) {
		ID = iD;
		this.zimmerStatus = zimmerStatus;
		this.von = von;
		this.bis = bis;
		this.beschreibung = beschreibung;
		this.zimmer = zimmer;
	}

	@Override
	public String toString() {
		return "Statusentwicklung [ID=" + ID + ", zimmerStatus=" + zimmerStatus
				+ ", von=" + von + ", bis=" + bis + ", beschreibung="
				+ beschreibung + ", zimmer=" + zimmer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result
				+ ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + ((bis == null) ? 0 : bis.hashCode());
		result = prime * result + ((von == null) ? 0 : von.hashCode());
		result = prime * result + ((zimmer == null) ? 0 : zimmer.hashCode());
		result = prime * result
				+ ((zimmerStatus == null) ? 0 : zimmerStatus.hashCode());
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
		Statusentwicklung other = (Statusentwicklung) obj;
		if (ID != other.ID)
			return false;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		} else if (!beschreibung.equals(other.beschreibung))
			return false;
		if (bis == null) {
			if (other.bis != null)
				return false;
		} else if (!bis.equals(other.bis))
			return false;
		if (von == null) {
			if (other.von != null)
				return false;
		} else if (!von.equals(other.von))
			return false;
		if (zimmer == null) {
			if (other.zimmer != null)
				return false;
		} else if (!zimmer.equals(other.zimmer))
			return false;
		if (zimmerStatus == null) {
			if (other.zimmerStatus != null)
				return false;
		} else if (!zimmerStatus.equals(other.zimmerStatus))
			return false;
		return true;
	}

	
}
