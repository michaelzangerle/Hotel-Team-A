package projekt.fhv.teama.classes.personen;

import java.util.Set;

import projekt.fhv.teama.classes.IKontingent;
import projekt.fhv.teama.classes.zimmer.IReservierung;


public class Vertragspartner implements IVertragspartner {
    private int ID;
    private String name;
    private String telefonNummer;
    private String email;
    private ILand land;
    private IKontodaten kontodaten;
    private Set<IAdresse> adressen;
    private IVertragspartnertyp typ;
    private Set<IKontingent> kontingente;
    private Set<IReservierung> reservierungen;
    
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

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(String telefonnummer) {
        this.telefonNummer = telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public ILand getLand() {
		return land;
	}

	public void setLand(ILand land) {
		this.land = land;
	}


	public IKontodaten getKontodaten() {
		return kontodaten;
	}

	public void setKontodaten(IKontodaten kontodaten) {
		this.kontodaten = kontodaten;
	}

	public Set<IAdresse> getAdressen() {
		return adressen;
	}

	public void setAdressen(Set<IAdresse> adressen) {
		this.adressen = adressen;
	}
	
	@Override
	public void addAdresse(IAdresse adresse) {
		this.adressen.add(adresse);
	}

	@Override
	public void removeAdresse(IAdresse adresse) {
		if (adressen.contains(adresse)) {
			this.adressen.remove(adresse);
		}
	}
	
	public IVertragspartnertyp getTyp() {
		return typ;
	}

	public void setTyp(IVertragspartnertyp typ) {
		this.typ = typ;
	}
	
	public Set<IKontingent> getKontingente() {
		return kontingente;
	}

	public void setKontingente(Set<IKontingent> kontingent) {
		this.kontingente = kontingent;
	}
	
	public Set<IReservierung> getReservierungen() {
		return reservierungen;
	}

	public void setReservierungen(Set<IReservierung> reservierungen) {
		this.reservierungen = reservierungen;
	}
	
	public Vertragspartner() {
	}

	public Vertragspartner(String name, String telefonnummer, String email,
			ILand land,  Kontodaten kontodaten,
			Set<IAdresse> adressen) {
		this.name = name;
		this.telefonNummer = telefonnummer;
		this.email = email;
		this.land = land;
		this.kontodaten = kontodaten;
		this.adressen = adressen;
	}
	
	public Vertragspartner(String name, String telefonnummer, String email,
			ILand land,  Kontodaten kontodaten,
			Set<IAdresse> adressen, IVertragspartnertyp typ) {
		this.name = name;
		this.telefonNummer = telefonnummer;
		this.email = email;
		this.land = land;
		this.kontodaten = kontodaten;
		this.adressen = adressen;
		this.typ = typ;
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
				+ ((telefonNummer == null) ? 0 : telefonNummer.hashCode());
//		result = prime * result + ((typ == null) ? 0 : typ.hashCode());
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
		if (telefonNummer == null) {
			if (other.telefonNummer != null)
				return false;
		} else if (!telefonNummer.equals(other.telefonNummer))
			return false;
//		if (typ == null) {
//			if (other.typ != null)
//				return false;
//		} else if (!typ.equals(other.typ))
//			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertragspartner [ID=" + ID + ", name=" + name
				+ ", telefonnummer=" + telefonNummer + ", email=" + email
				+ ", land=" + land + ", kontodaten="
				+ kontodaten + ", adressen=" + adressen + "]";
	}
}