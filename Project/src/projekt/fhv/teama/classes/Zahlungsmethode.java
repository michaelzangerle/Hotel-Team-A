package projekt.fhv.teama.classes;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Zahlungsmethode {
    private int zahlungsmethodeId;

    public int getZahlungsmethodeId() {
        return zahlungsmethodeId;
    }

    public void setZahlungsmethodeId(int zahlungsmethodeId) {
        this.zahlungsmethodeId = zahlungsmethodeId;
    }

    private String bezeichnung;

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    private String kuerzel;

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
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

        Zahlungsmethode that = (Zahlungsmethode) o;

        if (zahlungsmethodeId != that.zahlungsmethodeId) return false;
        if (beschreibung != null ? !beschreibung.equals(that.beschreibung) : that.beschreibung != null) return false;
        if (bezeichnung != null ? !bezeichnung.equals(that.bezeichnung) : that.bezeichnung != null) return false;
        if (kuerzel != null ? !kuerzel.equals(that.kuerzel) : that.kuerzel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zahlungsmethodeId;
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0);
        result = 31 * result + (kuerzel != null ? kuerzel.hashCode() : 0);
        result = 31 * result + (beschreibung != null ? beschreibung.hashCode() : 0);
        return result;
    }
}
