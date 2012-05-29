package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.classes.IModel;
import projekt.fhv.teama.classes.leistungen.IZusatzleistung;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.classes.personen.IVertragspartner;

/**
 * Interface f�r die Klasse Reservierung
 * 
 * @author Team A
 * @version 1.2
 */
public interface IReservierung extends IModel {

	/**
	 *  Hinzuf�gen eines Elements zum Attribut Zimmer
	 * @param zimmer IZimmer
	 */
	public void addZimmer(IZimmer zimmer);

	/**
	 * Entfernen des �bergebenen Elemets von dem Attribut Zimmer
	 * @param zimmer IZimmer
	 */
	public void removeZimmer(IZimmer zimmer);

	/**
	 * Retourniert den Wert des Attributs Zimmer
	 * @return Set<IZimmer>
	 */
	public Set<IZimmer> getZimmer();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Person
	 * @param person IPerson
	 */
	public void setPerson(IPerson person);

	/**
	 * Retourniert den Wert des Attributs Person
	 * @return IPerson
	 */
	public IPerson getPerson();

	/**
	 *  Hinzuf�gen eines Elements zum Attribut G�ste
	 * @param gast IGast
	 */
	public void addGast(IGast gast);

	/**
	 * Entfernen des �bergebenen Elemets von dem Attribut Gast
	 * @param gast IGast
	 */
	public void removeGast(IGast gast);

	/**
	 * Retourniert den Wert des Attributs G�ste
	 * @return Set<IGast>
	 */
	public Set<IGast> getGaeste();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut G�ste
	 * @param gaeste Set<IGast>
	 */
	public void setGaeste(Set<IGast> gaeste);

	/**
	 *  Hinzuf�gen eines Elements zum Attribut Optionen
	 * @param option IReservierungsOption
	 */
	public void addOption(IReservierungsOption option);

	/**
	 * Entfernen des �bergebenen Elemets von dem Attribut Optionen
	 * @param option IReservierungsOption
	 */
	public void removeOption(IReservierungsOption option);

	/**
	 * Retourniert den Wert des Attributs Optionen
	 * @return Set<IReservierungsOption>
	 */
	public Set<IReservierungsOption> getOptionen();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Vertragspartner
	 * @param partner IVertragspartner
	 */
	public void setVertragspartner(IVertragspartner partner);

	/**
	 * Retourniert den Wert des Attributs Vertragspartner
	 * @return IVertragspartner
	 */
	public IVertragspartner getVertragspartner();

	/**
	 * Retourniert den Wert des Attributs Teilreservierungen
	 * @return Set<ITeilreservierung>
	 */
	public Set<ITeilreservierung> getTeilreservierungen();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Teilreservierungen
	 * @param teilreservierungen Set<ITeilreservierung>
	 */
	public void setTeilreservierungen(Set<ITeilreservierung> teilreservierungen);

	/**
	 *  Hinzuf�gen eines Elements zum Attribut Teilreservierungen
	 * @param teilreservierung
	 */
	public void addTeilreservierung(ITeilreservierung teilreservierung);

	/**
	 * Entfernen des �bergebenen Elemets von dem Attribut Teilreservierungen
	 * @param teilreservierung ITeilreservierung
	 */
	public void removeTeilreservierung(ITeilreservierung teilreservierung);

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Von
	 * @param von java.sql.Date
	 */
	public void setVon(Date von);

	/**
	 * Retourniert den Wert des Attributs Von
	 * @return java.sql.Date
	 */
	public Date getVon();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Bis
	 * @param bis java.sql.Date
	 */
	public void setBis(Date bis);

	/**
	 * Retourniert den Wert des Attributs Bis
	 * @return java.sql.Date
	 */
	public Date getBis();

	/**
	 * Retourniert den Wert des Attributs Bearbeitet
	 * @return boolean
	 */
	public boolean getBearbeitet();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut bearbeitet
	 * @param b boolean
	 */
	public void setBearbeitet(boolean b);
	
	public boolean getHaustier();

	public void setHaustier(boolean haustier);

	public IZusatzleistung getPaket();

	public void setPaket(IZusatzleistung paket);
}
