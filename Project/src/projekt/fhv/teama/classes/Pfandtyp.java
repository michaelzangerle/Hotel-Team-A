package Entities;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Pfandtyp {
    private int pfandTypId;

    public int getPfandTypId() {
        return pfandTypId;
    }

    public void setPfandTypId(int pfandTypId) {
        this.pfandTypId = pfandTypId;
    }

    private String bezeichnung;

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    private String beschreibung;

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

        if (pfandTypId != pfandtyp.pfandTypId) return false;
        if (beschreibung != null ? !beschreibung.equals(pfandtyp.beschreibung) : pfandtyp.beschreibung != null)
            return false;
        if (bezeichnung != null ? !bezeichnung.equals(pfandtyp.bezeichnung) : pfandtyp.bezeichnung != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pfandTypId;
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0);
        result = 31 * result + (beschreibung != null ? beschreibung.hashCode() : 0);
        return result;
    }
}
