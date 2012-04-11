package Entities;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class AufenthaltPK implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AufenthaltPK that = (AufenthaltPK) o;

        if (gastId != that.gastId) return false;
        if (zimmerId != that.zimmerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gastId;
        result = 31 * result + zimmerId;
        return result;
    }
}
