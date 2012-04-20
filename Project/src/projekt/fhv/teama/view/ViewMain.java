package projekt.fhv.teama.view;

import java.awt.Dimension;
import java.net.URL;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.beans.Bindable;
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
		
	PushButton cf1PBtnNext;
	PushButton cf2PBtnNext;
	PushButton cf3PBtnNext;
	PushButton cf4PBtnNext;
	
	PushButton cf1PBtnBack;
	PushButton cf2PBtnBack;
	PushButton cf3PBtnBack;
	PushButton cf4PBtnBack;

	Border progress;
	Meter meter;
	
	BXMLSerializer bxmlSerializer = new BXMLSerializer();	
	private Window window = null;

		
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
		display.getHostWindow().setMinimumSize(new Dimension(1024,768));
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
		meter = (Meter)arg0.get("meter");		
		
		cf1PBtnNext = (PushButton)arg0.get("cf1PBtnNext");
		cf2PBtnNext = (PushButton)arg0.get("cf2PBtnNext");
		cf3PBtnNext = (PushButton)arg0.get("cf3PBtnNext");
		cf4PBtnNext = (PushButton)arg0.get("cf4PBtnNext");
		
		cf2PBtnBack = (PushButton)arg0.get("cf2PBtnBack");
		cf3PBtnBack = (PushButton)arg0.get("cf3PBtnBack");
		cf4PBtnBack = (PushButton)arg0.get("cf4PBtnBack");		
		
		reservationForm01.setVisible(true);
		checkInForm01.setVisible(false);
		checkInForm02.setVisible(false);
		checkInForm03.setVisible(false);
		checkInForm04.setVisible(false);
		occupationPreview.setVisible(false);
		
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
			}
			
		});
		
		cf4PBtnNext.getButtonPressListeners().add(new ButtonPressListener()  {

			@Override
			public void buttonPressed(Button arg0) {
				
				checkInForm04.setVisible(false);
				checkInForm01.setVisible(true);
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
		
		
		
		
		
	}

}
