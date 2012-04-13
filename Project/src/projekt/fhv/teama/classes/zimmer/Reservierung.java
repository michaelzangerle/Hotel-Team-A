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
    private List<Zimmer> zimmer;
    private List<Kategorie> kategorie;
    private List<Gast> gast;
	public Reservierung(Timestamp von, Timestamp bis, Person person,
			Vertragspartner vertragspartner, List<Option> optionen,
			List<Zimmer> zimmer, List<Kategorie> kategorie, List<Gast> gast) {
		this.von = von;
		this.bis = bis;
		this.person = person;
		this.vertragspartner = vertragspartner;
		this.optionen = optionen;
		this.zimmer = zimmer;
		this.kategorie = kategorie;
		this.gast = gast;
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
	public List<Option> getOptionen() {
		return optionen;
	}
	public void setOptionen(List<Option> optionen) {
		this.optionen = optionen;
	}
	public List<Zimmer> getZimmer() {
		return zimmer;
	}
	public void setZimmer(List<Zimmer> zimmer) {
		this.zimmer = zimmer;
	}
	public List<Kategorie> getKategorie() {
		return kategorie;
	}
	public void setKategorie(List<Kategorie> kategorie) {
		this.kategorie = kategorie;
	}
	public List<Gast> getGast() {
		return gast;
	}
	public void setGast(List<Gast> gast) {
		this.gast = gast;
	}
    
    

}
