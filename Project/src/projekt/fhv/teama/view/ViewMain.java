package projekt.fhv.teama.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

public class ViewMain extends Window implements Application, Bindable {
	
	BXMLSerializer bxmlSerializer = new BXMLSerializer();	
	private Window window = null;
	
	/* Labels */
	Label lbReservationDetails;	
	
	/* Border Container = Forms */
	Border reservationForm01;
	Border checkInForm01;
	Border checkInForm02;	
	Border checkInForm03;
	Border checkInForm04;
	Border occupationPreview;
	
	/* Buttons */
    PushButton rf1PBtnCheckIn;;
		
	PushButton cf1PBtnNext;
	PushButton cf2PBtnNext;
	PushButton cf3PBtnNext;
	PushButton cf4PBtnFinish;
	
	PushButton cf1PBtnBack;
	PushButton cf2PBtnBack;
	PushButton cf3PBtnBack;
	PushButton cf4PBtnBack;
	
	PushButton cf1PBtnCancel;
	PushButton cf2PBtnCancel;
	PushButton cf3PBtnCancel;
	PushButton cf4PBtnCancel;
	
	/* ListViews */
	ListView lvAssignedRooms;
	ListView lvBookedRoomCategories;
	ListButton lbtnGuests;
	ListButton lbtnAddresses;
	
	/* Processbar */
	Border progress;
	Meter meter;
	
	BoxPane bpAssignedRooms;
	BoxPane bpRoomsSummary;
	private ListButton lbtnDepositType;

		
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
		lvAssignedRooms = (ListView)arg0.get("lvAssignedRooms");
		lvBookedRoomCategories = (ListView)arg0.get("lvBookedRoomCategories");
		
		lbtnGuests = (ListButton)arg0.get("lbtnGuests");
		lbtnAddresses = (ListButton)arg0.get("lbtnAddresses");
		lbtnDepositType = (ListButton)arg0.get("lbtnDepositType");
		
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

		meter.setPercentage(0.25);
		
		/** Ende - Zustände zum Programmstart initialisieren **************************/

		
		
		/*** Test mit List Adapter ******************************************************************/
		

		// lvAssignedRooms.setListData(adaptedDoubleRooms);
	     
	     /**** Ende Test mit List Adapter ****************************************************************/      
		
		
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
		
	}
	

}
