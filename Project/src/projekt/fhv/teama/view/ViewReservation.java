package projekt.fhv.teama.view;

import java.net.URL;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Border;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TextInput;

/**
 * Um den UseCase bzw. die Formulare für die Reservierung umzusetzen.
 * Die Klasse ist momentan nur benutzt um das BXML File einzulesen.
 * Es ist vorgesehen hier das Setup bzw. die Properties und 
 * und Methoden zu implementieren, die die Oberfläche der UseCases 
 * mit Reservierung betreffen.
 * 
 * Aus zeitlichen Gründen ist notwendiges momentan in der ViewMain umgesetzt. 
 *
 * @author Team A
 * @version 1.1
 */
public class ViewReservation extends Border implements Bindable {
	    @BXML Form form = null;
	    @BXML PushButton rf1PBtnLoadJava = null;
	    @BXML PushButton clearButton = null;
	    @BXML PushButton rf1PBtnEditReservation = null;
	    @BXML PushButton rf1PBtnDeleteReservation = null;
	    @BXML PushButton rf1PBtnSaveReservation = null;
	    @BXML TextInput rf1TIName = null; 
	    @BXML PushButton cf1PBtnNext = null;
	 
	    /**
	     * Initialisierungsmethode für ViewReservation.
	     * 
	     * @see org.apache.pivot.beans.Bindable#initialize(org.apache.pivot.collections.Map, java.net.URL, org.apache.pivot.util.Resources)
	     */
	    @Override
	    public void initialize(Map<String, Object> namespace, URL location, Resources resources) {
	        
	        form.setEnabled(false);
	        	        
	        clearButton.setVisible(false);	 
	      	        
	        clearButton.getButtonPressListeners().add(new ButtonPressListener() {
	            @Override
	            public void buttonPressed(Button button) {
	                form.clear();
	            }
	        });
	        
	        rf1PBtnEditReservation.getButtonPressListeners().add(new ButtonPressListener() {
	            @Override
	            public void buttonPressed(Button button) {
	            	form.setEnabled(true);
	            	rf1TIName.requestFocus();
	            	
	            }
	        });	        
	        
	        rf1PBtnSaveReservation.getButtonPressListeners().add(new ButtonPressListener() {
	            @Override
	            public void buttonPressed(Button button) {
	            	form.setEnabled(false);	            	
	            }
	        });	        
	        
	    }
}
