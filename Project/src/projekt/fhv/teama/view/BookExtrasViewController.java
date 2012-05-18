package projekt.fhv.teama.view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ComponentMouseButtonListener;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.ListViewSelectionListener;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.Span;
import org.apache.pivot.wtk.TablePane;
import org.apache.pivot.wtk.TableView;
import org.apache.pivot.wtk.TableViewRowListener;

import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.usecasecontroller.ControllerZusatzleistungBuchen;
import projekt.fhv.teama.controller.usecasecontroller.LeistungAnzahl;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IALeistung;
import projekt.fhv.teama.integrate.IAZimmer;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.exception.WrongParameterException;
import projekt.fhv.teama.view.support.AdditionalServicesTableRow;
import projekt.fhv.teama.view.support.BlockingDialog;

public class BookExtrasViewController implements ButtonPressListener {
	private ViewAdditionalServices view;
	private ViewCurrentGuest viewGuest;
	private ViewMain viewMain;
	private ControllerZusatzleistungBuchen controller;
	private ArrayList<AdditionalServicesTableRow> tableDataService;

	private void initialize() throws FokusException, DatabaseException {
		viewGuest.setVisible(false);
		view.setVisible(true);
		viewMain.tabPLeftMain.setEnabled(false);
		viewMain.lvGuestSearch.setEnabled(false);
		viewMain.progress.setVisible(true);
		viewMain.lbProgress01.setVisible(true);
		viewMain.lbProgress02.setVisible(true);
		viewMain.lbProgress03.setVisible(false);
		viewMain.lbProgress04.setVisible(false);
		viewMain.meter.setPercentage(0.5);
		viewMain.lbProgress01.setTooltipText("Select a room and add services");
		viewMain.lbProgress02
				.setTooltipText("Check the overview of the booked services and finish the process by saving");
		viewMain.meter.getStyles().put("gridFrequency", "0.5");

		List<IAZimmer> rooms = controller.getZimmerVonGast();
		Wrapper wrapper = new Wrapper();

		view.asf1LVBookedRooms.setListData(wrapper
				.getZimmerWithoutPriceListAdapter(rooms));

	}

	public void exit() {
		controller.clearLists();;
		view.bpAdditionalServicesForm01.setVisible(true);
		view.bpAdditionalServicesForm02.setVisible(false);
		viewMain.tabPLeftMain.setEnabled(true);
		viewMain.lvGuestSearch.setEnabled(true);
		viewMain.progress.setVisible(false);
		view.setVisible(false);
		viewGuest.setVisible(true);
		viewMain.lbProgress01.setVisible(true);
		viewMain.lbProgress02.setVisible(true);
		viewMain.lbProgress03.setVisible(true);
		viewMain.lbProgress04.setVisible(true);
		viewMain.lvGuestSearch.setSelectedIndex(0);
	}

	public void setTableData() throws DatabaseException, FokusException {
		tableDataService = new ArrayList<AdditionalServicesTableRow>();

		List<IALeistung> services = controller.getArtikelundZusatzleistungen();
		List<IALeistung> curServices = new LinkedList<IALeistung>();
		HashMap<IALeistung, Integer> curMap = new HashMap<IALeistung, Integer>();
		IZimmer tempRoom = controller.getAktuellesZimmer();

		if (controller.getGebuchteLeistungen().get(tempRoom) != null) {
			for (LeistungAnzahl la : controller.getGebuchteLeistungen().get(
					tempRoom)) {
				curServices.add(la.getLeistung());
				curMap.put(la.getLeistung(), la.getAnzahl());
			}
		}

		int index = 0;
		for (IALeistung leistung : services) {
			tableDataService.add(new AdditionalServicesTableRow());
			AdditionalServicesTableRow row = tableDataService.get(index);
			if (curServices.contains(leistung)) {
				row.setQuantity(curMap.get(leistung));
				row.setAmount(String.valueOf(leistung.getPreis()));
				double total = curMap.get(leistung) * leistung.getPreis();
				row.setTotal(String.valueOf(total));
			} else {
				row.setQuantity(0);
				row.setAmount(leistung.getPreis());
				row.setTotal("0");
			}
			row.setType(leistung.getBezeichnung());
			index++;
		}
		view.asf1TVAdditionalServices.setTableData(tableDataService);
		view.asf1TVAdditionalServices.setRowEditor(view.tableViewRowEditor);
	}

	public void initializeSummaryWindow() throws FokusException,
			DatabaseException {
		int length = view.asf2smTPSummary.getRows().getLength();
		view.asf2PBtnFinish.setEnabled(true);
		int countServices = 0;
		view.asf2smTPSummary.getRows().remove(0, length);
		view.asf2smServiceGuest
				.setText("You are booking the following services for guest No. "
						+ controller.getGast().getNummer()
						+ " | "
						+ controller.getGast().getNachname().toUpperCase()
						+ " " + controller.getGast().getVorname() + ":");

		HashMap<IAZimmer, List<LeistungAnzahl>> services = controller
				.getGebuchteLeistungen();

		float total = 0;
		for (Map.Entry e : services.entrySet()) {
			IZimmer room = (IZimmer) e.getKey();
			List<LeistungAnzahl> tempServices = (List<LeistungAnzahl>) e
					.getValue();

			if (tempServices.size() != 0) {
				insertRowHeader();
				insertRowData(room.getNummer(), room.getKategorie()
						.getBezeichnung(), tempServices);

				for (LeistungAnzahl temp : tempServices) {
					total = total
							+ (temp.getLeistung().getPreis() * temp.getAnzahl());
					countServices++;
				}
			}
		}
		if (countServices == 0) {
			view.asf2PBtnFinish.setEnabled(false);
		}
		view.asf2smLBTotal.setText(String.valueOf(total));
	}

