package projekt.fhv.teama.classes;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.classes.zimmer.IKategorie;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Kontingent implements IKontingent {
	private int ID;
	private Date von;
	private Date bis;
	private short kondition;
	private short ueberbuchungsgrenze;
	private IVertragspartner vertragspartner;
	private Set<IKategorie> kategorien;

	public Kontingent(Date von, Date bis, short kondition, short ueberbuchungsgrenze, IVertragspartner vertragspartner,
			Set<IKategorie> kategorien) {
		this.von = von;
		this.bis = bis;
		this.kondition = kondition;
		this.ueberbuchungsgrenze = ueberbuchungsgrenze;
		this.vertragspartner = vertragspartner;
		this.kategorien = kategorien;
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

	public Set<IKategorie> getKategorien() {
		return kategorien;
	}

	public void setKategorien(Set<IKategorie> kategorien) {
		this.kategorien = kategorien;
	}

	@Override
	public String toString() {
		return "Kontingent [ID=" + ID + ", von=" + von + ", bis=" + bis + ", kondition=" + kondition
				+ ", ueberbuchungsgrenze=" + ueberbuchungsgrenze + ", vertragspartner=" + vertragspartner.getName()
				+ ", kategorien=" + kategorien + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((bis == null) ? 0 : bis.hashCode());
		result = prime * result + ((kategorien == null) ? 0 : kategorien.hashCode());
		result = prime * result + kondition;
		result = prime * result + ueberbuchungsgrenze;
		result = prime * result + ((vertragspartner == null) ? 0 : vertragspartner.getName().hashCode());
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
		if (kategorien == null) {
			if (other.kategorien != null)
				return false;
		} else if (!kategorien.equals(other.kategorien))
			return false;
		if (kondition != other.kondition)
			return false;
		if (ueberbuchungsgrenze != other.ueberbuchungsgrenze)
			return false;
		if (vertragspartner == null) {
			if (other.vertragspartner != null)
				return false;
		} else if (!vertragspartner.equals(other.vertragspartner))
			return false;
		if (von == null) {
			if (other.von != null)
				return false;
		} else if (!von.equals(other.von))
			return false;
		return true;
	}

}
