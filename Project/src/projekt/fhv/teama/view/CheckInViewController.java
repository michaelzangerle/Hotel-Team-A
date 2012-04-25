package projekt.fhv.teama.view;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.util.CalendarDate;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ComponentMouseButtonListener;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListButtonSelectionListener;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.ListViewSelectionListener;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.Span;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckIn;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.view.support.BlockingDialog;

public class CheckInViewController implements ButtonPressListener {
	private ViewMain viewMain;
	private ControllerCheckIn controllerCheckIn;
	private List<IGast> guests;
	private List<ITeilreservierung> teilreservierungen;
	private Wrapper wrapper;
	private List<IZimmer> selectedRooms;
	private List<IZimmer> availableRooms;
	
	
	@Override
	public void buttonPressed(Button arg0) {
		viewMain.reservationForm01.setVisible(false);
		viewMain.checkInForm01.setVisible(true);
		viewMain.progress.setVisible(true);
		viewMain.lvReservationSearch.setEnabled(false);
		initializeStep1();
	}

	private void initializeStep1() {
		addCheckInEventListener();
		IReservierung reservation = null;
		wrapper = new Wrapper();
		selectedRooms = new LinkedList<IZimmer>();
		try {
			reservation = controllerCheckIn.getAktuelleReservierung();
			guests = new Vector<IGast>(reservation.getGaeste());
			viewMain.lbtnGuests.setListData(wrapper.getGuestListAdapter(guests));
			
			String nummer = guests.get(0).getNummer();
			//setSelectedGuest(nummer);
		} catch (FokusException e) {
			e.printStackTrace();
		}
	}
	
	private void initializeStep2() {
		try {
			teilreservierungen = new Vector<>(controllerCheckIn.getAktuelleReservierung().getTeilreservierungen());
			viewMain.lvBookedRoomCategories.setListData(wrapper.getTeilreservierungListAdapter(teilreservierungen));
			
		} catch (FokusException e) {
			e.printStackTrace();
		}
	}

	private void initializeStep3() {
		
	}
	
	private void initializeStep4() {
		
	}
	
