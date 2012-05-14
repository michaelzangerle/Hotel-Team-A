package projekt.fhv.teama.view;

import java.awt.Color;
import java.net.URL;
import java.security.Provider.Service;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Collections.*;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.EnumList;
import org.apache.pivot.collections.Map;
import org.apache.pivot.collections.adapter.ListAdapter;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Border;
import org.apache.pivot.wtk.Bounds;
import org.apache.pivot.wtk.BoxPane;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.ListViewListener;
import org.apache.pivot.wtk.ListViewSelectionListener;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.Spinner;
import org.apache.pivot.wtk.TablePane;
import org.apache.pivot.wtk.TableView;
import org.apache.pivot.wtk.TableView.TableDataBindMapping;
import org.apache.pivot.wtk.TableViewBindingListener;
import org.apache.pivot.wtk.TableViewHeader;
import org.apache.pivot.wtk.TableViewListener;
import org.apache.pivot.wtk.TableViewRowListener;
import org.apache.pivot.wtk.TableViewSelectionListener;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.Theme;
import org.apache.pivot.wtk.content.CalendarDateSpinnerData;
import org.apache.pivot.wtk.content.TableViewRowEditor;
import org.apache.pivot.wtk.skin.terra.TerraTableViewHeaderSkin;
import org.apache.pivot.wtk.skin.terra.TerraTheme;

import projekt.fhv.teama.view.support.CurrencyValidator;
import projekt.fhv.teama.view.support.ExpenseType;
import projekt.fhv.teama.view.support.Services;
import projekt.fhv.teama.view.tests.TestData;

/**
 * Übersicht über einen momentan im Hotel eingecheckten Gast.
 * 
 * @author Team A
 * @version 1.1
 */
public class ViewAdditionalServices extends Border implements Bindable {

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
	TableView asf1TVAdditionalServices;

	public TableViewRowEditor tableViewRowEditor;
	
	@Override
	public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
		tableViewRowEditor = new TableViewRowEditor();
		asf1TVAdditionalServices.setRowEditor(tableViewRowEditor);
//		TestData td = new TestData();
//		td.generateTestData();
//
//		asf1TVAdditionalServices.setTableData(td.testDataServices);
//
//		// Quantity uses a TextInput
		TextInput quantityTextInput = new TextInput();
		quantityTextInput.setTextKey("quantity");
		tableViewRowEditor.getCellEditors().put("quantity", quantityTextInput);

		// Expense type uses a ListButton that presents the expense types
//		List<String> list = new LinkedList<String>();
//		ListAdapter<String> la = new ListAdapter<String>(list);
		
		
//		ListButton listButton = new ListButton();
//		listButton.setListData(new ArrayList<String>());
//		listButton.setSelectedItemKey("type");
//		tableViewRowEditor.getCellEditors().put("type", listButton);
		
		
//		asf1LBtypes = new ListButton
//    	        (new ListAdapter(list));
//		typeListButton.setSelectedItemKey("type");
//	    tableViewRowEditor.getCellEditors().put("type", typeListButton);
		
//		List<String> list = new LinkedList<String>();
//		list.add("asdf1");
//		list.add("asdf2");
//		ListAdapter<String> li = new ListAdapter<String>(list);
//		ListButton typeListButton = new ListButton();
//		typeListButton.setListData(li);
//		typeListButton.setSelectedItemKey("type");
//		tableViewRowEditor.getCellEditors().put("type", typeListButton);

		// Amount uses a TextInput with strict currency validation
		TextInput amountTextInput = new TextInput();
		amountTextInput.setValidator(new CurrencyValidator());
		amountTextInput.setStrictValidation(true);
		amountTextInput.setTextKey("amount");
		tableViewRowEditor.getCellEditors().put("amount", amountTextInput);
//
//		// Description uses a TextInput
		TextInput descriptionTextInput = new TextInput();
		descriptionTextInput.setTextKey("description");
		tableViewRowEditor.getCellEditors().put("description",
				descriptionTextInput);

	}

	public void setListData(List<String> listData) {
		List<String> list = new LinkedList<String>();
		for (String temp : listData) {
			list.add(temp);
		}
		ListAdapter<String> li = new ListAdapter<String>(list);
		ListButton typeListButton = new ListButton();
		typeListButton.setListData(li);
		typeListButton.setSelectedItemKey("type");
		tableViewRowEditor.getCellEditors().put("type", typeListButton);
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


}
