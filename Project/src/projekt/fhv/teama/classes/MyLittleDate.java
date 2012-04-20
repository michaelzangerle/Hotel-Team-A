package projekt.fhv.teama.classes;

import java.sql.Date;
import java.util.GregorianCalendar;

public class  MyLittleDate {

	
	private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month-1, day).getTime().getTime());

    }
	 
	 @SuppressWarnings({ "unused", "deprecation" })
	private static Date getCurrentDate()
	 {
		 java.util.Date date =new java.util.Date();
		return getDate(date.getYear(), date.getMonth(), date.getDay());
	 }
}
