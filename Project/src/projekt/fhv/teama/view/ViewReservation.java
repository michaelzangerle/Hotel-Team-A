package view;

import java.io.InputStream;
import java.net.URL;

import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.json.JSONSerializer;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.*;

import view.support.Address;
import view.support.Contact;
import view.support.IMAccount;


public class ViewReservation extends Border implements Bindable {
	 private Form form = null;
	    private PushButton loadJavaButton = null;
	    private PushButton loadJSONButton = null;
	    private PushButton clearButton = null;
	    private Label sourceLabel = null;
	 
	    private static final Contact CONTACT = new Contact("101", "Michael Zangerle",
	        new Address("123 Main St.", "Cambridge", "MA", "02142"),
	        "(617) 555-1234", "master@meister.msc",
	        new IMAccount("mza180°", "Yahoo"));
	 
	    @Override
	    public void initialize(Map<String, Object> namespace, URL location, Resources resources) {
	        form = (Form)namespace.get("form");
	        loadJavaButton = (PushButton)namespace.get("loadJavaButton");
	        loadJSONButton = (PushButton)namespace.get("loadJSONButton");
	        clearButton = (PushButton)namespace.get("clearButton");
	        sourceLabel = (Label)namespace.get("sourceLabel");
	 
	        loadJavaButton.getButtonPressListeners().add(new ButtonPressListener() {
	            @Override
	            public void buttonPressed(Button button) {
	                form.load(new BeanAdapter(CONTACT));
	                sourceLabel.setText("Java");
	            }
	        });
	 
//	        loadJSONButton.getButtonPressListeners().add(new ButtonPressListener() {
//	            @Override
//	            public void buttonPressed(Button button) {
//	                JSONSerializer serializer = new JSONSerializer();
//	                InputStream inputStream = getClass().getResourceAsStream("contact.json");
//	 
//	                try {
//	                    form.load(serializer.readObject(inputStream));
//	                    sourceLabel.setText("JSON");
//	                } catch(Exception exception) {
//	                    System.err.println(exception);
//	                }
//	 
//	                button.setEnabled(true);
//	            }
//	        });
	 
	        clearButton.getButtonPressListeners().add(new ButtonPressListener() {
	            @Override
	            public void buttonPressed(Button button) {
	                form.clear();
	                sourceLabel.setText(null);
	            }
	        });
	    }
}
