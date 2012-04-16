package projekt.fhv.teama.classes.personen;

public class Bankverbindung {
    @Override
	public String toString() {
		return "Bankverbindung [iban=" + iban + ", bic=" + bic
				+ ", kontonummer=" + kontonummer + ", blz=" + blz + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bic == null) ? 0 : bic.hashCode());
		result = prime * result + ((blz == null) ? 0 : blz.hashCode());
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		result = prime * result + ((kontonummer == null) ? 0 : kontonummer.hashCode());
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
		Bankverbindung other = (Bankverbindung) obj;
		if (bic == null) {
			if (other.bic != null)
				return false;
		} else if (!bic.equals(other.bic))
			return false;
		if (blz == null) {
			if (other.blz != null)
				return false;
		} else if (!blz.equals(other.blz))
			return false;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		if (kontonummer == null) {
			if (other.kontonummer != null)
				return false;
		} else if (!kontonummer.equals(other.kontonummer))
			return false;
		return true;
	}

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
	
	
	
	public Bankverbindung() {
	}
	
	public Bankverbindung(String iban, String bic, String kontonummer, String blz) {
		this.iban = iban;
		this.bic = bic;
		this.kontonummer = kontonummer;
		this.blz = blz;
	}
}
