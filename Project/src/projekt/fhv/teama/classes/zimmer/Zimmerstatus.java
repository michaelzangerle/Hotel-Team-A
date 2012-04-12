package projekt.fhv.teama.classes.zimmer;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Zimmerstatus {
	
	private int ID;
	private String bezeichnung;
	private String kuerzel;

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}
	
	@Override
	public String toString() {
		return "Zimmerstatus [ID=" + ID + ", bezeichnung=" + bezeichnung
				+ ", kuerzel=" + kuerzel + "]";
	}

	public Zimmerstatus() {
	}

	public Zimmerstatus(String bezeichnung, String kuerzel) {
		this.bezeichnung = bezeichnung;
		this.kuerzel = kuerzel;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Zimmerstatus that = (Zimmerstatus) o;

		if (ID != that.ID)
			return false;
		if (bezeichnung != null ? !bezeichnung.equals(that.bezeichnung)
				: that.bezeichnung != null)
			return false;
		if (kuerzel != null ? !kuerzel.equals(that.kuerzel)
				: that.kuerzel != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = ID;
		result = 31 * result
				+ (bezeichnung != null ? bezeichnung.hashCode() : 0);
		result = 31 * result + (kuerzel != null ? kuerzel.hashCode() : 0);
		return result;
	}
}
