package projekt.fhv.teama.classes.personen;

import java.util.List;

import projekt.fhv.teama.classes.Aufenthalt;
import projekt.fhv.teama.classes.rechnung.Rechnungsposition;
import projekt.fhv.teama.classes.zimmer.Reservierung;
import projekt.fhv.teama.classes.zimmer.Zimmer;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Gast extends Person {
    private int gastId;
    private String nummer;
    private Zimmer zimmer;
    private List<Reservierung> reservierungen;
    private List<Rechnungsposition> rechnungspositionen;
    private List<Aufenthalt> aufenthalte;
    
    public int getGastId() {
        return gastId;
    }

    public void setGastId(int gastId) {
        this.gastId = gastId;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gast gast = (Gast) o;

        if (gastId != gast.gastId) return false;
        if (nummer != null ? !nummer.equals(gast.nummer) : gast.nummer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gastId;
        result = 31 * result + (nummer != null ? nummer.hashCode() : 0);
        return result;
    }

	public Zimmer getZimmer() {
		return zimmer;
	}

	public void setZimmer(Zimmer zimmer) {
		this.zimmer = zimmer;
	}

	public List<Reservierung> getReservierungen() {
		return reservierungen;
	}

	public void setReservierungen(List<Reservierung> reservierungen) {
		this.reservierungen = reservierungen;
	}

	public List<Rechnungsposition> getRechnungspositionen() {
		return rechnungspositionen;
	}

	public void setRechnungspositionen(List<Rechnungsposition> rechnungspositionen) {
		this.rechnungspositionen = rechnungspositionen;
	}

	public List<Aufenthalt> getAufenthalte() {
		return aufenthalte;
	}

	public void setAufenthalte(List<Aufenthalt> aufenthalte) {
		this.aufenthalte = aufenthalte;
	}

	public Gast() {
		super();
	}

	public Gast(String nummer, Zimmer zimmer) {
		super();
		this.nummer = nummer;
		this.zimmer = zimmer;
	}
}
