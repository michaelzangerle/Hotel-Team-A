package projekt.fhv.teama.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.util.Filter;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.BindType;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.ListViewSelectionListener;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.Span;
import org.apache.pivot.wtk.TablePane;
import org.apache.pivot.wtk.TableView;
import org.apache.pivot.wtk.TableView.RowEditor;
import org.apache.pivot.wtk.TableView.SelectMode;
import org.apache.pivot.wtk.TableView.SelectedRowBindMapping;
import org.apache.pivot.wtk.TableView.TableDataBindMapping;
import org.apache.pivot.wtk.TableViewBindingListener;
import org.apache.pivot.wtk.TableViewListener;
import org.apache.pivot.wtk.TableViewRowListener;
import org.apache.pivot.wtk.TableViewSelectionListener;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.usecasecontroller.ControllerZusatzleistungBuchen;
import projekt.fhv.teama.controller.usecasecontroller.LeistungAnzahl;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.view.support.AdditionalServicesTableRow;
import projekt.fhv.teama.view.support.BlockingDialog;
import projekt.fhv.teama.view.support.Service;
import projekt.fhv.teama.view.tests.TestData;

public class BookExtrasViewController implements ButtonPressListener {
	private ViewAdditionalServices view;
	private ViewCurrentGuest viewGuest;
	private ViewMain viewMain;
	private ControllerZusatzleistungBuchen controller;
	private ArrayList<AdditionalServicesTableRow> tableDataService;
	private ListButton typeListButton;
	
	private void initialize() throws FokusException, DatabaseException {
		viewGuest.setVisible(false);
		view.setVisible(true);
		viewMain.lbProgress01.setVisible(true);
		viewMain.lbProgress02.setVisible(true);
		viewMain.lbProgress03.setVisible(false);
		viewMain.lbProgress04.setVisible(false);
		viewMain.meter.setPercentage(0.5);
		
		tableDataService = new ArrayList<AdditionalServicesTableRow>();
		initializeTableServices();

		List<IZimmer> rooms = controller.getZimmerVonGast();
		Wrapper wrapper = new Wrapper();

		view.asf1LVBookedRooms.setListData(wrapper
				.getZimmerWithoutPriceListAdapter(rooms));
		view.asf1LVBookedRooms.setSelectedIndex(0);

	}

	private void initializeTableServices() throws DatabaseException {
		TestData td = new TestData(tableDataService);
		td.generateTestData();
		view.asf1TVAdditionalServices.setTableData(td.testDataServices);
		view.asf1TVAdditionalServices.setRowEditor(view.tableViewRowEditor);

		typeListButton = new ListButton(new Service(
				controller.getArtikelundZusatzleistungen()));
		typeListButton.setSelectedItemKey("type");
		view.tableViewRowEditor.getCellEditors().put("type", typeListButton);

		// TextInput quantityTextInput = new TextInput();
		// quantityTextInput.setTextKey("quantity");
		// view.tableViewRowEditor.getCellEditors().put("quantity",
		// quantityTextInput);

		// Expense type uses a ListButton that presents the expense types
		// List<String> list = new LinkedList<String>();
		// list.add("xyz");
		// ListAdapter<String> la = new ListAdapter<String>(list);
		// ListButton listButton = new ListButton();
		// listButton.setSelectedItemKey("type");
		// listButton.setListData(la);
		// view.tableViewRowEditor.getCellEditors().put("type", listButton);
		// listButton.setSelectedIndex(0);
		// Amount uses a TextInput with strict currency validation
		// TextInput amountTextInput = new TextInput();
		// amountTextInput.setValidator(new CurrencyValidator());
		// amountTextInput.setStrictValidation(true);
		// amountTextInput.setTextKey("amount");
		// view.tableViewRowEditor.getCellEditors().put("amount",
		// amountTextInput);
		// //
		// // // Description uses a TextInput
		// TextInput descriptionTextInput = new TextInput();
		// descriptionTextInput.setTextKey("description");
		// view.tableViewRowEditor.getCellEditors().put("description",
		// descriptionTextInput);

		// TestData td = new TestData();
		// td.generateTestData();
		// view.asf1TVAdditionalServices.setTableData(td.testDataServices);
		// List<ILeistung> leistungen =
		// controller.getArtikelundZusatzleistungen();
		// List<String> list = new LinkedList<String>();
		// for (ILeistung leistung : leistungen) {
		// list.add(leistung.getBezeichnung());
		// }
		// view.setListData(list);

		// // Quantity uses a TextInput
		// TextInput quantityTextInput = new TextInput();
		// quantityTextInput.setTextKey("quantity");
		// tableViewRowEditor.getCellEditors().put("quantity",
		// quantityTextInput);
		//
		// // Expense type uses a ListButton that presents the expense types
		// List<String> list = new LinkedList<String>();
		// list.add("asdf1");
		// list.add("asdf2");
		// ListAdapter<String> li = new ListAdapter<String>(list);
		// ListButton typeListButton = new ListButton();
		// typeListButton.setListData(li);
		// typeListButton.setSelectedItemKey("type");
		// tableViewRowEditor.getCellEditors().put("type", typeListButton);
		//
		// // Amount uses a TextInput with strict currency validation
		// TextInput amountTextInput = new TextInput();
		// amountTextInput.setValidator(new CurrencyValidator());
		// amountTextInput.setStrictValidation(true);
		// amountTextInput.setTextKey("amount");
		// tableViewRowEditor.getCellEditors().put("amount", amountTextInput);
		// //
		// // // Description uses a TextInput
		// TextInput descriptionTextInput = new TextInput();
		// descriptionTextInput.setTextKey("description");
		// tableViewRowEditor.getCellEditors().put("description",
		// descriptionTextInput);

	}

