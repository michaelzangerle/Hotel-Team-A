package projekt.fhv.teama.classes.leistungen;

import java.util.List;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Warengruppe {
	
	private int ID;
	private String bezeichung;
	private short steuersatz;
	private String beschreibung;
	
	private List<Zusatzleistung> zusatzleistungen;
	private List<Artikel> artikels;
	
	public Warengruppe(String bezeichung, short steuersatz,
			String beschreibung, List<Zusatzleistung> zusatzleistungen,
			List<Artikel> artikels) {

		this.bezeichung = bezeichung;
		this.steuersatz = steuersatz;
		this.beschreibung = beschreibung;
		this.zusatzleistungen = zusatzleistungen;
		this.artikels = artikels;
	}
	
	public Warengruppe() {

	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getBezeichung() {
		return bezeichung;
	}
	public void setBezeichung(String bezeichung) {
		this.bezeichung = bezeichung;
	}
	public short getSteuersatz() {
		return steuersatz;
	}
	public void setSteuersatz(short steuersatz) {
		this.steuersatz = steuersatz;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public List<Zusatzleistung> getZusatzleistungen() {
		return zusatzleistungen;
	}
	public void setZusatzleistungen(List<Zusatzleistung> zusatzleistungen) {
		this.zusatzleistungen = zusatzleistungen;
	}
	public List<Artikel> getArtikels() {
		return artikels;
	}
	public void setArtikels(List<Artikel> artikels) {
		this.artikels = artikels;
	}
	@Override
	public String toString() {
		return "Warengruppe [ID=" + ID + ", bezeichung=" + bezeichung
				+ ", steuersatz=" + steuersatz + ", beschreibung="
				+ beschreibung + ", zusatzleistungen=" + zusatzleistungen
				+ ", artikels=" + artikels + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result
				+ ((artikels == null) ? 0 : artikels.hashCode());
		result = prime * result
				+ ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result
				+ ((bezeichung == null) ? 0 : bezeichung.hashCode());
		result = prime * result + steuersatz;
		result = prime
				* result
				+ ((zusatzleistungen == null) ? 0 : zusatzleistungen.hashCode());
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
		Warengruppe other = (Warengruppe) obj;
		if (ID != other.ID)
			return false;
		if (artikels == null) {
			if (other.artikels != null)
				return false;
		} else if (!artikels.equals(other.artikels))
			return false;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		} else if (!beschreibung.equals(other.beschreibung))
			return false;
		if (bezeichung == null) {
			if (other.bezeichung != null)
				return false;
		} else if (!bezeichung.equals(other.bezeichung))
			return false;
		if (steuersatz != other.steuersatz)
			return false;
		if (zusatzleistungen == null) {
			if (other.zusatzleistungen != null)
				return false;
		} else if (!zusatzleistungen.equals(other.zusatzleistungen))
			return false;
		return true;
	}
	
	
	
	

}
