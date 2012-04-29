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


public class SHSDateTime extends Thread implements Bindable {
	
	@BXML
	String currentTime = "init";
	
	@BXML
	String currentDay = "binit";
	
	@BXML
	String currentDate = "cinit";
	
	DateFormat time;
	
	public SHSDateTime() {				
		
	}
	
	
	public String getCurrentTime() {
		return currentTime;
	}

	public String getCurrentDay() {
		return currentDay;
	}

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
