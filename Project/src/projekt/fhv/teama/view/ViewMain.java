package projekt.fhv.teama.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.collections.adapter.ListAdapter;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.*;

import projekt.fhv.teama.view.controller.ViewController;

public class ViewMain extends Window implements Application, Bindable {
	
	ViewController viewController = new ViewController();
	BXMLSerializer bxmlSerializer = new BXMLSerializer();	
	private Window window = null;
	
	/* Labels */
	Label lbReservationDetails;	
	
	/* Border Container = Forms */
	Border reservationForm01;Border checkInForm01;Border checkInForm02;Border checkInForm03;Border checkInForm04;
	Border occupationPreview;
	
	/* Buttons */
    PushButton rf1PBtnCheckIn;;
		
	PushButton cf1PBtnNext;	PushButton cf2PBtnNext;	PushButton cf3PBtnNext;	PushButton cf4PBtnFinish; PushButton cf1PBtnBack;
	PushButton cf2PBtnBack; PushButton cf3PBtnBack; PushButton cf4PBtnBack;	PushButton cf1PBtnCancel; PushButton cf2PBtnCancel;
	PushButton cf3PBtnCancel; PushButton cf4PBtnCancel;
	
	/* ListViews, ListButtons and CalendarButtons */
	ListView lvAssignedRooms; ListView lvBookedRoomCategories; ListView lvReservationSearch;
	ListButton lbtnGuests; ListButton lbtnAddresses; ListButton lbtnDepositType; CalendarButton cbBirthdate; CalendarButton cbArrival;
	CalendarButton cbDeparture;

	/* TextInputs, RadioButtons and Checkboxes */
	TextInput tiLastName; TextInput tiFirstName; ButtonGroup bgGender; RadioButton rbMale; RadioButton rbFemale;
	TextInput tiStreet; TextInput tiCity; TextInput tiCountry; TextInput tiZip; TextInput tiPhone; TextInput tiMail;
	TextInput tiAccountNr; TextInput tiBankCodeNr; TextInput tiIban; TextInput tiBic; TextInput tiDepositNumber;
	
	/* Labels */
	Label lbProgress01;	Label lbProgress02;	Label lbProgress03;	Label lbProgress04;
	
	/* Processbar */
	Border progress; Meter meter;
	
	BoxPane bpAssignedRooms;
	BoxPane bpRoomsSummary;


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DesktopApplicationContext
				.applyStylesheet("/projekt/fhv/teama/view/style/styles.json");
		DesktopApplicationContext.main(
				(Class<? extends Application>) ViewMain.class, args);		
	}

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
		
		/** Controls initialisieren *********************************************/

		/* Forms initialisieren */
		reservationForm01 = (Border)arg0.get("reservationForm01");
		checkInForm01 = (Border)arg0.get("checkInForm01");
		checkInForm02 = (Border)arg0.get("checkInForm02");
		checkInForm03 = (Border)arg0.get("checkInForm03");
		checkInForm04 = (Border)arg0.get("checkInForm04");
			
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
		lvReservationSearch = (ListView)arg0.get("lvReservationSearch");
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
		viewController.testDaten.generateTestData();
		
		
		/** Testdaten füllen ***********************************************************/
		lvReservationSearch.setListData(viewController.testDaten.alAnkommendeGaeste);
		lbtnGuests.setListData(viewController.testDaten.alGaesteInReservierung);
		lbtnGuests.setSelectedIndex(0);
		lbtnAddresses.setListData(viewController.testDaten.alGastAdressen);
		lbtnAddresses.setSelectedIndex(0);
		lvBookedRoomCategories.setListData(viewController.testDaten.alGebuchteZimmerkategorien);
		lvAssignedRooms.setListData(viewController.testDaten.alVerfügbareDoppelzimmer);
		lbtnDepositType.setListData(viewController.testDaten.alPfandkategorien);
		lbtnDepositType.setSelectedIndex(0);
		
		meter.setPercentage(0.25);
				
		/** Ende - Zustände zum Programmstart initialisieren **************************/


		
		
		 /** Action Listeners ****************************************************************************/
		/* ToDo - in ViewController umsetzen*/
		 
		cf1PBtnNext.getButtonPressListeners().add(new ButtonPressListener()  {

			@Override
			public void buttonPressed(Button arg0) {
				
				checkInForm01.setVisible(false);
				checkInForm02.setVisible(true);
				meter.setPercentage(meter.getPercentage() + 0.25);
			}
			
		});
		
		cf2PBtnNext.getButtonPressListeners().add(new ButtonPressListener()  {

			@Override
			public void buttonPressed(Button arg0) {
				
				checkInForm02.setVisible(false);
				checkInForm03.setVisible(true);
				meter.setPercentage(meter.getPercentage() + 0.25);
			}
			
		});
				
		cf3PBtnNext.getButtonPressListeners().add(new ButtonPressListener()  {

			@Override
			public void buttonPressed(Button arg0) {
				
				checkInForm03.setVisible(false);
				checkInForm04.setVisible(true);
				meter.setPercentage(meter.getPercentage() + 0.25);

		        //Set label font.
		       // helloLabel.getStyles().put("font", new Font("Verdana", Font.PLAIN, 16));

		        //Set label font color.
		       // helloLabel.getStyles().put("color", new Color(134, 107, 64));

		        //Add the Label to the BoxPane Layout.
		     //   bpRoomsSummary.add(helloLabel);

			}
			
		});
		
		cf4PBtnFinish.getButtonPressListeners().add(new ButtonPressListener()  {

			@Override
			public void buttonPressed(Button arg0) {
				
				checkInForm04.setVisible(false);
				reservationForm01.setVisible(true);	
				progress.setVisible(false);
				meter.setPercentage(0.25);
			
			}
			
		});		
	
		cf2PBtnBack.getButtonPressListeners().add(new ButtonPressListener()  {

			@Override
			public void buttonPressed(Button arg0) {
				
				checkInForm01.setVisible(true);
				checkInForm02.setVisible(false);
				meter.setPercentage(meter.getPercentage() - 0.25);
			}
			
		});
				
		cf3PBtnBack.getButtonPressListeners().add(new ButtonPressListener()  {

			@Override
			public void buttonPressed(Button arg0) {
				
				checkInForm02.setVisible(true);
				checkInForm03.setVisible(false);
				bpRoomsSummary.remove(bpAssignedRooms);
				meter.setPercentage(meter.getPercentage() - 0.25);
			}
			
		});
		
		cf4PBtnBack.getButtonPressListeners().add(new ButtonPressListener()  {

			@Override
			public void buttonPressed(Button arg0) {
				
				checkInForm03.setVisible(true);
				checkInForm04.setVisible(false);
				meter.setPercentage(meter.getPercentage() - 0.25);
			}
			
		});
		
		rf1PBtnCheckIn.getButtonPressListeners().add(new ButtonPressListener()  {

			@Override
			public void buttonPressed(Button arg0) {
				
				reservationForm01.setVisible(false);
				progress.setVisible(true);
				checkInForm01.setVisible(true);	
			}
			
		});
		
		
		Action cancel = new Action(true) {
		    @Override
		    @SuppressWarnings("unchecked")
		    public void perform(Component source) {
		        Alert.alert("Cancel the Check-In Process? No Inputs will be changed or saved!", ViewMain.this);
		        
		    }
		};
		

		cf1PBtnCancel.setAction(cancel);
		cf2PBtnCancel.setAction(cancel);
		cf3PBtnCancel.setAction(cancel);
		cf4PBtnCancel.setAction(cancel);		
	}
	

}
