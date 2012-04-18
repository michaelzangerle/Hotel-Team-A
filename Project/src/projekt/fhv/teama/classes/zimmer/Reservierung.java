package projekt.fhv.teama.classes.zimmer;

import java.sql.Timestamp;
import java.util.Set;

import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.personen.Person;
import projekt.fhv.teama.classes.personen.Vertragspartner;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Reservierung {
	
	private int ID;
	private Timestamp von;
	private Timestamp bis;
	private Person person;
	private Vertragspartner vertragspartner;

	private Set<ReservierungsOption> optionen;
	private Set<Zimmer> zimmer;
	private Set<Gast> gaeste;
	private Set<Teilreservierung> teilreservierungen;

	public Reservierung(Timestamp von, Timestamp bis, Person person, Vertragspartner vertragspartner,
			Set<ReservierungsOption> optionen, Set<Zimmer> zimmer, Set<Gast> gaeste,
			Set<Teilreservierung> teilreservierungen) {
		this.von = von;
		this.bis = bis;
		this.person = person;
		this.vertragspartner = vertragspartner;
		this.optionen = optionen;
		this.zimmer = zimmer;
		this.gaeste = gaeste;
		this.teilreservierungen = teilreservierungen;
	}

	public Reservierung() {
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Vertragspartner getVertragspartner() {
		return vertragspartner;
	}

	public void setVertragspartner(Vertragspartner vertragspartner) {
		this.vertragspartner = vertragspartner;
	}

	public Set<ReservierungsOption> getOptionen() {
		return optionen;
	}

	public void setOptionen(Set<ReservierungsOption> optionen) {
		this.optionen = optionen;
	}

	public Set<Zimmer> getZimmer() {
		return zimmer;
	}

	public void setZimmer(Set<Zimmer> zimmer) {
		this.zimmer = zimmer;
	}

	public Set<Gast> getGaeste() {
		return gaeste;
	}

	public void setGaeste(Set<Gast> gaeste) {
		this.gaeste = gaeste;
	}

	public Set<Teilreservierung> getTeilreservierungen() {
		return teilreservierungen;
	}

	public void setTeilreservierungen(Set<Teilreservierung> teilreservierungen) {
		this.teilreservierungen = teilreservierungen;
	}

	@Override
	public String toString() {
		return "Reservierung [ID=" + ID + ", von=" + von + ", bis=" + bis + ", person=" + person + ", vertragspartner="
				+ vertragspartner + ", optionen=" + optionen + ", zimmer=" + zimmer + ", gaeste=" + gaeste
				+ ", teilreservierungen=" + teilreservierungen + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((bis == null) ? 0 : bis.hashCode());
		result = prime * result + ((gaeste == null) ? 0 : gaeste.hashCode());
		result = prime * result + ((optionen == null) ? 0 : optionen.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((teilreservierungen == null) ? 0 : teilreservierungen.hashCode());
		result = prime * result + ((vertragspartner == null) ? 0 : vertragspartner.hashCode());
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
		Reservierung other = (Reservierung) obj;
		if (ID != other.ID)
			return false;
		if (bis == null) {
			if (other.bis != null)
				return false;
		} else if (!bis.equals(other.bis))
			return false;
		if (gaeste == null) {
			if (other.gaeste != null)
				return false;
		} else if (!gaeste.equals(other.gaeste))
			return false;
		if (optionen == null) {
			if (other.optionen != null)
				return false;
		} else if (!optionen.equals(other.optionen))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (teilreservierungen == null) {
			if (other.teilreservierungen != null)
				return false;
		} else if (!teilreservierungen.equals(other.teilreservierungen))
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
		if (zimmer == null) {
			if (other.zimmer != null)
				return false;
		} else if (!zimmer.equals(other.zimmer))
			return false;
		return true;
	}

}
