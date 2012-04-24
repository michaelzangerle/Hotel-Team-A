package projekt.fhv.teama.classes;

import java.sql.Date;

import projekt.fhv.teama.classes.personen.IVertragspartner;

/**
 * Interface f�r die Klasse Kontingent
 * @author Team A
 * @version 1.9
 */
public interface IKontingent extends IModel {
	
	/**
	 * Setzt den Wert des Attributs Von
	 * @param von Date-Objekt
	 */
	public void setVon(Date von);

	/**
	 * Gibt den Wert des Attributs Von zur�ck
	 * @return Date-Objekt
	 */
	public Date getVon();

	/**
	 * Setzt den Wert des Attributs Bis
	 * @param bis Date-Objekt
	 */
	public void setBis(Date bis);

	/**
	 * Gibt den Wert des Attributs Bis zur�ck
	 * @return Date-Objekt
	 */
	public Date getBis();

	/**
	 * Setzt den Wert des Attributs Kondition
	 * @param kondition short-Wert
	 */
	public void setKondition(short kondition);

	/**
	 * Gibt den Wert des Attributs Kondition zur�ck
	 * @return short-Wert
	 */
	public short getKondition();

	/**
	 * Setzt den Wert des Attributs �berbuchungsgrenze
	 * @param ueberbuchungsgrenze short-Wert
	 */
	public void setUeberbuchungsgrenze(short ueberbuchungsgrenze);

	/**
	 * Gibt den Wert des Attributs �berbuchungsgrenze zur�ck
	 * @return short-Wert
	 */
	public short getUeberbuchungsgrenze();

	/**
	 * Setzt den Wert des Attributs Vertragspartner
	 * @param vertragspartner IVertragspartner-Objekt
	 */
	public void setVertragspartner(IVertragspartner vertragspartner);

	/**
	 * Gibt den Wert des Attributs Vertragspartner zur�ck
	 * @return IVertragspartner-Objekt
	 */
	public IVertragspartner getVertragspartner();

}
