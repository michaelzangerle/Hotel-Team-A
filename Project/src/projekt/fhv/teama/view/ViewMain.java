package projekt.fhv.teama.view;

import java.awt.Dimension;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.*;


public class ViewMain extends Window implements Application, Bindable {
	
	List<Component> checkInForms = new ArrayList<Component>();
	List<Component> textFields = new ArrayList<Component>();

	ViewController viewController = new ViewController();
	BXMLSerializer bxmlSerializer = new BXMLSerializer();
	
	private Window window = null;
	
	/** Controls initialisieren *********************************************/

	/* Labels */
	@BXML Label lbReservationDetails;	@BXML Label lbLoginShow; @BXML Label smLBLastName;	@BXML Label smLBFirstName;	@BXML Label smLBGender; 
	@BXML Label smLBBirthdate;	@BXML Label smLBStreet;	@BXML Label smLBZip;	@BXML Label smLBCity;	@BXML Label smLBCountry;	@BXML Label smLBPhone;
	@BXML Label smLBMail;	@BXML Label smLBAccountNr;	@BXML Label smLBBankCodeNr; @BXML Label smLBIban; @BXML Label smLBBic; @BXML Label smLBArrival;
	@BXML Label smLBDeparture; @BXML Label smLBDepositType; @BXML Label smLBDepositNr; @BXML Label smLBTotalPrice; @BXML Label lbLoginName;
	
	/* Border Container = Forms */
	@BXML Border reservationForm01;@BXML Border checkInForm01;@BXML Border checkInForm02;@BXML Border checkInForm03;@BXML Border checkInForm04;
	@BXML Border occupationPreview;@BXML TabPane tabPLeftMain;
	
	
	/* Buttons */
	@BXML PushButton rf1PBtnCheckIn;;
		
    
	@BXML TextInput tiLastName; @BXML TextInput tiFirstName; @BXML ButtonGroup bgGender; @BXML RadioButton rbMale; @BXML RadioButton rbFemale;
	@BXML TextInput tiStreet; @BXML TextInput tiCity; @BXML TextInput tiCountry;@BXML TextInput tiZip;@BXML TextInput tiPhone;@BXML TextInput tiMail;
	@BXML TextInput tiAccountNr;@BXML TextInput tiBankCodeNr;@BXML TextInput tiIban;@BXML TextInput tiBic;@BXML TextInput tiDepositNumber;
	
	@BXML Checkbox cbxShowAllRooms;
	
	@BXML PushButton cf1PBtnNext;@BXML PushButton cf2PBtnNext;@BXML	PushButton cf3PBtnNext;@BXML PushButton cf4PBtnFinish;@BXML PushButton cf1PBtnBack;
	@BXML PushButton cf2PBtnBack;@BXML PushButton cf3PBtnBack;@BXML PushButton cf4PBtnBack;@BXML PushButton cf1PBtnCancel;@BXML PushButton cf2PBtnCancel;
	@BXML PushButton cf3PBtnCancel;@BXML PushButton cf4PBtnCancel;

	
	/* ListViews, ListButtons and CalendarButtons */
	@BXML ListView lvAssignedRooms;@BXML ListView lvBookedRoomCategories;@BXML ListView lvReservationSearch;@BXML ListView lvArrivingSearch;@BXML ListView lvGuestSearch;
	@BXML ListButton lbtnGuests;@BXML ListButton lbtnAddresses;@BXML ListButton lbtnDepositType;@BXML CalendarButton cbBirthdate;@BXML CalendarButton cbArrival;
	@BXML CalendarButton cbDeparture;@BXML ListView smLVFinalRooms;@BXML ListView smLVHandedKeys;@BXML ListButton lbtnCountry;

	/* TextInputs, RadioButtons and Checkboxes */
	
	@BXML Label rf1LBResNr;@BXML TextInput rf1TIName;@BXML TextInput rf1TIStreet;@BXML TextInput rfTICity;@BXML TextInput rf1TICountry;@BXML TextInput rfTIZip;
	@BXML TextInput rf1TIPhone;@BXML TextInput rf1TIEMail;@BXML CalendarButton rf1CBArrival;@BXML CalendarButton rf1CBDeparture; 

	 
	/* Labels */
	@BXML Label lbProgress01;@BXML Label lbProgress02;@BXML	Label lbProgress03;@BXML Label lbProgress04;
	
	
	/* Processbar */
	@BXML Border progress;@BXML Meter meter;
	
	@BXML BoxPane bpAssignedRooms;
	@BXML BoxPane bpRoomsSummary;

	/** Ende - Controls initialisieren *********************************************/
	
	
	@Override
	public void startup(Display display, Map<String, String> properties)
			throws Exception {
		
		window = (Window) bxmlSerializer.readObject(ViewLogin.class,
				"ViewMain.bxml");
		display.getHostWindow().setMinimumSize(new Dimension(1024,600));
		window.open(display);
	}
	
	@Override
	public void resume() throws Exception {
	}

	@Override
	public boolean shutdown(boolean arg0) throws Exception {
		return false;
	}

	@Override
	public void suspend() throws Exception {
	}
	
	@Override
	public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
		
	    Locale.setDefault(Locale.ENGLISH);		
	
		/** Zustände zum Programmstart initialisieren *********************************/
		
