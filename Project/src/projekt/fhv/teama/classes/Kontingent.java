package projekt.fhv.teama.classes;

import java.sql.Date;

import projekt.fhv.teama.classes.personen.IVertragspartner;

/**
 * Beschreibt ein Kontingent
 * @author Team A
 * @version 1.9
 */
public class Kontingent implements IKontingent {
	
	private int ID;
	private Date von;
	private Date bis;
	private short kondition;
	private short ueberbuchungsgrenze;
	private IVertragspartner vertragspartner;

	public Kontingent(Date von, Date bis, short kondition, short ueberbuchungsgrenze,
			IVertragspartner vertragspartner) {
		this.von = von;
		this.bis = bis;
		this.kondition = kondition;
		this.ueberbuchungsgrenze = ueberbuchungsgrenze;
		this.vertragspartner = vertragspartner;
	}
	
	public Kontingent(Date von, Date bis, IVertragspartner vertragspartner) {
		this.von = von;
		this.bis = bis;
		this.vertragspartner = vertragspartner;
	}
	
	public Kontingent() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public short getKondition() {
		return kondition;
	}

	public void setKondition(short kondition) {
		this.kondition = kondition;
	}

	public short getUeberbuchungsgrenze() {
		return ueberbuchungsgrenze;
	}

	public void setUeberbuchungsgrenze(short ueberbuchungsgrenze) {
		this.ueberbuchungsgrenze = ueberbuchungsgrenze;
	}

	public IVertragspartner getVertragspartner() {
		return vertragspartner;
	}

	public void setVertragspartner(IVertragspartner vertragspartner) {
		this.vertragspartner = vertragspartner;
	}

	@Override
	public String toString() {
		return "Kontingent [ID=" + ID + ", von=" + von + ", bis=" + bis + ", kondition=" + kondition
				+ ", ueberbuchungsgrenze=" + ueberbuchungsgrenze + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((bis == null) ? 0 : bis.hashCode());
		result = prime * result + kondition;
		result = prime * result + ueberbuchungsgrenze;
//		result = prime * result + ((vertragspartner == null) ? 0 : vertragspartner.getName().hashCode());
		result = prime * result + ((von == null) ? 0 : von.hashCode());
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
		Kontingent other = (Kontingent) obj;
		if (ID != other.ID)
			return false;
		if (bis == null) {
			if (other.bis != null)
				return false;
		} else if (!bis.equals(other.bis))
			return false;
		if (kondition != other.kondition)
			return false;
		if (ueberbuchungsgrenze != other.ueberbuchungsgrenze)
			return false;
//		if (vertragspartner == null) {
//			if (other.vertragspartner != null)
//				return false;
//		} else if (vertragspartner.getID() != other.vertragspartner.getID())
//			return false;
		if (von == null) {
			if (other.von != null)
				return false;
		} else if (!von.equals(other.von))
			return false;
		return true;
	}
}
