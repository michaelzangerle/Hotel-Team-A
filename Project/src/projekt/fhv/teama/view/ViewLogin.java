package projekt.fhv.teama.view;

import java.net.URL;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.ApplicationContext;
import org.apache.pivot.wtk.Border;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.Window;

import projekt.fhv.teama.view.support.SHSDateTime;

/**
 * Diese Klasse erweitert Window und wird als erstes vom ViewController
 * geladen, damit der Login in das SHS abgehandelt werden kann.
 *
 * @author Team A
 * @version 1.1
 */
public class ViewLogin extends Window implements Bindable {
	@BXML TextInput tfUsername = null;
	@BXML TextInput tfPassword = null;
	@BXML PushButton pushBLogin = null;
	@BXML Border bLogin = null;
	
//	BXMLSerializer bxmlSerializer = new BXMLSerializer();
	
	private static SHSDateTime shsDateTime = new SHSDateTime();

	public TextInput getTfUsername() {
		return tfUsername;
	}

	public TextInput getTfPassword() {
		return tfPassword;
	}

	/**
	 * Die initialize() Methode wird vom Interface Bindable vorgeschrieben,
	 * damit werden die Componenten der Oberfläche initialisiert.
	 * 
	 * @see org.apache.pivot.beans.Bindable#initialize(org.apache.pivot.collections.Map, java.net.URL, org.apache.pivot.util.Resources)
	 */
	@Override
	public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
		shsDateTime.start();
		final Label lbcurrentTime =(Label)arg0.get("lbcurrentTime");
		final Label lbcurrentDate = (Label)arg0.get("lbcurrentDate");
		final Label lbcurrentDay = (Label)arg0.get("lbcurrentDay");		
		
		ApplicationContext.scheduleRecurringCallback((new Runnable() {
			public void run() {
				lbcurrentTime.setText(shsDateTime.getCurrentTime());
				lbcurrentDay.setText(shsDateTime.getCurrentDay());
				lbcurrentDate.setText(shsDateTime.getCurrentDate());
			}
		}), 1000);

	}
	
	/**
	 * Damit kann der Button Listener vom ViewController gesetzt werden.
	 * 
	 * @param e Event 
	 */
	public void setPushBLoginListener(ButtonPressListener e) {
		pushBLogin.getButtonPressListeners().add(e);
	}
	
}