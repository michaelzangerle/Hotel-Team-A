package projekt.fhv.teama.classes.zimmer;

import java.io.Serializable;

/**
 * Beschreibt einen Zimmerpreis
 * @author Team A
 * @version 1.2
 */
public class Zimmerpreis implements Serializable,IZimmerpreis {
	
	private static final long serialVersionUID = 1L;
	
	private int ID;
	private ISaison saison;
	private IKategorie kategorie;
	private float preis;

	public Zimmerpreis(ISaison saison, IKategorie kategorie, float preis) {
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

	public ISaison getSaison() {
		return saison;
	}

	public void setSaison(ISaison saison) {
		this.saison = saison;
	}

	public IKategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(IKategorie kategorie) {
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
		result = prime * result + ((kategorie == null) ? 0 : kategorie.getBezeichnung().hashCode());
		result = prime * result + Float.floatToIntBits(preis);
		result = prime * result + ((saison == null) ? 0 : saison.getBezeichnung().hashCode());
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
		} else if (kategorie.getID() != other.kategorie.getID())
			return false;
		if (Float.floatToIntBits(preis) != Float.floatToIntBits(other.preis))
			return false;
		if (saison == null) {
			if (other.saison != null)
				return false;
		} else if (saison.getID() != other.saison.getID())
			return false;
		return true;
	}

}
