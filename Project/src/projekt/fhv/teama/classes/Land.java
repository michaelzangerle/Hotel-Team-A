package Entities;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Land {
    private int landId;

    public int getLandId() {
        return landId;
    }

    public void setLandId(int landId) {
        this.landId = landId;
    }

    private String bezeichnung;

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    private String kuerzel;

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Land land = (Land) o;

        if (landId != land.landId) return false;
        if (bezeichnung != null ? !bezeichnung.equals(land.bezeichnung) : land.bezeichnung != null) return false;
        if (kuerzel != null ? !kuerzel.equals(land.kuerzel) : land.kuerzel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = landId;
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0);
        result = 31 * result + (kuerzel != null ? kuerzel.hashCode() : 0);
        return result;
    }
}
