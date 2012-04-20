package projekt.fhv.teama.view;

import java.awt.Dimension;
import java.net.URL;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.*;

public class ViewMain extends Window implements Application, Bindable {

	BXMLSerializer bxmlSerializer = new BXMLSerializer();	
	private Window window = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DesktopApplicationContext
				.applyStylesheet("/projekt/fhv/teama/view/style/styles.json");
		DesktopApplicationContext.main(
				(Class<? extends Application>) ViewMain.class, args);		
	}

	@Override
	public void startup(Display display, Map<String, String> properties)
			throws Exception {
		
		window = (Window) bxmlSerializer.readObject(ViewLogin.class,
				"ViewMain.bxml");
		display.getHostWindow().setMinimumSize(new Dimension(1024,768));
		window.open(display);
	}
	
	@Override
	public void resume() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean shutdown(boolean arg0) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void suspend() throws Exception {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
		
		Label lbReservationDetails = (Label)arg0.get("lbReservationDetails");
		Border reservationForm01 = (Border)arg0.get("reservationForm01");
		Border checkInForm01 = (Border)arg0.get("checkInForm01");
		Border checkInForm02 = (Border)arg0.get("checkInForm02");
		Border checkInForm03 = (Border)arg0.get("checkInForm03");
		Border checkInForm04 = (Border)arg0.get("checkInForm04");
		//Window viewMain = (Window)arg0.get("viewMain");
		
		reservationForm01.setVisible(false);
		checkInForm01.setVisible(true);
		checkInForm02.setVisible(false);
		checkInForm03.setVisible(false);
		checkInForm04.setVisible(false);
		
		
		
				
		// lbReservationDetails.setText("Jetzt durch Java gesetzt!");
	}

}
