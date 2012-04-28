package projekt.fhv.teama.view;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.collections.adapter.ListAdapter;
import org.apache.pivot.serialization.SerializationException;
import org.apache.pivot.util.CalendarDate;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.Button.State;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.ButtonStateListener;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ComponentMouseButtonListener;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListButtonSelectionListener;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.ListViewItemStateListener;
import org.apache.pivot.wtk.ListViewSelectionListener;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.Span;
import org.apache.pivot.wtk.TextInput;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.MyLittleDate;
import projekt.fhv.teama.classes.personen.Adresse;
import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.classes.personen.Kontodaten;
import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckIn;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.exception.WrongParameterException;
import projekt.fhv.teama.view.support.BlockingDialog;

public class CheckInViewController implements ButtonPressListener {
	private ViewMain viewMain;
	private ControllerCheckIn controllerCheckIn;
	private List<IGast> guests;
	private List<ITeilreservierung> teilreservierungen;
	private List<String> selectedRooms;
	private ViewController viewController;

	@Override
	public void buttonPressed(Button arg0) {
		viewMain.reservationForm01.setVisible(false);
		viewMain.checkInForm01.setVisible(true);
		viewMain.progress.setVisible(true);
		viewMain.tabPLeftMain.setEnabled(false);
		try {
			initialize();
		} catch (FokusException e2) {
			BlockingDialog bd = new BlockingDialog();
			bd.setContent(new Alert(MessageType.WARNING,
					"no reservation selected",
					new ArrayList<String>("OK")));
			bd.open(viewController.getDisp());
		} catch (DatabaseException e) {
			BlockingDialog bd = new BlockingDialog();
			bd.setContent(new Alert(MessageType.WARNING,
					"no reservation found",
					new ArrayList<String>("OK")));
		} catch (NotEnoughRoomsException e) {
			BlockingDialog bd = new BlockingDialog();
			bd.setContent(new Alert(MessageType.WARNING,
					"not enough free rooms found",
					new ArrayList<String>("OK")));
		}
	}

	private void initialize() throws FokusException, DatabaseException,
			NotEnoughRoomsException {
		addCheckInEventListener();
		selectedRooms = new LinkedList<String>();
		Wrapper wrapper = new Wrapper();
		controllerCheckIn.initVerfuegbareZimmer();
		teilreservierungen = new Vector<ITeilreservierung>(controllerCheckIn
				.getAktuelleReservierung().getTeilreservierungen());
		viewMain.lvBookedRoomCategories.setListData(wrapper
				.getTeilreservierungListAdapter(teilreservierungen));

		Date arrival = controllerCheckIn.getAktuelleReservierung().getVon();
		Date departure = controllerCheckIn.getAktuelleReservierung().getBis();
		CalendarDate d1 = CalendarDate.decode(arrival.toString());
		CalendarDate d2 = CalendarDate.decode(departure.toString());

		viewMain.cbArrival.setSelectedDate(d1);
		viewMain.cbDeparture.setSelectedDate(d2);

		for (ITeilreservierung teilreservierung : teilreservierungen) {
			showSelectedRooms(getRoomsByCategory(teilreservierung
					.getKategorie()));
		}

		defaultRoomAssignment();

		viewMain.lvBookedRoomCategories.setSelectedIndex(0);

		IReservierung reservation = controllerCheckIn.getAktuelleReservierung();
		guests = new Vector<IGast>(reservation.getGaeste());

		List<ILand> countries = controllerCheckIn.getLaender();
		viewMain.lbtnCountry.setListData(wrapper
				.getCountryListAdapter(countries));
		viewMain.lbtnCountry.setSelectedIndex(0);

		if (guests.size() != 0) {
			viewMain.lbtnGuests
					.setListData(wrapper.getGuestListAdapter(guests));
			String nummer = guests.get(0).getNummer();
			setSelectedGuest(nummer);
			viewMain.lbtnGuests.setSelectedIndex(0);
		} else {
			viewMain.lbtnGuests.setButtonData("no guest entry");
			viewMain.lbtnAddresses.setButtonData("no adress entry");
		}

		List<IPfandtyp> pfandTypen = controllerCheckIn.getPfandtyps();
		viewMain.lbtnDepositType.setListData(wrapper
				.getPfandTypListAdapter(pfandTypen));
		viewMain.lbtnDepositType.setSelectedIndex(0);
	}

