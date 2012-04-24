package projekt.fhv.teama.classes;

import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * Hilfsklasse zum Erstellen eines Datums
 * @author Team A
 * @version 1.1
 */
public class  MyLittleDate {

	
	/**
	 * Liefert ein datenbankkompatibles Datum zurück
	 * @param year Jahr
	 * @param month Monat
	 * @param day Tag
	 * @return Gibt ein java.sql.Date zurück
	 */
	public static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month-1, day).getTime().getTime());

    }
	 
	 /**
	  * Gibt das aktuelle Datum zurück
	 * @return Aktuelles java.sql.Date
	 */
	@SuppressWarnings({ "deprecation" })
	public static Date getCurrentDate()
	 {
		 java.util.Date date =new java.util.Date();
		return getDate(date.getYear(), date.getMonth(), date.getDay());
	 }
}
