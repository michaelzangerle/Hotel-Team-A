package projekt.fhv.teama.view;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ComponentMouseButtonListener;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListButtonSelectionListener;
import org.apache.pivot.wtk.MessageType;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckIn;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.view.support.BlockingDialog;

public class CheckInViewController implements ButtonPressListener {
	private ViewMain viewMain;
	private ControllerCheckIn controllerCheckIn;
	private List<IGast> guests;
	private Wrapper wrapper;
	
	
	@Override
	public void buttonPressed(Button arg0) {
		viewMain.reservationForm01.setVisible(false);
		viewMain.checkInForm01.setVisible(true);
		viewMain.progress.setVisible(true);
		viewMain.lvReservationSearch.setEnabled(false);
		initialize();
	}

	private void initialize() {
		addCheckInEventListener();
		IReservierung reservation = null;
		wrapper = new Wrapper();
		
		try {
			reservation = controllerCheckIn.getAktuelleReservierung();
			guests = new Vector<IGast>(reservation.getGaeste());
			viewMain.lbtnGuests.setListData(wrapper.getGuestListAdapter(guests));
		} catch (FokusException e) {
			e.printStackTrace();
		}
		

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

		viewMain.cf1PBtnCancel.setAction(cancel);
		viewMain.cf2PBtnCancel.setAction(cancel);
		viewMain.cf3PBtnCancel.setAction(cancel);
		viewMain.cf4PBtnCancel.setAction(cancel);
		
		viewMain.setcf1PBtnNextListener(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				viewMain.checkInForm01.setVisible(false);
				viewMain.checkInForm02.setVisible(true);
				viewMain.meter.setPercentage(viewMain.meter.getPercentage() + 0.25);
			}
		});
	
		viewMain.setcf2PBtnNextListener(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				viewMain.checkInForm02.setVisible(false);
				viewMain.checkInForm03.setVisible(true);
				viewMain.meter.setPercentage(viewMain.meter.getPercentage() + 0.25);
			}
		});
		
		viewMain.setcf3PBtnNextListener(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				viewMain.checkInForm03.setVisible(false);
				viewMain.checkInForm04.setVisible(true);
				viewMain.meter.setPercentage(viewMain.meter.getPercentage() + 0.25);
			}
		});
		
		viewMain.setlbtnGuestsListener(new CheckInStep1Listener());
	
	}
	public CheckInViewController(ViewMain viewMain,
			ControllerCheckIn controllerCheckIn) {
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

	Action cancel = new Action(true) {
		@Override
		public void perform(Component source) {

			BlockingDialog bd = new BlockingDialog();
			bd.setContent(new Alert(MessageType.WARNING,
					"Cancel the Check-In Process?"
							+ " Inputs will not be saved!",
					new ArrayList<String>("Yes", "No")));
			Dialog erg = bd.open(source.getDisplay());
			int i = ((Alert) erg).getSelectedOptionIndex();

			if (erg.getResult() && i == 0) {

				viewMain.checkInForm01.repaint();
				viewMain.checkInForm02.repaint();
				viewMain.checkInForm03.repaint();
				viewMain.checkInForm04.repaint();
				viewMain.checkInForm01.setVisible(false);
				viewMain.checkInForm02.setVisible(false);
				viewMain.checkInForm03.setVisible(false);
				viewMain.checkInForm04.setVisible(false);
				viewMain.progress.setVisible(false);
				viewMain.meter.setPercentage(0.25);
				viewMain.reservationForm01.setVisible(true);
				viewMain.lvReservationSearch.setEnabled(true);
			}

		}
	};
	
	public void setGuestFocus(String nummer) {
		for (IGast guest : guests) {
			if (guest.getNummer().equals(nummer)) {
				controllerCheckIn.setGast(guest);
			}
		}
	}
	
	class CheckInStep1Listener implements ListButtonSelectionListener {

		@Override
		public void selectedIndexChanged(ListButton arg0, int arg1) {
			
		}

		@Override
		public void selectedItemChanged(ListButton listButton, Object arg1) {

			String text = (String) listButton.getSelectedItem();
			String[] split = text.split(" ", 3);
			
			setGuestFocus(split[1]);
			try {
				IGast curGuest = controllerCheckIn.getGast();
				viewMain.tiFirstName.setText(curGuest.getVorname());
				viewMain.tiLastName.setText(curGuest.getNachname());
				viewMain.cbBirthdate.setSelectedDate(curGuest.getGeburtsdatum().toString());
				if (curGuest.getGeschlecht() == 'F') {
					viewMain.rbMale.setSelected(false);
					viewMain.rbFemale.setSelected(true);
				} else {
					viewMain.rbMale.setSelected(true);
					viewMain.rbFemale.setSelected(false);
				}
				
				List<IAdresse> adressen = new Vector<>(curGuest.getAdressen());
				//viewMain.lbtnGuests.setListData(wrapper);
			
			} catch (FokusException e) {
				e.printStackTrace();
			}
			
		}
	}

}
