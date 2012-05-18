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

	IAGast getAGast();

	IAZimmer getAZimmer();

	Date getAVon();

	Date getABis();
	
	IAPfandtyp getAPfandtyp();
	
	String getPfandNr();

	/**
	 * @return
	 */
	int getID();
}
