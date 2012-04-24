package projekt.fhv.teama.classes.zimmer;

import projekt.fhv.teama.classes.IModel;

/**
 * Interface f�r die Klasse Zimmerpreis 
 * @author Team A
 * @version 1.2
 */
public interface IZimmerpreis extends IModel {
	
	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Kategorie
	 * @param kategorie IKategorie
	 */
	public void setKategorie(IKategorie kategorie);

	/**
	 * Retourniert den Wert des Attributs Kategorie
	 * @return IKategorie
	 */
	public IKategorie getKategorie();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Saison
	 * @param saison ISaison
	 */
	public void setSaison(ISaison saison);

	/**
	 * Retourniert den Wert des Attributs Saison
	 * @return ISaison
	 */
	public ISaison getSaison();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Preis
	 * @param preis float
	 */
	public void setPreis(float preis);

	/**
	 * Retourniert den Wert des Attributs Preis
	 * @return float
	 */
	public float getPreis();
}
