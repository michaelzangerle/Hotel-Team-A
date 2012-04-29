package projekt.fhv.teama.view;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerCheckIn;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.exception.WrongParameterException;
import projekt.fhv.teama.view.support.BlockingDialog;


/**
 * Der CheckInViewController ist für das Eventhandling des Check-In Vorganges zuständig.
 * Hier werden die vom User ausgelösten Interaktionen ermittelt und an den Check-In usecase- Controller weitergeleitet.
 * @author Team A
 * @version 1.0
 */
public class CheckInViewController implements ButtonPressListener {
	private ViewMain viewMain;
	private IControllerCheckIn controllerCheckIn;
	private List<String> selectedRooms;
	private ViewController viewController;

	/**
	 * Startpunkt des Controllers - hier wird der Check-In Vorgang gestartet und die initialize Methode aufgerufen.
	 */
	public void buttonPressed(Button arg0) {
		viewMain.reservationForm01.setVisible(false);
		viewMain.checkInForm01.setVisible(true);
		viewMain.progress.setVisible(true);
		viewMain.tabPLeftMain.setEnabled(false);
		viewMain.lvArrivingSearch.setEnabled(false);
		try {
			initialize();
		} catch (FokusException e) {
			BlockingDialog bd = new BlockingDialog();
			bd.setContent(new Alert(MessageType.WARNING,
					"no reservation selected", new ArrayList<String>("OK")));
			bd.open(viewController.getDisp());
		} catch (DatabaseException e) {
			BlockingDialog bd = new BlockingDialog();
			bd.setContent(new Alert(MessageType.WARNING,
					"no reservation found", new ArrayList<String>("OK")));
		} catch (WrongParameterException e) {
		} catch (NotContainExeption e) {
			e.printStackTrace();
		}
	}

	/**
	 * In der initialize Methode werden die Daten der ausgewählten Reservierung geladen und an der GUI an den entsprechenden Komponenten als Text angezeigt.
	 * Zudem wird die defaultRoomAssignment Methode aufgerufen die den automatischen Zimmerzuteilungsprozess abhandelt.
	 * @throws FokusException
	 * @throws DatabaseException
	 * @throws WrongParameterException
	 * @throws NotContainExeption 
	 */
	private void initialize() throws FokusException, DatabaseException,
			WrongParameterException, NotContainExeption {
		addCheckInEventListener();
		selectedRooms = new LinkedList<String>();
		Wrapper wrapper = new Wrapper();
		controllerCheckIn.initVerfuegbareZimmer();
		List<ITeilreservierung> teilreservierungen = new Vector<ITeilreservierung>(
				controllerCheckIn.getAktuelleReservierung()
						.getTeilreservierungen());
		viewMain.lvBookedRoomCategories.setListData(wrapper
				.getTeilreservierungListAdapter(teilreservierungen));

		Date arrival = controllerCheckIn.getAktuelleReservierung().getVon();
		Date departure = controllerCheckIn.getAktuelleReservierung().getBis();
		CalendarDate d1 = CalendarDate.decode(arrival.toString());
		CalendarDate d2 = CalendarDate.decode(departure.toString());

		viewMain.cbArrival.setSelectedDate(d1);
		viewMain.cbDeparture.setSelectedDate(d2);

		for (ITeilreservierung teilreservierung : teilreservierungen) {
			showSelectedRooms(controllerCheckIn.getVerfügbareZimmerFürGegebeneKategorie(teilreservierung
					.getKategorie()));
		}

		try {
			defaultRoomAssignment();
		} catch (NotEnoughRoomsException e) {
			BlockingDialog bd = new BlockingDialog();
			bd.setContent(new Alert(MessageType.WARNING,
					e.getMessage(), new ArrayList<String>("OK")));
			bd.open(viewController.getDisp());
		}

		viewMain.lvBookedRoomCategories.setSelectedIndex(0);

		IReservierung reservation = controllerCheckIn.getAktuelleReservierung();
		List<IGast> guests = new Vector<IGast>(reservation.getGaeste());

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
		viewMain.meter.setPercentage(0.25);
	}

	/**
	 * Hier werden die Action- Events der Check- In Views initialisiert und den Event- Listener zugewiesen.
	 */
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

	/**
	 * Die setSelectedGuest Methode wird aufgerufen, wenn ein Gast aus der Reservierung ausgewählt wird. Sie initialisiert die Gast Daten der Check-In Form 1.
	 * @param nummer
	 * @throws FokusException
	 * @throws DatabaseException
	 */
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

