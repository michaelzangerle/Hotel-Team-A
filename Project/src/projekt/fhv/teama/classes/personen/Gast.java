package projekt.fhv.teama.classes.personen;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.rechnung.IRechnungsposition;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.integrate.IAAdresse;
import roomanizer.teamb.service.integrate.IBAdresse;
import roomanizer.teamb.service.integrate.IBRechnungsPosition;



/**
 * Beschreibt einen Gast der einen Aufenthalt in unserem Hotel absolviert
 * @author Team-A
 * @version 1.5
 */
public class Gast extends Person implements IGast {
	// private int ID;
	private String nummer;
	private IZimmer zimmer;
	private Set<IReservierung> reservierungen;
	private Set<IRechnungsposition> rechnungspositionen;
	private Set<IAufenthalt> aufenthalte;

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public IZimmer getZimmer() {
		return zimmer;
	}

	public void setZimmer(IZimmer zimmer) {
		this.zimmer = zimmer;
	}

	public Set<IReservierung> getReservierungen() {
		return reservierungen;
	}

	public void setReservierungen(Set<IReservierung> reservierungen) {
		this.reservierungen = reservierungen;
	}

	@Override
	public void addReservierung(IReservierung res) {
		this.reservierungen.add(res);
	}

	public Set<IRechnungsposition> getRechnungspositionen() {
		return rechnungspositionen;
	}

	public void setRechnungspositionen(Set<IRechnungsposition> rechnungspositionen) {
		this.rechnungspositionen = rechnungspositionen;
	}

	@Override
	public void addRechnungposition(IRechnungsposition rePos) {
		this.rechnungspositionen.add(rePos);
	}

	@Override
	public void removeRechnungsposition(IRechnungsposition rePos) {
		this.rechnungspositionen.add(rePos);
	}

	@Override
	public Set<IRechnungsposition> getRechnungsposition() {
		return rechnungspositionen;
	}

	public Set<IAufenthalt> getAufenthalte() {
		return aufenthalte;
	}

	public void setAufenthalte(Set<IAufenthalt> aufenthalte) {
		this.aufenthalte = aufenthalte;
	}

	@Override
	public void addAufenthalt(IAufenthalt aufenthalt) {
		this.aufenthalte.add(aufenthalt);
	}

	@Override
	public void removeAufenthalt(IAufenthalt aufenthalt) {
		if (aufenthalte.contains(aufenthalt)) {
			aufenthalte.remove(aufenthalt);
		}
	}

	public Gast() {
	}

	public Gast(String vorname, String nachname, char geschlecht, Set<IAdresse> adresse, Date geburtsdatum,
			String telefonnummer, String email, IKontodaten bankverbindung, String nummer) {
		super(vorname, nachname, geschlecht, adresse, geburtsdatum, telefonnummer, email, bankverbindung);
		this.nummer = nummer;
	}

	public Gast(String vorname, String nachname, char geschlecht, Set<IAdresse> adresse, Date geburtsdatum,
			String telefonnummer, String email, IKontodaten bankverbindung, String nummer, IZimmer zimmer) {
		super(vorname, nachname, geschlecht, adresse, geburtsdatum, telefonnummer, email, bankverbindung);
		this.nummer = nummer;
		this.zimmer = zimmer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + getID();
		// result = prime * result + ((aufenthalte == null) ? 0 :
		// aufenthalte.hashCode());
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		// result = prime * result + ((rechnungspositionen == null) ? 0 :
		// rechnungspositionen.hashCode());
		// result = prime * result + ((reservierungen == null) ? 0 :
		// reservierungen.hashCode());
		result = prime * result + ((zimmer == null) ? 0 : zimmer.getID());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gast other = (Gast) obj;
		if (getID() != other.getID())
			return false;
		// if (aufenthalte == null) {
		// if (other.aufenthalte != null)
		// return false;
		// } else if (!aufenthalte.equals(other.aufenthalte))
		// return false;
		if (nummer == null) {
			if (other.nummer != null)
				return false;
		} else if (!nummer.equals(other.nummer))
			return false;
		// if (rechnungspositionen == null) {
		// if (other.rechnungspositionen != null)
		// return false;
		// } else if (!rechnungspositionen.equals(other.rechnungspositionen))
		// return false;
		// if (reservierungen == null) {
		// if (other.reservierungen != null)
		// return false;
		// } else if (!reservierungen.equals(other.reservierungen))
		// return false;
		if (zimmer == null) {
			if (other.zimmer != null)
				return false;
		} else if (zimmer.getID() != other.zimmer.getID())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gast [ID=" + getID() + ", nummer=" + nummer
		// + ", zimmer=" + zimmer.getID() + ", "
		// + "reservierungen=" + reservierungen. + ", rechnungspositionen=" +
		// rechnungspositionen + ", aufenthalte=" + aufenthalte
				+ "]";
	}

	@Override
	public void removeReservierung(IReservierung res) {
		if (reservierungen.contains(res)) {
			this.reservierungen.remove(res);
		}
	}

	@Override
	public List<IBRechnungsPosition> getBRechnungsPositionen() {
		
		List<IBRechnungsPosition> rpos = new Vector<IBRechnungsPosition>();
		for (IRechnungsposition pos : this.getRechnungsposition()) {
			rpos.add((IBRechnungsPosition)pos);
		}
		return rpos;
	}

	@Override
	public String getFirstname() {
		return this.getVorname();
	}

	@Override
	public String getSurname() {
		return this.getNachname();
	}

	@Override
	public List<IBAdresse> getBAdressen() {
		
		List<IBAdresse> adds = new Vector<IBAdresse>();
		for (IAdresse adr : this.getAdressen()) {
			adds.add((IBAdresse)adr);
		}
				
		return adds;
	}

	@Override
	public Set<IBRechnungsPosition> getBOffeneRechnungsPositionen() {
				
		Set<IBRechnungsPosition> rpos = new HashSet<IBRechnungsPosition>();
		for (IBRechnungsPosition r : this.rechnungspositionen) {
			if(r.getFalsch() == false && r.getBezahlt() == false) {
				rpos.add(r);
			}
		}
		
		return rpos;
	}

	@Override
	public Set<IAAdresse> getAAdressen() {
		return new HashSet<IAAdresse>(this.getAdressen());
	}

}
