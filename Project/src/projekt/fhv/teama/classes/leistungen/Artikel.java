package projekt.fhv.teama.classes.leistungen;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Artikel extends Leistung {
	
//	private int artikelID;
	private float preis;
	private String beschreibung;
	private Warengruppe warengruppe;

	public Artikel(float preis, String bezeichnung, String beschreibung, Warengruppe warengruppe) {
		this.preis = preis;
		this.beschreibung = beschreibung;
		this.warengruppe = warengruppe;
		setBezeichnung(bezeichnung);
	}

	public Artikel() {
		super();
	}

//	public int getArtikelID() {
//		return artikelID;
//	}
//
//	public void setArtikelID(int artikelID) {
//		this.artikelID = artikelID;
//	}

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

	public Warengruppe getWarengruppe() {
		return warengruppe;
	}

	public void setWarengruppe(Warengruppe warengruppe) {
		this.warengruppe = warengruppe;
	}

	@Override
	public String toString() {
		return "Artikel [artikelID=" + getID() + ", preis=" + preis + ", beschreibung=" + beschreibung
				+ ", warengruppe=" + warengruppe.getID() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + getID();
		result = prime * result + ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + Float.floatToIntBits(preis);
		//result = prime * result + ((warengruppe == null) ? 0 : warengruppe.hashCode());
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
		Artikel other = (Artikel) obj;
		if (getID() != other.getID())
			return false;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		} else if (!beschreibung.equals(other.beschreibung))
			return false;
		if (Float.floatToIntBits(preis) != Float.floatToIntBits(other.preis))
			return false;
		if (warengruppe == null) {
			if (other.warengruppe != null)
				return false;
		} else if (!warengruppe.equals(other.warengruppe))
			return false;
		return true;
	}


	

}
