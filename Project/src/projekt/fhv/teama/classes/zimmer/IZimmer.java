package projekt.fhv.teama.classes.zimmer;

import java.util.Set;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.IModel;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.rechnung.IRechnungsposition;

/**
 * Interface für die Klasse Zimmer 
 * @author Team A
 * @version 1.2
 */
public interface IZimmer extends IModel {

	/**
	 * Setzt den übergebenen Wert für das Attribut Nummer
	 * @param nummer String
	 */
	public void setNummer(String nummer);

	/**
	 * Retourniert den Wert des Attributs Nummer
	 * @return String
	 */
	public String getNummer();

	/**
	 * Setzt den übergebenen Wert für das Attribut Kategorie
	 * @param kategorie IKategorie
	 */
	public void setKategorie(IKategorie kategorie);

	/**
	 * Retourniert den Wert des Attributs Kategorie
	 * @return IKategorie
	 */
	public IKategorie getKategorie();

	/**
	 * Setzt den übergebenen Wert für das Attribut Beschreibung
	 * @param beschreibung String
	 */
	public void setBeschreibung(String beschreibung);

	/**
	 * Retourniert den Wert des Attributs Beschreibung
	 * @return String
	 */
	public String getBeschreibung();

	/**
	 * Setzt den übergebenen Wert für das Attribut Zimmerstatus
	 * @param zimmerStatus IZimmerstatus
	 */
	public void setZimmerstatus(IZimmerstatus zimmerStatus);

	/**
	 * Retourniert den Wert des Attributs Zimmerstatus
	 * @return IZimmerstatus
	 */
	public IZimmerstatus getZimmerstatus();

	/**
	 * Retourniert den Wert des Attributs Statusentwicklungen
	 * @return Set<IStatusentwicklung>
	 */
	public Set<IStatusentwicklung> getStatusentwicklungen();

	/**
	 * Setzt den übergebenen Wert für das Attribut Statusentwicklungen
	 * @param statusenticklung Set<IStatusentwicklung>
	 */
	public void setStatusentwicklungen(Set<IStatusentwicklung> statusenticklung);
	
	/**
	 * Hinzufügen eines Elements zum Attribut Statusentwicklungen
	 * @param statusentwicklung IStatusentwicklung
	 */
	public void addStatusentwicklung(IStatusentwicklung statusentwicklung);
	
	/**
	 * Entfernen des übergebenen Elemets von dem Attribut Statusentwicklungen
	 * @param statusentwicklung IStatusentwicklung
	 */
	public void removeStatusentwicklung(IStatusentwicklung statusentwicklung);

	/**
	 *  Hinzufügen eines Elements zum Attribut Reservierungen
	 * @param res IReservierung
	 */
	public void addReservierung(IReservierung res);

	/**
	 * Entfernen des übergebenen Elemets von dem Attribut Reservierungen
	 * @param res IReservierung
	 */
	public void removeReservierung(IReservierung res);

	/**
	 * Retourniert den Wert des Attributs Reservierungen
	 * @return Set<IReservierung>
	 */
	public Set<IReservierung> getReservierungen();

	/**
	 * Setzt den übergebenen Wert für das Attribut Reservierungen
	 * @param reservierungen Set<IReservierung>
	 */
	public void setReservierungen(Set<IReservierung> reservierungen);

	/**
	 * Retourniert den Wert des Attributs Rechnungspositionen
	 * @return Set<IRechnungsposition>
	 */
	public Set<IRechnungsposition> getRechnungspositionen();

	/**
	 *  Hinzufügen eines Elements zum Attribut Rechnungspostionen
	 * @param rechnungsposition IRechnungsposition
	 */
	public void addRechungsposition(IRechnungsposition rechnungsposition);

	/**
	 * Entfernen des übergebenen Elemets von dem Attribut Rechnungspositionen
	 * @param rechnungsposition IRechnungsposition
	 */
	public void removeRechnungsposition(IRechnungsposition rechnungsposition);

	/**
	 * Setzt den übergebenen Wert für das Attribut Rechnungspositionen
	 * @param rechnungspositionen
	 */
	public void setRechnungspositionen(Set<IRechnungsposition> rechnungspositionen);

	/**
	 * Setzt den übergebenen Wert für das Attribut Gäste
	 * @param gaeste Set<IGast>
	 */
	public void setGaeste(Set<IGast> gaeste);

	/**
	 * Retourniert den Wert des Attributs Gäste
	 * @return Set<IGast>
	 */
	public Set<IGast> getGaeste();

	/**
	 *  Hinzufügen eines Elements zum Attribut Gäste
	 * @param gast IGast
	 */
	public void addGast(IGast gast);

	/**
	 * Entfernen des übergebenen Elemets von dem Attribut Gäste
	 * @param gast
	 */
	public void removeGast(IGast gast);
	
	/**
	 * Hinzufügen eines Elements zum Attribut Aufenthalte
	 * @param aufenthalt IAufenthalt
	 */
	public void addAufenthalt(IAufenthalt aufenthalt);
	
	/**
	 * Retourniert den Wert des Attributs Aufenthalte
	 * @return Set<IAufenthalt>
	 */
	public Set<IAufenthalt> getAufenthalte();
	
	/**
	 * Setzt den übergebenen Wert für das Attribut Aufenthalte
	 * @param aufenthalte Set<IAufenthalt>
	 */
	public void setAufenthalte(Set<IAufenthalt> aufenthalte);
	
	/**
	 * Entfernen des übergebenen Elemets von dem Attribut Aufenthalte
	 * @param aufenthalt IAufenthalt
	 */
	public void removeAufenthalt(IAufenthalt aufenthalt);

}
