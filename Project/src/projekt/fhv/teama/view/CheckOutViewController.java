package projekt.fhv.teama.view;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.Vector;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.adapter.ListAdapter;
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
import projekt.fhv.teama.integrate.IAAdresse;
import projekt.fhv.teama.integrate.IAAufenthalt;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.view.support.BlockingDialog;


/**
 * Der CheckOutViewController ist für das Eventhandling des Check-Out Vorgangs zuständig.
 * Hier werden die vom User ausgelösten Interaktionen ermittelt und an den Check-Out usecase Controller weitergeleitet.
 * @author Team A
 * @version 1.0
 */
public class CheckOutViewController {
	private ViewCheckOut view; 
	private ViewMain viewMain;
	private ViewCurrentGuest viewGuest;
	private ControllerCheckOut controller;
	private ViewController viewController;

	/**
	 * Die updateInvokeItems Methode kontrolliert ob alle Rechnungspositionen beglichen wurde, falls dies der Fall sein sollte wird die Hintergrunndfarbe des Labels geändert
	 * und der Text im Label neu gesetzt.
	 * @throws DatabaseException
	 * @throws FokusException
	 */
	private void updateInvokeItems() throws DatabaseException, FokusException {
		if (!controller.offeneRechnungspositionenVorhanden()) {
			view.cof1LBStatusInvoiceItems.setText("There are no open invoke items left");
			view.cof1LBStatusInvoiceItems.getStyles().put("backgroundColor", "#cae6b4");
		} else {
			view.cof1LBStatusInvoiceItems.setText("There are open invoice items left");
			view.cof1LBStatusInvoiceItems.getStyles().put("backgroundColor", "#fbe28e");
		}
	}
	
	
	/**
	 * Der FinishCheckOutListener überprüft ob alle erforderlichen Daten erfüllt sind und schliesst den Check-Out Vorgang ab.
	 *
	 */
	class FinishCheckOutListener implements ButtonPressListener {
		public void buttonPressed(Button arg0) {
			try {
				if (controller.offeneRechnungspositionenVorhanden()) {
					showBlockingDialog("All invoice line items must be paid", arg0);
				} else if (!allKeysHandedOver()) {
					showBlockingDialog("All keys must be handed over", arg0);
				} else if (!view.cof2LBDepositNr.getText().equals("")) {
					showBlockingDialog("Deposit must be handed over", arg0);
				} else {
					controller.save();
					exit();
					viewController.setReloadAufenthalte(true);
					clearForms();
					viewMain.tabPLeftMain.setSelectedIndex(1);
				}
			} catch (DatabaseException e) {
				showBlockingDialog("No Database Entries found", arg0);
			} catch (FokusException e) {
				showBlockingDialog("No guest selected", arg0);
			}
		}
	}
	
	
	/**
	 * Die allKeysHandedOver überprüft in der ViewList ob alle Schlüssel zurückgenommen worden sind.
	 * @return boolean
	 */
	private boolean allKeysHandedOver () {
		int length = view.cof2LVHandedKeys.getListData().getLength();
		for (int i = 0; i < length; i++) {
			if (!view.cof2LVHandedKeys.isItemChecked(i)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Startpunkt des Controllers - hier wird der Check- Out Vorgang gestartet und die benötigten Daten initialisiert.
	 * Bei fehlerhafter initialisierung wird der Check- Out Vorgang abgebrochen.
	 * @return boolean
	 */
	public boolean load() {
		try {
			initialize();
			setHandedKeysTable();
			setDeposit();
		} catch (Exception e) {
			exit();
			return false;
		} 
		return true;
	}
	
	/**
	 * set Deposit holt von dem usecase Controller den ausgehändigten Pfand.
	 * @throws DatabaseException
	 */
	public void setDeposit() throws DatabaseException {
		List<IAAufenthalt> aufenthalte = controller.getAufenthalte();
		if (aufenthalte.size() < 1) {
			throw new DatabaseException();
		}
		IAAufenthalt aufenthalt = aufenthalte.get(0);
		String bezeichnung = aufenthalt.getAPfandtyp().getBezeichnung();
		String nummer = aufenthalt.getPfandNr();
		view.cof2LBDepositNr.setText("Pfand: " + bezeichnung + " Nummer: " + nummer);
	}
	
	/**
	 * setHandedKeysTable initialisert die LVHandedKeys View. 
	 * @throws FokusException
	 * @throws DatabaseException
	 */
	public void setHandedKeysTable () throws FokusException, DatabaseException {
		Wrapper wrapper = new Wrapper();
		view.cof2LVHandedKeys.setListData(wrapper.getKeyListAdapaterA(controller.getZimmerVonGast()));
	}
	
	/**
	 * Die initialize Methode setzt den StartScreen für den Check- Out Vorgang.
	 * Zudem werden die Progress bars gesetzt.
	 * @throws FokusException
	 */
	private void initialize() throws FokusException {
		viewMain.tabPLeftMain.setEnabled(false);
		viewMain.lvGuestSearch.setEnabled(false);
		viewGuest.setVisible(false);
		view.setVisible(true);
		view.bpCheckOutForm01.setVisible(true);
		view.bpCheckOutForm02.setVisible(false);
		view.coProgress.setVisible(true);
		view.coMeter.setPercentage(0.5);
		view.coLBProgress01.setVisible(true);
		view.coLBProgress02.setVisible(true);
		view.coLBProgress03.setVisible(false);
		view.coLBProgress04.setVisible(false);
	}
	
	/**
	 * Die exit Methode wird beim Abschluss bzw. Abbruch des Check-Out Vorganges aufgerufen
	 * Hier werden die Screens zurückgesetzt und der Homescreen angezeigt.
	 */
	private void exit () {
		viewMain.tabPLeftMain.setEnabled(true);
		viewMain.lvGuestSearch.setEnabled(true);
		view.setVisible(false);
		view.coProgress.setVisible(false);
		view.coLBProgress01.setVisible(false);
		view.coLBProgress02.setVisible(false);
		viewGuest.setVisible(true);
		view.coProgress.setVisible(false);
		controller.clearLists();
	}
	
	private void clearForms() {
		viewGuest.cgf1LBGuestNr.setText("");
		viewGuest.cgf1TIEMail.setText("");
		viewGuest.cgf1TIName.setText("");
		viewGuest.cgf1TIPhone.setText("");
		viewGuest.cgf1TICity.setText("");
		viewGuest.cgf1TICountry.setText("");
		viewGuest.cgf1TIStreet.setText("");
		viewGuest.cgf1TIZip.setText("");
		view.cof1LBStatusInvoiceItems.setText("There are open invoice items left");
		view.cof1LBStatusInvoiceItems.getStyles().put("backgroundColor", "#fbe28e");
		view.cof2LBDepositNr.getStyles().put("backgroundColor", "#fbe28e");
		List<String> temp = new LinkedList<String>();
		view.cof2LVHandedKeys.setListData(new ListAdapter<String>(temp));
		viewGuest.cgf1LVBookedAdditionalServices.setListData(new ListAdapter<String>(temp));
		view.cof2LBDepositNr.setText("");
	}
	
	
	/**
	 * Hier werden die Action- Events der Check- Out- Views initialisiert und den Event- Listener zugewiesen.
	 */
	private void addCheckOutEventListener() {
		view.setlbProgress01Listener(new ComponentMouseButtonListener() {
			public boolean mouseUp(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3) {
				return false;
			}
			public boolean mouseDown(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3) {
				return false;
			}
			public boolean mouseClick(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3, int arg4) {
				gotoStep.perform(arg0);
				return false;
			}
		});
		view.setlbProgress02Listener(new ComponentMouseButtonListener() {
			public boolean mouseClick(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3,
					int arg4) {
				gotoStep.perform(arg0);
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
		view.cof1PBtnCancel.setAction(cancel);
		view.cof2PBtnCancel.setAction(cancel);
		view.cof1PBtnNext.setAction(gotoStep);
		view.cof2PBtnBack.setAction(gotoStep);
		view.setcof1PBtnUpdateListener(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				try {
					updateInvokeItems();
				} catch (DatabaseException e) {
					e.printStackTrace();
				} catch (FokusException e) {
					e.printStackTrace();
				}
			}
		});
		view.setcof2BTRemoveDepositListener(new ButtonPressListener() {

			@Override
			public void buttonPressed(Button arg0) {
				view.cof2LBDepositNr.setText("");
				view.cof2LBDepositNr.getStyles().put("backgroundColor", "#cae6b4");
			}
		});
		view.setcof2PBtnFinishSaveListener(new FinishCheckOutListener());
	}

	/**
	 * Die cancel- Action ruft ein BlockingDialog auf und ist bei einer Bestätigung für einen korrekten Abbruch des aktuellen Fensters zuständig.
	 */
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

	/**
	 * Die gotoStep- Action regelt die Steps des Check-Out Ablaufes und somit die Sichtbarkeit der einzelnen Check- Out Forms.
	 */
	Action gotoStep = new Action(true) {
		@Override
		public void perform(Component source) {
			if (source.getName().equals("coLBProgress01")
					|| source.getName().equals("cof2PBtnBack")) {
				view.bpCheckOutForm02.setVisible(false);
				view.bpCheckOutForm01.setVisible(true);
				view.coMeter.setPercentage(0.5);
			}

			if (source.getName().equals("coLBProgress02")
					|| source.getName().equals("cof1PBtnNext")) {
				viewMain.meter.setPercentage(1);
				view.bpCheckOutForm01.setVisible(false);
				view.bpCheckOutForm02.setVisible(true);
				view.coMeter.setPercentage(1);
			}
		}
	};
	
	public void showBlockingDialog(String msg, Component source) {
		BlockingDialog bd = new BlockingDialog();
		bd.setContent(new Alert(MessageType.WARNING,
				msg,
				new ArrayList<String>("OK")));
		bd.open(source.getDisplay());
	}
	
	/**
	 *  Konstruktor: Instanzen der viewCheckOut, ViewMain, ViewCurrentGuest und dem controller CheckOut werden dem CheckOutViewController zugewiesen.
	 * @param view
	 * @param viewMain
	 * @param viewGuest
	 * @param controllerCheckOut
	 */
	public CheckOutViewController(ViewCheckOut view, ViewMain viewMain, ViewCurrentGuest viewGuest, ControllerCheckOut controllerCheckOut, ViewController viewController) {
		this.view = view;
		this.viewMain = viewMain;
		this.viewGuest = viewGuest;
		this.controller = controllerCheckOut;
		this.viewController = viewController;
		addCheckOutEventListener();
	}
}
