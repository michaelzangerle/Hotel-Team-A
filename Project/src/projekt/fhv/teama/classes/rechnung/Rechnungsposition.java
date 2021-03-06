/**
 * 
 */
package projekt.fhv.teama.classes.rechnung;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import roomanizer.teamb.service.integrate.IBGast;
import roomanizer.teamb.service.integrate.IBLeistung;
import roomanizer.teamb.service.integrate.IBRechnung;
import roomanizer.teamb.service.integrate.IBZimmer;

/**
 * Beschreibt eine Rechnungsposition 
 * @author Team A
 * @version 1.9
 */
public class Rechnungsposition implements IRechnungsposition {

    private int ID;
    private Date erstellung;
    private int anzahl;
    private float einzelpreis;
    private float summe;
    private short steuersatz;
    private boolean beglichen;
    private IZimmer zimmer;
    private IRechnung rechnung;
    private ILeistung leistung;
    private IGast gast;
    private boolean falsch;

    public boolean getFalsch() {
		return falsch;
	}

	public Rechnungsposition() {
    }

    public Rechnungsposition(Date erstellung, int anzahl,
			float einzelpreis, float summe, short steuersatz,
			boolean beglichen, IZimmer zimmer, IRechnung rechnung,
			ILeistung leistung, IGast gast) {
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



	public ILeistung getLeistung() {
		return leistung;
	}

	public void setLeistung(ILeistung leistung) {
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

    public IZimmer getZimmer() {
        return zimmer;
    }

    public void setZimmer(IZimmer zimmer) {
        this.zimmer = zimmer;
    }

    public IRechnung getRechnung() {
        return rechnung;
    }

    public void setRechnung(IRechnung rechnung) {
        this.rechnung = rechnung;
    }

    public ILeistung getLeistungID() {
        return leistung;
    }

    public void setLeistungID(ILeistung leistung) {
        this.leistung = leistung;
    }

    public IGast getGast() {
        return gast;
    }

    public void setGast(IGast gast) {
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
				+ ((rechnung == null) ? 0 : rechnung.getID());
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
		} else if (rechnung.getID() != other.rechnung.getID())
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
		return "Rechnungsposition "+this.ID;
	}

	@Override
	public BigDecimal getBrutto() {
		
		float netto = this.getSumme();
		float steueranteil = netto*this.getSteuersatz()/100;
		
		return new BigDecimal(netto+steueranteil);
	}
	
	
	@Override
	public String getInvoiceLine() {
		return this.getBLeistung().getBezeichnung();
	}

	@Override
	public Timestamp getDate() {
		return new Timestamp(this.getErstellung().getTime());
	}

	@Override
	public Integer getAmount() {
		return new Integer(this.getAnzahl());
	}
	
	
	@Override
	public BigDecimal getUnitPrice() {
		return new BigDecimal(this.getEinzelpreis());
	}

	@Override
	public BigDecimal getTotalPrice() {
		return new BigDecimal(this.getSumme());
	}

	@Override
	public short getTaxRate() {
		return this.getSteuersatz();
	}

	@Override
	public IBGast getBGast() {
		return (IBGast)this.getGast();
	}

	@Override
	public IBZimmer getBZimmer() {
		return (IBZimmer) this.getZimmer();
	}

	@Override
	public IBLeistung getBLeistung() {
		return (IBLeistung)this.getLeistung();
	}
	
	@Override
	public BigDecimal getSteuerbetrag() {
		return new BigDecimal(this.getSumme()*this.getSteuersatz()/100);
	}

	@Override
	public void setBezahlt(boolean bezahlt) {
		this.setBeglichen(bezahlt);		
	}

	@Override
	public void setRechnung(IBRechnung rechnung) {
		this.setRechnung((IRechnung)rechnung);	
	}


	@Override
	public void setFalsch(boolean falsch) {
		this.falsch = falsch;
	}


	@Override
	public boolean getBezahlt() {
		return this.getBeglichen();
	}

	@Override
	public Timestamp getBErstellung() {
		return new Timestamp(this.getErstellung().getTime());
	}

}
