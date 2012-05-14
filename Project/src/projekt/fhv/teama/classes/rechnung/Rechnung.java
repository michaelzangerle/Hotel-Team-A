package projekt.fhv.teama.classes.rechnung;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import projekt.fhv.teama.classes.interfaces.teamb.IBLand;
import projekt.fhv.teama.classes.interfaces.teamb.IBRechnung;
import projekt.fhv.teama.classes.interfaces.teamb.IBRechnungsPosition;
import projekt.fhv.teama.classes.interfaces.teamb.IBTeilzahlung;
import projekt.fhv.teama.classes.interfaces.teamb.IBZahlungsmethode;
import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.classes.personen.IMitarbeiter;

/**
 * Beschreibt eine Rechnung
 * 
 * @author Team A
 * @version 1.9
 */
public class Rechnung implements IRechnung, IBRechnung {
	private int ID;
	private String bezahlerVorname;
	private String bezahlerNachname;
	private String bezahlerStrasse;
	private String bezahlerOrt;
	private String bezahlerPLZ;
	private float summe;
	private String nummer;
	private IMitarbeiter mitarbeiter;
	private ILand bezahlerLand;

	private Set<IRechnungsposition> rechnungspositionen = new HashSet<IRechnungsposition>();
	private Set<ITeilzahlung> teilzahlungen = new HashSet<ITeilzahlung>();

	public Rechnung(String bezahlerVorname, String bezahlerNachname, String bezahlerStrasse, String bezahlerOrt,
			String bezahlerPLZ, float summe, String nummer, IMitarbeiter mitarbeiter, ILand bezahlerLand,
			Set<IRechnungsposition> rechnungspostitionen, Set<ITeilzahlung> teilzahlungen) {

		this.bezahlerVorname = bezahlerVorname;
		this.bezahlerNachname = bezahlerNachname;
		this.bezahlerStrasse = bezahlerStrasse;
		this.bezahlerOrt = bezahlerOrt;
		this.bezahlerPLZ = bezahlerPLZ;
		this.summe = summe;
		this.nummer = nummer;
		this.mitarbeiter = mitarbeiter;
		this.bezahlerLand = bezahlerLand;
		this.rechnungspositionen = rechnungspostitionen;
		this.teilzahlungen = teilzahlungen;
	}

	public Rechnung() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getBezahlerVorname() {
		return bezahlerVorname;
	}

	public void setBezahlerVorname(String bezahlerVorname) {
		this.bezahlerVorname = bezahlerVorname;
	}

	public String getBezahlerNachname() {
		return bezahlerNachname;
	}

	public void setBezahlerNachname(String bezahlerNachname) {
		this.bezahlerNachname = bezahlerNachname;
	}

	public String getBezahlerStrasse() {
		return bezahlerStrasse;
	}

	public void setBezahlerStrasse(String bezahlerStrasse) {
		this.bezahlerStrasse = bezahlerStrasse;
	}

	public String getBezahlerOrt() {
		return bezahlerOrt;
	}

	public void setBezahlerOrt(String bezahlerOrt) {
		this.bezahlerOrt = bezahlerOrt;
	}

	public String getBezahlerPLZ() {
		return bezahlerPLZ;
	}

	public void setBezahlerPLZ(String bezahlerPLZ) {
		this.bezahlerPLZ = bezahlerPLZ;
	}

	public float getSumme() {
		return summe;
	}

