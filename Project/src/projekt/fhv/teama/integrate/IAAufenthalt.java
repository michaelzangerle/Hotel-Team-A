/**
 * 
 */
package projekt.fhv.teama.integrate;

import java.sql.Date;

/**
 * Beschreibt
 * 
 * @author Team A
 * @version 1.2
 */
public interface IAAufenthalt {

	IAGast getGast();

	IAZimmer getZimmer();

	Date getVon();

	Date getBis();
	
	IAPfandtyp getPfandtyp();
	
	String getPfandNr();
}