	/**
	 * Fokus über den ausgewählten Gast wird dem controllerCheckIn übergeben.
	 * @param nummer
	 * @throws FokusException
	 */
	public void setGuestFocus(String nummer) throws FokusException {
		List<IGast> guests = new Vector<IGast>(controllerCheckIn
				.getAktuelleReservierung().getGaeste());
		for (IGast guest : guests) {
			if (guest.getNummer().equals(nummer)) {
				controllerCheckIn.setGast(guest);
			}
		}
	}

	/**
	 * Konstruktor: Instanzen der ViewMain, ControllerCheckIn und ViewController werden dem CheckInViewController zugewiesen.
	 * @param viewMain
	 * @param controllerCheckIn
	 * @param viewController
	 */
	public CheckInViewController(ViewMain viewMain,
			ControllerCheckIn controllerCheckIn, ViewController viewController) {
		this.viewMain = viewMain;
		this.controllerCheckIn = controllerCheckIn;
		this.viewController = viewController;
	}

	/**
	 * Die gotoStep- Action regelt die Steps des Check-In Ablaufes und somit die Sichtbarkeit der einzelnen Check-In Forms.
	 */
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


	/**
	 * Die cancel- Action ruft ein BlockingDialog auf und ist bei einer Bestätigung für einen korrekten Abbruch des aktuellen Fensters zuständig.
	 */
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

	
	
	/**
	 * Bei der resetCheckInForms Methode wird die View auf den Ausgangszustand zurückgesetzt und die Texteingaben aus den TextInputs gelöscht. 
	 * Zudem werden die controllerCheckIn Listen und Fokusse gelöscht und neu initialisiert.
	 * Gesperrte Komponenten werden wieder freigegeben und die initialize View Main Methode wird aufgerufen.
	 */
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

	/**
	 * Hier wird die inc.checkInForm04 Form initialisiert. Bei nicht vorhandenen Einträgen wird der Hintergrund dieser Komponente Gelb hinterlegt. 
	 * @throws DatabaseEntryNotFoundException
	 * @throws FokusException
	 * @throws EmptyParameterException
	 * @throws SerializationException
	 */
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
	
	/**
	 * Bei einer Adressänderung aus der vorhandenen Reservierung werden die Adressdaten in der Check-In View neu gesetzt.
	 * @param street
	 * @param city
	 * @param zip
	 * @param country
	 * @throws FokusException
	 */
	public void setSelectedAdress(String street, String city, String zip,
			String country) throws FokusException {
		viewMain.tiStreet.setText(street);
		viewMain.tiCity.setText(city);
		viewMain.lbtnCountry.setSelectedItem(country);
		viewMain.tiZip.setText(zip);

	}

	/**
	 * liefert eine IAdresse, anhand der übergebenen Parameter.
	 * @param street
	 * @param city
	 * @param zip
	 * @param country
	 * @return IAdresse
	 * @throws FokusException
	 */
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


	/**
	 * Hier werden die verfügbaren Zimmer pro Teilreservierung ermittelt und an den ListViews (Check-In Step2) angezeigt.
	 * @param categoryName
	 * @throws FokusException
	 * @throws DatabaseException
	 * @throws NotContainExeption 
	 */
	public void setSelectedPartialReservation(String categoryName)
			throws FokusException, DatabaseException, NotContainExeption {
		IKategorie category = getCategoryByName(categoryName);
		Wrapper wrapper = new Wrapper();
		List<IZimmer> availableRooms = controllerCheckIn.getVerfügbareZimmerFürGegebeneKategorie(category);
		viewMain.lvAssignedRooms.setListData(wrapper
				.getZimmerListAdapter(availableRooms));
	}

	/**
	 * liefert eine Kategorie anhand der Bezeichnung.
	 * @param categoryName
	 * @return IKategorie
	 * @throws FokusException
	 */
	public IKategorie getCategoryByName(String categoryName)
			throws FokusException {
		ITeilreservierung curTeilreservierung = getSelectedTeilreservierung(categoryName);
		return curTeilreservierung.getKategorie();
	}

