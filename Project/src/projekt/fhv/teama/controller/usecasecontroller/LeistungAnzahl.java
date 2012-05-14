package projekt.fhv.teama.controller.usecasecontroller;

import projekt.fhv.teama.classes.leistungen.ILeistung;

public class LeistungAnzahl {

	private ILeistung leistung;
	private int anzahl;
	
	public LeistungAnzahl(ILeistung leistung,int anzahl) {
		this.leistung=leistung;
		this.anzahl=anzahl;
	}
	
	public ILeistung getLeistung() {
		return leistung;
	}

	public void setLeistung(ILeistung leistung) {
		this.leistung = leistung;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}
	
}
