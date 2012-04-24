package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.model.exception.FokusException;

/**
 * Interface des Kategorie Model, beschreibt die wichtigsten Methden um mit einer Kategore arbeiten zu können
 * @author Team-A
 * @version 1.5
 */
public interface IModelKategorie {

	/**
	 * Um die fokusierte Kategorie abzurufen
	 * @return IKategorie
	 * @throws FokusException
	 */
	IKategorie getKategorie() throws FokusException;

	/**
	 * Um den fokus auf eine Kategorie zu legen
	 * @param kategorie IKategorie
	 */
	void setKategorie(IKategorie kategorie);

}
