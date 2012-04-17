/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.rechnung;

import java.util.List;

import projekt.fhv.teama.classes.rechnung.Rechnungsposition;
import projekt.fhv.teama.hibernate.dao.GenericDao;

/**
 * @author mike
 * 
 */
public class RechnungspositionDao extends GenericDao<Rechnungsposition> {
	
	public RechnungspositionDao() {
		super("Rechnungsposition");
	}

	public List<Rechnungsposition> getRechnungspostionenByGuestName(String vorname, String nachname) {

		// TODO Rechnungsposition: getRechnungspostionenByGuestName(String
		// vorname, String nachname)
		// Abfrage auf gast - alle rechnungspositionen eines gastes
		return null;
	}

	public List<Rechnungsposition> getRechnungspostionenByZimmerNummer(String nummer) {

		// TODO Rechnungsposition: getRechnungspostionenByZimmerNummer(String nummer)
		// Abfrage auf gast - alle rechnungspositionen eines gastes
		return null;
	}

}
