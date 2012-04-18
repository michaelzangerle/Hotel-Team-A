package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Saison implements ISaison {

	private int ID;
	private String bezeichnung;
	private Date von;
	private Date bis;
	private Set<IZimmerpreis> zimmerpreise = new HashSet<IZimmerpreis>();

	public Saison(String bezeichnung, Date von, Date bis, Set<IZimmerpreis> zimmerpreise) {

		this.bezeichnung = bezeichnung;
		this.von = von;
		this.bis = bis;
		this.zimmerpreise = zimmerpreise;
	}

	public Saison() {

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



	public Set<IZimmerpreis> getZimmerpreise() {
		return zimmerpreise;
	}

	public void setZimmerpreise(Set<IZimmerpreis> zimmerpreise) {
		this.zimmerpreise = zimmerpreise;
	}

	@Override
	public String toString() {
		return "Saison [ID=" + ID + ", bezeichnung=" + bezeichnung + ", von=" + von + ", bis=" + bis
				+ ", zimmerpreise=" + zimmerpreise + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + ((bis == null) ? 0 : bis.hashCode());
		result = prime * result + ((von == null) ? 0 : von.hashCode());
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
		Saison other = (Saison) obj;
		if (ID != other.ID)
			return false;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
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
		if (zimmerpreise == null) {
			if (other.zimmerpreise != null)
				return false;
		} else if (!zimmerpreise.equals(other.zimmerpreise))
			return false;
		return true;
	}

	@Override
	public void addZimmerpreis(IZimmerpreis zimmerpreis) {
		this.zimmerpreise.add(zimmerpreis);
		
	}

	@Override
	public void removeZimmerpreis(IZimmerpreis zimmerpreis) {
		if(this.zimmerpreise.contains(zimmerpreis)){
			this.zimmerpreise.remove(zimmerpreis);
		}
		
	}

}
