package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.classes.personen.IVertragspartner;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Reservierung implements IReservierung {

	private int ID;
	private Date von;
	private Date bis;
	private IPerson person;
	private IVertragspartner vertragspartner;
	private boolean bearbeitet;

	private Set<IReservierungsOption> optionen = new HashSet<IReservierungsOption>();
	private Set<IZimmer> zimmer = new HashSet<IZimmer>();
	private Set<IGast> gaeste = new HashSet<IGast>();
	private Set<ITeilreservierung> teilreservierungen = new HashSet<ITeilreservierung>();

	public Reservierung(Date von, Date bis, IPerson person, IVertragspartner vertragspartner,
			Set<IReservierungsOption> optionen, Set<IZimmer> zimmer, Set<IGast> gaeste,
			Set<ITeilreservierung> teilreservierungen) {
		this.von = von;
		this.bis = bis;
		this.person = person;
		this.vertragspartner = vertragspartner;
		this.optionen = optionen;
		this.zimmer = zimmer;
		this.gaeste = gaeste;
		this.teilreservierungen = teilreservierungen;
	}

	public boolean getBearbeitet() {
		return bearbeitet;
	}

	public void setBearbeitet(boolean bearbeitet) {
		this.bearbeitet = bearbeitet;
	}

	public Reservierung(Date von, Date bis, IPerson person, Set<IGast> gaeste) {
		this.von = von;
		this.bis = bis;
		this.person = person;
		this.gaeste = gaeste;
	}

	public Reservierung(Date von, Date bis, IPerson person) {
		this.von = von;
		this.bis = bis;
		this.person = person;
	}

	public Reservierung(Date von, Date bis, IVertragspartner vertragspartner, Set<IGast> gaeste) {
		this.von = von;
		this.bis = bis;
		this.vertragspartner = vertragspartner;
		this.gaeste = gaeste;
	}

	public Reservierung(Date von, Date bis, IVertragspartner vertragspartner) {
		this.von = von;
		this.bis = bis;
		this.vertragspartner = vertragspartner;
	}

	public Reservierung() {
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

	public IPerson getPerson() {
		return person;
	}

	public void setPerson(IPerson person) {
		this.person = person;
	}

	public IVertragspartner getVertragspartner() {
		return vertragspartner;
	}

	public void setVertragspartner(IVertragspartner vertragspartner) {
		this.vertragspartner = vertragspartner;
	}

	public Set<IReservierungsOption> getOptionen() {
		return optionen;
	}

	public void setOptionen(Set<IReservierungsOption> optionen) {
		this.optionen = optionen;
	}

	public Set<IZimmer> getZimmer() {
		return zimmer;
	}

	public void setZimmer(Set<IZimmer> zimmer) {
		this.zimmer = zimmer;
	}

	public Set<IGast> getGaeste() {
		return gaeste;
	}

	public void setGaeste(Set<IGast> gaeste) {
		this.gaeste = gaeste;
	}

	public Set<ITeilreservierung> getTeilreservierungen() {
		return teilreservierungen;
	}

	public void setTeilreservierungen(Set<ITeilreservierung> teilreservierungen) {
		this.teilreservierungen = teilreservierungen;
	}

	@Override
	public String toString() {
		return "Reservierung [ID=" + ID + ", von=" + von + ", bis=" + bis
		// + ", person=" + person
		// + ", vertragspartner=" + vertragspartner
				+ ", optionen=" + optionen + ", zimmer=" + zimmer
				// + ", gaeste=" + gaeste
				+ ", teilreservierungen=" + teilreservierungen 
				+ ", bearbeitet="+ bearbeitet
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((bis == null) ? 0 : bis.hashCode());
		// result = prime * result + ((gaeste == null) ? 0 : gaeste.hashCode());
		// result = prime * result + ((optionen == null) ? 0 :
		// optionen.hashCode());
		// result = prime * result + ((person == null) ? 0 : person.hashCode());
		// result = prime * result + ((teilreservierungen == null) ? 0 :
		// teilreservierungen.hashCode());
		// result = prime * result + ((vertragspartner == null) ? 0 :
		// vertragspartner.hashCode());
		result = prime * result + ((von == null) ? 0 : von.hashCode());
		// result = prime * result + ((zimmer == null) ? 0 : zimmer.hashCode());
		result = prime * result + (bearbeitet ? 3124 : 3217);
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
		// if (gaeste == null) {
		// if (other.gaeste != null)
		// return false;
		// } else if (!gaeste.equals(other.gaeste))
		// return false;
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
		if (bearbeitet != other.bearbeitet)
			return false;
		if (zimmer == null) {
			if (other.zimmer != null)
				return false;
		} else if (!zimmer.equals(other.zimmer))
			return false;
		return true;
	}

	@Override
	public void addZimmer(IZimmer zimmer) {
		this.zimmer.add(zimmer);

	}

	@Override
	public void removeZimmer(IZimmer zimmer) {
		if (this.zimmer.contains(zimmer)) {
			this.zimmer.remove(zimmer);
		}

	}

	@Override
	public void addGast(IGast gast) {
		this.gaeste.add(gast);

	}

	@Override
	public void removeGast(IGast gast) {
		if (this.gaeste.contains(gast)) {
			this.gaeste.remove(gast);
		}
	}

	@Override
	public void addOption(IReservierungsOption option) {
		this.optionen.add(option);

	}

	@Override
	public void removeOption(IReservierungsOption option) {
		if (this.optionen.contains(option)) {
			this.optionen.remove(option);
		}
	}

	@Override
	public void addTeilreservierung(ITeilreservierung teilreservierung) {
		this.teilreservierungen.add(teilreservierung);

	}

	@Override
	public void removeTeilreservierung(ITeilreservierung teilreservierung) {
		if (this.teilreservierungen.contains(teilreservierung)) {
			this.teilreservierungen.remove(teilreservierung);
		}

	}

}
