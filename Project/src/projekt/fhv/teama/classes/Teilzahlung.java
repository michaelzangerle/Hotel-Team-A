package Entities;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Teilzahlung {
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

    private BigDecimal betrag;

    public BigDecimal getBetrag() {
        return betrag;
    }

    public void setBetrag(BigDecimal betrag) {
        this.betrag = betrag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teilzahlung that = (Teilzahlung) o;

        if (rechnungId != that.rechnungId) return false;
        if (zahlungsmethodeId != that.zahlungsmethodeId) return false;
        if (betrag != null ? !betrag.equals(that.betrag) : that.betrag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zahlungsmethodeId;
        result = 31 * result + rechnungId;
        result = 31 * result + (betrag != null ? betrag.hashCode() : 0);
        return result;
    }
}
