package projekt.fhv.teama.classes.personen;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Mitarbeiter {
    private int mitarbeiterId;

    public int getMitarbeiterId() {
        return mitarbeiterId;
    }

    public void setMitarbeiterId(int mitarbeiterId) {
        this.mitarbeiterId = mitarbeiterId;
    }

    private String passwort;

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    private Date einstellung;

    public Date getEinstellung() {
        return einstellung;
    }

    public void setEinstellung(Date einstellung) {
        this.einstellung = einstellung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mitarbeiter that = (Mitarbeiter) o;

        if (mitarbeiterId != that.mitarbeiterId) return false;
        if (einstellung != null ? !einstellung.equals(that.einstellung) : that.einstellung != null) return false;
        if (passwort != null ? !passwort.equals(that.passwort) : that.passwort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mitarbeiterId;
        result = 31 * result + (passwort != null ? passwort.hashCode() : 0);
        result = 31 * result + (einstellung != null ? einstellung.hashCode() : 0);
        return result;
    }
}
