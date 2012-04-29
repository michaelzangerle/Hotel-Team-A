package projekt.fhv.teama.view;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.LinkedList;
import org.apache.pivot.collections.Map;
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.collections.adapter.ListAdapter;
import org.apache.pivot.util.CalendarDate;
import org.apache.pivot.util.Vote;
import org.apache.pivot.wtk.*;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.controller.exeption.LoginInExeption;
import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckIn;
import projekt.fhv.teama.controller.usecasecontroller.ControllerLogin;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.*;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.view.support.BlockingDialog;



public class ViewController implements Application {
	private ViewLogin viewLogin;
	private ViewMain viewMain;
	private Display disp;
	private ControllerCheckIn controllerCheckIn;
	private Wrapper wrapper;

	@Override
	public void resume() throws Exception {

	}

	@Override
	public boolean shutdown(boolean arg0) throws Exception {
		return false;
	}

	/**
	 * The Application startup method is where to put your code for rendering
	 * UI. The startup method requires the throws Exception to prevent an error
	 * when trying to read to the bxml document. This handles the Serialization
	 * Exception thrown if file not found.
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
		viewMain.setMaximized(true);
		viewLogin.open(getDisp());

		addLoginEventListener();
	}

	@Override
	public void suspend() throws Exception {
	}

	private void addLoginEventListener() {
		viewLogin.setPushBLoginListener(new LoginListener());
	}

	private void addMainEventListener() {
		viewMain.setLvReservationSearchListener(new ReservationListListener());
		viewMain.setlvArrivingSearchListener(new ReservationListListener());
		viewMain.setrf1PBtnCheckInListener(new CheckInViewController(viewMain,
				controllerCheckIn, this));
		viewMain.setlvGuestSearchListener(new GuestListListener());
		viewMain.settabPLeftMainListener(new SearchPanelListener());
	}

	class LoginListener implements ButtonPressListener {
		private ControllerLogin controllerLogin;
		private String username;
		private String password;
		private IMitarbeiter ma;

		@Override
		public void buttonPressed(Button arg0) {
			this.username = viewLogin.getTfUsername().getText();
			this.password = viewLogin.getTfPassword().getText();

			if (username.equals("") || password.equals("")) {

				BlockingDialog bd = new BlockingDialog();
				bd.setContent(new Alert(MessageType.WARNING,
						"Please enter your username and password",
						new ArrayList<String>("OK")));
				bd.open(getDisp());
				return;
			}

			try {
				ma = controllerLogin.checkLogin(username, password);
				startMainView(ma.getVorname(), ma.getNachname());
			} catch (DatabaseException e) {
				BlockingDialog bd = new BlockingDialog();
				bd.setContent(new Alert(MessageType.WARNING,
						"Invalid username or password! Please don´t forget case sensitive",
						new ArrayList<String>("OK")));
				bd.open(getDisp());
			} catch (LoginInExeption e) {
				BlockingDialog bd = new BlockingDialog();
				bd.setContent(new Alert(MessageType.WARNING,
						"Invalid username or password! Please don´t forget case sensitive",
						new ArrayList<String>("OK")));
				bd.open(getDisp());
			}

		}

		public LoginListener() {
			controllerLogin = new ControllerLogin(new ModelMitarbeiter());
		}
	}

	public void startMainView(String vorname, String nachname) {
		viewMain.open(getDisp());
		viewMain.lbLoginName.setText(vorname + " " + nachname);
		wrapper = new Wrapper();
		try {
			initializeMainView();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		addMainEventListener();
	}

	public void initializeMainView() throws DatabaseException {
		if (controllerCheckIn == null) {
			controllerCheckIn = new ControllerCheckIn(new ModelReservierung(),
					new ModelAufenthalt(), new ModelGast(),
					new ModelTeilreservierung(), new ModelKategorie(),
					new ModelKontodaten(), new ModelPfandTyp(),
					new ModelZimmer(), new ModelZimmerstatus(),
					new ModelAdresse(), new ModelLand(),
					new ModelStatusentwicklung());
		}
		viewMain.rf1PBtnCheckIn.setEnabled(true);
		viewMain.tabPLeftMain.setSelectedIndex(1);

		try {
			viewMain.getLvReservationSearch().setListData(
					wrapper.getReservationListAdapter(controllerCheckIn.getAllReservierungen()));
		} catch (DatabaseException e) {
			List<String> list=new Vector<String>();
			list.add("Currently no reservation available");
			viewMain.lvArrivingSearch.setListData(new ListAdapter<String>(list));
		}

		try {
			viewMain.lvGuestSearch.setListData(wrapper.getGuestListAdapter(controllerCheckIn.getGaesteVonAuftenhalt()));
		} catch (DatabaseException e) {
			List<String> list=new Vector<String>();
			list.add("Currently no guests found");
			viewMain.lvArrivingSearch.setListData(new ListAdapter<String>(list));
		}
		
		try {
			if (controllerCheckIn.getCheckInReservierungen().size() == 0) {
				List<String> list=new Vector<String>();
				list.add("Currently no reservation available");
				viewMain.lvArrivingSearch.setListData(new ListAdapter<String>(list));
			} else {
				viewMain.lvArrivingSearch.setListData(wrapper.getReservationListAdapter(controllerCheckIn.getCheckInReservierungen()));
				setSelectedReservation(controllerCheckIn.getCheckInReservierungen().get(0).getID());
				viewMain.lvArrivingSearch.setSelectedIndex(0);
			}
		} catch (DatabaseException e) {
			List<String> list=new Vector<String>();
			list.add("Currently no reservation available");
			viewMain.lvArrivingSearch.setListData(new ListAdapter<String>(list));
		}
	}


	public void setReservationFocus(int ID) throws DatabaseException {
		for (IReservierung reservation : controllerCheckIn.getAllReservierungen()) {
			if (reservation.getID() == ID) {
				controllerCheckIn.setAktuelleReservierung(reservation);
				break;
			}
		}
	}

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

	public Display getDisp() {
		return disp;
	}

	public void setDisp(Display disp) {
		this.disp = disp;
	}
	
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
		viewMain.lvAssignedRooms.setListData(new ListAdapter<String>(emptyString));
	}

	class ReservationListListener implements ListViewSelectionListener {

		@Override
		public void selectedItemChanged(ListView listView, Object arg1) {
			String text = (String) listView.getSelectedItem();
			if(text==null)
				return;
			String[] split = text.split(" ", 3);
			int reservierungsnummer = Integer.valueOf(split[1]);

			try {
				setSelectedReservation(reservierungsnummer);
			} catch (DatabaseException e) {
				List<String> list=new Vector<String>();
				list.add("No reservation available");
				viewMain.lvArrivingSearch.setListData(new ListAdapter<String>(list));
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

	class SearchPanelListener implements TabPaneSelectionListener {
		@Override
		public Vote previewSelectedIndexChange(TabPane arg0, int index) {
			if (arg0 == null) {
				return Vote.DENY;
			}
			Wrapper wrapper = new Wrapper();
			if (index == 0) {
				viewMain.rf1PBtnCheckIn.setEnabled(false);
				clearReservationPanel();
				try {
					if (controllerCheckIn.getAllReservierungen().size() == 0) {
						List<String> list=new Vector<String>();
						list.add("Currently no reservation available");
						viewMain.lvReservationSearch.setListData(new ListAdapter<String>(list));
					} else {
						ListAdapter<String> reservations = wrapper.getReservationListAdapter(controllerCheckIn.getAllReservierungen());
						viewMain.lvReservationSearch.setListData(reservations);
						viewMain.lvReservationSearch.setSelectedIndex(0);
					}
				} catch (DatabaseException e) {
					List<String> list=new Vector<String>();
					list.add("Currently no reservation available");
					viewMain.lvReservationSearch.setListData(new ListAdapter<String>(list));
				}
			} else if(index == 1) {
				viewMain.rf1PBtnCheckIn.setEnabled(true);
				clearReservationPanel();
				try {
					if (controllerCheckIn.getCheckInReservierungen().size() == 0) {
						List<String> list=new Vector<String>();
						list.add("Currently no reservation available");
						viewMain.lvArrivingSearch.setListData(new ListAdapter<String>(list));
						viewMain.rf1PBtnCheckIn.setEnabled(false);
					} else {
						ListAdapter<String> curReservations = wrapper.getReservationListAdapter(controllerCheckIn.getCheckInReservierungen());
						viewMain.lvArrivingSearch.setListData(curReservations);
						viewMain.lvArrivingSearch.setSelectedIndex(0);
					}
				} catch (DatabaseException e) {
					List<String> list=new Vector<String>();
					list.add("Currently no reservation available");
					viewMain.lvArrivingSearch.setListData(new ListAdapter<String>(list));
				}
			} else if (index == 2) {
				viewMain.rf1PBtnCheckIn.setEnabled(false);
				clearReservationPanel();
				try {
					if (controllerCheckIn.getGaesteVonAuftenhalt().size() == 0) {
						List<String> list=new Vector<String>();
						list.add("Currently no guests found");
						viewMain.lvGuestSearch.setListData(new ListAdapter<String>(list));
					} else {
						ListAdapter<String> guests = wrapper.getGuestListAdapter(controllerCheckIn.getGaesteVonAuftenhalt());
						viewMain.lvGuestSearch.setListData(guests);
						viewMain.lvGuestSearch.setSelectedIndex(0);
					}
				} catch (DatabaseException e) {
					List<String> list=new Vector<String>();
					list.add("Currently no guests found");
					viewMain.lvGuestSearch.setListData(new ListAdapter<String>(list));
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

	class GuestListListener implements ListViewSelectionListener {
		@Override
		public void selectedItemChanged(ListView listView, Object arg1) {
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
}