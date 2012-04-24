package projekt.fhv.teama.classes.personen;

import java.util.Set;

import projekt.fhv.teama.classes.IModel;


/**
 * Beinhaltet alle wichtigen Methode im Bezug auf eine Adresse
 * @author Team-A
 * @version 1.5
 */
public interface IAdresse extends IModel {

	/**
	 * Um die Strasse in der Adresse zu bearbeiten
	 * @param strasse String
	 */
	public void setStrasse(String strasse);

	/**
	 * Um die Strasse einer Adresse abrufen zu können
	 * @return String
	 */
	public String getStrasse();

	/**
	 * Um den Ort in der Adresse zu bearbeiten
	 * @param ort String
	 */
	public void setOrt(String ort);

	/**
	 * Um den Ort einer Adresse abrufen zu können
	 * @return String
	 */
	public String getOrt();

	/**
	 * Um die PLZ einer Adresse abrufen setzen zu können
	 * @return String
	 */
	public void setPlz(String plz);
	/**
	 * Um die PLZ einer Adresse abrufen zu können
	 * @return String
	 */
	public String getPlz();
	/**
	 * Um das Land einer Adresse abrufen zu können
	 * @return String
	 */
	public ILand getLand();

	/**
	 * Um das Land einer Adresse abrufen zu können
	 * @return String
	 */
	public void setLand(ILand land);

	/**
	 * Um die Personen zu einer Adresse zu erhalten
	 * @return set<IPerson>
	 */
	public Set<IPerson> getPerson();

	/**
	 * Um eine Personenliste einer Adresse zu zuweisen
	 * @param person Set<IPerson>
	 */
	public void setPerson(Set<IPerson> person);

	/**
	 * Um die Vertragspartner zu einer Adresse zu erhalten
	 * @return set<IPerson>
	 */
	public Set<IVertragspartner> getVertragspartner();
	/**
	 * Um  Vertragspartner einer Adresse zu zuweisen
	 * @param person Set<IPerson>
	 */
	public void setVertragspartner(Set<IVertragspartner> vertragspartner);

}
