package projekt.fhv.teama.view.startup;


//Import the DesktopApplicationContext package.
import org.apache.pivot.wtk.DesktopApplicationContext;

import projekt.fhv.teama.view.ViewController;

/**
 * Diese Klasse repräsentiert den Einstiegspunkt in die Apache Pivot
 * Applikation für den Desktop.  
 * 
 * @author Team A
 *
 * @version 1.1
 */
public class ApplicationStartUp {
	
    //Entry point into all java applications.
    public static void main(String[] args) throws Exception
    {
        /**
        * Ladet die Pivot Anwendung in unser JAVA Programm
        * Es wird ein "Stylesheet" angegeben in welchem JSON Definitionen
        * ähnlich wie CSS Syntax die Start-Attribute des Objekts definieren
        * 
        * Es muss als Argument die richtige Klasse angegeben werden, welche das Programm
        * steuert.
        */
        DesktopApplicationContext.applyStylesheet("/projekt/fhv/teama/view/style/styles.json");
    	DesktopApplicationContext.main(ViewController.class, args);    	
    }
}