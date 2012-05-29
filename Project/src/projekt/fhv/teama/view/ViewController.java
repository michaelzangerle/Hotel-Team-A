package projekt.fhv.teama.view;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.Map;
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.collections.adapter.ListAdapter;
import org.apache.pivot.util.CalendarDate;
import org.apache.pivot.util.Vote;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ComponentKeyListener;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Keyboard;
import org.apache.pivot.wtk.Keyboard.KeyLocation;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.ListViewSelectionListener;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.Span;
import org.apache.pivot.wtk.TabPane;
import org.apache.pivot.wtk.TabPaneSelectionListener;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.TextInputContentListener;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.controller.exeption.LoginInExeption;
import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckIn;
import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckOut;
import projekt.fhv.teama.controller.usecasecontroller.ControllerLogin;
import projekt.fhv.teama.controller.usecasecontroller.ControllerZusatzleistungBuchen;
import projekt.fhv.teama.controller.usecasecontroller.LeistungAnzahl;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAAdresse;
import projekt.fhv.teama.integrate.IAAufenthalt;
import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.model.ModelAdresse;
import projekt.fhv.teama.model.ModelAufenthalt;
import projekt.fhv.teama.model.ModelGast;
import projekt.fhv.teama.model.ModelKategorie;
import projekt.fhv.teama.model.ModelKontodaten;
import projekt.fhv.teama.model.ModelLand;
import projekt.fhv.teama.model.ModelMitarbeiter;
import projekt.fhv.teama.model.ModelPfandTyp;
import projekt.fhv.teama.model.ModelReservierung;
import projekt.fhv.teama.model.ModelStatusentwicklung;
import projekt.fhv.teama.model.ModelTeilreservierung;
import projekt.fhv.teama.model.ModelZimmer;
import projekt.fhv.teama.model.ModelZimmerstatus;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.view.support.BlockingDialog;
import roomanizer.teamb.business.BusinessFactory;
import roomanizer.teamb.presentation.forms.invoice.InvoiceStep1;
import roomanizer.teamb.service.integrate.IBGast;
import roomanizer.teamb.service.integrate.IBKonsument;

/**
 * Der ViewController handelt die Events des Homescreens (ViewMain) ab.
 * 
 * @author Team A
 * @version 1.0
 */
public class ViewController implements Application {
	private ViewLogin viewLogin;
	private ViewMain viewMain;
	private ViewAdditionalServices bdViewAdditionalServices;
	private ViewCurrentGuest bdViewCurrentGuest;
	private ViewCheckOut bdViewCheckOut;
	private ControllerCheckIn controllerCheckIn;
	private ControllerZusatzleistungBuchen controllerZusatzleistung;
	private ControllerCheckOut controllerCheckOut;
	private CheckOutViewController checkOutViewController;
	private Wrapper wrapper;
	private Display disp;
	private ListAdapter<String> cacheListData;

	@Override
	public void resume() throws Exception {

	}

	@Override
	public boolean shutdown(boolean arg0) throws Exception {
		return false;
	}

	/**
	 * Die Startup Methode stellt den Einstiegspunkt eines Apache Pivot
	 * Projektes da. Hier werden die bxml files serialisiert und eingelesen.
	 * Zudem wird die Methode addLoginEvents aufgerufen.
	 */
	@Override
	public void startup(Display display, Map<String, String> properties)
			throws Exception {

		BXMLSerializer bS = new BXMLSerializer();
		setDisp(display);

		viewLogin = (ViewLogin) bS.readObject(getClass().getResource(
				"ViewLogin.bxml"));
		viewMain = (ViewMain) bS.readObject(getClass().getResource(
				"ViewMain.bxml"));

		bdViewAdditionalServices = (ViewAdditionalServices) bS.readObject(
				ViewAdditionalServices.class, "ViewAdditionalServices.bxml");

		bdViewCurrentGuest = (ViewCurrentGuest) bS.readObject(
				ViewAdditionalServices.class, "ViewCurrentGuest.bxml");

		bdViewCheckOut = (ViewCheckOut) bS.readObject(
				ViewAdditionalServices.class, "ViewCheckOut.bxml");

		viewMain.setMaximized(true);
		viewLogin.open(getDisp());
		viewLogin.requestFocus();
		addLoginEventListener();
	}

