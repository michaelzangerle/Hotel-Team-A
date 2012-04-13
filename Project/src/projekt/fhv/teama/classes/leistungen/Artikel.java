package projekt.fhv.teama.classes.leistungen;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Artikel {
	private int ID;
	private float preis;
	private String beschreibung;
	private Warengruppe warengruppe;

	public Artikel(float preis, String beschreibung, Warengruppe warengruppe) {

		this.preis = preis;
		this.beschreibung = beschreibung;
		this.warengruppe = warengruppe;
	}

	public Artikel() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public Warengruppe getWarengruppe() {
		return warengruppe;
	}

	public void setWarengruppe(Warengruppe warengruppe) {
		this.warengruppe = warengruppe;
	}

	@Override
	public String toString() {
		return "Artikel [ID=" + ID + ", preis=" + preis + ", beschreibung="
				+ beschreibung + ", warengruppe=" + warengruppe + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result
				+ ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + Float.floatToIntBits(preis);
		result = prime * result
				+ ((warengruppe == null) ? 0 : warengruppe.hashCode());
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
		Artikel other = (Artikel) obj;
		if (ID != other.ID)
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
