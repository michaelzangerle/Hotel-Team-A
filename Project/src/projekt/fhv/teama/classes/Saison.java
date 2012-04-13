package projekt.fhv.teama.classes;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Saison {
    
	private int ID;
	private String bezeichnung;
	private Timestamp von;
	private Timestamp bis;

    public Saison() {
	}

	public Saison(String bezeichnung, Timestamp von, Timestamp bis) {
		this.bezeichnung = bezeichnung;
		this.von = von;
		this.bis = bis;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Timestamp getVon() {
        return von;
    }

    public void setVon(Timestamp von) {
        this.von = von;
    }

    public Timestamp getBis() {
        return bis;
    }

    public void setBis(Timestamp bis) {
        this.bis = bis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Saison saison = (Saison) o;

        if (ID != saison.ID) return false;
        if (bezeichnung != null ? !bezeichnung.equals(saison.bezeichnung) : saison.bezeichnung != null) return false;
        if (bis != null ? !bis.equals(saison.bis) : saison.bis != null) return false;
        if (von != null ? !von.equals(saison.von) : saison.von != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0);
        result = 31 * result + (von != null ? von.hashCode() : 0);
        result = 31 * result + (bis != null ? bis.hashCode() : 0);
        return result;
    }

	@Override
	public String toString() {
		return "Saison [ID=" + ID + ", bezeichnung=" + bezeichnung + ", von="
				+ von + ", bis=" + bis + "]";
	}
    
    
}
