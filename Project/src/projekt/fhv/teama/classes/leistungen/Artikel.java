package projekt.fhv.teama.classes.leistungen;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Artikel {
    private int artikelId;

    public int getArtikelId() {
        return artikelId;
    }

    public void setArtikelId(int artikelId) {
        this.artikelId = artikelId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artikel artikel = (Artikel) o;

        if (artikelId != artikel.artikelId) return false;
        if (beschreibung != null ? !beschreibung.equals(artikel.beschreibung) : artikel.beschreibung != null)
            return false;
        if (preis != null ? !preis.equals(artikel.preis) : artikel.preis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = artikelId;
        result = 31 * result + (preis != null ? preis.hashCode() : 0);
        result = 31 * result + (beschreibung != null ? beschreibung.hashCode() : 0);
        return result;
    }
}
