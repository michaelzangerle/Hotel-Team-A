package projekt.fhv.teama.classes.personen;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Vertragspartner {
    private int vertragsPartnerId;

    public int getVertragsPartnerId() {
        return vertragsPartnerId;
    }

    public void setVertragsPartnerId(int vertragsPartnerId) {
        this.vertragsPartnerId = vertragsPartnerId;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        Vertragspartner that = (Vertragspartner) o;

        if (vertragsPartnerId != that.vertragsPartnerId) return false;
        if (bic != null ? !bic.equals(that.bic) : that.bic != null) return false;
        if (blz != null ? !blz.equals(that.blz) : that.blz != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (iban != null ? !iban.equals(that.iban) : that.iban != null) return false;
        if (kontonummer != null ? !kontonummer.equals(that.kontonummer) : that.kontonummer != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (ort != null ? !ort.equals(that.ort) : that.ort != null) return false;
        if (plz != null ? !plz.equals(that.plz) : that.plz != null) return false;
        if (strasse != null ? !strasse.equals(that.strasse) : that.strasse != null) return false;
        if (telefonnummer != null ? !telefonnummer.equals(that.telefonnummer) : that.telefonnummer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vertragsPartnerId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (strasse != null ? strasse.hashCode() : 0);
        result = 31 * result + (plz != null ? plz.hashCode() : 0);
        result = 31 * result + (ort != null ? ort.hashCode() : 0);
        result = 31 * result + (telefonnummer != null ? telefonnummer.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (iban != null ? iban.hashCode() : 0);
        result = 31 * result + (bic != null ? bic.hashCode() : 0);
        result = 31 * result + (kontonummer != null ? kontonummer.hashCode() : 0);
        result = 31 * result + (blz != null ? blz.hashCode() : 0);
        return result;
    }
}
