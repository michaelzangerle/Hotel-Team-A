package projekt.fhv.teama.view.tests;

import org.apache.pivot.collections.adapter.ListAdapter;

import java.util.LinkedList;
import java.util.List;

public class TestDaten {
	
	List<String> ankommendeGaeste;
	List<String> gaesteInReservierung;
	List<String> gastAdressen;
	
	List<String> gebuchteZimmerkategorien; 	/* = Teilreservierung */
	
	List<String> verfuegbareDopplezimmer;
	List<String> verfuegbareEinzelzimmer;
	
	List<String> pfandkategorien;
	
	List<String> zugeteilteZimmer;
	
	public static void main(String[] args) {
		
		//<String> states = new ArrayList<String>();
	     List<String> states = new LinkedList<String>();

	     states.add("Alabama");
	     states.add("Alaska");
	     states.add("Arizona");
	     states.add("Arkansas");
	     states.add("California");
	     states.add("Colorado");
	     states.add("Connecticut");
	     states.add("Delaware");
	     states.add("District of Columbia");
	     states.add("Florida");
	     states.add("Georgia");
	     states.add("Hawaii");
	     states.add("Idaho");
	     states.add("Illinois");
	     states.add("Indiana");
	     states.add("Iowa");
	     states.add("Kansas");
	     states.add("Kentucky");
	     states.add("Louisiana");
	     states.add("Maine");
	     states.add("Maryland");
	     states.add("Massachusetts");
	     states.add("Michigan");
	     states.add("Minnesota");
	     states.add("Mississippi");
	     states.add("Missouri");
	     states.add("Montana");
	     states.add("Nebraska");
	     states.add("Nevada");
	     states.add("New Hampshire");
	     states.add("New Jersey");
	     states.add("New Mexico");
	     states.add("New York");
	     states.add("North Carolina");
	     states.add("North Dakota");
	     states.add("Ohio");
	     states.add("Oklahoma");
	     states.add("Oregon");
	     states.add("Pennsylvania");
	     states.add("Rhode Island");
	     states.add("South Carolina");
	     states.add("South Dakota");
	     states.add("Tennessee");
	     states.add("Texas");
	     states.add("Utah");
	     states.add("Vermont");
	     states.add("Virginia");
	     states.add("Washington");
	     states.add("West Virginia");
	     states.add("Wisconsin");
	     states.add("Wyoming");
	     
	     
	     ListAdapter<String> hans = new ListAdapter<String>(states);
	     
	     
	     
	 
	}
	  
}
