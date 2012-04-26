package projekt.fhv.teama.view;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.collections.adapter.ListAdapter;
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
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListButtonSelectionListener;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.ListViewItemListener;
import org.apache.pivot.wtk.ListViewItemStateListener;
import org.apache.pivot.wtk.ListViewSelectionListener;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.Span;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckIn;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
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

	@Override
	public void buttonPressed(Button arg0) {
		viewMain.reservationForm01.setVisible(false);
		viewMain.checkInForm01.setVisible(true);
		viewMain.progress.setVisible(true);
		viewMain.lvReservationSearch.setEnabled(false);
		try {
			initialize();
		} catch (FokusException e2) {
			e2.printStackTrace();
		} catch (DatabaseException e) {
			e.printStackTrace();
		} catch (NotEnoughRoomsException e) {
			e.printStackTrace();
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

	public void setSelectedGuest(String nummer) throws FokusException {
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
		if (adressen.isEmpty()) {
			viewMain.lbtnAddresses.setButtonData("no adresses found");
		} else {
			Wrapper wrapper = new Wrapper();
			viewMain.lbtnAddresses.setListData(wrapper
					.getAdressListAdapter(adressen));
			viewMain.lbtnAddresses.setSelectedIndex(0);
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
	}

	public CheckInViewController(ViewMain viewMain,
			ControllerCheckIn controllerCheckIn) {
		this.viewMain = viewMain;
		this.controllerCheckIn = controllerCheckIn;
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
				} catch (NotContainExeption e) {
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

	public void initializeSummaryWindow() throws NotContainExeption {
		Wrapper wrapper = new Wrapper();
		viewMain.smLVFinalRooms.setListData(wrapper.getZimmerListAdapter(controllerCheckIn.getAusgewählteZimmer()));
		viewMain.smLVHandedKeys.setListData(wrapper.getKeyListAdapter(controllerCheckIn.getAusgewählteZimmer()));
		
		if (viewMain.rbMale.isSelected()) {
			viewMain.smLBGender.setText("male");
		} else {
			viewMain.smLBGender.setText("female");
		}
		
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
				e.printStackTrace();
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
		// IAdresse curAdress = getSelectedAdress(street, city, zip, country);
		viewMain.tiStreet.setText(street);
		viewMain.tiCity.setText(city);
		viewMain.tiCountry.setText(country);
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
				viewMain.lvAssignedRooms.setItemChecked(i, true);
				selectedRooms.add(wrapper.getZimmer(availableRooms.get(i)));
			}
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
}
