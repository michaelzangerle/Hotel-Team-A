package projekt.fhv.teama.classes.zimmer;

import java.util.Set;

import projekt.fhv.teama.classes.Kategoriekontingent;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Kategorie {

	private int ID;
	private String bezeichnung;
	private String beschreibung;
	private Set<Zimmerpreis> zimmerpreise;
	private Set<Teilreservierung> teilreservierungsreservierungen;
	private Set<Kategoriekontingent> kategoriekontingent;
	

	public Set<Kategoriekontingent> getKategoriekontingent() {
		return kategoriekontingent;
	}

	public void setKategoriekontingent(Set<Kategoriekontingent> kategoriekontingent) {
		this.kategoriekontingent = kategoriekontingent;
	}

	public Kategorie(String bezeichnung, String beschreibung, Set<Zimmerpreis> zimmerpreise,
			Set<Teilreservierung> teilreservierungsreservierungen, Set<Kategoriekontingent> kategoriekontingent) {
		this.bezeichnung = bezeichnung;
		this.beschreibung = beschreibung;
		this.zimmerpreise = zimmerpreise;
		this.teilreservierungsreservierungen = teilreservierungsreservierungen;
		this.kategoriekontingent = kategoriekontingent;
	}

	public Kategorie() {
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

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Set<Zimmerpreis> getZimmerpreise() {
		return zimmerpreise;
	}

	public void setZimmerpreise(Set<Zimmerpreis> zimmerpreise) {
		this.zimmerpreise = zimmerpreise;
	}

	
	public Set<Teilreservierung> getTeilreservierungsreservierungen() {
		return teilreservierungsreservierungen;
	}

	public void setTeilreservierungsreservierungen(Set<Teilreservierung> teilreservierungsreservierungen) {
		this.teilreservierungsreservierungen = teilreservierungsreservierungen;
	}

	@Override
	public String toString() {
		return "Kategorie [ID=" + ID + ", bezeichnung=" + bezeichnung + ", beschreibung=" + beschreibung
				+ ", zimmerpreise=" + zimmerpreise + ", teilreservierungsreservierungen="
				+ teilreservierungsreservierungen + ", kategoriekontingent=" + kategoriekontingent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + ((kategoriekontingent == null) ? 0 : kategoriekontingent.hashCode());
		result = prime * result
				+ ((teilreservierungsreservierungen == null) ? 0 : teilreservierungsreservierungen.hashCode());
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
		Kategorie other = (Kategorie) obj;
		if (ID != other.ID)
			return false;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		} else if (!beschreibung.equals(other.beschreibung))
			return false;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (kategoriekontingent == null) {
			if (other.kategoriekontingent != null)
				return false;
		} else if (!kategoriekontingent.equals(other.kategoriekontingent))
			return false;
		if (teilreservierungsreservierungen == null) {
			if (other.teilreservierungsreservierungen != null)
				return false;
		} else if (!teilreservierungsreservierungen.equals(other.teilreservierungsreservierungen))
			return false;
		if (zimmerpreise == null) {
			if (other.zimmerpreise != null)
				return false;
		} else if (!zimmerpreise.equals(other.zimmerpreise))
			return false;
		return true;
	}

}
