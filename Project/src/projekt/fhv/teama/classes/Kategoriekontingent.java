package projekt.fhv.teama.classes;

import projekt.fhv.teama.classes.zimmer.IKategorie;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Kategoriekontingent implements IKategoriekontigent {
	private int ID;
	private IKategorie kategorie;
	private IKontingent kontingent;
	private int anzahl;
	private int verfuegbar;

	public Kategoriekontingent(IKategorie kategorie, IKontingent kontingent, int anzahl, int verfuegbar) {

		this.kategorie = kategorie;
		this.kontingent = kontingent;
		this.anzahl = anzahl;
		this.verfuegbar = verfuegbar;
	}

	public Kategoriekontingent() {

	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public void setID(int iD) {
		ID = iD;
	}

	public IKategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(IKategorie kategorie) {
		this.kategorie = kategorie;
	}

	public IKontingent getKontingent() {
		return kontingent;
	}

	public void setKontingent(IKontingent kontingent) {
		this.kontingent = kontingent;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public int getVerfuegbar() {
		return verfuegbar;
	}

	public void setVerfuegbar(int verfuegbar) {
		this.verfuegbar = verfuegbar;
	}

	@Override
	public String toString() {
		return "Kategoriekontingent [ID=" + ID + ", kategorie=" + kategorie.getBezeichnung() + ", kontingent="
				+ kontingent.getID() + ", anzahl=" + anzahl + ", verfuegbar=" + verfuegbar + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + anzahl;
		result = prime * result + ((kategorie == null) ? 0 : kategorie.getBeschreibung().hashCode());
		result = prime * result + ((kontingent == null) ? 0 : kontingent.getID());
		result = prime * result + verfuegbar;
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
		Kategoriekontingent other = (Kategoriekontingent) obj;
		if (ID != other.ID)
			return false;
		if (anzahl != other.anzahl)
			return false;
		if (kategorie == null) {
			if (other.kategorie != null)
				return false;
		} else if (!kategorie.equals(other.kategorie))
			return false;
		if (kontingent == null) {
			if (other.kontingent != null)
				return false;
		} else if (!kontingent.equals(other.kontingent))
			return false;
		if (verfuegbar != other.verfuegbar)
			return false;
		return true;
	}

}
