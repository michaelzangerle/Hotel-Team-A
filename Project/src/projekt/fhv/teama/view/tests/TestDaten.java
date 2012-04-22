package projekt.fhv.teama.view.tests;

import org.apache.pivot.collections.adapter.ListAdapter;

import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckIn;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerCheckIn;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestDaten {
		
	IControllerCheckIn checkIn = new ControllerCheckIn(null, null, null, null, null, null, null, null, null, null);
	
	
	List<String> ankommendeGaeste;
	List<String> gaesteInReservierung;
	List<String> gastAdressen;	
	List<String> gebuchteZimmerkategorien; 	/* = Teilreservierungen */	
	List<String> verfuegbareDopplezimmer;
	List<String> verfuegbareEinzelzimmer;	
	List<String> pfandkategorien;	
	List<String> zugeteilteZimmer;	
	
	public ListAdapter<String> alAnkommendeGaeste;
	public ListAdapter<String> alGaesteInReservierung;
	public ListAdapter<String> alGastAdressen;
	public ListAdapter<String> alGebuchteZimmerkategorien;
	public ListAdapter<String> alVerfügbareDoppelzimmer;
	public ListAdapter<String> alVerfügbareEinzelzimmer;
	public ListAdapter<String> alPfandkategorien;
	public ListAdapter<String> alZugeteilteZimmer;
	

	public void generateTestData() {
		
	     verfuegbareDopplezimmer = new ArrayList<String>();
	     verfuegbareEinzelzimmer = new ArrayList<String>();
	     ankommendeGaeste = new ArrayList<String>();
	 	 gaesteInReservierung = new ArrayList<String>();
		 gastAdressen = new ArrayList<String>(); 		
		 gebuchteZimmerkategorien = new ArrayList<String>();		
		 verfuegbareDopplezimmer = new ArrayList<String>();
		 verfuegbareEinzelzimmer = new ArrayList<String>();		
		 pfandkategorien = new ArrayList<String>();		
		 zugeteilteZimmer = new ArrayList<String>();
    
	     NumberFormat numberFormat = NumberFormat.getInstance();
	     numberFormat.setMinimumIntegerDigits(3);
	    	     
	     for (int i = 0; i <= 40; i++) {
			
	    	 verfuegbareDopplezimmer.add("Nr. "+ numberFormat.format(i)+" Double Room");
	    	 verfuegbareEinzelzimmer.add("Nr. "+ numberFormat.format(i)+" Single Room");
	    	 ankommendeGaeste.add("Nr. " +numberFormat.format(i)+ " Lastname "+"Firstname, "+ "Street Nr., "+"ZIP "+"City");
	    	 

	    	 	if(i==25 || i==35 || i ==50){
	    	 		gaesteInReservierung.add("Lastname"+i+" Firstname");
	   	    		gastAdressen.add("Street Nr. "+i+", ZIP "+"City");

	    	 			    	 	}
	    	 
	    	 if (i==3) {
		      gebuchteZimmerkategorien.add(i + " Double Room(s)");
		      gebuchteZimmerkategorien.add(i + " Single Room(s)");		      
		      } 

  		 }	     
    	 
    	 pfandkategorien.add("ID card");
    	 pfandkategorien.add("Passport");
    	 pfandkategorien.add("Driving license");
	     
	     /* ListAdapter erstellen */
	     alAnkommendeGaeste = new ListAdapter<String>(ankommendeGaeste);
	     alGaesteInReservierung = new ListAdapter<String>(gaesteInReservierung);
	     alGastAdressen = new ListAdapter<String>(gastAdressen);
	     alGebuchteZimmerkategorien = new ListAdapter<String>(gebuchteZimmerkategorien);
	     alVerfügbareDoppelzimmer = new ListAdapter<String>(verfuegbareDopplezimmer);
	     alVerfügbareEinzelzimmer =  new ListAdapter<String>(verfuegbareEinzelzimmer);
	     alPfandkategorien =  new ListAdapter<String>(pfandkategorien);
	     alZugeteilteZimmer =  new ListAdapter<String>(zugeteilteZimmer);
	 
	}



	public ListAdapter<String> getAlZugeteilteZimmer() {
		return alZugeteilteZimmer;
	}


	public void setAlZugeteilteZimmer(ListAdapter<String> alZugeteilteZimmer) {
		this.alZugeteilteZimmer = alZugeteilteZimmer;
	}
	  
	public List<String> getZugeteilteZimmer() {
		return zugeteilteZimmer;
	}


	public void setZugeteilteZimmer(List<String> zugeteilteZimmer) {
		this.zugeteilteZimmer = zugeteilteZimmer;
	}

	
	
}
