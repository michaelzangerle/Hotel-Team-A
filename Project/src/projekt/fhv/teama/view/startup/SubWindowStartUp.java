package projekt.fhv.teama.view.startup;


//Import the DesktopApplicationContext package.
import org.apache.pivot.wtk.DesktopApplicationContext;

import projekt.fhv.teama.view.ViewController;
import projekt.fhv.teama.view.ViewCurrentGuest;

/**
 * Diese Klasse repr�sentiert den Einstiegspunkt in die Apache Pivot
 * Applikation f�r den Desktop.  
 * 
 * @author Team A
 *
 * @version 1.1
 */
public class SubWindowStartUp  {
	
    //Entry point into all java applications.
    public static void main(String[] args) throws Exception
    {
        /**
        * Ladet die Pivot Anwendung in unser JAVA Programm
        * Es wird ein "Stylesheet" angegeben in welchem JSON Definitionen
        * �hnlich wie CSS Syntax die Start-Attribute des Objekts definieren
        * 
        * Es muss als Argument die richtige Klasse angegeben werden, welche das Programm
        * steuert.
        */
        DesktopApplicationContext.applyStylesheet("/projekt/fhv/teama/view/style/styles.json");
      //  DesktopApplicationContext.main(ViewCurrentGuest.class, args);   
    }
}