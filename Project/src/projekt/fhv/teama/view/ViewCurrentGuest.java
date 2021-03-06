package projekt.fhv.teama.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Border;
import org.apache.pivot.wtk.BoxPane;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.CalendarButton;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TextInput;


/**
 * �bersicht �ber einen momentan im Hotel eingecheckten Gast.
 *
 * @author Team A
 * @version 1.1
 */
public class ViewCurrentGuest extends Border implements Bindable {
	
	List<Component> cgf1TextInputs = new ArrayList<Component>();

	ViewController viewController = new ViewController();
	

	/**
	 * Controls f�r das Fenster festlegen. Die Felder werden bei Deserialisierung
	 * automatisch initialisiert.
	 * 
	 */
	
	/* Container and Forms*/
	@BXML Border bdViewCurrentGuest;@BXML BoxPane bpCurrentGuestForm01;@BXML BoxPane cgf1BPStay;@BXML Form cgf1Form;
	
	/* Buttons */
	@BXML PushButton cgf1PBtnEditGuest;@BXML PushButton cgf1PBtnSaveGuest;@BXML PushButton cgf1PBtnDeleteGuest;@BXML PushButton cgf1ClearButton;
	@BXML PushButton cgf1PBtnBookExtras;@BXML PushButton cgf1PBtnCheckOut;
	
	/* Calendar Buttons */
	@BXML CalendarButton cgf1CBArrival;@BXML CalendarButton cgf1CBDeparture;
	
	/* Labels */
	@BXML 
	Label cgf1LBCurrentGuestDetails;
	@BXML 
	Label cgf1LBGuestNr;
	@BXML 
	Label cgf1LBArrival;
	@BXML 
	Label cgf1LBDeparture;
	
	
	/* TextInputs */
	@BXML TextInput cgf1TIName;@BXML TextInput cgf1TIStreet;@BXML TextInput cgf1TICity;@BXML TextInput cgf1TIZip;@BXML TextInput cgf1TICountry;
	@BXML TextInput cgf1TIPhone;@BXML TextInput	cgf1TIEMail;
	
	/* ListViews */
	@BXML ListView cgf1LVBookedAdditionalServices;
	
				
	
	    @Override
		public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
	    	
	    	Locale.setDefault(Locale.ENGLISH);	
	    }


	    public void setcgf1PBtnBookExtrasListener(ButtonPressListener e) {
	    	cgf1PBtnBookExtras.getButtonPressListeners().add(e);
	    }
	    
	    public void setcgf1PBtnCheckOutListener (ButtonPressListener e) {
	    	cgf1PBtnCheckOut.getButtonPressListeners().add(e);
	    }

	    
}
