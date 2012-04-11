package projekt.fhv.teama.classes;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Kategoriekontingent {
    private int kategorieId;

    public int getKategorieId() {
        return kategorieId;
    }

    public void setKategorieId(int kategorieId) {
        this.kategorieId = kategorieId;
    }

    private int kontingentId;

    public int getKontingentId() {
        return kontingentId;
    }

    public void setKontingentId(int kontingentId) {
        this.kontingentId = kontingentId;
    }

    private int anzahl;

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    private int verfuegbar;

    public int getVerfuegbar() {
        return verfuegbar;
    }

    public void setVerfuegbar(int verfuegbar) {
        this.verfuegbar = verfuegbar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kategoriekontingent that = (Kategoriekontingent) o;

        if (anzahl != that.anzahl) return false;
        if (kategorieId != that.kategorieId) return false;
        if (kontingentId != that.kontingentId) return false;
        if (verfuegbar != that.verfuegbar) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kategorieId;
        result = 31 * result + kontingentId;
        result = 31 * result + anzahl;
        result = 31 * result + verfuegbar;
        return result;
    }
}
