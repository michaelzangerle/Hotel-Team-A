package view;

import java.net.URL;

import org.apache.pivot.beans.*;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.*;

import view.support.SHSDateTime;

public class ViewLogin extends Window implements Application, Bindable {
	
	@BXML private TextInput tfUsername = null;
	@BXML private TextInput tfPassword = null;
	@BXML private PushButton pushBLogin = null;
	
	BXMLSerializer bxmlSerializer = new BXMLSerializer();
	
	private Window window = null;
	private static SHSDateTime shsDateTime = new SHSDateTime();
	

	@Override
	public void startup(Display display, Map<String, String> properties)
			throws Exception {

		shsDateTime.start();
		
		window = (Window) bxmlSerializer.readObject(ViewLogin.class,
				"ViewLogin.bxml");

		final Label lbcurrentTime = (Label) bxmlSerializer.getNamespace().get(
				"lbcurrentTime");
		Label lbcurrentDate = (Label) bxmlSerializer.getNamespace().get(
				"lbcurrentDate");
		Label lbcurrentDay = (Label) bxmlSerializer.getNamespace().get(
				"lbcurrentDay");
				
		lbcurrentTime.setText(shsDateTime.getCurrentTime());
		lbcurrentDay.setText(shsDateTime.getCurrentDay());
		lbcurrentDate.setText(shsDateTime.getCurrentDate());

		window.open(display);
		
		ApplicationContext.scheduleRecurringCallback((new Runnable() {

			public void run() {
				lbcurrentTime.setText(shsDateTime.getCurrentTime());
			}
		}), 1000);
			

	}

	@Override
	public boolean shutdown(boolean optional) {
		if (window != null) {
			window.close();
		}

		return false;
	}

	@Override
	public void suspend() {
	}

	@Override
	public void resume() {
	}

	public static void main(String[] args) {

		DesktopApplicationContext
				.applyStylesheet("/view/style/styles.json");
		DesktopApplicationContext.main(
				(Class<? extends Application>) ViewLogin.class, args);

	}

	
	public TextInput getTfUsername() {
		return tfUsername;
	}

	public void setTfUsername(TextInput tfUsername) {
		this.tfUsername = tfUsername;
	}

	public TextInput getTfPassword() {
		return tfPassword;
	}

	public void setTfPassword(TextInput tfPassword) {
		this.tfPassword = tfPassword;
	}
	
	
	public void init() {
		
		System.out.println("Hallo Init.");
	}

	@Override
	public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
		
		
		pushBLogin = (PushButton)arg0.get("pushBLogin");
		tfUsername = (TextInput)arg0.get("tfUsername");
		tfPassword = (TextInput)arg0.get("tfPassword");
		
		pushBLogin.getButtonPressListeners().add(new ButtonPressListener() {

			@Override
			public void buttonPressed(Button arg0) {

				if(tfUsername.getText().equals("") | tfPassword.getText().equals("")) {
					Alert.alert("Please insert username and password.", ViewLogin.this);
				}else {
					ViewMain programm = new ViewMain();
					String x[]={"--name=value"};
					programm.main(x);	
				}
			}
			
		}
		
	);
		
	}
	

}