	@Override
	public void suspend() throws Exception {
	}

	public ControllerZusatzleistungBuchen getControllerZusatzLeistungBuchen () {
		return controllerZusatzleistung;
	}
	
	
	/**
	 * Hier werden die Action- Events des Login Screens initialisiert und den
	 * Event- Listener zugewiesen.
	 */
	private void addLoginEventListener() {
		viewLogin.setPushBLoginListener(new ButtonPressListener() {
			public void buttonPressed(Button arg0) {
				login();
			}
		});
		viewLogin.getComponentKeyListeners().add(new ComponentKeyListener() {
			public boolean keyPressed(Component arg0, int arg1, KeyLocation arg2) {
				if (arg1 == Keyboard.KeyCode.ENTER) {
					login();
				}
				return false;
			}
			public boolean keyReleased(Component arg0, int arg1,
					KeyLocation arg2) {
				return false;
			}
			public boolean keyTyped(Component arg0, char arg1) {
				return false;
			}
		});
	}

	/**
	 * Hier werden die Action- Events der Main View initialisiert und den Event-
	 * Listener zugewiesen.
	 */
	private void addMainEventListener() {
		viewMain.setLvReservationSearchListener(new ReservationListListener());
		viewMain.setlvArrivingSearchListener(new ReservationListListener());
		viewMain.setrf1PBtnCheckInListener(new CheckInViewController(viewMain,
				controllerCheckIn, this));
		viewMain.settabPLeftMainListener(new SearchPanelListener());
		viewMain.setlvGuestSearchListener(new GuestListListener());
		viewMain.tiReservationSearch.getTextInputContentListeners().add(
				new TextInputContentListener.Adapter() {
					public void textRemoved(TextInput textInput, int arg1,
							int arg2) {
						String text = textInput.getText();

						if (text.length() == 0) {
							viewMain.lvReservationSearch
									.setListData(cacheListData);
							cacheListData = null;
							viewMain.lvReservationSearch.setSelectedIndex(0);
						} else {
							searchPanelInput(text, viewMain.lvReservationSearch);
						}
					}
					public void textInserted(TextInput textInput, int arg1,
							int arg2) {
						String text = textInput.getText();
						searchPanelInput(text, viewMain.lvReservationSearch);
					}
				});

		viewMain.tiArrivingSearch.getTextInputContentListeners().add(
				new TextInputContentListener.Adapter() {
					public void textRemoved(TextInput textInput, int arg1, int arg2) {
						String text = textInput.getText();

						if (text.length() == 0) {
							viewMain.lvArrivingSearch
									.setListData(cacheListData);
							cacheListData = null;
							viewMain.lvArrivingSearch.setSelectedIndex(0);
						} else {
							searchPanelInput(text, viewMain.lvArrivingSearch);
						}
					}
					public void textInserted(TextInput textInput, int arg1,
							int arg2) {
						String text = textInput.getText();
						searchPanelInput(text, viewMain.lvArrivingSearch);
					}
				});

		viewMain.tiGuestSearch.getTextInputContentListeners().add(
				new TextInputContentListener.Adapter() {
					public void textRemoved(TextInput textInput, int arg1, int arg2) {
						String text = textInput.getText();

						if (text.length() == 0) {
							viewMain.lvGuestSearch
									.setListData(cacheListData);
							cacheListData = null;
							viewMain.lvGuestSearch.setSelectedIndex(0);
						} else {
							searchPanelInput(text, viewMain.lvGuestSearch);
						}
					}
					public void textInserted(TextInput textInput, int arg1,
							int arg2) {
						String text = textInput.getText();
						searchPanelInput(text, viewMain.lvGuestSearch);
					}
				});

		bdViewCurrentGuest
				.setcgf1PBtnBookExtrasListener(new BookExtrasViewController(
						bdViewAdditionalServices, viewMain, bdViewCurrentGuest,
						controllerZusatzleistung));
		
		bdViewCurrentGuest
				.setcgf1PBtnCheckOutListener(new ButtonPressListener(){
					public void buttonPressed(Button arg0) {
						if (!checkOutViewController.load()){
							showBlockingDialog("Invalid guest selected", getDisp());
						}
					}
				});
		bdViewCheckOut.setcof1PBtnCreateInvoiceListener(new ButtonPressListener() {
					public void buttonPressed(Button arg0) {
						startInvoiceWindow();
					}
				});
	}

