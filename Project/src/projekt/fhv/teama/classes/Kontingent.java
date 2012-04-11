package Entities;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Kontingent {
    private int kontingentId;

    public int getKontingentId() {
        return kontingentId;
    }

    public void setKontingentId(int kontingentId) {
        this.kontingentId = kontingentId;
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

    private short kondition;

    public short getKondition() {
        return kondition;
    }

    public void setKondition(short kondition) {
        this.kondition = kondition;
    }

    private short ueberbuchungsgrenze;

    public short getUeberbuchungsgrenze() {
        return ueberbuchungsgrenze;
    }

    public void setUeberbuchungsgrenze(short ueberbuchungsgrenze) {
        this.ueberbuchungsgrenze = ueberbuchungsgrenze;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kontingent that = (Kontingent) o;

        if (kondition != that.kondition) return false;
        if (kontingentId != that.kontingentId) return false;
        if (ueberbuchungsgrenze != that.ueberbuchungsgrenze) return false;
        if (bis != null ? !bis.equals(that.bis) : that.bis != null) return false;
        if (von != null ? !von.equals(that.von) : that.von != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kontingentId;
        result = 31 * result + (von != null ? von.hashCode() : 0);
        result = 31 * result + (bis != null ? bis.hashCode() : 0);
        result = 31 * result + (int) kondition;
        result = 31 * result + (int) ueberbuchungsgrenze;
        return result;
    }
}
