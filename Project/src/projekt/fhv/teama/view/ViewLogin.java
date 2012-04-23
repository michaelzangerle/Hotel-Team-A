package projekt.fhv.teama.view;

import java.net.URL;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.ApplicationContext;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.Window;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.controller.ControllerMitarbeiter;
import projekt.fhv.teama.controller.exeption.LoginInExeption;
import projekt.fhv.teama.controller.usecasecontroller.ControllerLogin;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.view.support.SHSDateTime;

public class ViewLogin extends Window implements Application, Bindable {
	
	ControllerLogin controlLogin = new ControllerLogin(new ControllerMitarbeiter());
	
	
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
				.applyStylesheet("/projekt/fhv/teama/view/style/styles.json");
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
					
					
					
					try {
						/* 66, 1234 */
						String usString=tfUsername.getText();
						String pwString=tfPassword.getText();
						IMitarbeiter loginok= controlLogin.checkLogin(usString,pwString);
						if(loginok!=null)
						{
							
							String x[]={"--name=value"};
							ViewMain.main(x);
							
						}
						else {
							System.out.println("Login Not Ok");
						}
						
					} catch (DatabaseException e) {
						System.out.println(e.getMessage());
					}
					 catch (LoginInExeption e) {
							System.out.println(e.getMessage());
						}
					
				}
			}
			
		}
		
	);
		
	}
	

}