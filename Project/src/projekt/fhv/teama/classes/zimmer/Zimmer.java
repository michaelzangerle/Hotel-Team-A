package projekt.fhv.teama.classes.zimmer;

import java.util.List;

import projekt.fhv.teama.classes.Aufenthalt;
import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.rechnung.Rechnungsposition;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Zimmer {
    
	private int ID;
    private String nummer;
    private String beschreibung;
    private Zimmerstatus zimmerStatus;
    private Kategorie kategorie;
    
    /*Beziehungen*/
    private List<Reservierung> reservierungen;
	private List<Statusentwicklung> statusenticklung;
	private List<Gast> gaeste;
	private List<Aufenthalt> aufenthalte;
	private List<Rechnungsposition> rechnungspositionen;
	
    public List<Statusentwicklung> getStatusenticklung() {
		return statusenticklung;
	}

	public void setStatusenticklung(List<Statusentwicklung> statusenticklung) {
		this.statusenticklung = statusenticklung;
	}

	public List<Gast> getGaeste() {
		return gaeste;
	}

	public void setGaeste(List<Gast> gaeste) {
		this.gaeste = gaeste;
	}

	public List<Aufenthalt> getAufenthalte() {
		return aufenthalte;
	}

	public void setAufenthalte(List<Aufenthalt> aufenthalte) {
		this.aufenthalte = aufenthalte;
	}

	public List<Rechnungsposition> getRechnungspositionen() {
		return rechnungspositionen;
	}

	public void setRechnungspositionen(List<Rechnungsposition> rechnungspositionen) {
		this.rechnungspositionen = rechnungspositionen;
	}

	public Kategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}

	public Zimmerstatus getZimmerStatus() {
		return zimmerStatus;
	}

	public void setZimmerStatus(Zimmerstatus zimmerStatus) {
		this.zimmerStatus = zimmerStatus;
	}

	public List<Reservierung> getReservierungen() {
		return reservierungen;
	}

	public void setReservierungen(List<Reservierung> reservierungen) {
		this.reservierungen = reservierungen;
	}

    public int getID() {
        return ID;
    }

    public void setID(int zimmerId) {
        this.ID = zimmerId;
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
 
	@Override
	public String toString() {
		return "Zimmer [ID=" + ID + ", nummer=" + nummer + ", beschreibung="
				+ beschreibung + ", zimmerStatus=" + zimmerStatus
				+ ", kategorie=" + kategorie + ", reservierungen="
				+ reservierungen + ", statusenticklung=" + statusenticklung
				+ ", gaeste=" + gaeste + ", aufenthalte=" + aufenthalte
				+ ", rechnungspositionen=" + rechnungspositionen + "]";
	}

	public Zimmer(String nummer, String beschreibung,
			Zimmerstatus zimmerStatus, Kategorie kategorie,
			List<Reservierung> reservierungen,
			List<Statusentwicklung> statusenticklung, List<Gast> gaeste,
			List<Aufenthalt> aufenthalte,
			List<Rechnungsposition> rechnungspositionen) {
		this.nummer = nummer;
		this.beschreibung = beschreibung;
		this.zimmerStatus = zimmerStatus;
		this.kategorie = kategorie;
		this.reservierungen = reservierungen;
		this.statusenticklung = statusenticklung;
		this.gaeste = gaeste;
		this.aufenthalte = aufenthalte;
		this.rechnungspositionen = rechnungspositionen;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zimmer zimmer = (Zimmer) o;

        if (ID != zimmer.ID) return false;
        if (beschreibung != null ? !beschreibung.equals(zimmer.beschreibung) : zimmer.beschreibung != null)
            return false;
        if (nummer != null ? !nummer.equals(zimmer.nummer) : zimmer.nummer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (nummer != null ? nummer.hashCode() : 0);
        result = 31 * result + (beschreibung != null ? beschreibung.hashCode() : 0);
        return result;
    }

	public Zimmer() {
		super();
	}
}
