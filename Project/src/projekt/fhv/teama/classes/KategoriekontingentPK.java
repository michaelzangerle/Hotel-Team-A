package Entities;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class KategoriekontingentPK implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KategoriekontingentPK that = (KategoriekontingentPK) o;

        if (kategorieId != that.kategorieId) return false;
        if (kontingentId != that.kontingentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kategorieId;
        result = 31 * result + kontingentId;
        return result;
    }
}
