package projekt.fhv.teama.classes.zimmer;

import java.util.Set;

import projekt.fhv.teama.classes.IKategoriekontingent;
import projekt.fhv.teama.classes.IModel;

/**
 * Interface f�r die Klasse Kategorie 
 * @author Team A
 * @version 1.2
 */
public interface IKategorie extends IModel {
	
	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Bezeichnung
	 * @param bezeichnung String
	 */
	public void setBezeichnung(String bezeichnung);

	/**
	 * Retourniert den Wert des Attributs Bezeichnung
	 * @return String
	 */
	public String getBezeichnung();

	/**
	 * Hinzuf�gen eines Elements zum Attribut Zimmer
	 * @param zimmer IZimmer
	 */
	public void addZimmer(IZimmer zimmer);

	/**
	 * Entfernen des �bergebenen Elemets von dem Attribut Zimmer
	 * @param zimmer IZimmer
	 */
	public void removeZimmer(IZimmer zimmer);

	/**
	 * Retourniert den Wert des Attributs Zimmer
	 * @return Set<IZimmer>
	 */
	public Set<IZimmer> getZimmer();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Beschreibung
	 * @param beschreibung String
	 */
	public void setBeschreibung(String beschreibung);

	/**
	 * Retourniert den Wert des Attributs Beschreibung
	 * @return String
	 */
	public String getBeschreibung();

	/**
	 * Retourniert den Wert des Attributs Zimmerpreise
	 * @return Set<IZimmerpreis>
	 */
	public Set<IZimmerpreis> getZimmerpreise();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Zimmerpreise
	 * @param zimmerpreise Set<IZimmerpreis>
	 */
	public void setZimmerpreise(Set<IZimmerpreis> zimmerpreise);

	/**
	 *  Hinzuf�gen eines Elements zum Attribut 
	 * @param zimmerpreis IZimmerpreis
	 */
	public void addZimmerpreis(IZimmerpreis zimmerpreis);

	/**
	 * Entfernen des �bergebenen Elemets von dem Attribut Zimmerpreise
	 * @param zimmerpreis IZimmerpreis
	 */
	public void removeZimmerpreis(IZimmerpreis zimmerpreis);

	/**
	 * Teilreservierungen
	 * @return Set<ITeilreservierung>
	 */
	public Set<ITeilreservierung> getTeilreservierungen();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Teilreservierungen
	 * @param teilreservierungsreservierungen Set<ITeilreservierung>
	 */
	public void setTeilreservierungen(Set<ITeilreservierung> teilreservierungsreservierungen);

	/**
	 *  Hinzuf�gen eines Elements zum Attribut Teilreservierungen
	 * @param teilreservierung
	 */
	public void addTeilreservierung(ITeilreservierung teilreservierung);

	/**
	 * Entfernen des �bergebenen Elemets von dem Attribut Teilreservierungen
	 * @param teilreservierung ITeilreservierung
	 */
	public void removeTeilreservierung(ITeilreservierung teilreservierung);
	
	/**
	 * Retourniert den Wert des Attributs Kategoriekontingent
	 * @return Set<IKategoriekontingent>
	 */
	public Set<IKategoriekontingent> getKategoriekontingent();
	
	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Kategoriekontingent
	 * @param kategoriekontingent Set<IKategoriekontingent>
	 */
	public void setKategoriekontingent(Set<IKategoriekontingent> kategoriekontingent);
	
	/**
	 *  Hinzuf�gen eines Elements zum Attribut Kategoriekontingent
	 * @param kategoriekontingent IKategoriekontingent
	 */
	public void addKategoriekontingent(IKategoriekontingent kategoriekontingent);
	
	/**
	 * Entfernen des �bergebenen Elemets von dem Attribut Kategoriekontingente
	 * @param kategoriekontingent IKategoriekontinget
	 */
	public void removeKategoriekontingent(IKategoriekontingent kategoriekontingent);
}
