package projekt.fhv.teama.view;

import java.awt.Dimension;
import java.net.URL;
import java.util.Locale;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.beans.NamespaceBinding;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.List;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.Border;
import org.apache.pivot.wtk.BoxPane;
import org.apache.pivot.wtk.ButtonGroup;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.CalendarButton;
import org.apache.pivot.wtk.Checkbox;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ComponentMouseButtonListener;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListButtonSelectionListener;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.ListViewSelectionListener;
import org.apache.pivot.wtk.Meter;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.RadioButton;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.Window;

public class ViewMain extends Window implements Application, Bindable {
	
	List<Component> checkInForms = new ArrayList<Component>();
	List<Component> textFields = new ArrayList<Component>();

	ViewController viewController = new ViewController();
	BXMLSerializer bxmlSerializer = new BXMLSerializer();
	
	
	private Window window = null;
	
	/* Labels */
	@BXML Label lbReservationDetails;	
	@BXML Label lbLoginShow;
	
	/* Border Container = Forms */
	Border reservationForm01;Border checkInForm01;Border checkInForm02;Border checkInForm03;Border checkInForm04;
	Border occupationPreview;
	
	/* Buttons */
    PushButton rf1PBtnCheckIn;;
		
	PushButton cf1PBtnNext;	PushButton cf2PBtnNext;	PushButton cf3PBtnNext;	PushButton cf4PBtnFinish; PushButton cf1PBtnBack;
	PushButton cf2PBtnBack; PushButton cf3PBtnBack; PushButton cf4PBtnBack;	PushButton cf1PBtnCancel; PushButton cf2PBtnCancel;
	PushButton cf3PBtnCancel; PushButton cf4PBtnCancel;
	
	/* ListViews, ListButtons and CalendarButtons */
	ListView lvAssignedRooms; ListView lvBookedRoomCategories; ListView lvReservationSearch; ListView lvArrivingSearch; ListView lvGuestSearch;
	ListButton lbtnGuests; ListButton lbtnAddresses; ListButton lbtnDepositType; CalendarButton cbBirthdate; CalendarButton cbArrival;
	CalendarButton cbDeparture;

	/* TextInputs, RadioButtons and Checkboxes */
	TextInput tiLastName; TextInput tiFirstName; ButtonGroup bgGender; RadioButton rbMale; RadioButton rbFemale;
	TextInput tiStreet; TextInput tiCity; TextInput tiCountry; TextInput tiZip; TextInput tiPhone; TextInput tiMail;
	TextInput tiAccountNr; TextInput tiBankCodeNr; TextInput tiIban; TextInput tiBic; TextInput tiDepositNumber;
	Label rf1LBResNr; TextInput rf1TIName;TextInput rf1TIStreet;TextInput rfTICity;TextInput rf1TICountry;TextInput rfTIZip;
	TextInput rf1TIPhone;TextInput rf1TIEMail;CalendarButton rf1CBArrival;CalendarButton rf1CBDeparture; Checkbox cbxShowAllRooms;

	 
	/* Labels */
	Label lbProgress01;	Label lbProgress02;	Label lbProgress03;	Label lbProgress04;
	
	/* Processbar */
	Border progress; Meter meter;
	
	BoxPane bpAssignedRooms;
	BoxPane bpRoomsSummary;

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
		
		/** Controls initialisieren *********************************************/

		/* Borders & Forms initialisieren */
		reservationForm01 = (Border)arg0.get("reservationForm01");
		checkInForm01 = (Border)arg0.get("checkInForm01");
		checkInForm02 = (Border)arg0.get("checkInForm02");
		checkInForm03 = (Border)arg0.get("checkInForm03");
		checkInForm04 = (Border)arg0.get("checkInForm04");
		
		checkInForms.add(checkInForm01);
		checkInForms.add(checkInForm02);
		checkInForms.add(checkInForm03);
		checkInForms.add(checkInForm04);
		checkInForms.add(reservationForm01);
			
		occupationPreview = (Border)arg0.get("occupationPreview");		
		
		/* Buttons initialisieren | ViewRegistration */
		rf1PBtnCheckIn  = (PushButton)arg0.get("rf1PBtnCheckIn");		
		
		/* Buttons initialisieren | ViewCheckIn */
		cf1PBtnNext = (PushButton)arg0.get("cf1PBtnNext");
		cf2PBtnNext = (PushButton)arg0.get("cf2PBtnNext");
		cf3PBtnNext = (PushButton)arg0.get("cf3PBtnNext");
		cf4PBtnFinish = (PushButton)arg0.get("cf4PBtnFinish");
		
		cf2PBtnBack = (PushButton)arg0.get("cf2PBtnBack");
		cf3PBtnBack = (PushButton)arg0.get("cf3PBtnBack");
		cf4PBtnBack = (PushButton)arg0.get("cf4PBtnBack");
		
		cf1PBtnCancel= (PushButton)arg0.get("cf1PBtnCancel");
		cf2PBtnCancel = (PushButton)arg0.get("cf2PBtnCancel");
		cf3PBtnCancel = (PushButton)arg0.get("cf3PBtnCancel");
		cf4PBtnCancel = (PushButton)arg0.get("cf4PBtnCancel");
				
		/* ListViews u. ListButtons initialisieren */
		setLvReservationSearch((ListView)arg0.get("lvReservationSearch"));
		lvArrivingSearch = (ListView)arg0.get("lvArrivingSearch");
		lvGuestSearch = (ListView)arg0.get("lvGuestSearch");
		lvAssignedRooms = (ListView)arg0.get("lvAssignedRooms");
		lvBookedRoomCategories = (ListView)arg0.get("lvBookedRoomCategories");
		
