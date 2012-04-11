package projekt.fhv.teama.classes.leistungen;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Zimmer {
    private int zimmerId;

    public int getZimmerId() {
        return zimmerId;
    }

    public void setZimmerId(int zimmerId) {
        this.zimmerId = zimmerId;
    }

    private String nummer;

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
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

        Zimmer zimmer = (Zimmer) o;

        if (zimmerId != zimmer.zimmerId) return false;
        if (beschreibung != null ? !beschreibung.equals(zimmer.beschreibung) : zimmer.beschreibung != null)
            return false;
        if (nummer != null ? !nummer.equals(zimmer.nummer) : zimmer.nummer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zimmerId;
        result = 31 * result + (nummer != null ? nummer.hashCode() : 0);
        result = 31 * result + (beschreibung != null ? beschreibung.hashCode() : 0);
        return result;
    }
}
