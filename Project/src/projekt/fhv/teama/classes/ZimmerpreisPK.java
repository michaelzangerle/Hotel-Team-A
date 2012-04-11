package Entities;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class ZimmerpreisPK implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZimmerpreisPK that = (ZimmerpreisPK) o;

        if (kategorieId != that.kategorieId) return false;
        if (saisonId != that.saisonId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = saisonId;
        result = 31 * result + kategorieId;
        return result;
    }
}
