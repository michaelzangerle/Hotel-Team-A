package projekt.fhv.teama.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.LinkedList;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.*;

public class ViewMain extends Window implements Application, Bindable {
	
	Label lbReservationDetails;
	
	
	Border reservationForm01;
	Border checkInForm01;
	Border checkInForm02;	
	Border checkInForm03;
	Border checkInForm04;
	Border occupationPreview;
	
    PushButton rf1PBtnCheckIn;;
		
	PushButton cf1PBtnNext;
	PushButton cf2PBtnNext;
	PushButton cf3PBtnNext;
	PushButton cf4PBtnFinish;
	
	PushButton cf1PBtnBack;
	PushButton cf2PBtnBack;
	PushButton cf3PBtnBack;
	PushButton cf4PBtnBack;
	
	BoxPane bpAssignedRooms;
	BoxPane bpRoomsSummary;
	

	Border progress;
	Meter meter;
	
	BXMLSerializer bxmlSerializer = new BXMLSerializer();	
	private Window window = null;
	ListView lvAssignedRooms = null;

		
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
		// TODO Auto-generated method stub

	}

	@Override
	public boolean shutdown(boolean arg0) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void suspend() throws Exception {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
		
		Label lbReservationDetails = (Label)arg0.get("lbReservationDetails");
		reservationForm01 = (Border)arg0.get("reservationForm01");
		checkInForm01 = (Border)arg0.get("checkInForm01");
		checkInForm02 = (Border)arg0.get("checkInForm02");
		checkInForm03 = (Border)arg0.get("checkInForm03");
		checkInForm04 = (Border)arg0.get("checkInForm04");
		occupationPreview = (Border)arg0.get("occupationPreview");
		progress = (Border)arg0.get("mainProgress");
		
		bpRoomsSummary = (BoxPane)arg0.get("bpRoomsSummary");
		bpAssignedRooms = (BoxPane)arg0.get("bpAssignedRooms");
		lvAssignedRooms = (ListView)arg0.get("lvAssignedRooms");
        
	      //<String> states = new ArrayList<String>();
	       LinkedList<String> states = new LinkedList<String>();
	        states.setComparator(String.CASE_INSENSITIVE_ORDER);
	 
	        states.add("Alabama");
	        states.add("Alaska");
	        states.add("Arizona");
	        states.add("Arkansas");
	        states.add("California");
	        states.add("Colorado");
	        states.add("Connecticut");
	        states.add("Delaware");
	        states.add("District of Columbia");
	        states.add("Florida");
	        states.add("Georgia");
	        states.add("Hawaii");
	        states.add("Idaho");
	        states.add("Illinois");
	        states.add("Indiana");
	        states.add("Iowa");
	        states.add("Kansas");
	        states.add("Kentucky");
	        states.add("Louisiana");
	        states.add("Maine");
	        states.add("Maryland");
	        states.add("Massachusetts");
	        states.add("Michigan");
	        states.add("Minnesota");
	        states.add("Mississippi");
	        states.add("Missouri");
	        states.add("Montana");
	        states.add("Nebraska");
	        states.add("Nevada");
	        states.add("New Hampshire");
	        states.add("New Jersey");
	        states.add("New Mexico");
	        states.add("New York");
	        states.add("North Carolina");
	        states.add("North Dakota");
	        states.add("Ohio");
	        states.add("Oklahoma");
	        states.add("Oregon");
	        states.add("Pennsylvania");
	        states.add("Rhode Island");
	        states.add("South Carolina");
	        states.add("South Dakota");
	        states.add("Tennessee");
	        states.add("Texas");
	        states.add("Utah");
	        states.add("Vermont");
	        states.add("Virginia");
	        states.add("Washington");
	        states.add("West Virginia");
	        states.add("Wisconsin");
	        states.add("Wyoming");
	    
			 
	        lvAssignedRooms.setListData(states);
	        
	     
		
		meter = (Meter)arg0.get("meter");		
		
		rf1PBtnCheckIn  = (PushButton)arg0.get("rf1PBtnCheckIn");
		cf1PBtnNext = (PushButton)arg0.get("cf1PBtnNext");
		cf2PBtnNext = (PushButton)arg0.get("cf2PBtnNext");
		cf3PBtnNext = (PushButton)arg0.get("cf3PBtnNext");
		cf4PBtnFinish = (PushButton)arg0.get("cf4PBtnFinish");
		
		cf2PBtnBack = (PushButton)arg0.get("cf2PBtnBack");
		cf3PBtnBack = (PushButton)arg0.get("cf3PBtnBack");
		cf4PBtnBack = (PushButton)arg0.get("cf4PBtnBack");	
		
		
		reservationForm01.setVisible(true);
		checkInForm01.setVisible(false);
		checkInForm02.setVisible(false);
		checkInForm03.setVisible(false);
		checkInForm04.setVisible(false);
		occupationPreview.setVisible(false);
	    //final Label helloLabel = new Label("Hello World!");
		
		//progress.setVisible(true);
		meter.setPercentage(0.25);
		
		
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
