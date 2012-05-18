package projekt.fhv.teama.classes.personen;

import java.util.HashSet;
import java.util.Set;

import projekt.fhv.teama.integrate.IALand;

import roomanizer.teamb.service.integrate.IBLand;

/**
 * Beschreibt die Adresse die eine Person oder ein Vertragspartner im System haben kann
 * @author Team-A
 * @version 1.5
 */
public class Adresse implements IAdresse {
	
	private int ID;
	private String strasse;
    private String plz;
    private String ort;
    private Set<IPerson> person;
    private Set<IVertragspartner> vertragspartner;
    private ILand land;
    
    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Set<IPerson> getPerson() {
		return person;
	}

	public void setPerson(Set<IPerson> person) {
		this.person = person;
	}
	
	public Set<IVertragspartner> getVertragspartner() {
		return vertragspartner;
	}

	public void setVertragspartner(Set<IVertragspartner> vertragspartner) {
		this.vertragspartner = vertragspartner;
	}
	
	public ILand getLand() {
		return land;
	}

	public void setLand(ILand land) {
		this.land = land;
	}
	
	public Adresse() {
	}

	public Adresse(String strasse, String plz, String ort, ILand land) {
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		person = new HashSet<IPerson>();
		vertragspartner = new HashSet<IVertragspartner>();
		this.setLand(land);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + ((plz == null) ? 0 : plz.hashCode());
		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
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
		Adresse other = (Adresse) obj;
		if (ID != other.ID)
			return false;
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (plz == null) {
			if (other.plz != null)
				return false;
		} else if (!plz.equals(other.plz))
			return false;
		if (strasse == null) {
			if (other.strasse != null)
				return false;
		} else if (!strasse.equals(other.strasse))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adresse [ID=" + ID + ", strasse=" + strasse + ", plz=" + plz
				+ ", ort=" + ort + "]";
	}

	@Override
	public IBLand getBLand() {
		return (IBLand)land;
	}

	@Override
	public IALand getALand() {
		return (IALand)land;
	}
}
