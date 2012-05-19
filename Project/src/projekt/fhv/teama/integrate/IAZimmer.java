package projekt.fhv.teama.integrate;

/**
 * Interface f�r die Integration f�r die Zimmer-Klasse
 * 
 * @author Team A
 * @version 1.3
 */
public interface IAZimmer {

	/**
	 * Gibt die Zimmer-Nummer zur�ck
	 * @return String
	 */
	String getNummer();

	/**
	 * Gibt die Kategorie zur�ck
	 * @return IAKategorie
	 */
	IAKategorie getAKategorie();

}
