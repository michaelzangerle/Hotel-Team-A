package projekt.fhv.teama.classes;

public class Bankverbindung {
    private String iban;
    private String bic;
    private String kontonummer;
    private String blz;
    
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getKontonummer() {
		return kontonummer;
	}
	public void setKontonummer(String kontonummer) {
		this.kontonummer = kontonummer;
	}
	public String getBlz() {
		return blz;
	}
	public void setBlz(String blz) {
		this.blz = blz;
	}
	
	public Bankverbindung(String iban, String bic, String kontonummer, String blz) {
		this.iban = iban;
		this.bic = bic;
		this.kontonummer = kontonummer;
		this.blz = blz;
	}
}