		reservationForm01.setVisible(true);
		checkInForm01.setVisible(false);
		checkInForm02.setVisible(false);
		checkInForm03.setVisible(false);
		checkInForm04.setVisible(false);	
		
		/** Ende - Zustände zum Programmstart initialisieren **************************/
	}
	
	public List<TextInput> getAllCheckInTextFields () {
		List<TextInput> components = (List<TextInput>) new LinkedList<TextInput>();
		components.add(tiFirstName);
		components.add(tiLastName);
		components.add(tiAccountNr);
		components.add(tiBankCodeNr);
		components.add(tiBic);
		components.add(tiCity);
		components.add(tiDepositNumber);
		components.add(tiIban);
		components.add(tiMail);
		components.add(tiPhone);
		components.add(tiStreet);
		components.add(tiZip);
		return components;
	}
	
	public List<Label> getAllCheckInLabels () {
		List<Label> components = new Vector<Label>();
		components.add(smLBLastName);
		components.add(smLBFirstName);
		components.add(smLBStreet);
		components.add(smLBZip);
		components.add(smLBCountry);
		components.add(smLBCity);
		components.add(smLBPhone);
		components.add(smLBMail);
		components.add(smLBAccountNr);
		components.add(smLBIban);
		components.add(smLBBic);
		components.add(smLBArrival);
		components.add(smLBDeparture);
		components.add(smLBDepositType);
		components.add(smLBDepositNr);
		components.add(smLBBankCodeNr);
		return components;
	}

	public ListView getLvReservationSearch() {
		return lvReservationSearch;
	}

	public void setLvReservationSearch(ListView lvReservationSearch) {
		this.lvReservationSearch = lvReservationSearch;
	}
	
	public void setLvReservationSearchListener(ListViewSelectionListener e) {
		lvReservationSearch.getListViewSelectionListeners().add(e);
	}
	
	public void setLvlvArrivingSearch(ListView lvArrivingSearch) {
		this.lvArrivingSearch = lvArrivingSearch;
	}

	public void setlvArrivingSearchListener(ListViewSelectionListener e) {
		lvArrivingSearch.getListViewSelectionListeners().add(e);
	}

	public void setlvGuestSearchListener(ListViewSelectionListener e) {
		lvGuestSearch.getListViewSelectionListeners().add(e);
	}
	
	public void setrf1PBtnCheckInListener(ButtonPressListener e) {
		rf1PBtnCheckIn.getButtonPressListeners().add(e);
	}
	
	public void setlbProgress01Listener (ComponentMouseButtonListener e) {
		lbProgress01.getComponentMouseButtonListeners().add(e);
	}
	
	public void setlbProgress02Listener (ComponentMouseButtonListener e) {
		lbProgress02.getComponentMouseButtonListeners().add(e);
	}
	
	public void setlbProgress03Listener (ComponentMouseButtonListener e) {
		lbProgress03.getComponentMouseButtonListeners().add(e);
	}
	
	public void setlbProgress04Listener (ComponentMouseButtonListener e) {
		lbProgress04.getComponentMouseButtonListeners().add(e);
	}
	
	public void setcf1PBtnNextListener (ButtonPressListener e) {
		cf1PBtnNext.getButtonPressListeners().add(e);
	}
	
	public void setcf2PBtnNextListener (ButtonPressListener e) {
		cf2PBtnNext.getButtonPressListeners().add(e);
	}
	
	public void setcf3PBtnNextListener (ButtonPressListener e) {
		cf3PBtnNext.getButtonPressListeners().add(e);
	}
	
	public void setcf4PBtnFinishListener (ButtonPressListener e) {
		cf4PBtnFinish.getButtonPressListeners().add(e);
	}
	
	public void setcf2PBtnBackListener(ButtonPressListener e) {
		cf2PBtnBack.getButtonPressListeners().add(e);
	}

	public void setcf3PBtnBackListener(ButtonPressListener e) {
		cf3PBtnBack.getButtonPressListeners().add(e);
	}
	
	public void setcf4PBtnBackListener(ButtonPressListener e) {
		cf4PBtnBack.getButtonPressListeners().add(e);
	}
	
	public void setlbtnGuestsListener (ListButtonSelectionListener e) {
		lbtnGuests.getListButtonSelectionListeners().add(e);
	}
	
	public void setlbtnAddressesListener(ListButtonSelectionListener e) {
		lbtnAddresses.getListButtonSelectionListeners().add(e);
	}
	
	public void setlvBookedRoomCategoriesListener(ListViewSelectionListener e) {
		lvBookedRoomCategories.getListViewSelectionListeners().add(e);
	}
	
	public void setlvAssignedRoomsListener(ListViewItemStateListener e) {
		lvAssignedRooms.getListViewItemStateListeners().add(e);
	}	
	
	public void setcbxShowAllRoomsListener(ButtonPressListener e) {
		cbxShowAllRooms.getButtonPressListeners().add(e);
	}
	
	public void setcbxShowAllRoomsListener(ButtonStateListener e) {
		cbxShowAllRooms.getButtonStateListeners().add(e);
	}

	public void settabPLeftMainListener(TabPaneSelectionListener e) {
		tabPLeftMain.getTabPaneSelectionListeners().add(e);
	}
}
