package projekt.fhv.teama.view;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.apache.pivot.collections.adapter.ListAdapter;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;

public class Wrapper {
    ListAdapter<String> listAdapter;
    NumberFormat numberFormat;

    public ListAdapter<String> getReservationListAdapter(List<IReservierung> reservations) {
        List<String> curReservations = new ArrayList<String>();
        ReservationIDComparator reservationComparator = new ReservationIDComparator();
        Collections.sort(reservations, reservationComparator);

        for (IReservierung reservation : reservations){
            curReservations.add("Nr. " + numberFormat.format(reservation.getID()) + " | " + reservation.getPerson().getNachname().toUpperCase() + " "+ reservation.getPerson().getVorname());
        }
        return new ListAdapter<String>(curReservations);
    }

    public ListAdapter<String> getGuestListAdapter (List<IGast> guests) {
        LinkedList<String> curGuests = new LinkedList<String>();
        GuestNameComparator guestNameComparator = new GuestNameComparator();
        Collections.sort(guests, guestNameComparator);

        for(IGast guest : guests) {
            curGuests.add("Nr. " + guest.getNummer() + " | " + guest.getNachname().toUpperCase() + " " + guest.getVorname());
        }
        return new ListAdapter<String>(curGuests);
    }

    public Wrapper () {
        numberFormat = NumberFormat.getInstance();
        numberFormat.setMinimumIntegerDigits(3);
    }

    public class ReservationIDComparator implements Comparator<IReservierung>{

        @Override
        public int compare(IReservierung r1, IReservierung r2) {
            if (r1.getID() > r2.getID()) {
                return 1;
            }
            if (r1.getID() < r2.getID()) {
                return -1;
            }
            return 0;
        }
    }

    public class GuestNameComparator implements Comparator<IGast> {

        @Override
        public int compare(IGast g1, IGast g2) {
            if (g1.getNachname() == g2.getNachname()) {
                return g1.getVorname().compareTo(g2.getNachname());
            }
            return g1.getNachname().compareTo(g2.getNachname());
        }
    }
}

