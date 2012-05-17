package projekt.fhv.teama.classes.personen;

import roomanizer.teamb.service.integrate.IBLand;


/**
 * Beschreibt ein Land mit allen Informationen diesbezüglich
 * @author Team-A
 * @version 1.5
 */
public class Land implements ILand,IBLand {
	private int ID;
    private String bezeichnung;
    private String kuerzel;
	
    @Override
	public String toString() {
		return this.bezeichnung;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + ((kuerzel == null) ? 0 : kuerzel.hashCode());
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
		Land other = (Land) obj;
		if (ID != other.ID)
			return false;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (kuerzel == null) {
			if (other.kuerzel != null)
				return false;
		} else if (!kuerzel.equals(other.kuerzel))
			return false;
		return true;
	}

	public Land() {
	}

	public Land(String bezeichnung, String kuerzel) {
		super();
		this.bezeichnung = bezeichnung;
		this.kuerzel = kuerzel;
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

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }
}
