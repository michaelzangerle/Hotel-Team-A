package projekt.fhv.teama.classes.rechnung;

import projekt.fhv.teama.classes.IModel;
import roomanizer.teamb.service.integrate.IBTeilzahlung;

/**
 * Interface f�r eine Teilzahlung 
 * @author Team A
 * @version 1.9
 */
public interface ITeilzahlung extends IModel,IBTeilzahlung {

	/**
	 * Setzt den Wert des Attributs Zahlungsmethode auf den �bergebenen Wert
	 * @param zahlungsmethoden Set<IZahlunsmethode>
	 */
	public void setZahlungsmethode(IZahlungsmethode zahlungsmethode);

	/**
	 * Gibt den Wert des Attributs Zahlungsmethode zur�ck
	 * @return Set<IZahlungsmethode>
	 */
	public IZahlungsmethode getZahlungsmethode();

	/**
	 * Setzt das Attribut Rechnung auf den �bergebenen Wert
	 * @param rechnung IRechnung
	 */
	public void setRechnung(IRechnung rechnung);

	/**
	 * Gibt den Wert des Attributs Rechnung zur�ck
	 * @return IRechnung
	 */
	public IRechnung getRechnung();

	/**
	 * Setzt das Attribut Betrag auf den �bergebenen Wert
	 * @param betrag float
	 */
	public void setBetrag(float betrag);

	/**
	 * Gibt den Wert des Attributs Betrag zur�ck
	 * @return float
	 */
	public float getBetrag();
}
