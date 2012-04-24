package projekt.fhv.teama.view;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ComponentMouseButtonListener;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckIn;
import projekt.fhv.teama.model.exception.FokusException;


public class CheckInViewController implements ButtonPressListener {
	private ViewMain viewMain;
	private ControllerCheckIn controllerCheckIn;
	
	@Override
	public void buttonPressed(Button arg0) {
		viewMain.reservationForm01.setVisible(false);
		viewMain.checkInForm01.setVisible(true);
		viewMain.progress.setVisible(true);
		
		initialize();
	}
	
	
	
	private void initialize() {
		addCheckInEventListener();
		IReservierung reservation = null;
		try {
			reservation = controllerCheckIn.getAktuelleReservierung();
		} catch (FokusException e) {
			e.printStackTrace();
		}
		List<IGast> guests = new Vector<IGast>(reservation.getGaeste());
		
		
		
	}



	public void addCheckInEventListener() {
		
		
		viewMain.setlbProgress01Listener(new ComponentMouseButtonListener.Adapter() {
			public boolean mouseClick(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3,
					int arg4) {
					gotoStep.perform(arg0);
				return false;
			}
		
		});
		
		viewMain.setlbProgress02Listener(new ComponentMouseButtonListener.Adapter() {
			public boolean mouseClick(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3,
					int arg4) {
					gotoStep.perform(arg0);
				return false;
			}
		
		});
		
		viewMain.setlbProgress03Listener(new ComponentMouseButtonListener.Adapter() {
			public boolean mouseClick(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3,
					int arg4) {
					gotoStep.perform(arg0);
				return false;
			}
		
		});
		
		viewMain.setlbProgress04Listener(new ComponentMouseButtonListener.Adapter() {
			public boolean mouseClick(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3,
					int arg4) {
					gotoStep.perform(arg0);
				return false;
			}
		
		});
	
		
		
		
	
	}
	
	
	public CheckInViewController(ViewMain viewMain, ControllerCheckIn controllerCheckIn) {
		this.viewMain = viewMain;
		this.controllerCheckIn = controllerCheckIn;
	}
	
	
	Action gotoStep = new Action(true) {
		    @Override
		    public void perform(Component source) {
		    	if (source.getName().equals("lbProgress01")) {
		    		viewMain.meter.setPercentage(0.25);
		    		viewMain.checkInForm01.setVisible(true);
		    		viewMain.checkInForm02.setVisible(false);
		    		viewMain.checkInForm03.setVisible(false);
		    		viewMain.checkInForm04.setVisible(false);
		    	}
			      
		    	if (source.getName().equals("lbProgress02")) {
		    		viewMain.meter.setPercentage(0.50);
		    		viewMain.checkInForm01.setVisible(false);
		    		viewMain.checkInForm02.setVisible(true);
		    		viewMain.checkInForm03.setVisible(false);
		    		viewMain.checkInForm04.setVisible(false);
		    	}
			      
		    	if (source.getName().equals("lbProgress03")) {
		    		viewMain.meter.setPercentage(0.75);
		    		viewMain.checkInForm01.setVisible(false);
		    		viewMain.checkInForm02.setVisible(false);
		    		viewMain.checkInForm03.setVisible(true);
		    		viewMain.checkInForm04.setVisible(false);
		    	}
			      
		    	if (source.getName().equals("lbProgress04")) {
		    		viewMain.meter.setPercentage(1);
		    		viewMain.checkInForm01.setVisible(false);
		    		viewMain.checkInForm02.setVisible(false);
		    		viewMain.checkInForm03.setVisible(false);
		    		viewMain.checkInForm04.setVisible(true);
		    	}
		    }

	};
}
