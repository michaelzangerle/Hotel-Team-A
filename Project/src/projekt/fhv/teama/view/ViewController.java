package projekt.fhv.teama.view;

import java.util.List;
import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.collections.Map;
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.util.Filter;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.ListView.ItemEditor;
import org.apache.pivot.wtk.ListView.ItemRenderer;
import org.apache.pivot.wtk.ListView.SelectMode;
import org.apache.pivot.wtk.ListViewListener;
import org.apache.pivot.wtk.ListViewSelectionListener;
import org.apache.pivot.wtk.Span;

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
import projekt.fhv.teama.model.interfaces.IModelReservierung;
import projekt.fhv.teama.model.interfaces.IModelStatusentwicklung;
import projekt.fhv.teama.view.tests.TestDaten;

public class ViewController implements Application{
    private ViewLogin viewLogin; 
    private ViewMain viewMain;
	private Display disp;
	public TestDaten testDaten = new TestDaten();
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
		viewMain.setrf1PBtnCheckInListener(new CheckInViewController());
		viewMain.setlvGuestSearchListener(new GuestListListener());
	}
	
	class LoginListener implements ButtonPressListener {
		private ControllerLogin controllerLogin;
		
		@Override
		public void buttonPressed(Button arg0) {
			String username = viewLogin.getTfUsername().getText();
			String password = viewLogin.getTfPassword().getText();
			
			if (username.equals("") || password.equals("")) {
				System.out.println("Please enter your username and password");
				return;
			}
			
			try {
				IMitarbeiter ma =  controllerLogin.checkLogin(username, password);
				if (ma.equals(null)) {
					System.out.println("Invalid username or password!");
				} else {
					startMainView(ma.getNummer());
				}
			} catch (DatabaseException e) {
				e.printStackTrace();
			} catch (LoginInExeption e) {
				e.printStackTrace();
			}
		}
		public LoginListener() {
			controllerLogin = new ControllerLogin(new ModelMitarbeiter());
		}
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
		
		List<IReservierung> reservations = controllerCheckIn.getAllReservierungen();

		if (reservations.equals(null)) {
			viewMain.getLvReservationSearch().setListData("Currently no reservations available");
		} else {
			viewMain.getLvReservationSearch().setListData(wrapper.getReservationListAdapter(reservations));
		}		
	
	}

	
	class ReservationListListener implements ListViewSelectionListener{

		@Override
		public void selectedItemChanged(ListView listView, Object arg1) {
			String text = (String) listView.getSelectedItem();
			String[] split = text.split(" ", 3);
			int reservierungsnummer = Integer.valueOf(split[1]);
			
			System.out.println(reservierungsnummer);

			IReservierung reservierung = null;
			//TODO reservierung via id auslesen
			//getReservierungbyreservierungsnummer/id..
			//controllerCheckIn.setAktuelleReservierung(reservierung);
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
