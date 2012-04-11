package Entities;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class TeilzahlungPK implements Serializable {
    private int zahlungsmethodeId;

    public int getZahlungsmethodeId() {
        return zahlungsmethodeId;
    }

    public void setZahlungsmethodeId(int zahlungsmethodeId) {
        this.zahlungsmethodeId = zahlungsmethodeId;
    }

    private int rechnungId;

    public int getRechnungId() {
        return rechnungId;
    }

    public void setRechnungId(int rechnungId) {
        this.rechnungId = rechnungId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeilzahlungPK that = (TeilzahlungPK) o;

        if (rechnungId != that.rechnungId) return false;
        if (zahlungsmethodeId != that.zahlungsmethodeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zahlungsmethodeId;
        result = 31 * result + rechnungId;
        return result;
    }
}
