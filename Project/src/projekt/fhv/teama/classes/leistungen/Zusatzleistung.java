package projekt.fhv.teama.classes.leistungen;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Zusatzleistung {
    private int zusatzleistungId;

    public int getZusatzleistungId() {
        return zusatzleistungId;
    }

    public void setZusatzleistungId(int zusatzleistungId) {
        this.zusatzleistungId = zusatzleistungId;
    }

    private BigDecimal preis;

    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    private String beschreibung;

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    private boolean extern;

    public boolean isExtern() {
        return extern;
    }

    public void setExtern(boolean extern) {
        this.extern = extern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zusatzleistung that = (Zusatzleistung) o;

        if (extern != that.extern) return false;
        if (zusatzleistungId != that.zusatzleistungId) return false;
        if (beschreibung != null ? !beschreibung.equals(that.beschreibung) : that.beschreibung != null) return false;
        if (preis != null ? !preis.equals(that.preis) : that.preis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zusatzleistungId;
        result = 31 * result + (preis != null ? preis.hashCode() : 0);
        result = 31 * result + (beschreibung != null ? beschreibung.hashCode() : 0);
        result = 31 * result + (extern ? 1 : 0);
        return result;
    }
}
