package projekt.fhv.teama.classes.leistungen;


/**
 * Beschreibt die Leistung Artikel 
 * @author Team A
 * @version 1.8
 */
public class Artikel extends Leistung implements IArtikel{
	
	private float preis;
	private String beschreibung;
	private IWarengruppe warengruppe;
	private String bezeichnung;

	public Artikel(float preis, String bezeichnung, String beschreibung, IWarengruppe warengruppe) {
		this.preis = preis;
		this.bezeichnung = bezeichnung;
		this.beschreibung = beschreibung;
		this.warengruppe = warengruppe;
		setBezeichnung(bezeichnung);
	}
	
	public Artikel(float preis, String beschreibung, IWarengruppe warengruppe) {
		this.preis = preis;
		this.beschreibung = beschreibung;
		this.warengruppe = warengruppe;
		setBezeichnung(bezeichnung);
	}
	
	
	public Artikel() {

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

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public IWarengruppe getWarengruppe() {
		return warengruppe;
	}

	public void setWarengruppe(IWarengruppe warengruppe) {
		this.warengruppe = warengruppe;
	}

	@Override
	public String toString() {
		return "Artikel [preis=" + preis + ", beschreibung=" + beschreibung + ", warengruppe=" + warengruppe.getBezeichnung()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((beschreibung == null) ? 0 : beschreibung.hashCode());
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
		Artikel other = (Artikel) obj;
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
		} else if (!warengruppe.getBezeichnung().equals(other.warengruppe.getBezeichnung()))
			return false;
		return true;
	}

}
