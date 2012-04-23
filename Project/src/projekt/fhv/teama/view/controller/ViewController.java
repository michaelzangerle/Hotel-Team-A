package projekt.fhv.teama.view.controller;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Window;

import projekt.fhv.teama.view.ViewLogin;
import projekt.fhv.teama.view.ViewMain;
import projekt.fhv.teama.view.tests.TestDaten;

public class ViewController implements Application{
	
	public Display disp;
	public TestDaten testDaten = new TestDaten();
	
	@Override
	public void resume() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean shutdown(boolean arg0) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	 //Attributes
    private ViewLogin viewLogin; //The person object for testing bxml serializer
    private ViewMain viewMain;
    private Window window; //Currently not being used

    /**
    * The Application startup method is where to put your code for rendering UI.
    * The startup method requires the throws Exception to prevent an error
    * when trying to read to the bxml document. This handles the Serialization
    * Exception thrown if file not found.
    */
    @Override
    public void startup(Display display, Map<String, String> properties)
        throws Exception {

        //Create and instantiate a new BXML Serializer object.
        //This is used to read and process the bxml documents.
        BXMLSerializer bS = new BXMLSerializer();
        disp = display;

        //Next, we call the read object method to read the bxml document.
        //Several things are happening here. 

        //First we get the Person.bxml resource which is retrieved using
        //getClass().getResource() method. The resource is the Person.bxml file 

        //Second, we read the xml data from the retrieved file. In this case
        //the BXML Serializer will cast our person object defined in the bxml
        //document into an object of type Object. 

        //Third we must cast the object that was returned from the BXML
        //Serializer into a Person object. That is accomplished using
        //casting. Casting is implemented with the (Person). And finally
        //we assign the newly created Person object into our variable called
        //"person". Now we can reference the attributes set in the bxml document.
        
        
        viewLogin = (ViewLogin) bS.readObject(getClass().getResource("../ViewLogin.bxml"));
        viewMain = (ViewMain) bS.readObject(getClass().getResource("../ViewMain.bxml"));
        startMain();

   
    } 

	@Override
	public void suspend() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void startMain() {
		viewMain.open(disp);
	}
	
	
}
