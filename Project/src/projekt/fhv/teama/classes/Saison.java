package Entities;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Saison {
    private int saisonId;

    public int getSaisonId() {
        return saisonId;
    }

    public void setSaisonId(int saisonId) {
        this.saisonId = saisonId;
    }

    private String bezeichnung;

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
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

        Saison saison = (Saison) o;

        if (saisonId != saison.saisonId) return false;
        if (bezeichnung != null ? !bezeichnung.equals(saison.bezeichnung) : saison.bezeichnung != null) return false;
        if (bis != null ? !bis.equals(saison.bis) : saison.bis != null) return false;
        if (von != null ? !von.equals(saison.von) : saison.von != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = saisonId;
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0);
        result = 31 * result + (von != null ? von.hashCode() : 0);
        result = 31 * result + (bis != null ? bis.hashCode() : 0);
        return result;
    }
}
