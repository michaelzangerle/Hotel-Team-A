package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.classes.IModel;

/**
 * Interface für die Klasse Saison 
 * @author Team A
 * @version 1.2
 */
public interface ISaison extends IModel {
	
	/**
	 * Setzt den übergebenen Wert für das Attribut Bezeichnung
	 * @param bezeichnung String
	 */
	public void setBezeichnung(String bezeichnung);

	/**
	 * Retourniert den Wert des Attributs Bezeichnung
	 * @return String
	 */
	public String getBezeichnung();

	/**
	 * Setzt den übergebenen Wert für das Attribut Von
	 * @param von java.sql.Date
	 */
	public void setVon(Date von);

	/**
	 * Retourniert den Wert des Attributs Von
	 * @return java.sql.Date
	 */
	public Date getVon();

	/**
	 * Setzt den übergebenen Wert für das Attribut Bis
	 * @param bis java.sql.Date
	 */
	public void setBis(Date bis);

	/**
	 * Retourniert den Wert des Attributs Bis
	 * @return java.sql.Date
	 */
	public Date getBis();

	/**
	 * Retourniert den Wert des Attributs Zimmerpreise
	 * @return Set<IZimmerpreis>
	 */
	public Set<IZimmerpreis> getZimmerpreise();

	/**
	 * Setzt den übergebenen Wert für das Attribut Zimmerpreise
	 * @param zimmerpreise Set<IZimmerpreis>
	 */
	public void setZimmerpreise(Set<IZimmerpreis> zimmerpreise);

	/**
	 *  Hinzufügen eines Elements zum Attribut Zimmerpreise
	 * @param zimmerpreis IZimmerpreis
	 */
	public void addZimmerpreis(IZimmerpreis zimmerpreis);

	/**
	 * Entfernen des übergebenen Elemets von dem Attribut Zimmerpreise
	 * @param zimmerpreis IZimmerpreis
	 */
	public void removeZimmerpreis(IZimmerpreis zimmerpreis);
}