	public void setSelectedGuest(String nummer) throws FokusException,
			DatabaseException {
		Wrapper wrapper = new Wrapper();
		setGuestFocus(nummer);
		IGast curGuest = controllerCheckIn.getGast();

		viewMain.tiFirstName.setText(curGuest.getVorname());
		viewMain.tiLastName.setText(curGuest.getNachname());

		if (curGuest.getGeburtsdatum() != null) {
			Date birthday = curGuest.getGeburtsdatum();
			CalendarDate d1 = CalendarDate.decode(birthday.toString());
			viewMain.cbBirthdate.setSelectedDate(d1);
		}

		if (curGuest.getGeschlecht() == 'F') {
			viewMain.rbMale.setSelected(false);
			viewMain.rbFemale.setSelected(true);
		} else {
			viewMain.rbMale.setSelected(true);
			viewMain.rbFemale.setSelected(false);
		}

		List<IAdresse> adressen = new Vector<IAdresse>(curGuest.getAdressen());
		if (!adressen.isEmpty()) {
			wrapper = new Wrapper();
			viewMain.lbtnAddresses.setListData(wrapper
					.getAdressListAdapter(adressen));
			viewMain.lbtnAddresses.setSelectedIndex(0);
			viewMain.lbtnCountry.setSelectedItem(adressen.get(0).getLand()
					.getBezeichnung());
		}

		viewMain.tiPhone.setText(curGuest.getTelefonnummer());
		viewMain.tiMail.setText(curGuest.getEmail());
		viewMain.tiAccountNr.setText(curGuest.getKontodaten().getKontonummer());
		viewMain.tiBankCodeNr.setText(curGuest.getKontodaten().getBlz());
		viewMain.tiIban.setText(curGuest.getKontodaten().getIban());
		viewMain.tiBic.setText(curGuest.getKontodaten().getBic());
	}

