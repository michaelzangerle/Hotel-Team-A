package projekt.fhv.teama.view;

import java.awt.Color;
import java.util.List;

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
import projekt.fhv.teama.integrate.IAAufenthalt;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.view.support.BlockingDialog;


/**
 * 
 * @author Team A
 *
 */
public class CheckOutViewController implements ButtonPressListener {
	private ViewCheckOut view; 
	private ViewMain viewMain;
	private ViewCurrentGuest viewGuest;
	private ControllerCheckOut controller;

	
	
	class FinishCheckOutListener implements ButtonPressListener {
		public void buttonPressed(Button arg0) {
			if (controller.offeneRechnungspositionenVorhanden()) {
				BlockingDialog bd = new BlockingDialog();
				bd.setContent(new Alert(MessageType.WARNING,
						"All invoice line items must be paid",
						new ArrayList<String>("OK")));
				bd.open(view.getDisplay());
			} else {
				controller.save();
			}
		}
	}
	
	public void buttonPressed(Button arg0) {
		try {
			initialize();
			addCheckOutEventListener();
			setHandedKeysTable();
			setDeposit();
		} catch (FokusException e) {
			e.printStackTrace();
			exit();
		} catch (DatabaseException e) {
			e.printStackTrace();
			exit();
		}
	}
	
	public void setDeposit() throws DatabaseException {
		List<IAAufenthalt> aufenthalte = controller.getAufenthalte();
		IAAufenthalt aufenthalt = aufenthalte.get(0);
		String bezeichnung = aufenthalt.getPfandtyp().getBezeichnung();
		String nummer = aufenthalt.getPfandNr();
		view.cof2LBDepositNr.setText("Pfand: " + bezeichnung + " Nummer: " + nummer);
	}
	
	public void setHandedKeysTable () throws FokusException, DatabaseException {
		Wrapper wrapper = new Wrapper();
		view.cof2LVHandedKeys.setListData(wrapper.getKeyListAdapaterA(controller.getZimmerVonGast()));
	}
	

	private void initialize() throws FokusException {
		viewMain.tabPLeftMain.setEnabled(false);
		viewMain.lvGuestSearch.setEnabled(false);
		viewGuest.setVisible(false);
		view.setVisible(true);
		view.bpCheckOutForm01.setVisible(true);
		viewMain.progress.setVisible(true);
		viewMain.lbProgress01.setVisible(true);
		viewMain.lbProgress02.setVisible(true);
		viewMain.lbProgress03.setVisible(false);
		viewMain.lbProgress04.setVisible(false);
		viewMain.lbProgress01
		.setTooltipText("Generate Invoices for the guest");
		viewMain.lbProgress02
		.setTooltipText("Take back room-keys and remove deposit");
		viewMain.meter.setPercentage(0.5);
	}
	
	private void exit () {
		viewMain.tabPLeftMain.setEnabled(true);
		viewMain.lvGuestSearch.setEnabled(true);
		view.setVisible(false);
		viewGuest.setVisible(true);
		viewMain.progress.setVisible(false);
		viewMain.lbProgress01
		.setTooltipText("");
		viewMain.lbProgress02
		.setTooltipText("");
		viewMain.lbProgress01.setVisible(false);
		viewMain.lbProgress02.setVisible(false);
		viewMain.lbProgress03.setVisible(false);
		viewMain.lbProgress04.setVisible(false);
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
		view.cof2PBtnCancel.setAction(cancel);
		view.cof1PBtnNext.setAction(gotoStep);
		view.cof2PBtnBack.setAction(gotoStep);
//		view.setcof1PBtnCreateInvoiceListener(new ButtonPressListener(){
//			public void buttonPressed(Button arg0) {
//				createInvoice();
//			}
//		});
		view.setcof2BTRemoveDepositListener(new ButtonPressListener() {

			@Override
			public void buttonPressed(Button arg0) {
				view.cof2LBDepositNr.setText("");
				view.cof2LBDepositNr.getStyles().put("backgroundColor", Color.GREEN);
			}
		});
		view.setcof2PBtnFinishSaveListener(new FinishCheckOutListener());
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
				view.bpCheckOutForm01.setVisible(false);
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
					|| source.getName().equals("cof2PBtnBack")) {
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
	
	public CheckOutViewController(ViewCheckOut view, ViewMain viewMain, ViewCurrentGuest viewGuest, ControllerCheckOut controllerCheckOut) {
		this.view = view;
		this.viewMain = viewMain;
		this.viewGuest = viewGuest;
		this.controller = controllerCheckOut;
	}
}
