package projekt.fhv.teama.classes.personen;

import projekt.fhv.teama.classes.IModel;
import roomanizer.teamb.service.integrate.IBLand;

/**
 * Interface für das Land
 * @author Team-A
 * @version 1.5
 */
public interface ILand extends IModel,IBLand{


	/**
	 * Um die Bezeichnung des Landes zu setzen
	 * @param bezeichnung String
	 */
	public void setBezeichnung(String bezeichnung);

	/**
	 * Um die Bezeichnung abzurufen
	 * @return String
	 */
	public String getBezeichnung();

	/**
	 * Um die Kuerzel des Landes zu setzen
	 * @param bezeichnung String
	 */
	public void setKuerzel(String kuerzel);

	/**
	 * Um die Kuerzel abzurufen
	 * @return String
	 */
	public String getKuerzel();
}
