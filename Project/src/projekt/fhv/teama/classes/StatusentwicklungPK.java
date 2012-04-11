package Entities;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class StatusentwicklungPK implements Serializable {
    private int zimmerId;

    public int getZimmerId() {
        return zimmerId;
    }

    public void setZimmerId(int zimmerId) {
        this.zimmerId = zimmerId;
    }

    private int zimmerStatusId;

    public int getZimmerStatusId() {
        return zimmerStatusId;
    }

    public void setZimmerStatusId(int zimmerStatusId) {
        this.zimmerStatusId = zimmerStatusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusentwicklungPK that = (StatusentwicklungPK) o;

        if (zimmerId != that.zimmerId) return false;
        if (zimmerStatusId != that.zimmerStatusId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zimmerId;
        result = 31 * result + zimmerStatusId;
        return result;
    }
}
