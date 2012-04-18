package projekt.fhv.teama.classes;

import java.sql.Date;

import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.zimmer.Zimmer;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Aufenthalt {
    
	private Float preis;
    private String pfandNr;
    private Date von;
    private Date bis;
    private boolean schluessel;
    private Gast gast;
    private Zimmer zimmer;

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

    public boolean isSchluessel() {
        return schluessel;
    }

    public void setSchluessel(boolean schluessel) {
        this.schluessel = schluessel;
    }

	public Gast getGast() {
		return gast;
	}

	public void setGast(Gast gast) {
		this.gast = gast;
	}

	public Zimmer getZimmer() {
		return zimmer;
	}

	public void setZimmer(Zimmer zimmer) {
		this.zimmer = zimmer;
	}

	public Aufenthalt() {
	}

	public Aufenthalt(Float preis, String pfandNr, Date von, Date bis,
			boolean schluessel, Gast gast, Zimmer zimmer) {
		this.pfandNr = pfandNr;
		this.von = von;
		this.bis = bis;
		this.schluessel = schluessel;
		this.gast = gast;
		this.zimmer = zimmer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bis == null) ? 0 : bis.hashCode());
		result = prime * result + ((gast == null) ? 0 : gast.hashCode());
		result = prime * result + ((pfandNr == null) ? 0 : pfandNr.hashCode());
		result = prime * result + ((preis == null) ? 0 : preis.hashCode());
		result = prime * result + (schluessel ? 1231 : 1237);
		result = prime * result + ((von == null) ? 0 : von.hashCode());
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
		Aufenthalt other = (Aufenthalt) obj;
		if (bis == null) {
			if (other.bis != null)
				return false;
		} else if (!bis.equals(other.bis))
			return false;
		if (gast == null) {
			if (other.gast != null)
				return false;
		} else if (!gast.equals(other.gast))
			return false;
		if (pfandNr == null) {
			if (other.pfandNr != null)
				return false;
		} else if (!pfandNr.equals(other.pfandNr))
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
		} else if (!zimmer.equals(other.zimmer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aufenthalt [preis=" + preis + ", pfandNr=" + pfandNr + ", von="
				+ von + ", bis=" + bis + ", schluessel=" + schluessel
				+ ", gast=" + gast + ", zimmer=" + zimmer + "]";
	}


}
