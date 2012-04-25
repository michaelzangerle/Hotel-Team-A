package projekt.fhv.teama.view;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.Map;
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.util.CalendarDate;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.ListViewSelectionListener;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.Span;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.controller.exeption.LoginInExeption;
import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckIn;
import projekt.fhv.teama.controller.usecasecontroller.ControllerLogin;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
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
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.view.support.BlockingDialog;
import projekt.fhv.teama.view.tests.TestDaten;

public class ViewController implements Application{
    private ViewLogin viewLogin; 
    private ViewMain viewMain;
	private Display disp;
	public TestDaten testDaten = new TestDaten();
	private ControllerCheckIn controllerCheckIn;
	private Wrapper wrapper;
	private List<IReservierung> reservations;
	
	@Override
	public void resume() throws Exception {
		
	}

	@Override
	public boolean shutdown(boolean arg0) throws Exception {
		return false;
	}

    /**
    * The Application startup method is where to put your code for rendering UI.
    * The startup method requires the throws Exception to prevent an error
    * when trying to read to the bxml document. This handles the Serialization
    * Exception thrown if file not found.
    */
    @Override
    public void startup(Display display, Map<String, String> properties)
        throws Exception {

        BXMLSerializer bS = new BXMLSerializer();
        disp = display;
        
        viewLogin = (ViewLogin) bS.readObject(getClass().getResource("ViewLogin.bxml"));
        viewMain = (ViewMain) bS.readObject(getClass().getResource("ViewMain.bxml"));
        viewMain.setMaximized(true);
        viewLogin.open(disp);
        
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
		viewMain.setrf1PBtnCheckInListener(new CheckInViewController(viewMain, controllerCheckIn));
		viewMain.setlvGuestSearchListener(new GuestListListener());
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
				bd.setContent(new Alert(MessageType.WARNING, "Please enter your username and password",new ArrayList<String>("OK")));
				Dialog erg = bd.open(disp);
				return;
			} 
			
//			SHSActivityIndicator indicator = new SHSActivityIndicator(viewLogin);
//			Thread t = new Thread(indicator);
//			t.start();
//			
//			synchronized(this) {
//				Thread t1 = new Thread(this);
//				t1.start();
//			}
			
			try {
				ma =  controllerLogin.checkLogin(username, password);
				startMainView(ma.getNummer());
			} catch (DatabaseException e) {
				e.printStackTrace();
			} catch (LoginInExeption e) {
				e.printStackTrace();
			}	
			
		}
		
		public LoginListener() {
			controllerLogin = new ControllerLogin(new ModelMitarbeiter());
		}
		
//		@Override
//		public void run() {
//			try {
//				ma =  controllerLogin.checkLogin(username, password);	
//				this.notifyAll();
//			} catch (DatabaseException e) {
//				BlockingDialog bd = new BlockingDialog();
//				bd.setContent(new Alert(MessageType.WARNING, "Invalid username or password",new ArrayList<String>("OK")));
//				Dialog erg = bd.open(disp);
//				e.printStackTrace();
//			} catch (LoginInExeption e) {
//				e.printStackTrace();
//			}
//			
//		}
	}

	public void startMainView(String username) {
		viewMain.open(disp);
		//viewMain.getlbLoginShow().setText(username);
		wrapper = new Wrapper();
		initializeMainView();
		addMainEventListener();
	}
	
	
	private void initializeMainView() {
		controllerCheckIn = new ControllerCheckIn(new ModelReservierung(), new ModelAufenthalt(), 
				new ModelGast(), new ModelTeilreservierung(), new ModelKategorie(), 
				new ModelKontodaten(), new ModelPfandTyp(), new ModelZimmer(), new ModelZimmerstatus(), 
				new ModelAdresse(), new ModelLand(), new ModelStatusentwicklung());
		
		try {
			reservations = controllerCheckIn.getAllReservierungen();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}

		if (reservations.equals(null)) {
			viewMain.getLvReservationSearch().setListData("Currently no reservations available");
		} else {
			viewMain.getLvReservationSearch().setListData(wrapper.getReservationListAdapter(reservations));
		}
		setSelectedReservation(1);
	}

	public void setReservationFocus (int ID) {
		for (IReservierung reservation : reservations) {
			if (reservation.getID() == ID) {
				controllerCheckIn.setAktuelleReservierung(reservation);
			}
		}
	}
	
	public void setSelectedReservation(int reservierungsnummer) {
		setReservationFocus(reservierungsnummer);
		IReservierung curReservation = null;
		try {
			curReservation = controllerCheckIn.getAktuelleReservierung();
		} catch (FokusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewMain.rf1LBResNr.setText(String.valueOf(curReservation.getID()));
		viewMain.rf1TIName.setText(curReservation.getPerson().getNachname().toUpperCase() + " " + curReservation.getPerson().getVorname());
		viewMain.rf1TIEMail.setText(curReservation.getPerson().getEmail());
		viewMain.rf1TIPhone.setText(curReservation.getPerson().getTelefonnummer());
		
		List<IAdresse> adressen = new Vector<IAdresse>(curReservation.getPerson().getAdressen());
		
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
	
	class ReservationListListener implements ListViewSelectionListener{

		@Override
		public void selectedItemChanged(ListView listView, Object arg1) {
			String text = (String) listView.getSelectedItem();
			String[] split = text.split(" ", 3);
			int reservierungsnummer = Integer.valueOf(split[1]);
			
			setSelectedReservation(reservierungsnummer);
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
	
	class GuestListListener implements ListViewSelectionListener {

		@Override
		public void selectedItemChanged(ListView listView, Object arg1) {
			String text = (String) listView.getSelectedItem();
			
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
