package Entities;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class ZimmerreservierungPK implements Serializable {
    private int zimmerId;

    public int getZimmerId() {
        return zimmerId;
    }

    public void setZimmerId(int zimmerId) {
        this.zimmerId = zimmerId;
    }

    private int reservierungId;

    public int getReservierungId() {
        return reservierungId;
    }

    public void setReservierungId(int reservierungId) {
        this.reservierungId = reservierungId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZimmerreservierungPK that = (ZimmerreservierungPK) o;

        if (reservierungId != that.reservierungId) return false;
        if (zimmerId != that.zimmerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zimmerId;
        result = 31 * result + reservierungId;
        return result;
    }
}
