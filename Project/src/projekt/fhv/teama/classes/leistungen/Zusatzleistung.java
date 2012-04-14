package projekt.fhv.teama.classes.leistungen;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Zusatzleistung extends Leistung{
	
	
	private int zusatzleistungID;
	private float preis;
	private String beschreibung;
	private boolean extern;
	private Warengruppe warengruppe;

	public Zusatzleistung(float preis, String bezeichnung, String beschreibung, boolean extern, Warengruppe warengruppe) {
		this.preis = preis;
		this.beschreibung = beschreibung;
		this.extern = extern;
		this.warengruppe = warengruppe;
		setBezeichnung(bezeichnung);
	}

	public Zusatzleistung() {

	}



	public int getZusatzleistungID() {
		return zusatzleistungID;
	}

	public void setZusatzleistungID(int zusatzleistungID) {
		this.zusatzleistungID = zusatzleistungID;
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
		return "Zusatzleistung [zusatzleistungID=" + zusatzleistungID + ", preis=" + preis + ", beschreibung="
				+ beschreibung + ", extern=" + extern + ", warengruppe=" + warengruppe + "]";
	}



}
