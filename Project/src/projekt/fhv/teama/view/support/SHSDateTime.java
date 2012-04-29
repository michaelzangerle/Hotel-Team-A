package projekt.fhv.teama.view.support;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;


/**
 * Eine Klasse für die Anzeige der aktuellen Uhrzeit in englischem Format.
 * Die Ausführung erfolgt in einem eigenen Thread um die laufende
 * Aktualisierung zu ermöglichen.
 *
 * @author Team A
 * @version 1.1
 */
public class SHSDateTime extends Thread implements Bindable {
	
	@BXML
	String currentTime = "init";
	
	@BXML
	String currentDay = "init";
	
	@BXML
	String currentDate = "init";
	
	DateFormat time;
	
	public SHSDateTime() {				
		
	}
	
	
	/**
	 * Gibt die aktuelle Uhrzeit zurück
	 *
	 * @return String aktuelle Uhrzeit
	 */
	public String getCurrentTime() {
		return currentTime;
	}

	/**
	 * Gibt den aktuellen Wochentag zurück.	
	 *
	 * @return String aktueller Wochentag
	 */
	public String getCurrentDay() {
		return currentDay;
	}

	/**
	 * Gibt das aktuelle Datum zurück
	 * 
	 * @return String aktuelles Datum
	 */
	public String getCurrentDate() {
		return currentDate;
	}
	
	public void setCurrentTime(String timeformat) {
	   currentTime = timeformat;
	}

	@Override
	public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
		// wird nicht benötigt		
	}


	/**
	 * In der run() Methode wird das Datum, die Uhrzeit und der
	 * Wochentag mit dem SimpleDateFormat erzeugt.
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {			
		 
		 time = new SimpleDateFormat("EEEE", Locale.ENGLISH);
		 currentDay = time.format(new Date());
		 
		 time = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH );
		 currentDate = time.format(new Date());	
		
			while(true) {
				
				 time = new SimpleDateFormat("KK:mm:ss a");
				 this.setCurrentTime(time.format(new Date()));
			}
	}

	
}
