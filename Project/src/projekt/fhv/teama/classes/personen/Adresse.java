package projekt.fhv.teama.classes.personen;

public class Adresse {
	@Override
	public String toString() {
		return "Adresse [strasse=" + strasse + ", plz=" + plz + ", ort=" + ort
				+ "]";
	}

	private String strasse;
    private String plz;
    private String ort;
    
    
    
    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    
    
	public Adresse() {
	}

	public Adresse(String strasse, String plz, String ort) {
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
	}
}
