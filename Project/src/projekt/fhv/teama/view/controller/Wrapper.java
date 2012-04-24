package projekt.fhv.teama.view.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.pivot.collections.adapter.ListAdapter;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;

public class Wrapper {
	ListAdapter<String> listAdapter; 
	NumberFormat numberFormat;
	
	public ListAdapter<String> getReservationListAdapter(List<IReservierung> reservations) {
		List<String> curReservations = new ArrayList<String>();
		
		for (IReservierung reservation : reservations){
			curReservations.add("Nr. " + numberFormat.format(reservation.getID()) + " | " + reservation.getPerson().getNachname().toUpperCase() + " "+ reservation.getPerson().getVorname());
		}
		return new ListAdapter<String>(curReservations);
	}
	
	public ListAdapter<String> getGuestListAdapter (List<IGast> guests) {
		List<String> curGuests = new ArrayList<String>();
		
		for(IGast guest : guests) {
			curGuests.add("Nr. " + numberFormat.format(guest.getNummer() + " | " + guest.getNachname().toUpperCase() + " " + guest.getVorname()));
		}
		return new ListAdapter<String>(curGuests);
	}
	
	public Wrapper () {
		numberFormat = NumberFormat.getInstance();
		numberFormat.setMinimumIntegerDigits(3);
	}
}
