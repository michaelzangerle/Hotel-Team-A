package projekt.fhv.teama.view;

import java.net.URL;

import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.*;

import projekt.fhv.teama.view.support.Address;
import projekt.fhv.teama.view.support.Contact;
import projekt.fhv.teama.view.support.IMAccount;


public class ViewCheckIn extends Border implements Bindable {
	    Form form = null;
	    PushButton loadJavaButton = null;
	    PushButton clearButton = null;
	    Label sourceLabel = null;
	    
	    PushButton cf1PBtnNext = null;
	 
	    private static final Contact CONTACT = new Contact("101", "Michael Zangerle",
	        new Address("123 Main St.", "Cambridge", "MA", "02142"),
	        "(617) 555-1234", "master@meister.msc",
	        new IMAccount("mza180°", "Yahoo"));
	 
	    @Override
	    public void initialize(Map<String, Object> namespace, URL location, Resources resources) {
	        form = (Form)namespace.get("form");
	        loadJavaButton = (PushButton)namespace.get("loadJavaButton");
	        clearButton = (PushButton)namespace.get("clearButton");
	        sourceLabel = (Label)namespace.get("sourceLabel");
	        
	        cf1PBtnNext = (PushButton)namespace.get("cf1PBtnNext");	 
	      
	    }
}
