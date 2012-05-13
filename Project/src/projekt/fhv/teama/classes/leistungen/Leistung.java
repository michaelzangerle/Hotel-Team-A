package projekt.fhv.teama.classes.leistungen;

import projekt.fhv.teama.classes.interfaces.teamb.IBLeistung;

/**
 * Beschreibt eine Leistung
 * @author Team A
 * 
 */
public abstract class Leistung implements ILeistung,IBLeistung {

	private int ID;
	private String bezeichnung;

	public Leistung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Leistung() {
	}

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

	@Override
	public String toString() {
		return "Leistung [ID=" + ID + ", bezeichnung=" + bezeichnung + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
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
		Leistung other = (Leistung) obj;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		return true;
	}

	public abstract float getPreis();
	
}
