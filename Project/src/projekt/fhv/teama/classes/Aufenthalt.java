package projekt.fhv.teama.classes;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.classes.leistungen.IZusatzleistung;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.integrate.IAPfandtyp;
import projekt.fhv.teama.integrate.IAZimmer;

/**
 * Beschreibt einen Aufenthalt
 * @author Team A
 * @version 1.8
 */
public class Aufenthalt implements IAufenthalt {
	
    private int ID;
	private Float preis;
    private String pfandNr;
    private Date von;
    private Date bis;
    private boolean schluessel;
    private IGast gast;
    private IZimmer zimmer;
    private IPfandtyp pfandtyp;
    private Set<ILeistung> leistungen;
    private IZusatzleistung paket;
    
	public Aufenthalt() {
	}
	
	
	// #region
	public Aufenthalt(Float preis, String pfandNr, Date von, Date bis, boolean schluessel, IGast gast, IZimmer zimmer,
			IPfandtyp pfandtyp) {
		super();
		this.preis = preis;
		this.pfandNr = pfandNr;
		this.von = von;
		this.bis = bis;
		this.schluessel = schluessel;
		this.gast = gast;
		this.zimmer = zimmer;
		this.pfandtyp = pfandtyp;
	}



	public Aufenthalt(Float preis, Date von, Date bis, boolean schluessel, IGast gast, IZimmer zimmer) {
		this.von = von;
		this.bis = bis;
		this.schluessel = schluessel;
		this.gast = gast;
		this.zimmer = zimmer;
	}
	// #endregion
	
	public Aufenthalt(Float preis, String pfandNr, Date von, Date bis, boolean schluessel, IGast gast,
			IZimmer zimmer, IPfandtyp pfandtyp, Set<ILeistung> leistungen, IZusatzleistung paket) {
		this.preis = preis;
		this.pfandNr = pfandNr;
		this.von = von;
		this.bis = bis;
		this.schluessel = schluessel;
		this.gast = gast;
		this.zimmer = zimmer;
		this.pfandtyp = pfandtyp;
		this.leistungen = leistungen;
		this.paket = paket;
	}
	
	public Aufenthalt(Float preis, String pfandNr, Date von, Date bis, boolean schluessel, IGast gast,
			IZimmer zimmer, IPfandtyp pfandtyp, IZusatzleistung paket) {
		this.preis = preis;
		this.pfandNr = pfandNr;
		this.von = von;
		this.bis = bis;
		this.schluessel = schluessel;
		this.gast = gast;
		this.zimmer = zimmer;
		this.pfandtyp = pfandtyp;
		this.paket = paket;
	}

	public Set<ILeistung> getLeistungen() {
		return leistungen;
	}

	public void setLeistungen(Set<ILeistung> leistungen) {
		this.leistungen = leistungen;
	}

	public IZusatzleistung getPaket() {
		return paket;
	}

	public void setPaket(IZusatzleistung paket) {
		this.paket = paket;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}
	
    public Float getPreis() {
        return preis;
    }

    public void setPreis(Float preis) {
        this.preis = preis;
    }

    public String getPfandNr() {
        return pfandNr;
    }

    public void setPfandNr(String pfandNr) {
        this.pfandNr = pfandNr;
    }

    public Date getVon() {
        return von;
    }

    public void setVon(Date von) {
        this.von = von;
    }

    public Date getBis() {
        return bis;
    }

    public void setBis(Date bis) {
        this.bis = bis;
    }

    public boolean getSchluessel() {
        return schluessel;
    }

    public void setSchluessel(boolean schluessel) {
        this.schluessel = schluessel;
    }

	public IGast getGast() {
		return gast;
	}

	public void setGast(IGast gast) {
		this.gast = gast;
	}

	public IZimmer getZimmer() {
		return zimmer;
	}

	public void setZimmer(IZimmer zimmer) {
		this.zimmer = zimmer;
	}
	
	@Override
	public void setPfandtyp(IPfandtyp pfandtyp) {
		this.pfandtyp = pfandtyp;
		
	}

	@Override
	public IPfandtyp getPfandtyp() {
		return pfandtyp;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((bis == null) ? 0 : bis.hashCode());
		result = prime * result + ((gast == null) ? 0 : gast.getID());
		result = prime * result + ((leistungen == null) ? 0 : leistungen.hashCode());
		result = prime * result + ((paket == null) ? 0 : paket.getID());
		result = prime * result + ((pfandNr == null) ? 0 : pfandNr.hashCode());
		result = prime * result + ((pfandtyp == null) ? 0 : pfandtyp.hashCode());
		result = prime * result + ((preis == null) ? 0 : preis.hashCode());
		result = prime * result + (schluessel ? 1231 : 1237);
		result = prime * result + ((von == null) ? 0 : von.hashCode());
		result = prime * result + ((zimmer == null) ? 0 : zimmer.getID());
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
		Aufenthalt other = (Aufenthalt) obj;
		if (ID != other.ID)
			return false;
		if (bis == null) {
			if (other.bis != null)
				return false;
		} else if (!bis.equals(other.bis))
			return false;
		if (gast == null) {
			if (other.gast != null)
				return false;
		} else if (gast.getID() != other.gast.getID())
			return false;
		if (leistungen == null) {
			if (other.leistungen != null)
				return false;
		} else if (!leistungen.equals(other.leistungen))
			return false;
		if (paket == null) {
			if (other.paket != null)
				return false;
		} else if (paket.getID() != other.paket.getID())
			return false;
		if (pfandNr == null) {
			if (other.pfandNr != null)
				return false;
		} else if (!pfandNr.equals(other.pfandNr))
			return false;
		if (pfandtyp == null) {
			if (other.pfandtyp != null)
				return false;
		} else if (!pfandtyp.equals(other.pfandtyp))
			return false;
		if (preis == null) {
			if (other.preis != null)
				return false;
		} else if (!preis.equals(other.preis))
			return false;
		if (schluessel != other.schluessel)
			return false;
		if (von == null) {
			if (other.von != null)
				return false;
		} else if (!von.equals(other.von))
			return false;
		if (zimmer == null) {
			if (other.zimmer != null)
				return false;
		} else if (zimmer.getID() != other.zimmer.getID())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aufenthalt [ID=" + ID + ", preis=" + preis + ", pfandNr=" + pfandNr + ", von=" + von + ", bis=" + bis
				+ ", schluessel=" + schluessel + ", gast=" + gast + ", zimmer=" + zimmer + ", pfandtyp=" + pfandtyp
				+ ", leistungen=" + leistungen + ", paket=" + paket + "]";
	}


	@Override
	public IAGast getAGast() {
		return gast;
	}


	@Override
	public IAZimmer getAZimmer() {
		return zimmer;
	}


	@Override
	public Date getAVon() {
		return von;
	}


	@Override
	public Date getABis() {
		return bis;
	}


	@Override
	public IAPfandtyp getAPfandtyp() {
		return pfandtyp;
	}
}
