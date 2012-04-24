package projekt.fhv.teama.classes;

/**
 * Gibt f�r alle Models die Getter und Setter f�r die Property ID vor
 * 
 * @author Team A
 * @version 1.8
 */
public interface IModel {

	/**
	 * Setzt das Attribut ID
	 * @param ID Akzeptiert einen int-Wert
	 */
	public void setID(int ID);

	/**
	 * Gibt den Wert des Attributs ID als int zur�ck
	 * @return Gibt die ID als int zur�ck
	 */
	public int getID();

}
