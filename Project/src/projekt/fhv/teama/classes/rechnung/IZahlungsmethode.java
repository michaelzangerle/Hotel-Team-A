package projekt.fhv.teama.classes.rechnung;

import projekt.fhv.teama.classes.IModel;
import roomanizer.teamb.service.integrate.IBZahlungsmethode;

/**
 * Interface f�r eine Zahlungsmethode 
 * @author Team A
 * @version 1.9
 */
public interface IZahlungsmethode extends IModel,IBZahlungsmethode {
	
	/**
	 * Setzt das Attribut Bezeichnung auf den �bergebenen Wert
	 * @param bezeichnung String 
	 */
	public void setBezeichnung(String bezeichnung);

	/**
	 * Gibt den Wert des Attributs Bezeichnung zur�ck
	 * @return String
	 */
	public String getBezeichnung();

	/**
	 * Setzt das Attribut Beschreibung auf den �bergebenen Wert
	 * @param beschreibung String
	 */
	public void setBeschreibung(String beschreibung);

	/**
	 * Gibt den Wert des Attributs Beschreibung zur�ck
	 * @return Strin
	 */
	public String getBeschreibung();

	/**
	 * Setzt das Attribut K�rzel auf den �bergebenen Wert
	 * @param kuerzel String
	 */
	public void setKuerzel(String kuerzel);

	/**
	 * Gibt den Wert des Attributs Kuerzel zur�ck
	 * @return String
	 */
	public String getKuerzel();
}
