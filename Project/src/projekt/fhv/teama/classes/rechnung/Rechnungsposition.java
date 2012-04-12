/**
 * 
 */
package projekt.fhv.teama.classes.rechnung;

import java.util.Date;

import projekt.fhv.teama.classes.leistungen.Leistung;
import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.zimmer.Zimmer;

/**
 * @author mike
 *
 */
public class Rechnungsposition {

    private int ID;
    private Date erstellung;
    private int anzahl;
    private float einzelpreis;
    private float summe;
    private short steuersatz;
    private boolean beglichen;
    private Zimmer zimmer;
    private Rechnung rechnung;
    private Leistung leistung;
    private Gast gast;

    public Rechnungsposition() {
    }

    public Rechnungsposition(int iD, Date erstellung, int anzahl,
			float einzelpreis, float summe, short steuersatz,
			boolean beglichen, Zimmer zimmer, Rechnung rechnung,
			Leistung leistung, Gast gast) {
		super();
		ID = iD;
		this.erstellung = erstellung;
		this.anzahl = anzahl;
		this.einzelpreis = einzelpreis;
		this.summe = summe;
		this.steuersatz = steuersatz;
		this.beglichen = beglichen;
		this.zimmer = zimmer;
		this.rechnung = rechnung;
		this.leistung = leistung;
		this.gast = gast;
	}



	public Leistung getLeistung() {
		return leistung;
	}

	public void setLeistung(Leistung leistung) {
		this.leistung = leistung;
	}

	public int getID() {
        return ID;
    }

    public void setID(int rechnungspositionID) {
        this.ID = rechnungspositionID;
    }

    public Date getErstellung() {
        return erstellung;
    }

    public void setErstellung(Date erstellung) {
        this.erstellung = erstellung;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public float getEinzelpreis() {
        return einzelpreis;
    }

    public void setEinzelpreis(float einzelpreis) {
        this.einzelpreis = einzelpreis;
    }

    public float getSumme() {
        return summe;
    }

    public void setSumme(float summe) {
        this.summe = summe;
    }

    public short getSteuersatz() {
        return steuersatz;
    }

    public void setSteuersatz(short steuersatz) {
        this.steuersatz = steuersatz;
    }

    public boolean getBeglichen() {
        return beglichen;
    }

    public void setBeglichen(boolean beglichen) {
        this.beglichen = beglichen;
    }

    public Zimmer getZimmer() {
        return zimmer;
    }

    public void setZimmer(Zimmer zimmer) {
        this.zimmer = zimmer;
    }

    public Rechnung getRechnung() {
        return rechnung;
    }

    public void setRechnung(Rechnung rechnung) {
        this.rechnung = rechnung;
    }

    public Leistung getLeistungID() {
        return leistung;
    }

    public void setLeistungID(Leistung leistung) {
        this.leistung = leistung;
    }

    public Gast getGast() {
        return gast;
    }

    public void setGast(Gast gast) {
        this.gast = gast;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + anzahl;
		result = prime * result + (beglichen ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(einzelpreis);
		result = prime * result
				+ ((erstellung == null) ? 0 : erstellung.hashCode());
		result = prime * result + ((gast == null) ? 0 : gast.hashCode());
		result = prime * result
				+ ((leistung == null) ? 0 : leistung.hashCode());
		result = prime * result
				+ ((rechnung == null) ? 0 : rechnung.hashCode());
		result = prime * result + steuersatz;
		result = prime * result + Float.floatToIntBits(summe);
		result = prime * result + ((zimmer == null) ? 0 : zimmer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rechnungsposition other = (Rechnungsposition) obj;
		if (ID != other.ID)
			return false;
		if (anzahl != other.anzahl)
			return false;
		if (beglichen != other.beglichen)
			return false;
		if (Float.floatToIntBits(einzelpreis) != Float
				.floatToIntBits(other.einzelpreis))
			return false;
		if (erstellung == null) {
			if (other.erstellung != null)
				return false;
		} else if (!erstellung.equals(other.erstellung))
			return false;
		if (gast == null) {
			if (other.gast != null)
				return false;
		} else if (!gast.equals(other.gast))
			return false;
		if (leistung == null) {
			if (other.leistung != null)
				return false;
		} else if (!leistung.equals(other.leistung))
			return false;
		if (rechnung == null) {
			if (other.rechnung != null)
				return false;
		} else if (!rechnung.equals(other.rechnung))
			return false;
		if (steuersatz != other.steuersatz)
			return false;
		if (Float.floatToIntBits(summe) != Float.floatToIntBits(other.summe))
			return false;
		if (zimmer == null) {
			if (other.zimmer != null)
				return false;
		} else if (!zimmer.equals(other.zimmer))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "javaapplication10.Rechnungsposition[ rechnungspositionID=" + ID + " ]";
    }

}