	/**
	 * Hier werden automatisch Zimmer für die entspechenden Teilreservierungen/Zimmerkategorien dem Gast zugewiesen. 
	 * Falls nicht genügend freie Zimmer vorhanden sind, wird eine NotEnoughRoomsException geworfen.
	 * @throws NotEnoughRoomsException
	 * @throws DatabaseException
	 * @throws FokusException
	 * @throws WrongParameterException
	 * @throws NotContainExeption
	 */
	public void defaultRoomAssignment() throws NotEnoughRoomsException,
			DatabaseException, FokusException, WrongParameterException, NotContainExeption {
		Wrapper wrapper = new Wrapper();
		StringBuilder message = new StringBuilder();
		
		for (ITeilreservierung teilreservierung : controllerCheckIn
				.getAktuelleReservierung().getTeilreservierungen()) {
			List<IZimmer> availableRooms = controllerCheckIn.getVerfügbareZimmerFürGegebeneKategorie(teilreservierung
					.getKategorie());

			for (int i = 0; i < teilreservierung.getAnzahl(); i++) {
				if (i >= availableRooms.size()) {
					int missingRooms = teilreservierung.getAnzahl() - i;
					message.append("Not enough rooms in category " + teilreservierung.getKategorie().getBezeichnung() + " amount: " + missingRooms + "  ");
					break;
				} else {
					controllerCheckIn.addZimmer(availableRooms.get(i));
					selectedRooms.add(wrapper.getZimmer(availableRooms.get(i)));
				}
			}
		}
		if (!message.toString().equals("")) {
			throw new NotEnoughRoomsException(message.toString());
		}
		try {
			showSelectedRooms(controllerCheckIn.getAusgewählteZimmer());
		} catch (NotContainExeption e) {
			e.printStackTrace();
		}
	}

	/**
	 * getRoomByNumber liefert ein IZimmer anhand der Zimmernummer.
	 * @param roomNumber
	 * @return
	 * @throws DatabaseException
	 * @throws FokusException
	 */
	public IZimmer getRoomByNumber(String roomNumber) throws DatabaseException,
			FokusException {
		List<IZimmer> availableRooms = controllerCheckIn.getVerfügbareZimmer();
		for (IZimmer room : availableRooms) {
			if (room.getNummer().equals(roomNumber)) {
				return room;
			}
		}
		return null;
	}

	/**
	 * Hier wird eine Teilreservierung anhand der Kategoriebezeichnung zurückgegeben.
	 * @param categoryName
	 * @return ITeilreservierung
	 * @throws FokusException
	 */
	public ITeilreservierung getSelectedTeilreservierung(String categoryName)
			throws FokusException {
		List<ITeilreservierung> teilreservierungen = new Vector<ITeilreservierung>(
				controllerCheckIn.getAktuelleReservierung()
						.getTeilreservierungen());
		for (ITeilreservierung teilreservierung : teilreservierungen) {
			if (teilreservierung.getKategorie().getBezeichnung()
					.equalsIgnoreCase(categoryName)) {
				return teilreservierung;
			}
		}
		return null;
	}

