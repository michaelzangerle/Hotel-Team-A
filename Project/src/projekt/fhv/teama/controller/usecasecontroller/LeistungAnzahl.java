package projekt.fhv.teama.controller.usecasecontroller;

import projekt.fhv.teama.integrate.IALeistung;

/**
 * Diese Klasse dient als Wrapper um eine Leistung in Verbindung zu einer Anzahl 
 *
 * @author Team-A
 * @version 1.5
 */
public class LeistungAnzahl {

	private IALeistung leistung;
	private int anzahl;
	
	public LeistungAnzahl(IALeistung leistung,int anzahl) {
		this.leistung=leistung;
		this.anzahl=anzahl;
	}
	
	/**
	 * Methode um die Leistung zu holen
	 * @return ILeistung
	 */
	public IALeistung getLeistung() {
		return leistung;
	}

	/**
	 * Methode um die Leistung zu sezten
	 * @param leistung
	 */
	public void setLeistung(IALeistung leistung) {
		this.leistung = leistung;
	}

	/**
	 * Methode um die Anzahl zu holen
	 * @return int
	 */
	public int getAnzahl() {
		return anzahl;
	}

	/**
	 * Methode um die Anzahl zu setzen
	 * @param anzahl
	 */
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}
	
}
