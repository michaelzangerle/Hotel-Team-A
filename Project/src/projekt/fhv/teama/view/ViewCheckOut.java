package projekt.fhv.teama.view;

import java.net.URL;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.BoxPane;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.ComponentMouseButtonListener;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.Meter;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TableView;
import org.apache.pivot.wtk.TextInput;


/**
 * Um den UseCase bzw. die Formulare f�r den CheckOut umzusetzen.
 *
 * @author Team A
 * @version 1.1
 */
public class ViewCheckOut extends BoxPane implements Bindable {
	 
	/**
	 * Controls f�r das Fenster festlegen. Die Felder werden bei
	 * Deserialisierung automatisch initialisiert.
	 * 
	 */

	/* Container */
	@BXML
	BoxPane bpCheckOutForm01;
	@BXML
	BoxPane bpCheckOutForm02;

	/* TextInputs */
	@BXML
	TextInput cof1TIGuest;
	
	/* Buttons */
	@BXML
	PushButton cof1PBtnCancel;
	@BXML
	PushButton cof1PBtnCreateInvoice; 
	@BXML
	PushButton cof1PBtnUpdate; //TODO ge�ndert
	@BXML
	PushButton cof1PBtnNext;
	@BXML
	PushButton cof2PBtnCancel;
	@BXML
	PushButton cof2PBtnFinishSave;
	@BXML
	PushButton cof2PBtnBack;
	@BXML
	PushButton cof2BTRemoveDeposit;
	
	/* ListViews */
	@BXML
	ListView asf1LVBookedRooms; 
	@BXML 
	ListView cof2LVHandedKeys;

	/* TableViews */
	@BXML
	TableView asf1TVAdditionalServices;
	
	/* Labels */
	@BXML
	Label cof2LBDepositNr; 
	@BXML 
	Label coLBProgress01; 
	@BXML 
	Label coLBProgress02; 
	@BXML 
	Label coLBProgress03; 
	@BXML 
	Label coLBProgress04;
	@BXML
	Label cof1LBStatusInvoiceItems;
	
	/* Progressbar UseCase CheckOut */
	@BXML
	Progress coProgress;
	@BXML
	Meter coMeter;
	
	
	    @Override
		public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
	    }	   
	    
	    public void setcof1PBtnCreateInvoiceListener (ButtonPressListener e) {
	    	cof1PBtnCreateInvoice.getButtonPressListeners().add(e);
	    }
	    
	    public void setcof2BTRemoveDepositListener(ButtonPressListener e) {
	    	cof2BTRemoveDeposit.getButtonPressListeners().add(e);
	    }

	    public void setcof2PBtnFinishSaveListener(ButtonPressListener e) {
	    	cof2PBtnFinishSave.getButtonPressListeners().add(e);
	    }
	    
	    public void setlbProgress01Listener (ComponentMouseButtonListener e) {
	    	coLBProgress01.getComponentMouseButtonListeners().add(e);
		}
	    
	    public void setlbProgress02Listener (ComponentMouseButtonListener e) {
	    	coLBProgress02.getComponentMouseButtonListeners().add(e);
		}
	    
	    public void setcof1PBtnUpdateListener(ButtonPressListener e) {
	    	cof1PBtnUpdate.getButtonPressListeners().add(e);
	    }
}
