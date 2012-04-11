package projekt.fhv.teama.classes.personen;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Gast {
    private int gastId;

    public int getGastId() {
        return gastId;
    }

    public void setGastId(int gastId) {
        this.gastId = gastId;
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

        Gast gast = (Gast) o;

        if (gastId != gast.gastId) return false;
        if (nummer != null ? !nummer.equals(gast.nummer) : gast.nummer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gastId;
        result = 31 * result + (nummer != null ? nummer.hashCode() : 0);
        return result;
    }
}
