package projekt.fhv.teama.classes;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Pfandtyp {
    private int ID;
    private String bezeichnung;
    private String beschreibung;
    private List<Aufenthalt> aufenthalte;
    
    public int getPfandTypId() {
        return ID;
    }

    public void setPfandTypId(int pfandTypId) {
        this.ID = pfandTypId;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
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

        Pfandtyp pfandtyp = (Pfandtyp) o;

        if (ID != pfandtyp.ID) return false;
        if (beschreibung != null ? !beschreibung.equals(pfandtyp.beschreibung) : pfandtyp.beschreibung != null)
            return false;
        if (bezeichnung != null ? !bezeichnung.equals(pfandtyp.bezeichnung) : pfandtyp.bezeichnung != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0);
        result = 31 * result + (beschreibung != null ? beschreibung.hashCode() : 0);
        return result;
    }

	public Pfandtyp(String bezeichnung, String beschreibung,
			List<Aufenthalt> aufenthalte) {
		this.bezeichnung = bezeichnung;
		this.beschreibung = beschreibung;
		this.setAufenthalte(aufenthalte);
	}

	public Pfandtyp() {
	}

	public List<Aufenthalt> getAufenthalte() {
		return aufenthalte;
	}

	public void setAufenthalte(List<Aufenthalt> aufenthalte) {
		this.aufenthalte = aufenthalte;
	}
}
