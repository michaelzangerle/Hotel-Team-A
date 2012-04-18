package projekt.fhv.teama.classes.zimmer;

import java.util.HashSet;
import java.util.Set;

import projekt.fhv.teama.classes.IKategoriekontingent;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Kategorie implements IKategorie {

	private int ID;
	private String bezeichnung;
	private String beschreibung;
	private Set<IZimmerpreis> zimmerpreise = new HashSet<IZimmerpreis>();
	private Set<ITeilreservierung> teilreservierungsreservierungen = new HashSet<ITeilreservierung>();
	private Set<IKategoriekontingent> kategoriekontingent = new HashSet<IKategoriekontingent>();
	private Set<IZimmer> zimmer = new HashSet<IZimmer>();

	public Kategorie(String bezeichnung, String beschreibung, Set<IZimmerpreis> zimmerpreise,
			Set<ITeilreservierung> teilreservierungsreservierungen, Set<IKategoriekontingent> kategoriekontingent,
			Set<IZimmer> zimmer) {

		this.bezeichnung = bezeichnung;
		this.beschreibung = beschreibung;
		this.zimmerpreise = zimmerpreise;
		this.teilreservierungsreservierungen = teilreservierungsreservierungen;
		this.kategoriekontingent = kategoriekontingent;
		this.zimmer = zimmer;
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

	public Set<IZimmerpreis> getZimmerpreise() {
		return zimmerpreise;
	}

	public void setZimmerpreise(Set<IZimmerpreis> zimmerpreise) {
		this.zimmerpreise = zimmerpreise;
	}

	public Set<ITeilreservierung> getTeilreservierungsreservierungen() {
		return teilreservierungsreservierungen;
	}

	public void setTeilreservierungsreservierungen(Set<ITeilreservierung> teilreservierungsreservierungen) {
		this.teilreservierungsreservierungen = teilreservierungsreservierungen;
	}

	public Set<IKategoriekontingent> getKategoriekontingent() {
		return kategoriekontingent;
	}

	public void setKategoriekontingent(Set<IKategoriekontingent> kategoriekontingent) {
		this.kategoriekontingent = kategoriekontingent;
	}

	public Set<IZimmer> getZimmer() {
		return zimmer;
	}

	public void setZimmer(Set<IZimmer> zimmer) {
		this.zimmer = zimmer;
	}

	@Override
	public String toString() {
		return "Kategorie [ID=" + ID + ", bezeichnung=" + bezeichnung + ", beschreibung=" + beschreibung
				+ ", zimmerpreise=" + zimmerpreise + ", teilreservierungsreservierungen="
				+ teilreservierungsreservierungen + ", kategoriekontingent=" + kategoriekontingent + ", zimmer="
				+ zimmer + "]";
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
		result = prime * result + ((zimmer == null) ? 0 : zimmer.hashCode());
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
		if (zimmer == null) {
			if (other.zimmer != null)
				return false;
		} else if (!zimmer.equals(other.zimmer))
			return false;
		if (zimmerpreise == null) {
			if (other.zimmerpreise != null)
				return false;
		} else if (!zimmerpreise.equals(other.zimmerpreise))
			return false;
		return true;
	}

	@Override
	public void addZimmer(IZimmer zimmer) {
		this.zimmer.add(zimmer);

	}

	@Override
	public void removeZimmer(IZimmer zimmer) {
		if (this.zimmerpreise.contains(zimmer)) {
			this.zimmerpreise.remove(zimmer);
		}

	}

	@Override
	public void addZimmerpreis(IZimmerpreis zimmerpreis) {
		this.zimmerpreise.add(zimmerpreis);

	}

	@Override
	public void removeZimmerpreis(IZimmerpreis zimmerpreis) {
		if (this.zimmerpreise.contains(zimmerpreis)) {
			this.zimmerpreise.remove(zimmerpreis);
		}
	}

	@Override
	public void addTeilreservierung(ITeilreservierung teilreservierung) {
		this.teilreservierungsreservierungen.add(teilreservierung);

	}

	@Override
	public void removeTeilreservierung(ITeilreservierung teilreservierung) {
		if (this.teilreservierungsreservierungen.contains(teilreservierung)) {
			this.teilreservierungsreservierungen.remove(teilreservierung);
		}

	}

}
