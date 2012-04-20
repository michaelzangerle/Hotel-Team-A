package projekt.fhv.teama.classes;

import java.io.ObjectInputStream.GetField;
import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.dialect.function.VarArgsSQLFunction;

import javassist.expr.NewArray;

public class  MyLittleDate {

	
	private static Date getDate(int year, int month, int day) {

        return new Date(new GregorianCalendar(year, month-1, day).getTime().getTime());

    }
	 
	 private static Date getCurrentDate()
	 {
		 java.util.Date date =new java.util.Date();
		return getDate(date.getYear(), date.getMonth(), date.getDay());
	 }
}
