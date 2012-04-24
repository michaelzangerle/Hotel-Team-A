package projekt.fhv.teama.classes;

/**
 * Gibt für alle Models die Getter und Setter für die Property ID vor
 * 
 * @author Team A
 * @version 1.8
 */
public interface IModel {

	/**
	 * Setzt die Property ID
	 * 
	 * @param ID Akzeptiert einen int-Wert
	 */
	public void setID(int ID);

	/**
	 * Gibt den Wert der Property ID als int zurück
	 * 
	 * @return Gibt die ID als int zurück
	 */
	public int getID();

}
