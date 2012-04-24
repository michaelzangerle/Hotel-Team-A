package projekt.fhv.teama.classes.personen;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.classes.rechnung.IRechnung;


/**
 * Beinhaltet alle wichtigen Methoden für den Mitarbeiter
 * @author Team-A
 * @version 1.5
 */
public interface IMitarbeiter extends IPerson {
	
	/**
	 * Zum setzen eines Passwortes
	 * @param passwort String
	 */
	public void setPasswort(String passwort);

	/**
	 * Zum abrufen des Passwortes
	 * @return String
	 */
	public String getPasswort();

	/**
	 * Zum setzen des Einstelldatums
	 * @param einstellung Date
	 */
	public void setEinstellung(Date einstellung);

	/**
	 * Zum Abrufen des Einstelldatums
	 * @return Date
	 */
	public Date getEinstellung();

	/**
	 * Um die Berechtigungen abzurufen für einen Mitarbeiter
	 * @return Set<IBerechtigung>
	 */
	public Set<IBerechtigung> getBerechtigungen();

	/**
	 * Um eine Berechtigung hinzufügen
	 * @param berechtigung IBerechtigung
	 */
	public void addBerechtigung(IBerechtigung berechtigung);

	/**
	 * Um eine Berechtigung zu löschen
	 * @param berechtigung IBerechtigung
	 */
	public void removeBerechtigung(IBerechtigung berechtigung);

	/**
	 * Um ein Set von Berechtigungen zuzuweisen
	 * @param berechtigungen Set<IBerechtigung>
	 */
	public void setBerechtigungen(Set<IBerechtigung> berechtigungen);

	/**
	 * Um die Rechnungen abzurufen die vom Mitarbeiter bearbeitet wurden
	 * @return Set<IRechnung>
	 */
	public Set<IRechnung> getRechnungen();

	/**
	 * Um die Rechnungen die vom Mitarbeiter bearbeitet wurden hinzuzufügen
	 * @param rechnungen Set<IRechnung>
	 */
	public void setRechnungen(Set<IRechnung> rechnungen);

	/**
	 * Um die Rechnung die vom Mitarbeiter bearbeitet wurden hinzuzufügen
	 * @param rechnungen Set<IRechnung>
	 */
	public void addRechnung(IRechnung rechnung);

	/**
	 * Um die Rechnung zu löschen
	 * @param rechnungen Set<IRechnung>
	 */
	public void removeRechnung(IRechnung rechnung);
	
	/**
	 * Um die Mitarbeiternummer abzurufen
	 * @return String
	 */
	public String getNummer();
	
	/**
	 * Um die Mitarbeiternummer zu setzen
	 * @param nummer String
	 */
	public void setNummer(String nummer);
}