	public void initializeSummaryWindow() throws FokusException,
			DatabaseException {
		view.asf2smServiceGuest
				.setText("You are booking the following services for guest No. "
						+ controller.getGast().getNummer()
						+ " | "
						+ controller.getGast().getNachname().toUpperCase()
						+ " " + controller.getGast().getVorname() + ":");
		HashMap<IZimmer, List<LeistungAnzahl>> services = controller
				.getGebuchteLeistungen();

		for (Map.Entry e : services.entrySet()) {
			IZimmer room = (IZimmer) e.getKey();
			view.asf2smLBRoom.setText(room.getNummer());
			List<LeistungAnzahl> tempServices = (List<LeistungAnzahl>) e
					.getValue();
			for (LeistungAnzahl service : tempServices) {
				TablePane.Row row = new TablePane.Row(1, true);
				view.asf2smLBServices.setText("test"); // service.getBezeichnung
				view.asf2smLBTotal.setText("");
			}
		}
	}

	public void addServiceToRoom() {

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
		view.setasf1TVAdditionalServicesListener(new AdditionalServiceListener());
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
				// resetCheckInForms();
				view.bpAdditionalServicesForm01.setVisible(true);
				view.bpAdditionalServicesForm02.setVisible(false);
				view.setVisible(false);
				viewGuest.setVisible(true);
				viewMain.lbProgress03.setVisible(true);
				viewMain.lbProgress04.setVisible(true);
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
				try {
					initializeSummaryWindow();
				} catch (FokusException e) {
					e.printStackTrace();
				} catch (DatabaseException e) {
					e.printStackTrace();
				}
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

	public BookExtrasViewController(ViewAdditionalServices view,
			ViewMain viewMain, ViewCurrentGuest viewGuest,
			ControllerZusatzleistungBuchen controller) {
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
			try {
				IZimmer room = controller.getZimmerByNummer(split[0]);
				controller.setAktuellesZimmer(room);
				view.asf1TISelectedRoom.setText("Nr. " + room.getNummer() + " "
						+ room.getKategorie().getBezeichnung()
						+ " - adding services:");
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

	class AdditionalServiceListener implements TableViewRowListener {
		@Override
		public void rowInserted(TableView arg0, int arg1) {
			System.out.println("row inserted " + arg0);
			System.out.println("row inserted " + arg1);

		}

		@Override
		public void rowUpdated(TableView arg0, int arg1) {
			System.out.println("row updated " + arg0);
			System.out.println("row updated " + arg1);
			view.asf1LBtypes.setSelectedIndex(arg1);

			// Service asdf = tableDataService.get(arg1).getType();

//			System.out.println(tableDataService.get(arg1).getAmount());
			System.out.println(tableDataService.get(arg1).getType());
			try {
				ILeistung leistung = controller.getArtikelundZusatzleistungen()
						.get(arg1);
				System.out.println(leistung.toString());

			} catch (DatabaseException e) {
				e.printStackTrace();
			}
			if (tableDataService.get(arg1).getType() != null) {
				tableDataService.add(new AdditionalServicesTableRow());
			}

		}

		@Override
		public void rowsCleared(TableView arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void rowsRemoved(TableView arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void rowsSorted(TableView arg0) {
			// TODO Auto-generated method stub

		}
	}
}