	/**
	 * Hier werden die vorhandenen Reservierungen bzw. Gäste anhand von dem übergebenen String gesucht.
	 * Es kann dabei nach Nummer der Reservierung / des Gastes und Name des Gastes gesucht werden.
	 * @param text
	 * @param lv
	 */
	@SuppressWarnings("unchecked")
	private void searchPanelInput(String text, ListView lv) {
		if (cacheListData == null) {
			cacheListData = (ListAdapter<String>) lv.getListData();
		}
		List<String> suggestions = new LinkedList<String>();
		List<String> list = cacheListData.getList();
		for (String temp : list) {
			if (temp.toUpperCase().contains(text.toUpperCase())) { 
				suggestions.add(temp);
			}
		}
		if (suggestions.isEmpty()) {
			int i = viewMain.tabPLeftMain.getSelectedIndex();
			switch (i) {
				case 0 :
					setListData(lv, "no reservation found");
					break;
				case 1 :
					setListData(lv, "no reservation found");
					break;
				case 2 :
					setListData(lv, "no guest found");
					break;
			}
		} else {
			ListAdapter<String> adapter = new ListAdapter<String>(suggestions);
			lv.setListData(adapter);
			lv.setSelectedIndex(0);
		}
	}

	/**
	 * setzt in der übergebenen ListView einen beliebigen Text.
	 * @param view
	 * @param text
	 */
	private void setListData(ListView view, String text) {
		List<String> temp = new LinkedList<String>();
		temp.add(text);
		ListAdapter<String> adapter = new ListAdapter<String>(temp);
		view.setListData(adapter);
	}

