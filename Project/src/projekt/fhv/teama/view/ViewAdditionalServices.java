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
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.ListViewSelectionListener;
import org.apache.pivot.wtk.Meter;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TablePane;
import org.apache.pivot.wtk.TableView;
import org.apache.pivot.wtk.TableViewRowListener;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.content.TableViewRowEditor;

import projekt.fhv.teama.view.support.CurrencyValidator;

/**
 * Um den UseCase Zusatzleistungen buchen umzusetzen. Die Felder werden bei
 * Deserialisierung automatisch initialisiert.
 * 
 * @author Team A
 * @version 1.1
 */
public class ViewAdditionalServices extends BoxPane implements Bindable {

	/**
	 * Controls für das Fenster festlegen. Die Felder werden bei
	 * Deserialisierung automatisch initialisiert.
	 * 
	 */

	/* Container */
	@BXML
	BoxPane bpAdditionalServicesForm01;
	@BXML
	BoxPane bpAdditionalServicesForm02;
	@BXML
	TablePane asf2smTPSummary;
	
	/* Label */
	@BXML
	Label asf1LBBookedRooms;
	@BXML
	Label asf1LBAdditionalServices;
	@BXML
	Label asf1TISelectedRoom;
	@BXML
	Label asf2smLBRoom;
	@BXML 
	Label asf2smLBServices;
	@BXML 
	Label asf2smLBTotal;
	@BXML
	Label asf2smServiceGuest;

	/* TextInputs */

	/* Buttons */
	@BXML
	PushButton asf1PBtnCancel;
	@BXML
	PushButton asf1PBtnBack;
	@BXML
	PushButton asf1PBtnNext;
	@BXML
	PushButton asf2PBtnBack;
	@BXML
	PushButton asf2PBtnFinish;
	@BXML
	PushButton asf2PBtnCancel;
	@BXML
	ListButton asf1LBtypes;
	
	/* ListViews */
	@BXML
	ListView asf1LVBookedRooms;

	/* TableViews */
	@BXML
	TableView asf1TVAdditionalServices; @BXML Label asLBProgress01; @BXML Label asLBProgress02; @BXML Label asLBProgress03; @BXML Label asLBProgress04;
	
	/* Progressbar UseCase CheckOut */
	@BXML
	Progress asProgress;
	@BXML
	Meter asMeter;
	

	public TableViewRowEditor tableViewRowEditor;
	
	@Override
	public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
		tableViewRowEditor = new TableViewRowEditor();
		asf1TVAdditionalServices.setRowEditor(tableViewRowEditor);

		// Quantity uses a TextInput
		TextInput quantityTextInput = new TextInput();
		quantityTextInput.setTextKey("quantity");
		tableViewRowEditor.getCellEditors().put("quantity", quantityTextInput);

		// Description uses a TextInput
		TextInput descriptionTextInput = new TextInput();
		descriptionTextInput.setTextKey("description");
		tableViewRowEditor.getCellEditors().put("description",
				descriptionTextInput);

	}

	public void setasf1PBtnNextListener(ButtonPressListener e) {
		asf1PBtnNext.getButtonPressListeners().add(e);
	}

	public void setasf2PBtnFinishListener(ButtonPressListener e) {
		asf2PBtnFinish.getButtonPressListeners().add(e);
	}

	public void setas1PBtnBack(ButtonPressListener e) {
		asf1PBtnBack.getButtonPressListeners().add(e);
	}

	public void setasf2PBtnBack(ButtonPressListener e) {
		asf2PBtnBack.getButtonPressListeners().add(e);
	}

	public void setasf1PBtnCancel(ButtonPressListener e) {
		asf1PBtnCancel.getButtonPressListeners().add(e);
	}

	public void setasf1LVBookedRoomsListener(ListViewSelectionListener e) {
		asf1LVBookedRooms.getListViewSelectionListeners().add(e);
	}

	public void setasf1TVAdditionalServicesListener(TableViewRowListener e) {
		asf1TVAdditionalServices.getTableViewRowListeners().add(e);
	}

	public void setlbProgress01Listener (ComponentMouseButtonListener e) {
		asLBProgress01.getComponentMouseButtonListeners().add(e);
	}
    
    public void setlbProgress02Listener (ComponentMouseButtonListener e) {
    	asLBProgress02.getComponentMouseButtonListeners().add(e);
	}
}
