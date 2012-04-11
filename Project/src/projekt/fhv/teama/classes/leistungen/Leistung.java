package projekt.fhv.teama.classes.leistungen;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Leistung {
    private int leistungId;

    public int getLeistungId() {
        return leistungId;
    }

    public void setLeistungId(int leistungId) {
        this.leistungId = leistungId;
    }

    private String bezeichnung;

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Leistung leistung = (Leistung) o;

        if (leistungId != leistung.leistungId) return false;
        if (bezeichnung != null ? !bezeichnung.equals(leistung.bezeichnung) : leistung.bezeichnung != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = leistungId;
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0);
        return result;
    }
}
