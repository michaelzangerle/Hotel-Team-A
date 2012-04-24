package projekt.fhv.teama.classes.personen;

import java.util.Set;

import projekt.fhv.teama.classes.IModel;


/**
 * Widerspiegelt die Schnittstelle für eine Berechtigung
 * @author Team-A
 * @version 1.5
 */
public interface IBerechtigung extends IModel {
	
	/**
	 * Um die Bezeichnung einer Berechtigung zu setzen
	 * @param bezeichnung String
	 */
	public void setBezeichnung(String bezeichnung);

	/**
	 * Um die Bezeichnung einer Berechtigung abzufragen
	 * @return String
	 */
	public String getBezeichnung();

	/**
	 * Um die Beschreibung einer Berechtigung zu setzen
	 * @param bezeichnung String
	 */
	public void setBeschreibung(String beschreibung);

	/**
	 * Um die Beschreibung einer Berechtigung abzufragen
	 * @return String
	 */
	public String getBeschreibung();

	/**
	 * Um das Kuerzel einer Berechtigung zu setzen
	 * @param bezeichnung String
	 */
	public void setKuerzel(String kuerzel);

	/**
	 * Um das Kuerzel einer Berechtigung abzufragen
	 * @return String
	 */
	public String getKuerzel();

	/**
	 * Um eine List von berechtigten Mitarbeiter zu erhalten
	 * @return Set<IMitarbeiter>
	 */
	public Set<IMitarbeiter> getBerechtigte();

	/**
	 * Um eine Liste von Berechtigte zu setzen
	 * @param berechtigte Set<IMitarbeiter>
	 */
	public void setBerechtigte(Set<IMitarbeiter> berechtigte);

	/**
	 * Um einen Mitarbeiter zu den Berechtigten hinzuzufügen
	 * @param berechtigter IMitarbeiter
	 */
	public void addBerechtigter(IMitarbeiter berechtigter);
	
	/**
	 * Um einen Mitarbeiter von den Berechtigten zu entfernen
	 * @param berechtigter IMitarbeiter
	 */
	public void removeBerechtigter(IMitarbeiter berechtigter);
}
