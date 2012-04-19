package projekt.fhv.teama.classes.personen;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Berechtigung implements IBerechtigung {
    private int ID;
    private String bezeichnung;
    private String kuerzel;
    private String beschreibung;
    private Set<IMitarbeiter> berechtigte;
    
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

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Berechtigung that = (Berechtigung) o;

        if (ID != that.ID) return false;
        if (beschreibung != null ? !beschreibung.equals(that.beschreibung) : that.beschreibung != null) return false;
        if (bezeichnung != null ? !bezeichnung.equals(that.bezeichnung) : that.bezeichnung != null) return false;
        if (kuerzel != null ? !kuerzel.equals(that.kuerzel) : that.kuerzel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0);
        result = 31 * result + (kuerzel != null ? kuerzel.hashCode() : 0);
        result = 31 * result + (beschreibung != null ? beschreibung.hashCode() : 0);
        return result;
    }

	public Set<IMitarbeiter> getBerechtigte() {
		return berechtigte;
	}

	public void setBerechtigte(Set<IMitarbeiter> berechtigte) {
		this.berechtigte = berechtigte;
	}
	
	@Override
	public void addBerechtigter(IMitarbeiter berechtigter) {
		this.berechtigte.add(berechtigter);
	}

	@Override
	public void removeBerechtigter(IMitarbeiter berechtigter) {
		if (berechtigte.contains(berechtigter)) {
			this.berechtigte.remove(berechtigter);
		}
	}
	
	public Berechtigung() {
	}

	public Berechtigung(String bezeichnung, String kuerzel) {
		this.bezeichnung = bezeichnung;
		this.kuerzel = kuerzel;
		berechtigte = new HashSet<IMitarbeiter>();
	}

	public Berechtigung(String bezeichnung, String kuerzel, String beschreibung) {
		this.bezeichnung = bezeichnung;
		this.kuerzel = kuerzel;
		this.beschreibung = beschreibung;
		berechtigte = new HashSet<IMitarbeiter>();
	}

	@Override
	public String toString() {
		return "Berechtigung [ID=" + ID + ", bezeichnung=" + bezeichnung
				+ ", kuerzel=" + kuerzel + ", beschreibung=" + beschreibung
				+ "]";
	}
}
