package projekt.fhv.teama.classes.zimmer;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Zimmerpreis implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ID;
	private Saison saison;
	private Kategorie kategorie;
	private float preis;

	public Zimmerpreis(Saison saison, Kategorie kategorie, float preis) {
		this.saison = saison;
		this.kategorie = kategorie;
		this.preis = preis;
	}

	public Zimmerpreis() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Saison getSaison() {
		return saison;
	}

	public void setSaison(Saison saison) {
		this.saison = saison;
	}

	public Kategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}

	public float getPreis() {
		return preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

	@Override
	public String toString() {
		return "Zimmerpreis [ID=" + ID + ", saison=" + saison.getBezeichnung() + ", kategorie=" + kategorie.getBezeichnung() + ", preis=" + preis + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
//		result = prime * result + ((kategorie == null) ? 0 : kategorie.hashCode());
		result = prime * result + Float.floatToIntBits(preis);
//		result = prime * result + ((saison == null) ? 0 : saison.hashCode());
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
		Zimmerpreis other = (Zimmerpreis) obj;
		if (ID != other.ID)
			return false;
		if (kategorie == null) {
			if (other.kategorie != null)
				return false;
		} else if (!kategorie.equals(other.kategorie))
			return false;
		if (Float.floatToIntBits(preis) != Float.floatToIntBits(other.preis))
			return false;
		if (saison == null) {
			if (other.saison != null)
				return false;
		} else if (!saison.equals(other.saison))
			return false;
		return true;
	}

}
