package projekt.fhv.teama.view;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ComponentMouseButtonListener;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.MessageType;

import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckOut;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.view.support.BlockingDialog;

public class CheckOutViewController implements ButtonPressListener {
	private ViewCheckOut view; 
	private ViewMain viewMain;
	private ViewCurrentGuest viewGuest;
	private ControllerCheckOut controller;
	
	public void buttonPressed(Button arg0) {
		initialize();
	}

	private void initialize() {
		viewMain.tabPLeftMain.setEnabled(false);
		viewMain.lvGuestSearch.setEnabled(false);
		viewGuest.setVisible(false);
		view.setVisible(true);
		viewMain.progress.setVisible(true);
		viewMain.lbProgress01.setVisible(true);
		viewMain.lbProgress02.setVisible(true);
		viewMain.lbProgress03.setVisible(false);
		viewMain.lbProgress04.setVisible(false);
		viewMain.meter.setPercentage(0.5);
		addCheckOutEventListener();
	}
	
	private void exit () {
		viewMain.tabPLeftMain.setEnabled(true);
		viewMain.lvGuestSearch.setEnabled(true);
		view.setVisible(false);
		viewGuest.setVisible(true);
		viewMain.progress.setVisible(false);
		viewMain.lbProgress01.setVisible(true);
		viewMain.lbProgress02.setVisible(true);
		viewMain.lbProgress03.setVisible(true);
		viewMain.lbProgress04.setVisible(true);
		viewMain.meter.setPercentage(0.5);
	}
	
	private void addCheckOutEventListener() {
		viewMain.setlbProgress01Listener(new ComponentMouseButtonListener() {
			public boolean mouseClick(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3,
					int arg4) {
				view.bpCheckOutForm02.setVisible(false);
				view.bpCheckOutForm01.setVisible(true);
				viewMain.meter.setPercentage(0.5);
				return false;
			}
			public boolean mouseDown(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3) {
				return false;
			}
			public boolean mouseUp(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3) {
				return false;
			}
		});
		viewMain.setlbProgress02Listener(new ComponentMouseButtonListener() {
			public boolean mouseUp(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3) {
				viewMain.meter.setPercentage(1);
				view.bpCheckOutForm01.setVisible(false);
				view.bpCheckOutForm02.setVisible(true);
				return false;
			}
			public boolean mouseDown(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3) {
				return false;
			}
			public boolean mouseClick(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3,
					int arg4) {
				return false;
			}
		});
		view.cof1PBtnCancel.setAction(cancel);
		view.cof1PBtnNext.setAction(gotoStep);
	}

	Action cancel = new Action(true) {
		@Override
		public void perform(Component source) {

			BlockingDialog bd = new BlockingDialog();
			bd.setContent(new Alert(MessageType.WARNING,
					"Cancel the Additional Services Process?"
							+ " Inputs will not be saved!",
					new ArrayList<String>("Yes", "No")));
			Dialog erg = bd.open(source.getDisplay());
			int i = ((Alert) erg).getSelectedOptionIndex();

			if (erg.getResult() && i == 0) {
				view.bpCheckOutForm01.setVisible(true);
				view.bpCheckOutForm02.setVisible(false);
				view.setVisible(false);
				exit();
			}
		}
	};

	Action gotoStep = new Action(true) {
		@Override
		public void perform(Component source) {
			if (source.getName().equals("lbProgress01")
					|| source.getName().equals("asf2PBtnBack")) {
				view.bpCheckOutForm02.setVisible(false);
				view.bpCheckOutForm01.setVisible(true);
				viewMain.meter.setPercentage(0.5);
			}

			if (source.getName().equals("lbProgress02")
					|| source.getName().equals("cof1PBtnNext")) {
				viewMain.meter.setPercentage(1);
				view.bpCheckOutForm01.setVisible(false);
				view.bpCheckOutForm02.setVisible(true);
			}
		}
	};
	
	public CheckOutViewController(ViewCheckOut view, ViewMain viewMain, ViewCurrentGuest viewGuest) {
		this.view = view;
		this.viewMain = viewMain;
		this.viewGuest = viewGuest;
		this.controller = new ControllerCheckOut();
	}
}
