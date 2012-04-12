package projekt.fhv.teama.classes;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Land {
	
    @Override
	public String toString() {
		return "Land [ID=" + ID + ", bezeichnung=" + bezeichnung + ", kuerzel="
				+ kuerzel + "]";
	}

	private int ID;
    private String bezeichnung;
    private String kuerzel;
    
    public Land() {
	}

	public Land(String bezeichnung, String kuerzel) {
		super();
		this.bezeichnung = bezeichnung;
		this.kuerzel = kuerzel;
	}

	public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }
}