	/**
	 * ActionListener für die Zimmerkategorien/Teilreservierungen.
	 */
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
				showSelectedRooms(controllerCheckIn.getVerfügbareZimmerFürGegebeneKategorie(getCategoryByName(categoryName)));
			} catch (DatabaseException e1) {
				e1.printStackTrace();
			} catch (FokusException e1) {
				e1.printStackTrace();
			} catch (NotContainExeption e) {
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

	/**
	 * 	Der RoomChangedListener kontrolliert den Ablauf, wenn ein Zimmer dem Gast hinzugefügt bzw. gelöscht wird.
	 *  Hierfür wird der eingetragene Text anhand der Zimmernummer geparst und das ausgewählte Zimmer dem Check-In Controller zugewiesen.
	 */
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
					} catch (WrongParameterException e) {
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
					} catch (WrongParameterException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Hier wird das zu löschende Zimmer dem usecase Controller übermittelt.
	 * @param room
	 * @throws WrongParameterException
	 */
	public void removeRoom(IZimmer room) throws WrongParameterException {
		controllerCheckIn.remove(room);
	}

	/**
	 * Hier wird das zu hinzufügende Zimmer dem usecase Controller übergeben.
	 * @param room
	 * @throws WrongParameterException
	 */
	public void addRoom(IZimmer room) throws WrongParameterException {
		controllerCheckIn.addZimmer(room);
	}

	/**
	 * ActionListener: Übermittelt alle verügbaren und freien Zimmer.
	 *
	 */
	class ShowAllRoomsListener implements ButtonStateListener {
		public void stateChanged(Button arg0, State arg1) {
			if (arg0.isSelected()) {
				try {
					List<IZimmer> allAvailableRooms = controllerCheckIn.getVerfügbareZimmer();
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
					showSelectedRooms(controllerCheckIn.getVerfügbareZimmerFürGegebeneKategorie(getCategoryByName(categoryName)));
				} catch (DatabaseException e) {
					e.printStackTrace();
				} catch (FokusException e) {
					e.printStackTrace();
				} catch (NotContainExeption e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Ausgewählte Zimmer werden an die GUI übernommen.
	 * @param availableRooms
	 */
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

	/**
	 * Überprüft die Check-In Eingabefelder auf fehlende Parameter und liefert die Fehleranzahl zurück.
	 * @param message
	 * @return int
	 * @throws SerializationException
	 */
	public int checkFormOnEmptyFields(String message)
			throws SerializationException {
		List<Label> components = (List<Label>) viewMain.getAllCheckInLabels();
		int count = 0;

		for (Label comp : components) {
			if (comp.getText().equals(new String())
					|| comp.getText().equals("MISSING!")) {
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
				viewMain.smLVHandedKeys
						.setStyles("{backgroundColor:'#fbe28e'}");
				viewMain.smLVHandedKeys
						.setStyles("{alternateItemBackgroundColor:'#fbe28e'}");
				count++;
			} else {
				viewMain.smLVHandedKeys
						.setStyles("{backgroundColor:'#e6eff8'}");
				viewMain.smLVHandedKeys
						.setStyles("{alternateItemBackgroundColor:'#e6eff8'}");
			}
		}
		try {
			if (controllerCheckIn.getAusgewählteZimmer().size() != 0) {
				viewMain.smLVFinalRooms
						.setStyles("{backgroundColor:'#e6eff8'}");
			}
		} catch (NotContainExeption e) {
			count++;
			LinkedList<String> listmsg = new LinkedList<String>();
			listmsg.add(message);
			ListAdapter<String> list = new ListAdapter<String>(listmsg);
			viewMain.smLVFinalRooms.setListData(list);
			viewMain.smLVFinalRooms.setStyles("{backgroundColor:'#fbe28e'}");
		}
		return count;
	}

	
	/**
	 * Hier werden die benötigten Check-In Informationen ausgelesen, dem ausgewähltem Gast hinzugefügt und bei Vollständigkeit ein neuer Aufenthalt pro ausgewähltes Zimmer erstellt.
	 * @throws java.text.ParseException
	 * @throws FokusException
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 * @throws NotContainExeption
	 * @throws WrongParameterException
	 */
	public void createStay() throws java.text.ParseException, FokusException,
			DatabaseException, EmptyParameterException, NotContainExeption,
			WrongParameterException {

		if (controllerCheckIn.getGast() == null) {
			Set<IAdresse> adr = new HashSet<IAdresse>();
			controllerCheckIn.setGast(new Gast("", "", ' ', adr, MyLittleDate
					.getCurrentDate(), "", "", new Kontodaten("",
					"", "", ""), "", null));
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

	/**
	 * Überprüft, ob sich die Adresse des Gastes geändert hat.
	 * @param street
	 * @param zip
	 * @param city
	 * @param country
	 * @return boolean
	 * @throws FokusException
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 * @throws NotContainExeption
	 */
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
	
	/**
	 * Der GuestChangedListener kontrolliert den Ablauf, wenn ein Gast aus der Reservierung ausgewählt wird.
	 * Hierfür wird der eingetragene Text nach der Gastnummer geparst und die setSelectedGuest Methode aufgerufen.
	 */
	
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
						"no guest selected", new ArrayList<String>("OK")));
			} catch (DatabaseException e) {
				BlockingDialog bd = new BlockingDialog();
				bd.setContent(new Alert(MessageType.WARNING, "no guest found",
						new ArrayList<String>("OK")));
			}
		}
	}

	/**
	 * Der GuestChangedListener kontrolliert den Ablauf, wenn ein Adresse aus der Reservierung ausgewählt wird.
	 * Hierfür wird der eingetragene Text nach der Straße, Ort, PLZ und Land geparst und die setSelectedAdress Methode aufgerufen.
	 *
	 */
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

	
	/**
	 * 	Der GuestChangedListener kontrolliert den Ablauf, wenn der Aufenthalt abgespeichert werden soll.
	 *  Hierfür wird die checkFormOnEmptyFields Methode aufgerufen und bei Vollständigkeit der benötigten Daten die createStay Methode.
	 *  Zudem werden die Einträge der Reservierungsforms gelöscht und die View zurück auf den Ausgangspunkt gestellt.
	 */
	class CreateAufenthaltListener implements ButtonPressListener {
		public void buttonPressed(Button arg0) {
			try {
				int errors = checkFormOnEmptyFields("MISSING!");
				if (errors == 0) {
					createStay();
					viewController.clearReservationPanel();
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
			} catch (WrongParameterException e) {
				e.printStackTrace();
			} catch (SerializationException e) {
				e.printStackTrace();
			}
		}
	}
}