	public void setSelectedGuest(String nummer) throws FokusException {
		setGuestFocus(nummer);
		IGast curGuest = controllerCheckIn.getGast();
		viewMain.tiFirstName.setText(curGuest.getVorname());
		viewMain.tiLastName.setText(curGuest.getNachname());

		if(curGuest.getGeburtsdatum() != null) {
			Date birthday = curGuest.getGeburtsdatum();
			CalendarDate d1 = CalendarDate.decode(birthday.toString());
			//viewMain.cbBirthdate.setSelectedDate(d1); nullpointer!!wieso??
		}

		if (curGuest.getGeschlecht() == 'F') {
			viewMain.rbMale.setSelected(false);
			viewMain.rbFemale.setSelected(true);
		} else {
			viewMain.rbMale.setSelected(true);
			viewMain.rbFemale.setSelected(false);
		}
		
		List<IAdresse> adressen = new Vector<>(curGuest.getAdressen());
		if (adressen.isEmpty()) {
			viewMain.lbtnAddresses.setListData("no adresses found");
		} else {
			viewMain.lbtnAddresses.setListData(wrapper.getAdressListAdapter(adressen));
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
	}
	

	public CheckInViewController(ViewMain viewMain,
			ControllerCheckIn controllerCheckIn) {
		this.viewMain = viewMain;
		this.controllerCheckIn = controllerCheckIn;
	}

	Action gotoStep = new Action(true) {
		@Override
		public void perform(Component source) {
			if (source.getName().equals("lbProgress01") || source.getName().equals("cf2PBtnBack")) {
				viewMain.meter.setPercentage(0.25);
				viewMain.checkInForm01.setVisible(true);
				viewMain.checkInForm02.setVisible(false);
				viewMain.checkInForm03.setVisible(false);
				viewMain.checkInForm04.setVisible(false);
				initializeStep1();
			}

			if (source.getName().equals("lbProgress02") || source.getName().equals("cf1PBtnNext") || source.getName().equals("cf3PBtnBack")) {
				viewMain.meter.setPercentage(0.50);
				viewMain.checkInForm01.setVisible(false);
				viewMain.checkInForm02.setVisible(true);
				viewMain.checkInForm03.setVisible(false);
				viewMain.checkInForm04.setVisible(false);
				initializeStep2();
			}

			if (source.getName().equals("lbProgress03") || source.getName().equals("cf2PBtnNext")|| source.getName().equals("cf4PBtnBack")) {
				viewMain.meter.setPercentage(0.75);
				viewMain.checkInForm01.setVisible(false);
				viewMain.checkInForm02.setVisible(false);
				viewMain.checkInForm03.setVisible(true);
				viewMain.checkInForm04.setVisible(false);
				initializeStep3();
			}

			if (source.getName().equals("lbProgress04") || source.getName().equals("cf3PBtnNext")) {
				viewMain.meter.setPercentage(1);
				viewMain.checkInForm01.setVisible(false);
				viewMain.checkInForm02.setVisible(false);
				viewMain.checkInForm03.setVisible(false);
				viewMain.checkInForm04.setVisible(true);
				initializeStep4();
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

	
	class GuestChangedListener implements ListButtonSelectionListener {

		@Override
		public void selectedIndexChanged(ListButton listButton, int arg1) {

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
	
	public void setSelectedAdress(String street, String city, String zip, String country) throws FokusException {
		setAdressFocus(street, city, zip, country);
//		IAdresse curAdress = getSelectedAdress(street, city, zip, country);
		viewMain.tiStreet.setText(street);
		viewMain.tiCity.setText(city);
		viewMain.tiCountry.setText(country);
		viewMain.tiZip.setText(zip);
	}
	
	public IAdresse getSelectedAdress (String street, String city, String zip, String country) throws FokusException{
		List<IAdresse> adressen = new Vector<IAdresse>(controllerCheckIn.getGast().getAdressen());
		
		for (IAdresse adresse : adressen) {
			if (adresse.getStrasse().equalsIgnoreCase(street) && adresse.getOrt().equalsIgnoreCase(city)  && adresse.getPlz().equalsIgnoreCase(zip) && adresse.getLand().getBezeichnung().equalsIgnoreCase(country)){
				return adresse;
			}
		}
		return null;
	}
	
	public void setAdressFocus(String street, String city, String zip, String country) throws FokusException{
		List<IAdresse> adressen = new Vector<IAdresse>(controllerCheckIn.getGast().getAdressen());
		
		for (IAdresse adresse : adressen) {
			if (adresse.getStrasse() == street && adresse.getOrt() == city && adresse.getPlz() == zip && adresse.getLand().getBezeichnung() == country){
				//TODO Adresse im checkin controller weglassen?
			}
		}
	}

	public void setSelectedPartialReservation(String categoryName) {
		ITeilreservierung curTeilreservierung = getSelectedTeilreservierung(categoryName);
		IKategorie category = curTeilreservierung.getKategorie();

		try {
			availableRooms = controllerCheckIn.getVerfügbareZimmerFürGegebeneKategorie(category);
			viewMain.lvAssignedRooms.setListData(wrapper.getZimmerListAdapter(availableRooms));
		} catch (FokusException e) {
			e.printStackTrace();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		try {
			defaultRoomAssignment(availableRooms, curTeilreservierung.getAnzahl());
		} catch (NotEnoughRoomsException e) {
			System.out.println(e.getRoomsRequired());
		}
		
	}
	
	public void defaultRoomAssignment(List<IZimmer> roomsAvailable, int requiredRooms) throws NotEnoughRoomsException{
		for (int i=0; i <= requiredRooms; i++) {
			if (i >= roomsAvailable.size()) {
				throw new NotEnoughRoomsException(requiredRooms-i);
			}
			selectedRooms.add(roomsAvailable.get(i));
		}
	}
	
	public IZimmer getRoomByNumber (int roomNumber) {
		for (IZimmer room : availableRooms) {
			if (room.getID() == roomNumber) {
				return room;
			}
		}
		return null;
	}
	
	public ITeilreservierung getSelectedTeilreservierung (String categoryName) {
		for (ITeilreservierung teilreservierung : teilreservierungen) {
			if (teilreservierung.getKategorie().getBezeichnung().equalsIgnoreCase(categoryName)) {
				return teilreservierung;
			}
		}
		return null;
	}
	
	class CategoryChangedListener implements ListViewSelectionListener {
		@Override
		public void selectedItemChanged(ListView listView, Object arg1) {
			String text = (String) listView.getSelectedItem();
			String[] split = text.split(" ");
			
			String categoryName = split[1];
			
			setSelectedPartialReservation(categoryName);
		}

		@Override
		public void selectedRangeAdded(ListView arg0, int arg1, int arg2) {
		}

		@Override
		public void selectedRangeRemoved(ListView arg0, int arg1, int arg2) {
		}

		@Override
		public void selectedRangesChanged(ListView arg0, Sequence<Span> arg1) {
		}
	}

	class RoomChangedListener implements ListViewSelectionListener {

		@Override
		public void selectedItemChanged(ListView listView, Object arg1) {
			String text = (String) listView.getSelectedItem();
			String[] split = text.split(" \\| ");
			IZimmer room = getRoomByNumber(Integer.valueOf(split[1]));
			selectedRooms.add(room);
		}

		@Override
		public void selectedRangeAdded(ListView arg0, int arg1, int arg2) {
		}

		@Override
		public void selectedRangeRemoved(ListView arg0, int arg1, int arg2) {
		}

		@Override
		public void selectedRangesChanged(ListView arg0, Sequence<Span> arg1) {
		}
	}
}