	private void insertRowData(String roomNo, String roomDescription,
			List<LeistungAnzahl> services) {
		TablePane.Row row = new TablePane.Row();
		view.asf2smTPSummary.getRows().add(row);
		int n = view.asf2smTPSummary.getColumns().getLength();

		StringBuilder sb = new StringBuilder();
		double amount = 0;
		int j = 1;
		for (LeistungAnzahl service : services) {
			if (j < services.size()) {
				sb.append(service.getAnzahl() + "x "
						+ service.getLeistung().getBezeichnung() + ", ");
			} else {
				sb.append(service.getAnzahl() + "x "
						+ service.getLeistung().getBezeichnung());
			}
			amount = amount
					+ (service.getLeistung().getPreis() * service.getAnzahl());
			j++;
		}

		for (int i = 1; i <= n; i++) {
			Label label = new Label();
			label.setStyleName("smTableCell");
			switch (i) {
				case 1 :
					label.setText("Nr. " + roomNo + " " + roomDescription);
					break;
				case 2 :
					label.setText(sb.toString());
					break;
				case 3 :
					label.setText("€ " + amount);
					break;
			}
			row.add(label);
		}
	}

	private void insertRowHeader() {
		TablePane.Row row = new TablePane.Row();
		view.asf2smTPSummary.getRows().add(row);
		int n = view.asf2smTPSummary.getColumns().getLength();

		for (int i = 1; i <= n; i++) {
			Label label = new Label();

			label.setStyleName("smTableHeader");

			switch (i) {
				case 1 :
					label.setText("Room");
					break;
				case 2 :
					label.setText("Additional Services");
					break;
				case 3 :
					label.setText("Total amount per room");
					break;
			}
			row.setHeight(20);
			row.add(label);
		}
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
		view.asf2PBtnBack.setAction(gotoStep);
		viewMain.setlbProgress01Listener(new ComponentMouseButtonListener() {
			public boolean mouseClick(Component arg0,
					org.apache.pivot.wtk.Mouse.Button arg1, int arg2, int arg3,
					int arg4) {
				view.bpAdditionalServicesForm02.setVisible(false);
				view.bpAdditionalServicesForm01.setVisible(true);
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
				view.bpAdditionalServicesForm01.setVisible(false);
				view.bpAdditionalServicesForm02.setVisible(true);
				try {
					initializeSummaryWindow();
				} catch (FokusException e) {
					e.printStackTrace();
				} catch (DatabaseException e) {
					e.printStackTrace();
				}
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
				view.bpAdditionalServicesForm01.setVisible(true);
				view.bpAdditionalServicesForm02.setVisible(false);
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

	public void buttonPressed(Button arg0) {

		try {
			initialize();
			addBookExtrasEventListener();
			view.asf1LVBookedRooms.setSelectedIndex(0);
		} catch (FokusException e) {
			exit();
		} catch (DatabaseException e) {
			exit();
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
			try {
				controller.saveLeistungen();
			} catch (FokusException e) {
				e.printStackTrace();
			} catch (WrongParameterException e) {
				e.printStackTrace();
			} catch (DatabaseException e) {
				e.printStackTrace();
			} catch (NotContainExeption e) {
				e.printStackTrace();
			}

			exit();
		}
	}

	class RoomChangedListener implements ListViewSelectionListener {
		public void selectedItemChanged(ListView arg0, Object arg1) {
			String text = (String) view.asf1LVBookedRooms.getSelectedItem();
			if (text == null)
				return;

			String[] split = text.split(" \\| ");
			try {
				IAZimmer room = controller.getZimmerByNummer(split[0]);
				controller.setAktuellesZimmer(room);
				view.asf1TISelectedRoom.setText("Nr. " + room.getNummer() + " "
						+ room.getKategorie().getBezeichnung()
						+ " - adding services:");
				setTableData();

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
		}

		@Override
		public void rowUpdated(TableView arg0, int arg1) {
			String type = tableDataService.get(arg1).getType();
			int quantity = tableDataService.get(arg1).getQuantity();
			try {
				IALeistung service = controller.getLeistungByBezeichnung(type);
				if (quantity > 999) {
					tableDataService.get(arg1).setQuantity(0);

				} else if (quantity == 0) {
					controller.removeLeistung(service);
					tableDataService.get(arg1).setTotal("0");
				} else {
					controller.addLeistung(service, quantity);
					double total = quantity * service.getPreis();
					tableDataService.get(arg1).setTotal(String.valueOf(total));
				}
			} catch (DatabaseException e1) {

			} catch (NotContainExeption e1) {
			} catch (FokusException e) {
			} catch (EmptyParameterException e) {
			}
		}

		@Override
		public void rowsCleared(TableView arg0) {
		}

		@Override
		public void rowsRemoved(TableView arg0, int arg1, int arg2) {
		}

		@Override
		public void rowsSorted(TableView arg0) {
			System.out.println("asdf");
			System.out.println(arg0.getRowAt(1));
			System.out.println(arg0.getTableData());
		}
	}
}
