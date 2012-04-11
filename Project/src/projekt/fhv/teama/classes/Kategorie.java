package projekt.fhv.teama.classes;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Kategorie {
	
    private int kategorieId;
    private String bezeichnung;
    private String beschreibung;

    public int getKategorieId() {
        return kategorieId;
    }

    public void setKategorieId(int kategorieId) {
        this.kategorieId = kategorieId;
    }  

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
   
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

        Kategorie kategorie = (Kategorie) o;

        if (kategorieId != kategorie.kategorieId) return false;
        if (beschreibung != null ? !beschreibung.equals(kategorie.beschreibung) : kategorie.beschreibung != null)
            return false;
        if (bezeichnung != null ? !bezeichnung.equals(kategorie.bezeichnung) : kategorie.bezeichnung != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kategorieId;
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0);
        result = 31 * result + (beschreibung != null ? beschreibung.hashCode() : 0);
        return result;
    }
}
