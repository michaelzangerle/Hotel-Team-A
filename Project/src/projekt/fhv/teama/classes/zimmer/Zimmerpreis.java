package projekt.fhv.teama.classes.zimmer;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Zimmerpreis {
    private int saisonId;

    public int getSaisonId() {
        return saisonId;
    }

    public void setSaisonId(int saisonId) {
        this.saisonId = saisonId;
    }

    private int kategorieId;

    public int getKategorieId() {
        return kategorieId;
    }

    public void setKategorieId(int kategorieId) {
        this.kategorieId = kategorieId;
    }

    private BigDecimal preis;

    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zimmerpreis that = (Zimmerpreis) o;

        if (kategorieId != that.kategorieId) return false;
        if (saisonId != that.saisonId) return false;
        if (preis != null ? !preis.equals(that.preis) : that.preis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = saisonId;
        result = 31 * result + kategorieId;
        result = 31 * result + (preis != null ? preis.hashCode() : 0);
        return result;
    }
}
