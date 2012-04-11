package Entities;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Rechnung {
    private int rechnungId;

    public int getRechnungId() {
        return rechnungId;
    }

    public void setRechnungId(int rechnungId) {
        this.rechnungId = rechnungId;
    }

    private String bezahlerVorname;

    public String getBezahlerVorname() {
        return bezahlerVorname;
    }

    public void setBezahlerVorname(String bezahlerVorname) {
        this.bezahlerVorname = bezahlerVorname;
    }

    private String bezahlerNachname;

    public String getBezahlerNachname() {
        return bezahlerNachname;
    }

    public void setBezahlerNachname(String bezahlerNachname) {
        this.bezahlerNachname = bezahlerNachname;
    }

    private String bezahlerStrasse;

    public String getBezahlerStrasse() {
        return bezahlerStrasse;
    }

    public void setBezahlerStrasse(String bezahlerStrasse) {
        this.bezahlerStrasse = bezahlerStrasse;
    }

    private String bezahlerOrt;

    public String getBezahlerOrt() {
        return bezahlerOrt;
    }

    public void setBezahlerOrt(String bezahlerOrt) {
        this.bezahlerOrt = bezahlerOrt;
    }

    private String bezahlerPlz;

    public String getBezahlerPlz() {
        return bezahlerPlz;
    }

    public void setBezahlerPlz(String bezahlerPlz) {
        this.bezahlerPlz = bezahlerPlz;
    }

    private BigDecimal summe;

    public BigDecimal getSumme() {
        return summe;
    }

    public void setSumme(BigDecimal summe) {
        this.summe = summe;
    }

    private String nummer;

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rechnung rechnung = (Rechnung) o;

        if (rechnungId != rechnung.rechnungId) return false;
        if (bezahlerNachname != null ? !bezahlerNachname.equals(rechnung.bezahlerNachname) : rechnung.bezahlerNachname != null)
            return false;
        if (bezahlerOrt != null ? !bezahlerOrt.equals(rechnung.bezahlerOrt) : rechnung.bezahlerOrt != null)
            return false;
        if (bezahlerPlz != null ? !bezahlerPlz.equals(rechnung.bezahlerPlz) : rechnung.bezahlerPlz != null)
            return false;
        if (bezahlerStrasse != null ? !bezahlerStrasse.equals(rechnung.bezahlerStrasse) : rechnung.bezahlerStrasse != null)
            return false;
        if (bezahlerVorname != null ? !bezahlerVorname.equals(rechnung.bezahlerVorname) : rechnung.bezahlerVorname != null)
            return false;
        if (nummer != null ? !nummer.equals(rechnung.nummer) : rechnung.nummer != null) return false;
        if (summe != null ? !summe.equals(rechnung.summe) : rechnung.summe != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rechnungId;
        result = 31 * result + (bezahlerVorname != null ? bezahlerVorname.hashCode() : 0);
        result = 31 * result + (bezahlerNachname != null ? bezahlerNachname.hashCode() : 0);
        result = 31 * result + (bezahlerStrasse != null ? bezahlerStrasse.hashCode() : 0);
        result = 31 * result + (bezahlerOrt != null ? bezahlerOrt.hashCode() : 0);
        result = 31 * result + (bezahlerPlz != null ? bezahlerPlz.hashCode() : 0);
        result = 31 * result + (summe != null ? summe.hashCode() : 0);
        result = 31 * result + (nummer != null ? nummer.hashCode() : 0);
        return result;
    }
}
