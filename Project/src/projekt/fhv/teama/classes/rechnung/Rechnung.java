package projekt.fhv.teama.classes.rechnung;


import java.util.List;

import projekt.fhv.teama.classes.personen.Adresse;
import projekt.fhv.teama.classes.personen.Mitarbeiter;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Rechnung {
    private int ID;
    private String bezahlerVorname;
    private String bezahlerNachname;
    private Adresse adresse;
    private float summe;
    private String nummer;
    private Mitarbeiter mitarbeiter;
    
    private List<Rechnungsposition> rechnungspostitionen;
    private List<Teilzahlung> teilzahlungen;
    
	public Rechnung(String bezahlerVorname, String bezahlerNachname,
			Adresse adresse, float summe, String nummer,
			Mitarbeiter mitarbeiter,
			List<Rechnungsposition> rechnungspostitionen,
			List<Teilzahlung> teilzahlungen) {
		this.bezahlerVorname = bezahlerVorname;
		this.bezahlerNachname = bezahlerNachname;
		this.adresse = adresse;
		this.summe = summe;
		this.nummer = nummer;
		this.mitarbeiter = mitarbeiter;
		this.rechnungspostitionen = rechnungspostitionen;
		this.teilzahlungen = teilzahlungen;
	}
	public Rechnung() {

	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getBezahlerVorname() {
		return bezahlerVorname;
	}
	public void setBezahlerVorname(String bezahlerVorname) {
		this.bezahlerVorname = bezahlerVorname;
	}
	public String getBezahlerNachname() {
		return bezahlerNachname;
	}
	public void setBezahlerNachname(String bezahlerNachname) {
		this.bezahlerNachname = bezahlerNachname;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public float getSumme() {
		return summe;
	}
	public void setSumme(float summe) {
		this.summe = summe;
	}
	public String getNummer() {
		return nummer;
	}
	public void setNummer(String nummer) {
		this.nummer = nummer;
	}
	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}
	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}
	public List<Rechnungsposition> getRechnungspostitionen() {
		return rechnungspostitionen;
	}
	public void setRechnungspostitionen(List<Rechnungsposition> rechnungspostitionen) {
		this.rechnungspostitionen = rechnungspostitionen;
	}
	public List<Teilzahlung> getTeilzahlungen() {
		return teilzahlungen;
	}
	public void setTeilzahlungen(List<Teilzahlung> teilzahlungen) {
		this.teilzahlungen = teilzahlungen;
	}
	@Override
	public String toString() {
		return "Rechnung [ID=" + ID + ", bezahlerVorname=" + bezahlerVorname
				+ ", bezahlerNachname=" + bezahlerNachname + ", adresse="
				+ adresse + ", summe=" + summe + ", nummer=" + nummer
				+ ", mitarbeiter=" + mitarbeiter + ", rechnungspostitionen="
				+ rechnungspostitionen + ", teilzahlungen=" + teilzahlungen
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime
				* result
				+ ((bezahlerNachname == null) ? 0 : bezahlerNachname.hashCode());
		result = prime * result
				+ ((bezahlerVorname == null) ? 0 : bezahlerVorname.hashCode());
		result = prime * result
				+ ((mitarbeiter == null) ? 0 : mitarbeiter.hashCode());
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		result = prime
				* result
				+ ((rechnungspostitionen == null) ? 0 : rechnungspostitionen
						.hashCode());
		result = prime * result + Float.floatToIntBits(summe);
		result = prime * result
				+ ((teilzahlungen == null) ? 0 : teilzahlungen.hashCode());
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
		Rechnung other = (Rechnung) obj;
		if (ID != other.ID)
			return false;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (bezahlerNachname == null) {
			if (other.bezahlerNachname != null)
				return false;
		} else if (!bezahlerNachname.equals(other.bezahlerNachname))
			return false;
		if (bezahlerVorname == null) {
			if (other.bezahlerVorname != null)
				return false;
		} else if (!bezahlerVorname.equals(other.bezahlerVorname))
			return false;
		if (mitarbeiter == null) {
			if (other.mitarbeiter != null)
				return false;
		} else if (!mitarbeiter.equals(other.mitarbeiter))
			return false;
		if (nummer == null) {
			if (other.nummer != null)
				return false;
		} else if (!nummer.equals(other.nummer))
			return false;
		if (rechnungspostitionen == null) {
			if (other.rechnungspostitionen != null)
				return false;
		} else if (!rechnungspostitionen.equals(other.rechnungspostitionen))
			return false;
		if (Float.floatToIntBits(summe) != Float.floatToIntBits(other.summe))
			return false;
		if (teilzahlungen == null) {
			if (other.teilzahlungen != null)
				return false;
		} else if (!teilzahlungen.equals(other.teilzahlungen))
			return false;
		return true;
	}
    
    
    
  
}
