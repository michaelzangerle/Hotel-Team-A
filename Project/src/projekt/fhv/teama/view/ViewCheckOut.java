package projekt.fhv.teama.view;

import java.net.URL;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Border;
import org.apache.pivot.wtk.BoxPane;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TablePane;
import org.apache.pivot.wtk.TableView;
import org.apache.pivot.wtk.TextInput;


/**
 * Um den UseCase bzw. die Formulare für den CheckOut umzusetzen.
 *
 * @author Team A
 * @version 1.1
 */
public class ViewCheckOut extends Border implements Bindable {
	 
	/**
	 * Controls für das Fenster festlegen. Die Felder werden bei
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
	PushButton cof1PBtnNext;

	/* ListViews */
	@BXML
	ListView asf1LVBookedRooms;

	/* TableViews */
	@BXML
	TableView asf1TVAdditionalServices;
	
	
	    @Override
		public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
	    }	   

}
