package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Statusentwicklung {
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

    private String beschreibung;

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statusentwicklung that = (Statusentwicklung) o;

        if (zimmerId != that.zimmerId) return false;
        if (zimmerStatusId != that.zimmerStatusId) return false;
        if (beschreibung != null ? !beschreibung.equals(that.beschreibung) : that.beschreibung != null) return false;
        if (bis != null ? !bis.equals(that.bis) : that.bis != null) return false;
        if (von != null ? !von.equals(that.von) : that.von != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zimmerId;
        result = 31 * result + zimmerStatusId;
        result = 31 * result + (von != null ? von.hashCode() : 0);
        result = 31 * result + (bis != null ? bis.hashCode() : 0);
        result = 31 * result + (beschreibung != null ? beschreibung.hashCode() : 0);
        return result;
    }
}
