package projekt.fhv.teama.classes.personen;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    private int personId;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    private String vorname;

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    private String nachname;

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    private String geschlecht;

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    private String strasse;

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    private String plz;

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    private String ort;

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    private Date geburtsdatum;

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    private String telefonnummer;

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String iban;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    private String bic;

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    private String kontonummer;

    public String getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }

    private String blz;

    public String getBlz() {
        return blz;
    }

    public void setBlz(String blz) {
        this.blz = blz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (personId != person.personId) return false;
        if (bic != null ? !bic.equals(person.bic) : person.bic != null) return false;
        if (blz != null ? !blz.equals(person.blz) : person.blz != null) return false;
        if (email != null ? !email.equals(person.email) : person.email != null) return false;
        if (geburtsdatum != null ? !geburtsdatum.equals(person.geburtsdatum) : person.geburtsdatum != null)
            return false;
        if (geschlecht != null ? !geschlecht.equals(person.geschlecht) : person.geschlecht != null) return false;
        if (iban != null ? !iban.equals(person.iban) : person.iban != null) return false;
        if (kontonummer != null ? !kontonummer.equals(person.kontonummer) : person.kontonummer != null) return false;
        if (nachname != null ? !nachname.equals(person.nachname) : person.nachname != null) return false;
        if (ort != null ? !ort.equals(person.ort) : person.ort != null) return false;
        if (plz != null ? !plz.equals(person.plz) : person.plz != null) return false;
        if (strasse != null ? !strasse.equals(person.strasse) : person.strasse != null) return false;
        if (telefonnummer != null ? !telefonnummer.equals(person.telefonnummer) : person.telefonnummer != null)
            return false;
        if (vorname != null ? !vorname.equals(person.vorname) : person.vorname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId;
        result = 31 * result + (vorname != null ? vorname.hashCode() : 0);
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        result = 31 * result + (geschlecht != null ? geschlecht.hashCode() : 0);
        result = 31 * result + (strasse != null ? strasse.hashCode() : 0);
        result = 31 * result + (plz != null ? plz.hashCode() : 0);
        result = 31 * result + (ort != null ? ort.hashCode() : 0);
        result = 31 * result + (geburtsdatum != null ? geburtsdatum.hashCode() : 0);
        result = 31 * result + (telefonnummer != null ? telefonnummer.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (iban != null ? iban.hashCode() : 0);
        result = 31 * result + (bic != null ? bic.hashCode() : 0);
        result = 31 * result + (kontonummer != null ? kontonummer.hashCode() : 0);
        result = 31 * result + (blz != null ? blz.hashCode() : 0);
        return result;
    }
}
