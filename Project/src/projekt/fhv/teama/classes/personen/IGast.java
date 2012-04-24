package projekt.fhv.teama.classes.personen;

import java.util.Set;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.rechnung.IRechnungsposition;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;

/**
 * Beschreibt die Methoden die der Gast ben�tigt
 * @author Team-A
 * @version 1.5
 */
public interface IGast extends IPerson {
	
	/**
	 * Um die Gastnummer zu setzen
	 * @param nummer String
	 */
	public void setNummer(String nummer);

	/**
	 * Um die Gastnummer zuerhalten
	 * @return String Gastnummer
	 */
	public String getNummer();

	/**
	 * Um eine Rechnungsposition hinzuzuf�gen 
	 * @param rePos IRechnungsposition
	 */
	public void addRechnungposition(IRechnungsposition rePos);

	/**
	 * Um eine Rechnungsposition zu l�schen 
	 * @param rePos IRechnungsposition
	 */
	public void removeRechnungsposition(IRechnungsposition rePos);

	/**
	 * Um die Rechnungspositionen abzufragen
	 * @return Set<IRechnungspostion>
	 */
	public Set<IRechnungsposition> getRechnungsposition();

	/**
	 * Um eine Reservierung hinzuzuf�gen 
	 * @param res IReservierung
	 */
	public void addReservierung(IReservierung res);
	/**
	 * Um eine Reservierung zu l�schen 
	 * @param res IReservierung
	 */
	public void removeReservierung(IReservierung res);

	/**
	 * Um die Reservierungen zum Gast abzurufen
	 * @return Set<IReservierung>
	 */
	public Set<IReservierung> getReservierungen();

	/**
	 * Um einen Aufenthalt hinzuzuf�gen
	 * @param aufenthalt IAufenthalt
	 */
	public void addAufenthalt(IAufenthalt aufenthalt);

	/**
	 * Um die Aufenthalte eines Gastes abzurufen
	 * @return Set<IAufenthalt>
	 */
	public Set<IAufenthalt> getAufenthalte();

	/**
	 * Um einen Aufenthalt zu l�schen
	 * @param aufenthalt IAufenthalt
	 */
	public void removeAufenthalt(IAufenthalt aufenthalt);

	/**
	 * Um das Zimmer im Gast zu setzen
	 * @param zimmer IZimmer
	 */
	public void setZimmer(IZimmer zimmer);

	/**
	 * Um das Zimmer des Gastes abzurufen
	 * @return IZimmer
	 */
	public IZimmer getZimmer();
}
