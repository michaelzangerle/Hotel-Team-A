package projekt.fhv.teama.classes.leistungen;

import java.util.Set;

import projekt.fhv.teama.classes.rechnung.Rechnungsposition;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Zusatzleistung extends Leistung{
	
	private float preis;
	private String beschreibung;
	private boolean extern;
	private Warengruppe warengruppe;

	public Zusatzleistung(float preis, String bezeichnung, String beschreibung, boolean extern, Warengruppe warengruppe,Set<Rechnungsposition> rechnungspositionen) {
		this.preis = preis;
		this.beschreibung = beschreibung;
		this.extern = extern;
		this.warengruppe = warengruppe;
		setBezeichnung(bezeichnung);
	}

	public Zusatzleistung() {
		super();
	}

	public float getPreis() {
		return preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public boolean isExtern() {
		return extern;
	}

	public void setExtern(boolean extern) {
		this.extern = extern;
	}

	public Warengruppe getWarengruppe() {
		return warengruppe;
	}

	public void setWarengruppe(Warengruppe warengruppe) {
		this.warengruppe = warengruppe;
	}


	@Override
	public String toString() {
		return "Zusatzleistung [preis=" + preis + ", beschreibung=" + beschreibung + ", extern=" + extern
				+ ", warengruppe=" + warengruppe.getBezeichnung() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + (extern ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(preis);
		result = prime * result + ((warengruppe == null) ? 0 : warengruppe.getBezeichnung().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zusatzleistung other = (Zusatzleistung) obj;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		} else if (!beschreibung.equals(other.beschreibung))
			return false;
		if (extern != other.extern)
			return false;
		if (Float.floatToIntBits(preis) != Float.floatToIntBits(other.preis))
			return false;
		if (warengruppe == null) {
			if (other.warengruppe != null)
				return false;
		} else if (!warengruppe.getBezeichnung().equals(other.warengruppe.getBezeichnung()))
			return false;
		return true;
	}

	
}
