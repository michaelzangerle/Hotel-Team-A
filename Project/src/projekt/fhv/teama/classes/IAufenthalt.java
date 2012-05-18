package projekt.fhv.teama.classes;

import java.sql.Date;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.integrate.IAAufenthalt;

/**
 * Interface f�r die Klasse Aufenthalt
 * @author Team A
 * @version 1.9
 */
public interface IAufenthalt extends IModel,IAAufenthalt {
	
	/**
	 * Setzt den Preis den Aufenthalt fest
	 * @param preis
	 */
	public void setPreis(Float preis);

	/**
	 * Gibt den Wert des Attributs Preis zur�ck
	 * @return Float-Wert des Preis Attributs
	 */
	public Float getPreis();

	/**
	 * Setzen des Werts f�r das Pfandtyp Attribut
	 * @param pfandtyp IPfandTyp-Objekt welcher dem Attribut zugewiesen wird
	 */
	public void setPfandtyp(IPfandtyp pfandtyp);

	/**
	 * Gibt den Wert des Attributs Pfand zur�ck
	 * @return PfandTyp-Objekt des Pfand-Typ Attributs
	 */
	public IPfandtyp getPfandtyp();

	/**
	 * Setzen des Werts f�r das Von Attribut
	 * @param von Date-Objekt welcher dem Attribut zugewiesen wird
	 */
	public void setVon(Date von);

	/**
	 * Gibt den Wert des Attributs Von zur�ck
	 * @return Date-Objekt des Attributs
	 */
	public Date getVon();

	/**
	 * Setzen des Werts f�r das Bis Attribut
	 * @param bis Date-Objekt welcher dem Attribut zugewiesen wird
	 */
	public void setBis(Date bis);

	/**
	 * Gibt den Wert des Attributs Bis zur�ck
	 * @return Date-Objekt des Attributs
	 */
	public Date getBis();

	/**
	 * Setzen des Werts f�r das Schl�ssel Attribut
	 * @param schluessel Schl�ssel-Objekt welcher dem Attribut zugewiesen wird
	 */
	public void setSchluessel(boolean schluessel);

	/**
	 * Setzen des Werts f�r das Schl�ssel Attribut
	 * @return Schluessel-Wert des Schl�ssel Attributs
	 */
	public boolean getSchluessel();

	/**
	 * Setzen des Werts f�r das PfandNr Attribut
	 * @param pfandNr String-Wert welcher dem Attribut zugewiesen wird
	 */
	public void setPfandNr(String pfandNr);

	/**
	 * Gibt den Wert des Attributs PfandNr zur�ck
	 * @return String-Wert des PfandNr Attributs
	 */
	public String getPfandNr();

	/**
	 * Gibt den Wert des Attributs Gast zur�ck
	 * @return IGast-Objekt des Gast Attributs
	 */
	public IGast getGast();

	/**
	 * Setzen des Werts f�r das Gast Attribut
	 * @param gast IGast-Objekt welcher dem Attribut zugewiesen wird
	 */
	public void setGast(IGast gast);

	/**
	 * Gibt den Wert des Attributs Zimmer zur�ck
	 * @return IZimmer-Objekt des Attributs
	 */
	public IZimmer getZimmer();

	/**
	 * Setzen des Werts f�r das Zimmer Attribut
	 * @param zimmer IZimmer-Objekt welcher dem Attribut zugewiesen wird
	 */
	public void setZimmer(IZimmer zimmer);

}
