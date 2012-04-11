package projekt.fhv.teama.classes;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Aufenthalt {
    private int gastId;

    public int getGastId() {
        return gastId;
    }

    public void setGastId(int gastId) {
        this.gastId = gastId;
    }

    private int zimmerId;

    public int getZimmerId() {
        return zimmerId;
    }

    public void setZimmerId(int zimmerId) {
        this.zimmerId = zimmerId;
    }

    private BigDecimal preis;

    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    private String pfandNr;

    public String getPfandNr() {
        return pfandNr;
    }

    public void setPfandNr(String pfandNr) {
        this.pfandNr = pfandNr;
    }

    private Date von;

    public Date getVon() {
        return von;
    }

    public void setVon(Date von) {
        this.von = von;
    }

    private Date bis;

    public Date getBis() {
        return bis;
    }

    public void setBis(Date bis) {
        this.bis = bis;
    }

    private boolean schluessel;

    public boolean isSchluessel() {
        return schluessel;
    }

    public void setSchluessel(boolean schluessel) {
        this.schluessel = schluessel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aufenthalt that = (Aufenthalt) o;

        if (gastId != that.gastId) return false;
        if (schluessel != that.schluessel) return false;
        if (zimmerId != that.zimmerId) return false;
        if (bis != null ? !bis.equals(that.bis) : that.bis != null) return false;
        if (pfandNr != null ? !pfandNr.equals(that.pfandNr) : that.pfandNr != null) return false;
        if (preis != null ? !preis.equals(that.preis) : that.preis != null) return false;
        if (von != null ? !von.equals(that.von) : that.von != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gastId;
        result = 31 * result + zimmerId;
        result = 31 * result + (preis != null ? preis.hashCode() : 0);
        result = 31 * result + (pfandNr != null ? pfandNr.hashCode() : 0);
        result = 31 * result + (von != null ? von.hashCode() : 0);
        result = 31 * result + (bis != null ? bis.hashCode() : 0);
        result = 31 * result + (schluessel ? 1 : 0);
        return result;
    }
}