	/**
	 * Hier wird ein neues Swing Fenster für den Rechnungserstellen Usecase der
	 * Gruppe B aufgerufen.
	 */
	public void startInvoiceWindow() {
		IBGast gast;
		try {
			gast = (IBGast) controllerCheckOut.getGast();

			IBKonsument konsument = (IBKonsument) gast;
			
			new InvoiceStep1(null, BusinessFactory.newInvoiceController(
					konsument, gast)).showForm();
		} catch (FokusException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Die Login Methode handelt den Login- Vorgang ab. Username und Passwort
	 * werden auf Fehleingaben überprüft und dem controllerLogin weitergegeben.
	 * Falls ein falscher Username bzw. ein falsches Passwort eingegeben wurde,
	 * wird eine entprechende Fehlermeldung angezeigt.
	 */
	public void login() {
		String username = viewLogin.getTfUsername().getText();
		String password = viewLogin.getTfPassword().getText();
		ControllerLogin controllerLogin = new ControllerLogin(
				new ModelMitarbeiter());

		if (username.equals("") || password.equals("")) {
			showBlockingDialog("Please enter your username and password", getDisp());
			return;
		}

		try {
			IMitarbeiter ma = controllerLogin.checkLogin(username, password);
			startMainView(ma.getVorname(), ma.getNachname());
		} catch (DatabaseException e) {
			showBlockingDialog("Invalid username or password! Please keep case sensitive in mind", getDisp());
		} catch (LoginInExeption e) {
			showBlockingDialog("Invalid username or password! Please keep case sensitive in mind", getDisp());
		}
	}

	/**
	 * Bei korrekter Eingabe der LoginDaten wird die mainView angezeigt und die
	 * initialize und add Eventlistener Methoden aufgerufen.
	 * 
	 * @param vorname
	 * @param nachname
	 */
	public void startMainView(String vorname, String nachname) {
		viewMain.open(getDisp());
		viewMain.lbLoginName.setText(vorname + " " + nachname);
		wrapper = new Wrapper();
		viewMain.mainContent.add(bdViewAdditionalServices);
		viewMain.mainContent.add(bdViewCurrentGuest);
		viewMain.mainContent.add(bdViewCheckOut);
		controllerCheckOut = new ControllerCheckOut();
		checkOutViewController = new CheckOutViewController(bdViewCheckOut, viewMain, bdViewCurrentGuest, controllerCheckOut, this);
		initializeMainView();
		addMainEventListener();
	}

	/**
	 * Initialisierung der Suchlisten: Reservierungs-, Arriving- und
	 * Gastsuchliste
	 * 
	 * @throws DatabaseException
	 */
	public void initializeMainView() {
		
		if (controllerCheckIn == null) {
			controllerCheckIn = new ControllerCheckIn(new ModelReservierung(),
					new ModelAufenthalt(), new ModelGast(),
					new ModelTeilreservierung(), new ModelKategorie(),
					new ModelKontodaten(), new ModelPfandTyp(),
					new ModelZimmer(), new ModelZimmerstatus(),
					new ModelAdresse(), new ModelLand(),
					new ModelStatusentwicklung());
		}
		if (controllerZusatzleistung == null) {
			controllerZusatzleistung = new ControllerZusatzleistungBuchen();
		}
		viewMain.rf1PBtnCheckIn.setEnabled(true);
		viewMain.tabPLeftMain.setEnabled(true);
		viewMain.tabPLeftMain.setSelectedIndex(1);
		viewMain.lvArrivingSearch.setEnabled(true);
		viewMain.lvReservationSearch.setEnabled(true);
		viewMain.lvGuestSearch.setEnabled(true);

		try {
			viewMain.getLvReservationSearch().setListData(
					wrapper.getReservationListAdapter(controllerCheckIn
							.getAllReservierungen()));
		} catch (DatabaseException e) {
			setListData(viewMain.lvReservationSearch, "Currently no reservations");
		}

		try {
			viewMain.lvGuestSearch.setListData(wrapper
					.getGuestListAdapter(controllerCheckIn
							.getGaesteVonAuftenhalt()));
		} catch (DatabaseException e) {
			setListData(viewMain.lvGuestSearch, "Currently no guests");
		}

		try {
			if (controllerCheckIn.getCheckInReservierungen().size() == 0) {
				setListData(viewMain.lvArrivingSearch, "Currently no reservations");
			} else {
				viewMain.lvArrivingSearch.setListData(wrapper
						.getReservationListAdapter(controllerCheckIn
								.getCheckInReservierungen()));
				setSelectedReservation(controllerCheckIn
						.getCheckInReservierungen().get(0).getID());
				viewMain.lvArrivingSearch.setSelectedIndex(0);
			}
		} catch (DatabaseException e) {
			setListData(viewMain.lvArrivingSearch, "Currently no reservations available");
		}
	}

	/**
	 * Fokus einer ausgewählten Reservierung wird dem controllerCheckIn
	 * übergeben.
	 * 
	 * @param ID
	 * @throws DatabaseException
	 */
	public void setReservationFocus(int ID) throws DatabaseException {
		for (IReservierung reservation : controllerCheckIn
				.getAllReservierungen()) {
			if (reservation.getID() == ID) {
				controllerCheckIn.setAktuelleReservierung(reservation);
				break;
			}
		}
	}

	/**
	 * Reservierungsdaten, der ausgewählten Reservierung, werden in die
	 * entsprechende Form (inc.reservationForm01) gesetzt.
	 * 
	 * @param reservierungsnummer
	 * @throws DatabaseException
	 */
	public void setSelectedReservation(int reservierungsnummer)
			throws DatabaseException {
		setReservationFocus(reservierungsnummer);
		IReservierung curReservation = null;
		try {
			curReservation = controllerCheckIn.getAktuelleReservierung();
		} catch (FokusException e) {

		}
		viewMain.rf1LBResNr.setText(String.valueOf(curReservation.getID()));
		viewMain.rf1TIName.setText(curReservation.getPerson().getNachname()
				.toUpperCase()
				+ " " + curReservation.getPerson().getVorname());
		viewMain.rf1TIEMail.setText(curReservation.getPerson().getEmail());
		viewMain.rf1TIPhone.setText(curReservation.getPerson()
				.getTelefonnummer());

		List<IAdresse> adressen = new Vector<IAdresse>(curReservation
				.getPerson().getAdressen());

		if (!adressen.equals(null)) {
			IAdresse adresse = adressen.get(0);
			viewMain.rf1TIStreet.setText(adresse.getStrasse());
			viewMain.rf1TICountry.setText(adresse.getLand().getBezeichnung());
			viewMain.rfTICity.setText(adresse.getOrt());
			viewMain.rfTIZip.setText(adresse.getPlz());
		}

		Date arrival = curReservation.getVon();
		Date departure = curReservation.getBis();

		CalendarDate d1 = CalendarDate.decode(arrival.toString());
		CalendarDate d2 = CalendarDate.decode(departure.toString());

		viewMain.rf1CBArrival.setSelectedDate(d1);
		viewMain.rf1CBDeparture.setSelectedDate(d2);
	}

	/**
	 * gibt den Display Parameter der ViewMain zurück.
	 */
	public Display getDisp() {
		return disp;
	}

	/**
	 * setzt den Display Parameter der ViewMain.
	 * 
	 * @param disp
	 */
	public void setDisp(Display disp) {
		this.disp = disp;
	}

	/**
	 * Löscht die vorhandenen Daten einer Reservierung in der ReservierungsForm.
	 */
	public void clearReservationPanel() {
		viewMain.rf1LBResNr.setText("");
		viewMain.rf1TIEMail.setText("");
		viewMain.rf1TIName.setText("");
		viewMain.rf1TIPhone.setText("");
		viewMain.rf1TIStreet.setText("");
		viewMain.rf1TICountry.setText("");
		viewMain.rfTIZip.setText("");
		viewMain.rfTICity.setText("");
		List<String> emptyString = new Vector<String>();
		emptyString.add("");
		viewMain.lvAssignedRooms.setListData(new ListAdapter<String>(
				emptyString));
	}

	/**
	 * Der Reservation- Listener kontrolliert den Ablauf, wenn eine Reservierung
	 * im Suchpanel ausgewählt wurde. Hierfür wird die Reservierungsnummer aus
	 * dem gesetzten Text geparst und die stSelectedReservation Methode
	 * aufgerufen.
	 */
	class ReservationListListener implements ListViewSelectionListener {
		@Override
		public void selectedItemChanged(ListView listView, Object arg1) {
			String text = (String) listView.getSelectedItem();
			if (text == null || text.contains("no reservation"))
				return;

			String[] split = text.split(" ", 3);
			int reservierungsnummer = Integer.valueOf(split[1]);

			try {
				setSelectedReservation(reservierungsnummer);
			} catch (DatabaseException e) {
				setListData(viewMain.lvArrivingSearch, "Currently no reservation available");
			}
		}
		@Override
		public void selectedRangeAdded(ListView listView, int arg1, int arg2) {
		}

		@Override
		public void selectedRangeRemoved(ListView listView, int arg1, int arg2) {
		}

		@Override
		public void selectedRangesChanged(ListView listView, Sequence<Span> arg1) {
		}
	}

	
	/**
	 * Gastdaten, des ausgewählten Gastes, werden in die
	 * entsprechende Form (inc.currentGuestForm01) gesetzt.
	 * @param gastNummer
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 * @throws NotContainExeption
	 * @throws FokusException
	 */
	public void setSelectedGuest(String gastNummer) throws DatabaseException,
			EmptyParameterException, NotContainExeption, FokusException {
		if (controllerZusatzleistung == null) {
			controllerZusatzleistung = new ControllerZusatzleistungBuchen();
		}
		IAGast curGast = controllerZusatzleistung.getGastByNummer(gastNummer);
		controllerZusatzleistung.setGast(curGast);
		controllerCheckOut.setGast(curGast);
		bdViewCurrentGuest.cgf1LBGuestNr.setText(curGast.getNummer());
		bdViewCurrentGuest.cgf1TIEMail.setText(curGast.getEmail());
		bdViewCurrentGuest.cgf1TIName.setText(curGast.getVorname() + " "
				+ curGast.getNachname().toUpperCase());
		bdViewCurrentGuest.cgf1TIPhone.setText(curGast.getTelefonnummer());
		List<IAAdresse> adressen = new Vector<IAAdresse>(curGast.getAAdressen());

		if (!adressen.equals(null)) {
			IAAdresse adresse = adressen.get(0);
			bdViewCurrentGuest.cgf1TICity.setText(adresse.getOrt());
			bdViewCurrentGuest.cgf1TICountry.setText(adresse.getLand()
					.getBezeichnung());
			bdViewCurrentGuest.cgf1TIStreet.setText(adresse.getStrasse());
			bdViewCurrentGuest.cgf1TIZip.setText(adresse.getPlz());
		}
		List<IAAufenthalt> aufenthalte = controllerZusatzleistung
				.getAufenthalte();
		IAAufenthalt aufenthalt = aufenthalte.get(0);

		Date arrival = aufenthalt.getAVon();
		Date departure = aufenthalt.getABis();

		CalendarDate d1 = CalendarDate.decode(arrival.toString());
		CalendarDate d2 = CalendarDate.decode(departure.toString());

		bdViewCurrentGuest.cgf1CBArrival.setSelectedDate(d1);
		bdViewCurrentGuest.cgf1CBDeparture.setSelectedDate(d2);

		try {
			List<LeistungAnzahl> services = controllerZusatzleistung
					.bereitsgebuchtLeistungenFuerGast();
			HashMap<String, Integer> tempMap = new HashMap<String, Integer>();
			for (LeistungAnzahl temp : services) {
				if (temp != null) {
					int menge = temp.getAnzahl();
					if (tempMap
							.containsKey(temp.getLeistung().getBezeichnung())) {
						menge = tempMap
								.get(temp.getLeistung().getBezeichnung())
								+ temp.getAnzahl();
					}
					tempMap.put(temp.getLeistung().getBezeichnung(), menge);
				}
			}
			bdViewCurrentGuest.cgf1LVBookedAdditionalServices
					.setListData(wrapper.getZusatzleistungListAdapter(tempMap));
		} catch (DatabaseException e) {
			setListData(bdViewCurrentGuest.cgf1LVBookedAdditionalServices, "Currently no additional service booked");
		}
	}

	/**
	 * Der Guestlist- Listener kontrolliert den Ablauf, wenn ein Gast
	 * im Suchpanel ausgewählt wurde. Hierfür wird die Gastnummer aus
	 * dem gesetzten Text geparst und die setSelectedGuest Methode
	 * aufgerufen.
	 */
	class GuestListListener implements ListViewSelectionListener {

		@Override
		public void selectedItemChanged(ListView listView, Object arg1) {
			String text = (String) listView.getSelectedItem();
			if (text == null || text.equals("Currently no guests"))
				return;

			String[] split = text.split(" ");
			try {
				setSelectedGuest(split[1]);
			} catch (DatabaseException e) {
			} catch (EmptyParameterException e) {
				e.printStackTrace();
			} catch (NotContainExeption e) {
				showBlockingDialog("Invalid guest selected", getDisp());
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

	/**
	 * Der SearchPanel- Listener kontrolliert den Ablauf, wenn ein Tab im linken
	 * Suchfeld ausgewählt wird. Hierfür werden der benötigte ListAdapter
	 * geladen.
	 */
	class SearchPanelListener implements TabPaneSelectionListener {
		@Override
		public Vote previewSelectedIndexChange(TabPane arg0, int index) {
			clearReservationPanel();
			Wrapper wrapper = new Wrapper();
			if (index == 0) {
				viewMain.reservationForm01.setVisible(true);
				bdViewCurrentGuest.setVisible(false);
				viewMain.rf1PBtnCheckIn.setEnabled(false);
				cacheListData = null;
				try {
					if (controllerCheckIn.getAllReservierungen().size() == 0) {
						setListData(viewMain.lvReservationSearch, "Currently no reservation available");
					} else {
						ListAdapter<String> reservations = wrapper
								.getReservationListAdapter(controllerCheckIn
										.getAllReservierungen());
						viewMain.lvReservationSearch.setListData(reservations);
						viewMain.lvReservationSearch.setSelectedIndex(0);
					}
				} catch (DatabaseException e) {
					setListData(viewMain.lvReservationSearch, "Currently no reservation available");
				}
			} else if (index == 1) {
				viewMain.reservationForm01.setVisible(true);
				bdViewCurrentGuest.setVisible(false);
				viewMain.rf1PBtnCheckIn.setEnabled(true);
				cacheListData = null;
				try {
					if (controllerCheckIn.getCheckInReservierungen().size() == 0) {
						setListData(viewMain.lvArrivingSearch, "Currently no reservation available");
						viewMain.rf1PBtnCheckIn.setEnabled(false);
						viewMain.lvArrivingSearch.setEnabled(false);
					} else {
						viewMain.rf1PBtnCheckIn.setEnabled(true);
						viewMain.lvArrivingSearch.setEnabled(true);
						ListAdapter<String> curReservations = wrapper
								.getReservationListAdapter(controllerCheckIn
										.getCheckInReservierungen());
						viewMain.lvArrivingSearch.setListData(curReservations);
						viewMain.lvArrivingSearch.setSelectedIndex(0);
					}
				} catch (DatabaseException e) {
					setListData(viewMain.lvReservationSearch, "Currently no reservation available");
				}
			} else if (index == 2) {
				viewMain.reservationForm01.setVisible(false);
				bdViewCurrentGuest.setVisible(true);
				viewMain.rf1PBtnCheckIn.setEnabled(false);
				cacheListData = null;
				try {
					if (controllerCheckIn.getGaesteVonAuftenhalt().size() == 0) {
						setListData(viewMain.lvGuestSearch, "Currently no guests");
						viewMain.lvGuestSearch.setEnabled(false);
						bdViewCurrentGuest.cgf1PBtnCheckOut.setEnabled(false);
						bdViewCurrentGuest.cgf1PBtnBookExtras.setEnabled(false);
					} else {
						bdViewCurrentGuest.cgf1PBtnCheckOut.setEnabled(true);
						bdViewCurrentGuest.cgf1PBtnBookExtras.setEnabled(true);
						viewMain.lvGuestSearch.setEnabled(true);
						ListAdapter<String> guests = wrapper
								.getGuestListAdapter(controllerCheckIn
										.getGaesteVonAuftenhalt());
						viewMain.lvGuestSearch.setListData(guests);
						viewMain.lvGuestSearch.setSelectedIndex(0);
					}
				} catch (DatabaseException e) {
					setListData(viewMain.lvReservationSearch, "Currently no guests");
				}
			}
			return Vote.APPROVE;
		}

		@Override
		public void selectedIndexChangeVetoed(TabPane arg0, Vote arg1) {
		}

		@Override
		public void selectedIndexChanged(TabPane arg0, int arg1) {
		}

	}
	
	public void setReloadAufenthalte(boolean needReload) {
		controllerCheckIn.setNeedReloadAufenthalt(needReload);
	}


	public void showBlockingDialog(String message, Display disp) {
		BlockingDialog bd = new BlockingDialog();
		bd.setContent(new Alert(MessageType.WARNING,
				message,
				new ArrayList<String>("OK")));
		Dialog erg = bd.open(disp);
		
		int i = ((Alert) erg).getSelectedOptionIndex();
		if (erg.getResult()) {
			erg.close();
		}
	}

}