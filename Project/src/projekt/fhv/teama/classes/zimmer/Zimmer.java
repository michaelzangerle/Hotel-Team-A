package projekt.fhv.teama.classes.zimmer;

import java.util.HashSet;
import java.util.Set;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.rechnung.IRechnungsposition;
import projekt.fhv.teama.classes.leistungen.Leistung;

/**
 * Created with IntelliJ IDEA. User: mike Date: 09.04.12 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class Zimmer extends Leistung implements IZimmer {

	private String nummer;
	private String beschreibung;
	private IKategorie kategorie;
	private IZimmerstatus zimmerstatus;

	/* Beziehungen */

	private Set<IReservierung> reservierungen = new HashSet<IReservierung>();
	private Set<IStatusentwicklung> statusentwicklungen = new HashSet<IStatusentwicklung>();
	private Set<IGast> gaeste = new HashSet<IGast>();
//	private Set<IAufenthalt> aufenthalte = new HashSet<IAufenthalt>();
	private Set<IRechnungsposition> rechnungspositionen = new HashSet<IRechnungsposition>();

	public Zimmer(String nummer,String bezeichnung, String beschreibung, IKategorie kategorie, IZimmerstatus zimmerStatus,
			Set<IReservierung> reservierungen, Set<IStatusentwicklung> statusenticklungen,
			Set<IRechnungsposition> rechnungspositionen) {
		super(bezeichnung);
		this.nummer = nummer;
		this.beschreibung = beschreibung;
		this.kategorie = kategorie;
		this.zimmerstatus = zimmerStatus;
		this.reservierungen = reservierungen;
		this.statusentwicklungen = statusenticklungen;
		this.rechnungspositionen = rechnungspositionen;
	}

	public Zimmer() {

	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public IKategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(IKategorie kategorie) {
		this.kategorie = kategorie;
	}

	public IZimmerstatus getZimmerstatus() {
		return zimmerstatus;
	}

	public void setZimmerstatus(IZimmerstatus zimmerStatus) {
		this.zimmerstatus = zimmerStatus;
	}

	public Set<IReservierung> getReservierungen() {
		return reservierungen;
	}

	public void setReservierungen(Set<IReservierung> reservierungen) {
		this.reservierungen = reservierungen;
	}

	public Set<IStatusentwicklung> getStatusentwicklungen() {
		return statusentwicklungen;
	}

	public void setStatusentwicklungen(Set<IStatusentwicklung> statusenticklungen) {
		this.statusentwicklungen = statusenticklungen;
	}

	public Set<IRechnungsposition> getRechnungspositionen() {
		return rechnungspositionen;
	}

	public void setRechnungspositionen(Set<IRechnungsposition> rechnungspositionen) {
		this.rechnungspositionen = rechnungspositionen;
	}

	@Override
	public String toString() {
		return "Zimmer [ID=" + getID() 
				+ ", nummer=" + nummer 
				+ ", beschreibung=" + beschreibung 
				+ ", kategorie="+ kategorie.getBezeichnung() 
				+ ", zimmerStatus=" + zimmerstatus.getBezeichnung() 
//				+ ", reservierungen=" + reservierungen
//				+ ", statusenticklungen=" + statusentwicklungen 
//				+ ", gaeste=" + gaeste 
//				+ ", aufenthalte=" + aufenthalte
//				+ ", rechnungspositionen=" + rechnungspositionen 
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getID();
		//result = prime * result + ((aufenthalte == null) ? 0 : aufenthalte.hashCode());
		result = prime * result + ((beschreibung == null) ? 0 : beschreibung.hashCode());
		//result = prime * result + ((gaeste == null) ? 0 : gaeste.hashCode());
		result = prime * result + ((kategorie == null) ? 0 : kategorie.hashCode());
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		//result = prime * result + ((rechnungspositionen == null) ? 0 : rechnungspositionen.hashCode());
		result = prime * result + ((reservierungen == null) ? 0 : reservierungen.hashCode());
//		result = prime * result + ((statusentwicklungen == null) ? 0 : statusentwicklungen.hashCode());
		result = prime * result + ((zimmerstatus == null) ? 0 : zimmerstatus.hashCode());
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
		Zimmer other = (Zimmer) obj;
		if (getID() != other.getID())
			return false;
//		if (aufenthalte == null) {
//			if (other.aufenthalte != null)
//				return false;
//		} else if (!aufenthalte.equals(other.aufenthalte))
//			return false;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		} else if (!beschreibung.equals(other.beschreibung))
			return false;
//		if (gaeste == null) {
//			if (other.gaeste != null)
//				return false;
//		} else if (!gaeste.equals(other.gaeste))
//			return false;
		if (kategorie == null) {
			if (other.kategorie != null)
				return false;
		} else if (!kategorie.getBezeichnung().equals(other.kategorie.getBezeichnung()))
			return false;
		if (nummer == null) {
			if (other.nummer != null)
				return false;
		} else if (!nummer.equals(other.nummer))
			return false;
//		if (rechnungspositionen == null) {
//			if (other.rechnungspositionen != null)
//				return false;
//		} else if (!rechnungspositionen.equals(other.rechnungspositionen))
//			return false;
		if (reservierungen == null) {
			if (other.reservierungen != null)
				return false;
		} else if (!reservierungen.equals(other.reservierungen))
			return false;
//		if (statusentwicklungen == null) {
//			if (other.statusentwicklungen != null)
//				return false;
//		} else if (!statusentwicklungen.equals(other.statusentwicklungen))
//			return false;
		if (zimmerstatus == null) {
			if (other.zimmerstatus != null)
				return false;
		} else if (!zimmerstatus.getBezeichnung().equals(other.zimmerstatus.getBezeichnung()))
			return false;
		return true;
	}

	@Override
	public void addReservierung(IReservierung res) {
		this.reservierungen.add(res);

	}

	@Override
	public void removeReservierung(IReservierung res) {
		if (this.reservierungen.contains(res)) {
			this.reservierungen.remove(res);
		}

	}

	@Override
	public void addRechungsposition(IRechnungsposition rechnungsposition) {
		this.rechnungspositionen.add(rechnungsposition);

	}

	@Override
	public void removeRechnungsposition(IRechnungsposition rechnungsposition) {
		if (this.rechnungspositionen.contains(rechnungsposition)) {
			this.rechnungspositionen.remove(rechnungsposition);
		}

	}

	@Override
	public void setGaeste(Set<IGast> gaeste) {
		this.gaeste = gaeste;
		
	}

	@Override
	public Set<IGast> getGaeste() {
		return gaeste;
	}

	@Override
	public void addGast(IGast gast) {
		gaeste.add(gast);
		
	}

	@Override
	public void removeGast(IGast gast) {
		if(gaeste.contains(gast)){
			gaeste.remove(gast);
		}
		
	}
}
