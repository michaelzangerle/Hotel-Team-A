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
	private List<Artikel> artikel;
	
	public Warengruppe(String bezeichung, short steuersatz,
			String beschreibung, List<Zusatzleistung> zusatzleistungen,
			List<Artikel> artikel) {

		this.bezeichung = bezeichung;
		this.steuersatz = steuersatz;
		this.beschreibung = beschreibung;
		this.zusatzleistungen = zusatzleistungen;
		this.artikel = artikel;
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
		return artikel;
	}
	public void setArtikels(List<Artikel> artikels) {
		this.artikel = artikels;
	}
	@Override
	public String toString() {
		return "Warengruppe [ID=" + ID + ", bezeichung=" + bezeichung
				+ ", steuersatz=" + steuersatz + ", beschreibung="
				+ beschreibung + ", zusatzleistungen=" + zusatzleistungen
				+ ", artikels=" + artikel + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result
				+ ((artikel == null) ? 0 : artikel.hashCode());
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
		if (artikel == null) {
			if (other.artikel != null)
				return false;
		} else if (!artikel.equals(other.artikel))
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
