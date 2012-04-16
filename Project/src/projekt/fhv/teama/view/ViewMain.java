package projekt.fhv.teama.view;

import java.awt.Dimension;
import java.net.URL;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.ApplicationContext;
import org.apache.pivot.wtk.BoxPane;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.Window;

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
		BoxPane bpReservation2 = (BoxPane)arg0.get("bpReservation2");
		
		bpReservation2.setVisible(true);
		
		// lbReservationDetails.setText("Jetzt durch Java gesetzt!");
		
		

	}

}
