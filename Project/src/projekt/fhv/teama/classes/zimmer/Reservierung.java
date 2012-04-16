package projekt.fhv.teama.classes.zimmer;

import java.sql.Timestamp;
import java.util.List;

import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.personen.Person;
import projekt.fhv.teama.classes.personen.Vertragspartner;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Reservierung {
    private int ID;
    private Timestamp von;
    private Timestamp bis;
    private Person person;
    private Vertragspartner vertragspartner;
    
    private List<Option> optionen;
//    private List<Zimmer> zimmer;
    private List<Kategorie> kategorie;
//    private List<Gast> gast;
	public Reservierung(int iD, Timestamp von, Timestamp bis, Person person, Vertragspartner vertragspartner,
			List<Option> optionen, List<Kategorie> kategorie) {
		super();
		ID = iD;
		this.von = von;
		this.bis = bis;
		this.person = person;
		this.vertragspartner = vertragspartner;
		this.optionen = optionen;
		this.kategorie = kategorie;
	}
	public Reservierung() {
		super();
		// TODO Auto-generated constructor stub
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
	public List<Option> getOptionen() {
		return optionen;
	}
	public void setOptionen(List<Option> optionen) {
		this.optionen = optionen;
	}
	public List<Kategorie> getKategorie() {
		return kategorie;
	}
	public void setKategorie(List<Kategorie> kategorie) {
		this.kategorie = kategorie;
	}
	@Override
	public String toString() {
		return "Reservierung [ID=" + ID + ", von=" + von + ", bis=" + bis + ", person=" + person + ", vertragspartner="
				+ vertragspartner + ", optionen=" + optionen + ", kategorie=" + kategorie + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((bis == null) ? 0 : bis.hashCode());
		result = prime * result + ((kategorie == null) ? 0 : kategorie.hashCode());
		result = prime * result + ((optionen == null) ? 0 : optionen.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((vertragspartner == null) ? 0 : vertragspartner.hashCode());
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
		Reservierung other = (Reservierung) obj;
		if (ID != other.ID)
			return false;
		if (bis == null) {
			if (other.bis != null)
				return false;
		} else if (!bis.equals(other.bis))
			return false;
		if (kategorie == null) {
			if (other.kategorie != null)
				return false;
		} else if (!kategorie.equals(other.kategorie))
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
