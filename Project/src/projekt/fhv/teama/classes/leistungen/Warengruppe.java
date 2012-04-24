package projekt.fhv.teama.classes.leistungen;

import java.util.HashSet;
import java.util.Set;

/**
 * Beschreibt eine Warengruppe
 * @author Team A
 *
 */
public class Warengruppe implements IWarengruppe {

	private int ID;
	private String bezeichnung;
	private short steuersatz;
	private String beschreibung;

	public Set<IZusatzleistung> zusatzleistungen = new HashSet<IZusatzleistung>();
	public Set<IArtikel> artikel = new HashSet<IArtikel>();

	public Warengruppe(String bezeichung, short steuersatz, String beschreibung, Set<IZusatzleistung> zusatzleistungen,
			Set<IArtikel> artikel) {

		this.bezeichnung = bezeichung;
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

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
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

	public Set<IZusatzleistung> getZusatzleistungen() {
		return zusatzleistungen;
	}

	public void setZusatzleistungen(Set<IZusatzleistung> zusatzleistungen) {
		this.zusatzleistungen = zusatzleistungen;
	}

	public Set<IArtikel> getArtikel() {
		return artikel;
	}

	public void setArtikel(Set<IArtikel> artikel) {
		this.artikel = artikel;
	}

	@Override
	public String toString() {
		return "Warengruppe [ID=" + ID + ", bezeichung=" + bezeichnung + ", steuersatz=" + steuersatz
				+ ", beschreibung=" + beschreibung + ", zusatzleistungen=" + zusatzleistungen + ", artikel=" + artikel
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((artikel == null) ? 0 : artikel.hashCode());
		result = prime * result + ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + steuersatz;
		result = prime * result + ((zusatzleistungen == null) ? 0 : zusatzleistungen.hashCode());
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
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
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

	@Override
	public void addArtikel(IArtikel artikel) {
		this.artikel.add(artikel);

	}

	@Override
	public void removeArtikel(IArtikel artikel) {
		if (zusatzleistungen.contains(artikel)) {
			this.artikel.remove(artikel);
		}
	}

	@Override
	public void addZusatzleistung(IZusatzleistung zusatzleistung) {
		this.zusatzleistungen.add(zusatzleistung);

	}

	@Override
	public void removeZusatzleistung(IZusatzleistung zusatzleistung) {
		if (zusatzleistungen.contains(zusatzleistung)) {
			zusatzleistungen.remove(zusatzleistung);
		}

	}

}
