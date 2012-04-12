package projekt.fhv.teama.classes;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Kategorie {
	
    private int ID;
    private String bezeichnung;
    private String beschreibung;
    
    public Kategorie(){
    	
    }
    
    public Kategorie(String bezeichnung, String beschreibung) {
		super();
		this.bezeichnung = bezeichnung;
		this.beschreibung = beschreibung;
	}

	public int getID() {
        return ID;
    }

    public void setID(int kategorieId) {
        this.ID = kategorieId;
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

        if (ID != kategorie.ID) return false;
        if (beschreibung != null ? !beschreibung.equals(kategorie.beschreibung) : kategorie.beschreibung != null)
            return false;
        if (bezeichnung != null ? !bezeichnung.equals(kategorie.bezeichnung) : kategorie.bezeichnung != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0);
        result = 31 * result + (beschreibung != null ? beschreibung.hashCode() : 0);
        return result;
    }

	@Override
	public String toString() {
		return "Kategorie [kategorieId=" + ID + ", bezeichnung="
				+ bezeichnung + ", beschreibung=" + beschreibung + "]";
	}
    
    
}
