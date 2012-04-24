package projekt.fhv.teama.classes.personen;

import projekt.fhv.teama.classes.IModel;

public interface IKontodaten extends IModel {

	public void setIban(String iban);
	public String getIban();
	public void setBic(String bic);
	public String getBic();
	public void setKontonummer(String ktoNr);
	public String getKontonummer();
	public void setBlz(String blz);
	public String getBlz();

}
