package projekt.fhv.teama.classes.personen;

import projekt.fhv.teama.classes.IModel;

/**
 * Beschreibt die Wichtigsten Methoden für die Kontodaten
 * 
 * @author Team-A
 * @version 1.5
 */
public interface IKontodaten extends IModel {

	/**
	 * Um den Iban der Kontodaten zu setzen
	 * @param iban 
	 */
	public void setIban(String iban);

	/**
	 * Um den Iban abzurufen
	 * @return iban String
	 */
	public String getIban();

	/**
	 * Um den Bic der Kontodaten zu setzen
	 * @param bic String
	 */
	public void setBic(String bic);

	/**
	 * Um den Bic abzurufen
	 * @return bic String
	 */
	public String getBic();

	/**
	 * Um den Kontonummer der Kontodaten zu setzen
	 * @param ktoNr String
	 */
	public void setKontonummer(String ktoNr);

	/**
	 * Um den Kontonummer abzurufen
	 * @return ktoNr String 
	 */
	public String getKontonummer();

	/**
	 * Um den Blz der Kontodaten zu setzen
	 * @param blz  String
	 */
	public void setBlz(String blz);

	/**
	 * Um den Blz abzurufen
	 * @return blz String
	 */
	public String getBlz();

}