	public void setSumme(float summe) {
		this.summe = summe;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public IMitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(IMitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public ILand getBezahlerLand() {
		return bezahlerLand;
	}

	public void setBezahlerLand(ILand bezahlerLand) {
		this.bezahlerLand = bezahlerLand;
	}

	public Set<IRechnungsposition> getRechnungspositionen() {
		return rechnungspositionen;
	}

	public void setRechnungspositionen(Set<IRechnungsposition> rechnungspositionen) {
		this.rechnungspositionen = rechnungspositionen;
	}

	public Set<ITeilzahlung> getTeilzahlungen() {
		return teilzahlungen;
	}

	public void setTeilzahlungen(Set<ITeilzahlung> teilzahlungen) {
		this.teilzahlungen = teilzahlungen;
	}

	@Override
	public String toString() {
		return "Rechnung [ID=" + ID + ", bezahlerVorname=" + bezahlerVorname + ", bezahlerNachname=" + bezahlerNachname
				+ ", bezahlerStrasse=" + bezahlerStrasse + ", bezahlerOrt=" + bezahlerOrt + ", bezahlerPLZ="
				+ bezahlerPLZ + ", summe=" + summe + ", nummer=" + nummer + ", mitarbeiter=" + mitarbeiter
				+ ", bezahlerLand=" + bezahlerLand + ", rechnungspostitionen=" + rechnungspositionen
				+ ", teilzahlungen=" + teilzahlungen + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((bezahlerLand == null) ? 0 : bezahlerLand.hashCode());
		result = prime * result + ((bezahlerNachname == null) ? 0 : bezahlerNachname.hashCode());
		result = prime * result + ((bezahlerOrt == null) ? 0 : bezahlerOrt.hashCode());
		result = prime * result + ((bezahlerPLZ == null) ? 0 : bezahlerPLZ.hashCode());
		result = prime * result + ((bezahlerStrasse == null) ? 0 : bezahlerStrasse.hashCode());
		result = prime * result + ((bezahlerVorname == null) ? 0 : bezahlerVorname.hashCode());
		result = prime * result + ((mitarbeiter == null) ? 0 : mitarbeiter.hashCode());
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		result = prime * result + ((rechnungspositionen == null) ? 0 : rechnungspositionen.hashCode());
		result = prime * result + Float.floatToIntBits(summe);
		result = prime * result + ((teilzahlungen == null) ? 0 : teilzahlungen.hashCode());
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
		Rechnung other = (Rechnung) obj;
		if (ID != other.ID)
			return false;
		if (bezahlerLand == null) {
			if (other.bezahlerLand != null)
				return false;
		} else if (!bezahlerLand.equals(other.bezahlerLand))
			return false;
		if (bezahlerNachname == null) {
			if (other.bezahlerNachname != null)
				return false;
		} else if (!bezahlerNachname.equals(other.bezahlerNachname))
			return false;
		if (bezahlerOrt == null) {
			if (other.bezahlerOrt != null)
				return false;
		} else if (!bezahlerOrt.equals(other.bezahlerOrt))
			return false;
		if (bezahlerPLZ == null) {
			if (other.bezahlerPLZ != null)
				return false;
		} else if (!bezahlerPLZ.equals(other.bezahlerPLZ))
			return false;
		if (bezahlerStrasse == null) {
			if (other.bezahlerStrasse != null)
				return false;
		} else if (!bezahlerStrasse.equals(other.bezahlerStrasse))
			return false;
		if (bezahlerVorname == null) {
			if (other.bezahlerVorname != null)
				return false;
		} else if (!bezahlerVorname.equals(other.bezahlerVorname))
			return false;
		if (mitarbeiter == null) {
			if (other.mitarbeiter != null)
				return false;
		} else if (!mitarbeiter.equals(other.mitarbeiter))
			return false;
		if (nummer == null) {
			if (other.nummer != null)
				return false;
		} else if (!nummer.equals(other.nummer))
			return false;
		if (rechnungspositionen == null) {
			if (other.rechnungspositionen != null)
				return false;
		} else if (!rechnungspositionen.equals(other.rechnungspositionen))
			return false;
		if (Float.floatToIntBits(summe) != Float.floatToIntBits(other.summe))
			return false;
		if (teilzahlungen == null) {
			if (other.teilzahlungen != null)
				return false;
		} else if (!teilzahlungen.equals(other.teilzahlungen))
			return false;
		return true;
	}

	@Override
	public void addRechnungsposition(IRechnungsposition rePos) {
		this.rechnungspositionen.add(rePos);
	}

	@Override
	public void removeRechnungsposition(IRechnungsposition rePos) {
		if (this.rechnungspositionen.contains(rePos)) {
			this.rechnungspositionen.remove(rePos);
		}
	}

	@Override
	public void addTeilzahlung(ITeilzahlung teilzahl) {
		this.teilzahlungen.add(teilzahl);

	}

	@Override
	public void removeTeilzahlung(ITeilzahlung teilzahl) {
		if (this.teilzahlungen.contains(teilzahl)) {
			this.teilzahlungen.remove(teilzahl);
		}
	}

	@Override
	public String getFirstname() {

		return this.getBezahlerVorname();
	}

	@Override
	public void setFirstname(String first) {
		this.setBezahlerVorname(first);
	}

	@Override
	public String getSurname() {
		return this.getBezahlerNachname();
	}

	@Override
	public void setSurname(String sur) {
		this.setBezahlerVorname(sur);
	}

	@Override
	public String getPostalCode() {
		return this.getBezahlerPLZ();
	}

	@Override
	public void setPostalCode(String postal) {
		this.setBezahlerPLZ(postal);
	}

	@Override
	public String getAddress() {
		return this.getBezahlerOrt();
	}

	@Override
	public void setAddress(String addresse) {
		this.setBezahlerStrasse(addresse);
	}

	@Override
	public String getLocation() {
		return this.getBezahlerOrt();
	}

	@Override
	public void setLocation(String location) {
		this.setBezahlerOrt(location);
	}

	@Override
	public IBLand getCountry() {
		return (IBLand) this.bezahlerLand;
	}

	@Override
	public void setCountry(IBLand country) {
		this.setBezahlerLand((ILand) country);
	}

	@Override
	public String getRechnungsNummer() {
		return this.getNummer();
	}

	@Override
	public void setRechnungsNummer(String nummer) {
		this.setNummer(nummer);
	}

	@Override
	public Set<IBRechnungsPosition> getRechnungsPositionen() {

		Set<IBRechnungsPosition> rpos = new HashSet<IBRechnungsPosition>();
		for (IRechnungsposition r : this.getRechnungspositionen()) {
			rpos.add((IBRechnungsPosition) r);
		}

		return rpos;
	}

	@Override
	public void addRechnungsPosition(IBRechnungsPosition position) {
		this.addRechnungsposition((IRechnungsposition) position);
	}

	@Override
	public void removeRechnungsPosition(IBRechnungsPosition position) {
		if (this.getRechnungsPositionen().contains((IRechnungsposition) position)) {
			this.getRechnungsPositionen().remove((IRechnungsposition) position);
		}
	}

	@Override
	public Set<IBTeilzahlung> getBTeilzahlungen() {

		Set<IBTeilzahlung> tz = new HashSet<IBTeilzahlung>();
		for (ITeilzahlung t : this.getTeilzahlungen()) {
			tz.add((IBTeilzahlung) t);
		}

		return tz;
	}

	@Override
	public void addBezahlung(IBZahlungsmethode methode, BigDecimal betrag) {

		IZahlungsmethode z1 = (IZahlungsmethode) methode;
		float betr = betrag.floatValue();
		ITeilzahlung teilzahl = new Teilzahlung(this, betr, z1);

		this.addTeilzahlung(teilzahl);
	}

	@Override
	public void removeBezahlung(IBTeilzahlung teilzahlung) {
		if (this.getTeilzahlungen().contains((ITeilzahlung) teilzahlung)) {
			this.getTeilzahlungen().remove((ITeilzahlung) teilzahlung);
		}
	}

	@Override
	public Integer getBID() {
		return new Integer(this.getID());
	}
}
