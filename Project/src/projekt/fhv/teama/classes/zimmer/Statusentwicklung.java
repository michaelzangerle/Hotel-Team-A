package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Statusentwicklung implements IStatusentwicklung {

	private int ID;
	private IZimmer zimmer;
	private IZimmerstatus zimmerStatus;
	private Date von;
	private Date bis;
	private String beschreibung;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public IZimmer getZimmer() {
		return zimmer;
	}

	public void setZimmer(IZimmer zimmer) {
		this.zimmer = zimmer;
	}

	public IZimmerstatus getZimmerStatus() {
		return zimmerStatus;
	}

	public void setZimmerStatus(IZimmerstatus zimmerStatus) {
		this.zimmerStatus = zimmerStatus;
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

	public Statusentwicklung() {

	}

	public Statusentwicklung(IZimmer zimmer, IZimmerstatus zimmerStatus, Date von, Date bis, String beschreibung) {
		super();
		this.zimmer = zimmer;
		this.zimmerStatus = zimmerStatus;
		this.von = von;
		this.bis = bis;
		this.beschreibung = beschreibung;
	}

	@Override
	public String toString() {
		return "Statusentwicklung [zimmer=" + zimmer.getID() + ", zimmerStatus=" + zimmerStatus.getBezeichnung() + ", von=" + von + ", bis="
				+ bis + ", beschreibung=" + beschreibung + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + ((bis == null) ? 0 : bis.hashCode());
		result = prime * result + ((von == null) ? 0 : von.hashCode());
		result = prime * result + ((zimmer == null) ? 0 : zimmer.getID());
		result = prime * result + ((zimmerStatus == null) ? 0 : zimmerStatus.getBezeichnung().hashCode());
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
		} else if (zimmer.getID() != other.zimmer.getID())
			return false;
		if (zimmerStatus == null) {
			if (other.zimmerStatus != null)
				return false;
		} else if (!zimmerStatus.getBezeichnung().equals(other.zimmerStatus.getBezeichnung()))
			return false;
		return true;
	}
}
