package projekt.fhv.teama.classes.rechnung;

import java.util.Set;

import projekt.fhv.teama.classes.IModel;

/**
 * Interface für eine Teilzahlung 
 * @author Team A
 * @version 1.9
 */
public interface ITeilzahlung extends IModel {

	/**
	 * Setzt den Wert des Attributs Zahlungsmethode auf den übergebenen Wert
	 * @param zahlungsmethoden Set<IZahlunsmethode>
	 */
	public void setZahlungsmethoden(Set<IZahlungsmethode> zahlungsmethoden);

	/**
	 * Gibt den Wert des Attributs Zahlungsmethode zurück
	 * @return Set<IZahlungsmethode>
	 */
	public Set<IZahlungsmethode> getZahlungsmethoden();

	/**
	 * Fügt eine Zahlungsmethode zum Attribut Zahlungsmethoden hinzu
	 * @param zahlungsmethode IZahlungsmethode
	 */
	public void addZahlungsmethode(IZahlungsmethode zahlungsmethode);

	/**
	 * Entfernt den übergebenen Wert aus dem Attribut Zahlungsmethoden
	 * @param zahlungsmethode IZahlungsmethode
	 */
	public void removeZahlungsmethode(IZahlungsmethode zahlungsmethode);

	/**
	 * Setzt das Attribut Rechnung auf den übergebenen Wert
	 * @param rechnung IRechnung
	 */
	public void setRechnung(IRechnung rechnung);

	/**
	 * Gibt den Wert des Attributs Rechnung zurück
	 * @return IRechnung
	 */
	public IRechnung getRechnung();

	/**
	 * Setzt das Attribut Betrag auf den übergebenen Wert
	 * @param betrag float
	 */
	public void setBetrag(float betrag);

	/**
	 * Gibt den Wert des Attributs Betrag zurück
	 * @return float
	 */
	public float getBetrag();
}
