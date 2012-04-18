package projekt.fhv.teama.classes.personen;

import java.util.Set;

public class Vertragspartner {
    private int ID;
    private String name;
    private String telefonnummer;
    private String email;
    private Land land;
    private Kontodaten kontodaten;
    private Set<Adresse> adressen;
    private VertragspartnerTyp typ;
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Land getLand() {
		return land;
	}

	public void setLand(Land land) {
		this.land = land;
	}


	public Kontodaten getKontodaten() {
		return kontodaten;
	}

	public void setKontodaten(Kontodaten kontodaten) {
		this.kontodaten = kontodaten;
	}

	public Set<Adresse> getAdressen() {
		return adressen;
	}

	public void setAdressen(Set<Adresse> adressen) {
		this.adressen = adressen;
	}

	public Vertragspartner() {
	}

	public Vertragspartner(String name, String telefonnummer, String email,
			Land land, VertragspartnerTyp typ, Kontodaten kontodaten,
			Set<Adresse> adressen) {
		this.name = name;
		this.telefonnummer = telefonnummer;
		this.email = email;
		this.land = land;
		this.typ = typ;
		this.kontodaten = kontodaten;
		this.adressen = adressen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result
				+ ((adressen == null) ? 0 : adressen.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((kontodaten == null) ? 0 : kontodaten.hashCode());
		result = prime * result + ((land == null) ? 0 : land.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((telefonnummer == null) ? 0 : telefonnummer.hashCode());
		result = prime * result + ((typ == null) ? 0 : typ.hashCode());
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
		Vertragspartner other = (Vertragspartner) obj;
		if (ID != other.ID)
			return false;
		if (adressen == null) {
			if (other.adressen != null)
				return false;
		} else if (!adressen.equals(other.adressen))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (kontodaten == null) {
			if (other.kontodaten != null)
				return false;
		} else if (!kontodaten.equals(other.kontodaten))
			return false;
		if (land == null) {
			if (other.land != null)
				return false;
		} else if (!land.equals(other.land))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (telefonnummer == null) {
			if (other.telefonnummer != null)
				return false;
		} else if (!telefonnummer.equals(other.telefonnummer))
			return false;
		if (typ == null) {
			if (other.typ != null)
				return false;
		} else if (!typ.equals(other.typ))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertragspartner [ID=" + ID + ", name=" + name
				+ ", telefonnummer=" + telefonnummer + ", email=" + email
				+ ", land=" + land + ", typ=" + typ + ", kontodaten="
				+ kontodaten + ", adressen=" + adressen + "]";
	}
}