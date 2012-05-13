package projekt.fhv.teama.view;

import java.util.List;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.util.Filter;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.ListView.ItemEditor;
import org.apache.pivot.wtk.ListView.ItemRenderer;
import org.apache.pivot.wtk.ListView.SelectMode;
import org.apache.pivot.wtk.ListViewListener;
import org.apache.pivot.wtk.ListViewSelectionListener;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.Span;

import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.usecasecontroller.ControllerZusatzleistungBuchen;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.view.support.BlockingDialog;

public class BookExtrasViewController implements ButtonPressListener {
	ViewAdditionalServices view;
	ViewCurrentGuest viewGuest;
	ViewMain viewMain;
	ControllerZusatzleistungBuchen controller;
	
	private void initialize() throws FokusException, DatabaseException {
		viewGuest.setVisible(false);
		view.setVisible(true);
		viewMain.lbProgress01.setVisible(true);
		viewMain.lbProgress02.setVisible(true);
		viewMain.lbProgress03.setVisible(false);
		viewMain.lbProgress04.setVisible(false);
		viewMain.meter.setPercentage(0.5);
		List<IZimmer> rooms = controller.getZimmerVonGast();
		Wrapper wrapper = new Wrapper();
		view.asf1LVBookedRooms.setListData(wrapper.getZimmerWithoutPriceListAdapter(rooms));
		view.asf1LVBookedRooms.setSelectedIndex(0);
	}
	
	private void addBookExtrasEventListener() {
		view.setasf1PBtnNextListener(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				gotoStep.perform(arg0);
			}
		});
		view.setasf2PBtnFinishListener(new SaveAdditionalService());
		view.asf1PBtnCancel.setAction(cancel);
		view.asf2PBtnCancel.setAction(cancel);
		view.setasf1LVBookedRoomsListener(new RoomChangedListener());
		view.setas1PBtnBack(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				gotoStep.perform(arg0);
			}
		});
		view.setasf2PBtnBack(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				gotoStep.perform(arg0);
			}
		});
		
	}
	
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
//				resetCheckInForms();
				view.bpAdditionalServicesForm01.setVisible(true);
				view.bpAdditionalServicesForm02.setVisible(false);
				view.setVisible(false);
				viewGuest.setVisible(true);
			}
			

		}
	};
	
	Action gotoStep = new Action(true) {
		@Override
		public void perform(Component source) {
			if (source.getName().equals("lbProgress01")
					|| source.getName().equals("asf2PBtnBack1")) {
				view.bpAdditionalServicesForm02.setVisible(false);
				view.bpAdditionalServicesForm01.setVisible(true);
				viewMain.meter.setPercentage(0.5);
			}

			if (source.getName().equals("lbProgress02")
					|| source.getName().equals("asf1PBtnNext")) {
				viewMain.meter.setPercentage(1);
				view.bpAdditionalServicesForm01.setVisible(false);
				view.bpAdditionalServicesForm02.setVisible(true);
				
			}
		}
	};
	
	@Override
	public void buttonPressed(Button arg0) {
		addBookExtrasEventListener();
		try {
			initialize();
		} catch (FokusException e) {
			e.printStackTrace();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}
	
	public BookExtrasViewController(ViewAdditionalServices view, ViewMain viewMain, ViewCurrentGuest viewGuest, ControllerZusatzleistungBuchen controller) {
		this.view = view;
		this.viewMain = viewMain;
		this.viewGuest = viewGuest;
		this.controller = controller;
	}
	
	class SaveAdditionalService implements ButtonPressListener {

		public void buttonPressed(Button arg0) {
			
		}
		
	}
	
	class RoomChangedListener implements ListViewSelectionListener {
		public void selectedItemChanged(ListView arg0, Object arg1) {
			String text = (String) view.asf1LVBookedRooms.getSelectedItem();
			if (text == null)
				return;

			String[] split = text.split(" \\| ");
			System.out.println(split[0]);
			try {
				IZimmer room = controller.getZimmerVonGastByNummer(split[0]);
				controller.setAktuellesZimmer(room);
				view.asf1TISelectedRoom.setText("Nr. " + room.getNummer() + " " + room.getKategorie().getBezeichnung() + " - adding services:");
			} catch (EmptyParameterException e) {
				e.printStackTrace();
			} catch (DatabaseException e) {
				e.printStackTrace();
			} catch (FokusException e) {
				e.printStackTrace();
			}
			
		}
		public void selectedRangeAdded(ListView arg0, int arg1, int arg2) {
		}
		public void selectedRangeRemoved(ListView arg0, int arg1, int arg2) {
		}
		public void selectedRangesChanged(ListView arg0, Sequence<Span> arg1) {
		}
	}
}


	