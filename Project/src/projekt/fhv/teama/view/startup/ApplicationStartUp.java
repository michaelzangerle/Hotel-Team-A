package projekt.fhv.teama.view.startup;

/**
* This class represents the entry point into an
* Apache Pivot application on the desktop.
*/


//Import the DesktopApplicationContext package.
import org.apache.pivot.wtk.DesktopApplicationContext;

import projekt.fhv.teama.view.ViewController;

public class ApplicationStartUp {
	
    //Entry point into all java applications.
    public static void main(String[] args) throws Exception
    {
        /**
        * Load the pivot application into our Java program.
        * Remember to enter correct class in the parameter list..  
        */
        DesktopApplicationContext.applyStylesheet("/projekt/fhv/teama/view/style/styles.json");
    	DesktopApplicationContext.main(ViewController.class, args);    	
        

    }
}