	public void setGuestFocus(String nummer) {
		for (IGast guest : guests) {
			if (guest.getNummer().equals(nummer)) {
				controllerCheckIn.setGast(guest);
			}
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

		viewMain.setcf1PBtnNextListener(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				gotoStep.perform(arg0);
			}
		});
		viewMain.setcf2PBtnNextListener(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				gotoStep.perform(arg0);
			}
		});
		viewMain.setcf3PBtnNextListener(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				gotoStep.perform(arg0);
			}
		});

		viewMain.setcf2PBtnBackListener(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				gotoStep.perform(arg0);
			}
		});
		viewMain.setcf3PBtnBackListener(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				gotoStep.perform(arg0);
			}
		});
		viewMain.setcf4PBtnBackListener(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				gotoStep.perform(arg0);
			}
		});

		viewMain.cf1PBtnCancel.setAction(cancel);
		viewMain.cf2PBtnCancel.setAction(cancel);
		viewMain.cf3PBtnCancel.setAction(cancel);
		viewMain.cf4PBtnCancel.setAction(cancel);

		viewMain.setlbtnGuestsListener(new GuestChangedListener());
		viewMain.setlbtnAddressesListener(new AdressChangedListener());
		viewMain.setlvBookedRoomCategoriesListener(new CategoryChangedListener());
		viewMain.setlvAssignedRoomsListener(new RoomChangedListener());

		viewMain.setcbxShowAllRoomsListener(new ShowAllRoomsListener());
		viewMain.setcf4PBtnFinishListener(new CreateAufenthaltListener());
	}

	public CheckInViewController(ViewMain viewMain,
			ControllerCheckIn controllerCheckIn, ViewController viewController) {
		this.viewMain = viewMain;
		this.controllerCheckIn = controllerCheckIn;
		this.viewController = viewController;
	}

	Action gotoStep = new Action(true) {
		@Override
		public void perform(Component source) {
			if (source.getName().equals("lbProgress01")
					|| source.getName().equals("cf2PBtnBack")) {
				viewMain.meter.setPercentage(0.25);
				viewMain.checkInForm01.setVisible(true);
				viewMain.checkInForm02.setVisible(false);
				viewMain.checkInForm03.setVisible(false);
				viewMain.checkInForm04.setVisible(false);
			}

			if (source.getName().equals("lbProgress02")
					|| source.getName().equals("cf1PBtnNext")
					|| source.getName().equals("cf3PBtnBack")) {
				viewMain.meter.setPercentage(0.50);
				viewMain.checkInForm01.setVisible(false);
				viewMain.checkInForm02.setVisible(true);
				viewMain.checkInForm03.setVisible(false);
				viewMain.checkInForm04.setVisible(false);
			}

			if (source.getName().equals("lbProgress03")
					|| source.getName().equals("cf2PBtnNext")
					|| source.getName().equals("cf4PBtnBack")) {
				viewMain.meter.setPercentage(0.75);
				viewMain.checkInForm01.setVisible(false);
				viewMain.checkInForm02.setVisible(false);
				viewMain.checkInForm03.setVisible(true);
				viewMain.checkInForm04.setVisible(false);
			}

			if (source.getName().equals("lbProgress04")
					|| source.getName().equals("cf3PBtnNext")) {
				viewMain.meter.setPercentage(1);
				viewMain.checkInForm01.setVisible(false);
				viewMain.checkInForm02.setVisible(false);
				viewMain.checkInForm03.setVisible(false);
				viewMain.checkInForm04.setVisible(true);
				try {
					initializeSummaryWindow();
					checkFormOnEmptyFields("");
				} catch (SerializationException e) {
					e.printStackTrace();
				} catch (DatabaseEntryNotFoundException e) {
					e.printStackTrace();
				} catch (FokusException e) {
					e.printStackTrace();
				} catch (EmptyParameterException e) {
					e.printStackTrace();
				}
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
				resetCheckInForms();
			}

		}
	};

	public void resetCheckInForms() {
		viewMain.checkInForm01.setVisible(false);
		viewMain.checkInForm02.setVisible(false);
		viewMain.checkInForm03.setVisible(false);
		viewMain.checkInForm04.setVisible(false);
		viewMain.progress.setVisible(false);
		viewMain.meter.setPercentage(0.25);
		viewMain.reservationForm01.setVisible(true);
		viewMain.tabPLeftMain.setEnabled(true);

		controllerCheckIn.clearLists();
		try {
			viewController.initializeMainView();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		List<TextInput> components = viewMain.getAllCheckInTextFields();
		for (TextInput comp : components) {
			comp.setText("");
		}
	}

	public void initializeSummaryWindow()
			throws DatabaseEntryNotFoundException, FokusException,
			EmptyParameterException, SerializationException {
		Wrapper wrapper = new Wrapper();

		try {
			viewMain.smLVFinalRooms.setListData(wrapper
					.getZimmerListAdapter(controllerCheckIn
							.getAusgewählteZimmer()));
			viewMain.smLVHandedKeys
			.setListData(wrapper.getKeyListAdapter(controllerCheckIn
					.getAusgewählteZimmer()));
		} catch (NotContainExeption e) {
			LinkedList<String> listmsg = new LinkedList<String>();
			listmsg.add(" ");
			ListAdapter<String> list = new ListAdapter<String>(listmsg);
			viewMain.smLVFinalRooms.setListData(list);
			viewMain.smLVFinalRooms.setStyles("{backgroundColor:'#fbe28e'}");
			viewMain.smLVHandedKeys.setListData(list);
			viewMain.smLVFinalRooms.setStyles("{backgroundColor:'#fbe28e'}");
		}

		if (viewMain.rbMale.isSelected()) {
			viewMain.smLBGender.setText("male");
		} else {
			viewMain.smLBGender.setText("female");
		}

		java.sql.Date von = MyLittleDate.getDate(
				viewMain.cbArrival.getSelectedDate().year,
				viewMain.cbArrival.getSelectedDate().month,
				viewMain.cbArrival.getSelectedDate().day);
		java.sql.Date bis = MyLittleDate.getDate(
				viewMain.cbDeparture.getSelectedDate().year,
				viewMain.cbDeparture.getSelectedDate().month,
				viewMain.cbDeparture.getSelectedDate().day);
		viewMain.smLBTotalPrice.setText("€ "
				+ String.valueOf(controllerCheckIn
						.berechneZimmerpreis(von, bis)));
	}

	class GuestChangedListener implements ListButtonSelectionListener {
		@Override
		public void selectedIndexChanged(ListButton listButton, int arg1) {
			selectedItemChanged(listButton, arg1);
		}

		@Override
		public void selectedItemChanged(ListButton listButton, Object arg1) {
			if (listButton.getSelectedItem() == null) {
				return;
			}
			String text = (String) listButton.getSelectedItem();
			String[] split = text.split(" ", 3);
			try {
				setSelectedGuest(split[1]);
			} catch (FokusException e) {
				BlockingDialog bd = new BlockingDialog();
				bd.setContent(new Alert(MessageType.WARNING,
						"no guest selected",
						new ArrayList<String>("OK")));
			} catch (DatabaseException e) {
				BlockingDialog bd = new BlockingDialog();
				bd.setContent(new Alert(MessageType.WARNING,
						"not guest found",
						new ArrayList<String>("OK")));
			}
		}
	}

	
	
	
	class AdressChangedListener implements ListButtonSelectionListener {
		@Override
		public void selectedIndexChanged(ListButton listButton, int arg1) {

		}

		@Override
		public void selectedItemChanged(ListButton listButton, Object arg1) {
			if (listButton.getSelectedItem() == null) {
				return;
			}
			String text = (String) listButton.getSelectedItem();
			String[] split = text.split(" \\| ");
			try {
				setSelectedAdress(split[0], split[1], split[2], split[3]);
			} catch (FokusException e) {
				e.printStackTrace();
			}
		}
	}

	public void setSelectedAdress(String street, String city, String zip,
			String country) throws FokusException {
		setAdressFocus(street, city, zip, country);
		viewMain.tiStreet.setText(street);
		viewMain.tiCity.setText(city);
		viewMain.lbtnCountry.setSelectedItem(country);
		viewMain.tiZip.setText(zip);
		
	}

	public IAdresse getSelectedAdress(String street, String city, String zip,
			String country) throws FokusException {
		List<IAdresse> adressen = new Vector<IAdresse>(controllerCheckIn
				.getGast().getAdressen());

		for (IAdresse adresse : adressen) {
			if (adresse.getStrasse().equalsIgnoreCase(street)
					&& adresse.getOrt().equalsIgnoreCase(city)
					&& adresse.getPlz().equalsIgnoreCase(zip)
					&& adresse.getLand().getBezeichnung()
							.equalsIgnoreCase(country)) {
				return adresse;
			}
		}
		return null;
	}

	public void setAdressFocus(String street, String city, String zip,
			String country) throws FokusException {
		List<IAdresse> adressen = new Vector<IAdresse>(controllerCheckIn
				.getGast().getAdressen());

		for (IAdresse adresse : adressen) {
			if (adresse.getStrasse() == street && adresse.getOrt() == city
					&& adresse.getPlz() == zip
					&& adresse.getLand().getBezeichnung() == country) {
			}
		}
	}

	public void setSelectedPartialReservation(String categoryName) {
		IKategorie category = getCategoryByName(categoryName);

		try {
			Wrapper wrapper = new Wrapper();
			List<IZimmer> availableRooms = getRoomsByCategory(category);
			viewMain.lvAssignedRooms.setListData(wrapper
					.getZimmerListAdapter(availableRooms));
		} catch (FokusException e) {
			e.printStackTrace();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

	public IKategorie getCategoryByName(String categoryName) {
		ITeilreservierung curTeilreservierung = getSelectedTeilreservierung(categoryName);
		return curTeilreservierung.getKategorie();
	}

	public void defaultRoomAssignment() throws NotEnoughRoomsException,
			DatabaseException, FokusException {
		Wrapper wrapper = new Wrapper();
		for (ITeilreservierung teilreservierung : controllerCheckIn
				.getAktuelleReservierung().getTeilreservierungen()) {
			List<IZimmer> availableRooms = getRoomsByCategory(teilreservierung
					.getKategorie());

			for (int i = 0; i < teilreservierung.getAnzahl(); i++) {
				if (i >= availableRooms.size()) {
					throw new NotEnoughRoomsException(availableRooms.size() - i);
				}
				controllerCheckIn.addZimmer(availableRooms.get(i));
				selectedRooms.add(wrapper.getZimmer(availableRooms.get(i)));
			}
		}
		try {
			showSelectedRooms(controllerCheckIn.getAusgewählteZimmer());
		} catch (NotContainExeption e) {
			e.printStackTrace();
		}
	}

	public List<IZimmer> getRoomsByCategory(IKategorie kat)
			throws DatabaseException, FokusException {
		HashMap<IKategorie, List<IZimmer>> availableRooms = controllerCheckIn
				.getVerfuegbareZimmer();
		List<IZimmer> z = availableRooms.get(kat);
		return z;
	}

	public IZimmer getRoomByNumber(String roomNumber) throws DatabaseException,
			FokusException {
		List<IZimmer> availableRooms = getAllAvailableRooms();
		for (IZimmer room : availableRooms) {
			if (room.getNummer().equals(roomNumber)) {
				return room;
			}
		}
		return null;
	}

	public ITeilreservierung getSelectedTeilreservierung(String categoryName) {
		for (ITeilreservierung teilreservierung : teilreservierungen) {
			if (teilreservierung.getKategorie().getBezeichnung()
					.equalsIgnoreCase(categoryName)) {
				return teilreservierung;
			}
		}
		return null;
	}

	public List<IZimmer> getAllAvailableRooms() throws DatabaseException,
			FokusException {
		List<IZimmer> curRooms = new LinkedList<IZimmer>();
		HashMap<IKategorie, List<IZimmer>> rooms = controllerCheckIn
				.getVerfuegbareZimmer();
		List<IZimmer> alle = new Vector<IZimmer>();

		for (Map.Entry<IKategorie, List<IZimmer>> entry : rooms.entrySet()) {
			alle.addAll(entry.getValue());

		}
		return alle;
	}

	class CategoryChangedListener implements ListViewSelectionListener {
		@Override
		public void selectedItemChanged(ListView listView, Object arg1) {
			if (listView.getSelectedItem() == null) {
				return;
			}
			if (viewMain.cbxShowAllRooms.isSelected()) {
				viewMain.cbxShowAllRooms.setSelected(false);
			}
			String text = (String) listView.getSelectedItem();
			String[] split = text.split(" ", 2);
			String categoryName = split[1];

			try {
				showSelectedRooms(getRoomsByCategory(getCategoryByName(categoryName)));
			} catch (DatabaseException e1) {
				e1.printStackTrace();
			} catch (FokusException e1) {
				e1.printStackTrace();
			}
		}
		public void selectedRangeAdded(ListView arg0, int arg1, int arg2) {
		}
		public void selectedRangeRemoved(ListView arg0, int arg1, int arg2) {
		}
		public void selectedRangesChanged(ListView arg0, Sequence<Span> arg1) {
		}
	}

	class RoomChangedListener implements ListViewItemStateListener {
		public void selectedItemChanged(ListView listView, Object arg1) {

		}
		public void selectedRangeAdded(ListView arg0, int arg1, int arg2) {
		}
		public void selectedRangeRemoved(ListView arg0, int arg1, int arg2) {
		}
		public void selectedRangesChanged(ListView arg0, Sequence<Span> arg1) {
		}
		@Override
		public void itemCheckedChanged(ListView listView, int arg1) {
			viewMain.lvAssignedRooms.setSelectedIndex(arg1);
			String text = (String) viewMain.lvAssignedRooms.getSelectedItem();
			String[] split = text.split(" \\| ");

			if (!listView.isItemChecked(arg1)) {
				if (selectedRooms.contains(text)) {
					selectedRooms.remove(text);
					try {
						removeRoom(getRoomByNumber(split[0]));
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (DatabaseException e) {
						e.printStackTrace();
					} catch (FokusException e) {
						e.printStackTrace();
					}
				}
			} else {
				if (!selectedRooms.contains(text)) {
					selectedRooms.add(text);
					try {
						controllerCheckIn.addZimmer(getRoomByNumber(split[0]));
					} catch (DatabaseException e) {
						e.printStackTrace();
					} catch (FokusException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void removeRoom(IZimmer room) {
		controllerCheckIn.remove(room);
	}

	
	public void addRoom(IZimmer room) {
		controllerCheckIn.addZimmer(room);
	}

	class ShowAllRoomsListener implements ButtonStateListener {
		public void stateChanged(Button arg0, State arg1) {
			if (arg0.isSelected()) {
				try {
					List<IZimmer> allAvailableRooms = getAllAvailableRooms();
					showSelectedRooms(allAvailableRooms);
				} catch (DatabaseException e) {
					e.printStackTrace();
				} catch (FokusException e) {
					e.printStackTrace();
				}

			} else {
				String selectedItem = (String) viewMain.lvBookedRoomCategories
						.getSelectedItem();
				String[] split = selectedItem.split(" ", 2);

				String categoryName = split[1];

				try {
					showSelectedRooms(getRoomsByCategory(getCategoryByName(categoryName)));
				} catch (DatabaseException e) {
					e.printStackTrace();
				} catch (FokusException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void showSelectedRooms(List<IZimmer> availableRooms) {
		int i = 0;
		Wrapper wrapper = new Wrapper();
		ListAdapter<String> rooms = wrapper
				.getZimmerListAdapter(availableRooms);
		viewMain.lvAssignedRooms.setListData(rooms);

		for (String room : rooms) {
			if (selectedRooms.contains(room)) {
				viewMain.lvAssignedRooms.setItemChecked(i, true);
			}
			i++;
		}
	}

	public int checkFormOnEmptyFields(String message)
			throws SerializationException {
		List<Label> components = (List<Label>) viewMain.getAllCheckInLabels();
		int count = 0;

		for (Label comp : components) {
			if (comp.getText().equals(new String())) {
				comp.setText(message);
				comp.setStyles("{backgroundColor:'#fbe28e'}");
				count++;
			} else {
				comp.setStyles("{backgroundColor:'#ffffff'}");
			}
		}
		int length = viewMain.smLVHandedKeys.getListData().getLength();

		for (int i = 0; i < length; i++) {
			if (!viewMain.smLVHandedKeys.isItemChecked(i)) {
				count++;
			}
		}
		try {
			if (controllerCheckIn.getAusgewählteZimmer().size() != 0) {
				viewMain.smLVFinalRooms.setStyles("{backgroundColor:'#e6eff8'}");
				viewMain.smLVHandedKeys.setStyles("{backgroundColor:'#e6eff8'}");
			}
		} catch (NotContainExeption e) {
			count++;
			LinkedList<String> listmsg = new LinkedList<String>();
			listmsg.add(message);
			ListAdapter<String> list = new ListAdapter<String>(listmsg);
			viewMain.smLVFinalRooms.setListData(list);
			viewMain.smLVFinalRooms.setStyles("{backgroundColor:'#fbe28e'}");
			viewMain.smLVHandedKeys.setListData(list);
			viewMain.smLVHandedKeys.setStyles("{backgroundColor:'#fbe28e'}");
		}
		return count;
	}

	public void createStay() throws java.text.ParseException, FokusException,
			DatabaseException, EmptyParameterException, NotContainExeption,
			InvalidCountryException, WrongParameterException {

		if (controllerCheckIn.getGast() == null) {
			Set<IAdresse> adr = new HashSet<IAdresse>();
			controllerCheckIn.setGast(new Gast("", "", 'm', adr, MyLittleDate
					.getCurrentDate(), "xxxxxx", "xxx", new Kontodaten("xxx",
					"xxx", "xxx", "xxx"), "NoNumber", null));
		}

		controllerCheckIn.setVorname(viewMain.smLBFirstName.getText());
		controllerCheckIn.setNachname(viewMain.smLBLastName.getText());
		controllerCheckIn.setKontodaten(viewMain.smLBAccountNr.getText(),
				viewMain.smLBBankCodeNr.getText(), viewMain.smLBIban.getText(),
				viewMain.smLBBic.getText());
		controllerCheckIn.setTelefonnummer(viewMain.smLBPhone.getText());
		controllerCheckIn.setEmail(viewMain.smLBMail.getText());

		char gender = ' ';
		if (viewMain.smLBGender.getText().equalsIgnoreCase("female")) {
			gender = 'w';
		} else {
			gender = 'm';
		}

		controllerCheckIn.setGeschlecht(gender);

		// String arrival = viewMain.smLBArrival.getText();
		// String departure = viewMain.smLBDeparture.getText();

		java.sql.Date von = MyLittleDate.getDate(
				viewMain.cbArrival.getSelectedDate().year,
				viewMain.cbArrival.getSelectedDate().month,
				viewMain.cbArrival.getSelectedDate().day - 1);
		java.sql.Date bis = MyLittleDate.getDate(
				viewMain.cbDeparture.getSelectedDate().year,
				viewMain.cbDeparture.getSelectedDate().month,
				viewMain.cbDeparture.getSelectedDate().day - 1);
		java.sql.Date birthdate = MyLittleDate.getDate(
				viewMain.cbBirthdate.getSelectedDate().year,
				viewMain.cbBirthdate.getSelectedDate().month,
				viewMain.cbBirthdate.getSelectedDate().day - 1);
		if (birthdate != null) {
			controllerCheckIn.setGeburtsdatum(birthdate);
		}

		String street = viewMain.smLBStreet.getText();
		String zip = viewMain.smLBZip.getText();
		String city = viewMain.smLBCity.getText();
		String countryDescription = viewMain.smLBCountry.getText();

		ILand country = controllerCheckIn
				.getLandByBezeichnung(countryDescription);
		if (country == null) {
			throw new InvalidCountryException();
		}
		if (isNewAdress(street, zip, city, country)) {
			controllerCheckIn
					.addAdresse(new Adresse(street, zip, city, country));
		}

		String pfandNummer = viewMain.smLBDepositNr.getText();
		String pfandTyp = viewMain.smLBDepositType.getText();
		List<IPfandtyp> typs = controllerCheckIn.getPfandtyps();
		IPfandtyp selectedPfandTyp = null;
		for (IPfandtyp typ : typs) {
			if (typ.getBezeichnung().equals(pfandTyp)) {
				selectedPfandTyp = typ;
				break;
			}
		}
		List<IZimmer> rooms = controllerCheckIn.getAusgewählteZimmer();

		for (IZimmer room : rooms) {
			controllerCheckIn.saveAufenthalt(
					controllerCheckIn.getZimmerpreisProKategorie(
							room.getKategorie()).getPreis(), von, bis, true,
					controllerCheckIn.getGast(), room, selectedPfandTyp,
					pfandNummer);
		}
	}

	class CreateAufenthaltListener implements ButtonPressListener {
		public void buttonPressed(Button arg0) {
			try {
				int errors = checkFormOnEmptyFields("MISSING");
				if (errors == 0) {
					createStay();
					resetCheckInForms();
				}
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			} catch (FokusException e) {
			} catch (DatabaseException e) {
				e.printStackTrace();
			} catch (EmptyParameterException e) {
				e.printStackTrace();
			} catch (NotContainExeption e) {
				e.printStackTrace();
			} catch (InvalidCountryException e) {
				e.printStackTrace();
			} catch (WrongParameterException e) {
				e.printStackTrace();
			} catch (SerializationException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isNewAdress(String street, String zip, String city,
			ILand country) throws FokusException, DatabaseException,
			EmptyParameterException, NotContainExeption {

		for (IAdresse adress : controllerCheckIn.getGast().getAdressen()) {
			if (adress.getStrasse().equalsIgnoreCase(street)
					&& adress.getPlz().equalsIgnoreCase(zip)
					&& adress.getOrt().equalsIgnoreCase(city)
					&& adress.getLand().equals(country)) {
				return false;
			}
		}
		return true;
	}
}
