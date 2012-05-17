package projekt.fhv.teama.classes.rechnung;

import projekt.fhv.teama.classes.IModel;
import roomanizer.teamb.service.integrate.IBTeilzahlung;

/**
 * Interface für eine Teilzahlung 
 * @author Team A
 * @version 1.9
 */
public interface ITeilzahlung extends IModel,IBTeilzahlung {

	/**
	 * Setzt den Wert des Attributs Zahlungsmethode auf den übergebenen Wert
	 * @param zahlungsmethoden Set<IZahlunsmethode>
	 */
	public void setZahlungsmethode(IZahlungsmethode zahlungsmethode);

	/**
	 * Gibt den Wert des Attributs Zahlungsmethode zurück
	 * @return Set<IZahlungsmethode>
	 */
	public IZahlungsmethode getZahlungsmethode();

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
