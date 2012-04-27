package projekt.fhv.teama.view;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.apache.pivot.collections.adapter.ListAdapter;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerpreis;
import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckIn;

public class Wrapper {
	ListAdapter<String> listAdapter;
	NumberFormat numberFormat;

	public ListAdapter<String> getReservationListAdapter(
			List<IReservierung> reservations) {
		List<String> curReservations = new ArrayList<String>();
		ReservationIDComparator reservationComparator = new ReservationIDComparator();
		Collections.sort(reservations, reservationComparator);

		for (IReservierung reservation : reservations) {
			curReservations.add("Nr. "
					+ numberFormat.format(reservation.getID()) + " | "
					+ reservation.getPerson().getNachname().toUpperCase() + " "
					+ reservation.getPerson().getVorname());
		}
		return new ListAdapter<String>(curReservations);
	}

	public ListAdapter<String> getGuestListAdapter(List<IGast> guests) {
		LinkedList<String> curGuests = new LinkedList<String>();
		GuestNameComparator guestNameComparator = new GuestNameComparator();
		Collections.sort(guests, guestNameComparator);

		for (IGast guest : guests) {
			curGuests.add("Nr. " + guest.getNummer() + " | "
					+ guest.getNachname().toUpperCase() + " "
					+ guest.getVorname());
		}
		return new ListAdapter<String>(curGuests);
	}

	public ListAdapter<String> getAdressListAdapter(List<IAdresse> adresses) {
		LinkedList<String> curAdresses = new LinkedList<String>();

		for (IAdresse adress : adresses) {
			curAdresses.add(adress.getStrasse() + " | " + adress.getOrt()
					+ " | " + adress.getPlz() + " | "
					+ adress.getLand().getBezeichnung());
		}
		return new ListAdapter<String>(curAdresses);
	}

	public ListAdapter<String> getTeilreservierungListAdapter(
			List<ITeilreservierung> teilreservierungen) {
		LinkedList<String> curteilreservierungen = new LinkedList<String>();

		for (ITeilreservierung teilreservierung : teilreservierungen) {
			curteilreservierungen.add(teilreservierung.getAnzahl() + "x "
					+ teilreservierung.getKategorie().getBezeichnung());
		}
		return new ListAdapter<String>(curteilreservierungen);
	}

	public ListAdapter<String> getZimmerListAdapter(List<IZimmer> roomsAvailable) {
		LinkedList<String> curRooms = new LinkedList<String>();
		RoomNumberComparator roomNumberComparator = new RoomNumberComparator();
		Collections.sort(roomsAvailable, roomNumberComparator);

		for (IZimmer room : roomsAvailable) {
			curRooms.add(room.getNummer() + " | "
					+ room.getKategorie().getBezeichnung()+ " | € " +new Vector<IZimmerpreis>(room.getKategorie().getZimmerpreise()).get(0).getPreis());
		}
		return new ListAdapter<String>(curRooms);
	}
	
	public ListAdapter<String> getKeyListAdapter(List<IZimmer> rooms) {
		LinkedList<String> keyNumber = new LinkedList<String>();
		RoomNumberComparator roomNumberComparator = new RoomNumberComparator();
		Collections.sort(rooms, roomNumberComparator);

		for (IZimmer room : rooms) {
			keyNumber.add("Key No. " + room.getNummer());
		}
		return new ListAdapter<String>(keyNumber);
	}
	
	public String getZimmer (IZimmer zimmer){
		return zimmer.getNummer() + " | "
				+ zimmer.getKategorie().getBezeichnung()+ " | € " +new Vector<IZimmerpreis>(zimmer.getKategorie().getZimmerpreise()).get(0).getPreis();
	}

	public ListAdapter<String> getPfandTypListAdapter(List<IPfandtyp> pfandtypen) {
		LinkedList<String> curPfandTypen = new LinkedList<String>();

		for (IPfandtyp pfandtyp : pfandtypen) {
			curPfandTypen.add(pfandtyp.getBezeichnung());
		}
		return new ListAdapter<String>(curPfandTypen);
	}

	public Wrapper() {
		numberFormat = NumberFormat.getInstance();
		numberFormat.setMinimumIntegerDigits(3);
	}

	public class ReservationIDComparator implements Comparator<IReservierung> {

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

	public class RoomNumberComparator implements Comparator<IZimmer> {

		@Override
		public int compare(IZimmer z1, IZimmer z2) {
			if (z1.getKategorie().getBezeichnung() ==z2.getKategorie().getBezeichnung()){
				return z1.getNummer().compareTo(z2.getNummer());
			}
			return z1.getKategorie().getBezeichnung().compareTo(z2.getKategorie().getBezeichnung());
		}
	}
}