		lbtnGuests = (ListButton)arg0.get("lbtnGuests");
		lbtnAddresses = (ListButton)arg0.get("lbtnAddresses");
		lbtnDepositType = (ListButton)arg0.get("lbtnDepositType");
		
		/* TextInputs, RadioButtons and CheckBoxes */
		tiLastName = (TextInput)arg0.get("tiLastName");
		tiFirstName = (TextInput)arg0.get("tiFirstName");
		bgGender = (ButtonGroup)arg0.get("bgGender");
		rbMale = (RadioButton)arg0.get("rbMale");
		rbFemale = (RadioButton)arg0.get("rbFemale");
		tiStreet = (TextInput)arg0.get("tiStreet");
		tiCity = (TextInput)arg0.get("tiCity");
		tiCountry = (TextInput)arg0.get("tiCountry");
		tiZip = (TextInput)arg0.get("tiZip");
		tiPhone = (TextInput)arg0.get("tiPhone");
		tiMail = (TextInput)arg0.get("tiMail");
		tiAccountNr = (TextInput)arg0.get("tiAccountNr");		
		tiBankCodeNr = (TextInput)arg0.get("tiBankCodeNr");
		tiIban = (TextInput)arg0.get("tiIban");
		tiBic = (TextInput)arg0.get("tiBic");
		tiDepositNumber = (TextInput)arg0.get("tiDepositNumber");
		rf1LBResNr = (Label)arg0.get("rf1LBResNr");
		rf1TIName = (TextInput)arg0.get("rf1TIName");
		rf1TIStreet = (TextInput)arg0.get("rf1TIStreet");
		rfTICity = (TextInput)arg0.get("rfTICity");
		rf1TICountry = (TextInput)arg0.get("rf1TICountry");
		rfTIZip = (TextInput)arg0.get("rfTIZip");
		rf1TIPhone = (TextInput)arg0.get("rf1TIPhone");
		rf1TIEMail = (TextInput)arg0.get("rf1TIEMail");
		cbxShowAllRooms = (Checkbox)arg0.get("cbxShowAllRooms");
		bgGender = (ButtonGroup)arg0.get("bgGender");
		
		/* CalendarButtons */
		rf1CBArrival = (CalendarButton)arg0.get("rf1CBArrival");
		rf1CBDeparture = (CalendarButton)arg0.get("rf1CBDeparture");
		cbArrival = (CalendarButton)arg0.get("cbArrival");
		cbDeparture = (CalendarButton)arg0.get("cbDeparture");
		cbBirthdate = (CalendarButton)arg0.get("cbBirthdate");

		/* Labels */
		lbProgress01 = (Label)arg0.get("lbProgress01");
		lbProgress02 = (Label)arg0.get("lbProgress02");
		lbProgress03 = (Label)arg0.get("lbProgress03");
		lbProgress04 = (Label)arg0.get("lbProgress04");
				
		/* ProgressBar */
		progress = (Border)arg0.get("mainProgress");
		meter = (Meter)arg0.get("meter");		
		

		bpRoomsSummary = (BoxPane)arg0.get("bpRoomsSummary");
		bpAssignedRooms = (BoxPane)arg0.get("bpAssignedRooms");			
						
		/** Ende - Controls initialisieren *********************************************/

		
		/** Zustände zum Programmstart initialisieren *********************************/
		
		reservationForm01.setVisible(true);
		checkInForm01.setVisible(false);
		checkInForm02.setVisible(false);
		checkInForm03.setVisible(false);
		checkInForm04.setVisible(false);
		occupationPreview.setVisible(false);
		
		/** Testdaten füllen ***********************************************************/	
		
		viewController.testDaten.generateTestData();
		
//		lvReservationSearch.setListData(viewController.testDaten.alAnkommendeGaeste);
//		lvArrivingSearch.setListData(viewController.testDaten.alAnkommendeGaeste);
		//lvGuestSearch.setListData(viewController.testDaten.alAnkommendeGaeste);
//		lvGuestSearch.setSelectMode("multi");
		
//		lbtnGuests.setListData(viewController.testDaten.alGaesteInReservierung);
//		lbtnGuests.setSelectedIndex(0);
//		lbtnAddresses.setListData(viewController.testDaten.alGastAdressen);
//		lbtnAddresses.setSelectedIndex(0);
//		lvBookedRoomCategories.setListData(viewController.testDaten.alGebuchteZimmerkategorien);
//		lvAssignedRooms.setListData(viewController.testDaten.alVerfügbareDoppelzimmer);
//		lbtnDepositType.setListData(viewController.testDaten.alPfandkategorien);
//		lbtnDepositType.setSelectedIndex(0);
		
		meter.setPercentage(0.25);
		
		
		/** TestBindings **/
				
		  // Bind list button selection to label text
	  //  NamespaceBinding namespaceBinding1 = new NamespaceBinding(arg0, "cbBirthdate.selectedItem", "smLBGender.text");


	   // namespaceBinding1.bind();    
	    
	    
	  
	    //bgGender.getSelection().getButtonData();	    

		
		/**				**/
		
				
		/** Ende - Zustände zum Programmstart initialisieren **************************/
	}

	public Label getlbLoginShow() {
		return lbLoginShow;
	}
	
	public void setlbLoginShow(String username) {
		lbLoginShow.setText(username);
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
	
	public void setlvAssignedRoomsListener(ListViewSelectionListener e) {
		lvAssignedRooms.getListViewSelectionListeners().add(e);
	}	
	

	public void setcbxShowAllRoomsListener(ButtonPressListener e) {
		cbxShowAllRooms.getButtonPressListeners().add(e);
	}
	
	
	

	
}
