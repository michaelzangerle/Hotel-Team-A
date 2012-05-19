package projekt.fhv.teama.integrate;

/**
 * Interface für die Integration für die Zimmer-Klasse
 * 
 * @author Team A
 * @version 1.3
 */
public interface IAZimmer {

	/**
	 * Gibt die Zimmer-Nummer zurück
	 * @return String
	 */
	String getNummer();

	/**
	 * Gibt die Kategorie zurück
	 * @return IAKategorie
	 */
	IAKategorie getAKategorie();

}
