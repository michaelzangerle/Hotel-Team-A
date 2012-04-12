package projekt.fhv.teama.classes.leistungen;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Warengruppe {
    private int warengruppeId;

    public int getWarengruppeId() {
        return warengruppeId;
    }

    public void setWarengruppeId(int warengruppeId) {
        this.warengruppeId = warengruppeId;
    }

    private String bezeichung;

    public String getBezeichung() {
        return bezeichung;
    }

    public void setBezeichung(String bezeichung) {
        this.bezeichung = bezeichung;
    }

    private short steuersatz;

    public short getSteuersatz() {
        return steuersatz;
    }

    public void setSteuersatz(short steuersatz) {
        this.steuersatz = steuersatz;
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

        Warengruppe that = (Warengruppe) o;

        if (steuersatz != that.steuersatz) return false;
        if (warengruppeId != that.warengruppeId) return false;
        if (beschreibung != null ? !beschreibung.equals(that.beschreibung) : that.beschreibung != null) return false;
        if (bezeichung != null ? !bezeichung.equals(that.bezeichung) : that.bezeichung != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = warengruppeId;
        result = 31 * result + (bezeichung != null ? bezeichung.hashCode() : 0);
        result = 31 * result + (int) steuersatz;
        result = 31 * result + (beschreibung != null ? beschreibung.hashCode() : 0);
        return result;
    }
}
