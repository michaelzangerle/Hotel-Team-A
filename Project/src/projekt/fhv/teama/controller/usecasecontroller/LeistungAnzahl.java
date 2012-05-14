package projekt.fhv.teama.controller.usecasecontroller;

import projekt.fhv.teama.classes.leistungen.ILeistung;

/**
 * Diese Klasse dient als Wrapper um eine Leistung in Verbindung zu einer Anzahl 
 *
 * @author Team-A
 * @version 1.5
 */
public class LeistungAnzahl {

	private ILeistung leistung;
	private int anzahl;
	
	public LeistungAnzahl(ILeistung leistung,int anzahl) {
		this.leistung=leistung;
		this.anzahl=anzahl;
	}
	
	/**
	 * Methode um die Leistung zu holen
	 * @return ILeistung
	 */
	public ILeistung getLeistung() {
		return leistung;
	}

	/**
	 * Methode um die Leistung zu sezten
	 * @param leistung
	 */
	public void setLeistung(ILeistung leistung) {
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
