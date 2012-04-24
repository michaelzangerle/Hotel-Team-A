package projekt.fhv.teama.view;

import java.net.URL;
import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.ApplicationContext;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.Window;
import projekt.fhv.teama.view.support.SHSDateTime;

public class ViewLogin extends Window implements Bindable {
	@BXML public TextInput tfUsername = null;
	@BXML private TextInput tfPassword = null;
	@BXML private PushButton pushBLogin = null;
	
	BXMLSerializer bxmlSerializer = new BXMLSerializer();
	
	private Window window = null;
	private static SHSDateTime shsDateTime = new SHSDateTime();

	public TextInput getTfUsername() {
		return tfUsername;
	}

	public TextInput getTfPassword() {
		return tfPassword;
	}

	@Override
	public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
		shsDateTime.start();
		final Label lbcurrentTime =(Label)arg0.get("lbcurrentTime");
		final Label lbcurrentDate = (Label)arg0.get("lbcurrentDate");
		final Label lbcurrentDay = (Label)arg0.get("lbcurrentDay");
		pushBLogin = (PushButton)arg0.get("pushBLogin");
		tfUsername = (TextInput)arg0.get("tfUsername");
		tfPassword = (TextInput)arg0.get("tfPassword");
		
		
		ApplicationContext.scheduleRecurringCallback((new Runnable() {
			public void run() {
				lbcurrentTime.setText(shsDateTime.getCurrentTime());
				lbcurrentDay.setText(shsDateTime.getCurrentDay());
				lbcurrentDate.setText(shsDateTime.getCurrentDate());
			}
		}), 1000);

		
//		lbcurrentTime.setText(shsDateTime.getCurrentTime());
//		lbcurrentDay.setText(shsDateTime.getCurrentDay());
//		lbcurrentDate.setText(shsDateTime.getCurrentDate());
	}
	
	public void setPushBLoginListener(ButtonPressListener e) {
		pushBLogin.getButtonPressListeners().add(e);
	}
	
}