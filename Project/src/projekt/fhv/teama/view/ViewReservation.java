package projekt.fhv.teama.view;

import java.net.URL;

import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.*;

import projekt.fhv.teama.view.support.Address;
import projekt.fhv.teama.view.support.Contact;
import projekt.fhv.teama.view.support.IMAccount;

public class ViewReservation extends Border implements Bindable {
	    Form form = null;
	    PushButton rf1PBtnLoadJava = null;
	    PushButton clearButton = null;
	    PushButton rf1PBtnEditReservation = null;
	    PushButton rf1PBtnDeleteReservation = null;
	    PushButton rf1PBtnSaveReservation = null;
	    TextInput rf1TIName = null;
	    
	    
	    PushButton cf1PBtnNext = null;
	 
	    private static final Contact CONTACT = new Contact("101", "Michael Zangerle",
	        new Address("123 Main St.", "Cambridge", "MA", "02142"),
	        "(617) 555-1234", "master@meister.msc",
	        new IMAccount("mza180°", "Yahoo"));
	 
	    @Override
	    public void initialize(Map<String, Object> namespace, URL location, Resources resources) {
	        form = (Form)namespace.get("form");
	        rf1PBtnLoadJava = (PushButton)namespace.get("rf1PBtnLoadJava");
	        clearButton = (PushButton)namespace.get("clearButton");
	        rf1PBtnEditReservation = (PushButton)namespace.get("rf1PBtnEditReservation");
	        rf1PBtnDeleteReservation = (PushButton)namespace.get("rf1PbtnDeleteReservation");
	        rf1PBtnSaveReservation = (PushButton)namespace.get("rf1PBtnSaveReservation");
	        rf1TIName = (TextInput) namespace.get("rf1TIName");
	        
	        cf1PBtnNext = (PushButton)namespace.get("cf1PBtnNext");
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
