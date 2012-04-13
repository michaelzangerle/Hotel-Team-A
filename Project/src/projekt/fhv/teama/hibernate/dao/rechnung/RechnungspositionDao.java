/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.rechnung;

import projekt.fhv.teama.classes.rechnung.Rechnungsposition;
import projekt.fhv.teama.hibernate.dao.GenericDao;

/**
 * @author mike
 *
 */
public class RechnungspositionDao extends GenericDao<Rechnungsposition>{

	public RechnungspositionDao() {
		super("Rechnungsposition");
	}
	
	// TODO
	// Abfrage auf gast - alle rechnungspositionen eines gastes

}
