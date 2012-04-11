package projekt.fhv.teama.classes;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Reservierung {
    private int reservierungId;

    public int getReservierungId() {
        return reservierungId;
    }

    public void setReservierungId(int reservierungId) {
        this.reservierungId = reservierungId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservierung that = (Reservierung) o;

        if (reservierungId != that.reservierungId) return false;
        if (bis != null ? !bis.equals(that.bis) : that.bis != null) return false;
        if (von != null ? !von.equals(that.von) : that.von != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reservierungId;
        result = 31 * result + (von != null ? von.hashCode() : 0);
        result = 31 * result + (bis != null ? bis.hashCode() : 0);
        return result;
    }
}
