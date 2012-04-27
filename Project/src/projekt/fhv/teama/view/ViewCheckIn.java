package projekt.fhv.teama.view;

import java.net.URL;
import java.util.LinkedList;

import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.List;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.*;

import projekt.fhv.teama.view.support.Address;
import projekt.fhv.teama.view.support.Contact;
import projekt.fhv.teama.view.support.IMAccount;


public class ViewCheckIn extends Border implements Bindable {
	    Form chf1;Form chf2;Form chf3;Form chf4;Form chf5;Form chf6;
	    PushButton clearButton = null;
		
	 
	    @Override
		public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
	        chf1 = (Form)arg0.get("chf1");
	        chf2 = (Form)arg0.get("chf2");
	        chf3 = (Form)arg0.get("chf3");
	        chf4 = (Form)arg0.get("chf4");
	        chf5 = (Form)arg0.get("chf5");
	        chf6 = (Form)arg0.get("chf6");    
	    }
	    
	    
	    void clearCheckInForms() {
	    	
	    	chf1.clear();
	    	chf2.clear();
	    	chf3.clear();
	    	chf4.clear();
	    	chf5.clear();
	    	chf6.clear();	    	
	    }
	    

}
