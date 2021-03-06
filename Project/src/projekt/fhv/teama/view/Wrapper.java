package projekt.fhv.teama.view;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.pivot.collections.adapter.ListAdapter;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerpreis;
import projekt.fhv.teama.integrate.IALeistung;
import projekt.fhv.teama.integrate.IAZimmer;

/**
 * Die Wrapper Klasse ist f�r das ListAdapter- Management verantwortlich, d.h. die Umwandlung von Objekten zu String listen.
 * @author Team A
 * @version 1.0
 */
public class Wrapper {
	ListAdapter<String> listAdapter;
	NumberFormat numberFormat;

	/**
	 * liefert den Reservierungs- ListAdapter
	 * @param reservations
	 * @return ListAdapter<String>
	 */
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

	/**
	 * liefert den Gast- ListAdapter
	 * @param guests
	 * @return ListAdapter<String>
	 */
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

	/**
	 * liefert den Adress- ListAdapter
	 * @param adresses
	 * @return ListAdapter<String>
	 */
	public ListAdapter<String> getAdressListAdapter(List<IAdresse> adresses) {
		LinkedList<String> curAdresses = new LinkedList<String>();

		for (IAdresse adress : adresses) {
			curAdresses.add(adress.getStrasse() + " | " + adress.getOrt()
					+ " | " + adress.getPlz() + " | "
					+ adress.getLand().getBezeichnung());
		}
		return new ListAdapter<String>(curAdresses);
	}

	/**
	 * liefert den teilreservierungs- ListAdapter
	 * @param teilreservierungen
	 * @return ListAdapter<String>
	 */
	public ListAdapter<String> getTeilreservierungListAdapter(
			List<ITeilreservierung> teilreservierungen) {
		LinkedList<String> curteilreservierungen = new LinkedList<String>();

		for (ITeilreservierung teilreservierung : teilreservierungen) {
			curteilreservierungen.add(teilreservierung.getAnzahl() + "x "
					+ teilreservierung.getKategorie().getBezeichnung());
		}
		return new ListAdapter<String>(curteilreservierungen);
	}

	/**
	 * liefert den Zimmer- ListAdapter
	 * @param roomsAvailable
	 * @return ListAdapter<String>
	 */
	public ListAdapter<String> getZimmerListAdapter(List<IZimmer> roomsAvailable) {
		LinkedList<String> curRooms = new LinkedList<String>();
		RoomNumberComparator roomNumberComparator = new RoomNumberComparator();
		Collections.sort(roomsAvailable, roomNumberComparator);

		for (IZimmer room : roomsAvailable) {
			curRooms.add(room.getNummer() + " | "
					+ room.getKategorie().getBezeichnung()+ " | � " +new Vector<IZimmerpreis>(room.getKategorie().getZimmerpreise()).get(0).getPreis());
		}
		return new ListAdapter<String>(curRooms);
	}
	
	/**
	 * lierfert den Zimmer (ohne Preisangabe) ListAdapter und Sortiert diese
	 * @param roomsAvailable
	 * @return
	 */
	public ListAdapter<String> getZimmerWithoutPriceListAdapterA(List<IAZimmer> roomsAvailable) {
		LinkedList<String> curRooms = new LinkedList<String>();
		RoomNumberComparatorA roomNumberComparator = new RoomNumberComparatorA();
		Collections.sort(roomsAvailable, roomNumberComparator);

		for (IAZimmer room : roomsAvailable) {
			curRooms.add(room.getNummer() + " | "
					+ room.getAKategorie().getBezeichnung());
		}
		return new ListAdapter<String>(curRooms);
	}
	/**
	 * liefert den Schl�ssel- ListAdapter
	 * @param rooms
	 * @return ListAdapter<String>
	 */
	public ListAdapter<String> getKeyListAdapter(List<IZimmer> rooms) {
		LinkedList<String> keyNumber = new LinkedList<String>();
		RoomNumberComparator roomNumberComparator = new RoomNumberComparator();
		Collections.sort(rooms, roomNumberComparator);

		for (IZimmer room : rooms) {
			keyNumber.add("Key No. " + room.getNummer());
		}
		return new ListAdapter<String>(keyNumber);
	}
	
	/**
	 * liefert den Schl�ssel- ListAdapter 
	 * @param rooms
	 * @return
	 */
	public ListAdapter<String> getKeyListAdapaterA (List<IAZimmer> rooms) {
		LinkedList<String> keyNumber = new LinkedList<String>();
		RoomNumberComparatorA roomNumberComparator = new RoomNumberComparatorA();
		Collections.sort(rooms, roomNumberComparator);

		for (IAZimmer room : rooms) {
			keyNumber.add("Key No. " + room.getNummer());
		}
		return new ListAdapter<String>(keyNumber);
	}
	
	
	
	/**
	 * Liefert den Ausgabe- String f�r das �bergebene Zimmer.
	 * @param zimmer
	 * @return String
	 */
	public String getZimmer (IZimmer zimmer){
		return zimmer.getNummer() + " | "
				+ zimmer.getKategorie().getBezeichnung()+ " | � " +new Vector<IZimmerpreis>(zimmer.getKategorie().getZimmerpreise()).get(0).getPreis();
	}
	
	/**
	 * liefert den PfandTyp- ListAdapter
	 * @param pfandtypen
	 * @return ListAdapter<String>
	 */
	public ListAdapter<String> getPfandTypListAdapter(List<IPfandtyp> pfandtypen) {
		LinkedList<String> curPfandTypen = new LinkedList<String>();

		for (IPfandtyp pfandtyp : pfandtypen) {
			curPfandTypen.add(pfandtyp.getBezeichnung());
		}
		return new ListAdapter<String>(curPfandTypen);
	}
	
	/**
	 * liefert den Zusatzleistungs ListAdapter
	 * @param services
	 * @return
	 */
	public ListAdapter<String> getZusatzleistungListAdapter(HashMap<String, Integer> services) {
		LinkedList<String> curZusatzleistungen = new LinkedList<String>();
		for (@SuppressWarnings("rawtypes") Map.Entry e : services.entrySet()) {
			curZusatzleistungen.add(e.getValue() + "x " + e.getKey());
		}
		return new ListAdapter<String>(curZusatzleistungen);
	}
	
	/**
	 * Sortiert die �bergebene Liste 
	 * @param list
	 * @return
	 */
	public List<IALeistung> getSortedLeistungList (List<IALeistung> list) {
		ZusatzLeistungComparatorA zusatzleistungComparator = new ZusatzLeistungComparatorA();
		Collections.sort(list, zusatzleistungComparator);
		return list;
	}
	
	/**
	 * liefert den Land- ListAdapter
	 * @param reservations
	 * @return ListAdapter<String>
	 */
	public ListAdapter<String> getCountryListAdapter(List<ILand> countries) {
		LinkedList<String> curCountries = new LinkedList<String>();
		CountryNameComparator countryComparator = new CountryNameComparator();
		Collections.sort(countries, countryComparator);
		
		for (ILand country : countries) {
			curCountries.add(country.getBezeichnung());
		}
		return new ListAdapter<String>(curCountries);
	}

	/**
	 * Konstruktor - initialisierung des Nummerformates.
	 */
	public Wrapper() {
		numberFormat = NumberFormat.getInstance();
		numberFormat.setMinimumIntegerDigits(3);
	}

	/**
	 * Der ReservationID Comparator sortiert die Reservierungen anhand der Reservierungsnummer.
	 */
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

	/**
	 * Der GuestName Comparator sortiert die Gaeste anhand des Nachnamen und Vornamen.
	 */
	public class GuestNameComparator implements Comparator<IGast> {

		@Override
		public int compare(IGast g1, IGast g2) {
			if (g1.getNachname() == g2.getNachname()) {
				return g1.getVorname().compareTo(g2.getNachname());
			}
			return g1.getNachname().compareTo(g2.getNachname());
		}
	}

	/**
	 * Der RoomNumber Comparator sortiert die Zimmer anhand der Kategorie- Bezeichnung und Zimmernummer.
	 */
	public class RoomNumberComparator implements Comparator<IZimmer> {

		@Override
		public int compare(IZimmer z1, IZimmer z2) {
			if (z1.getKategorie().getBezeichnung() ==z2.getKategorie().getBezeichnung()){
				return z1.getNummer().compareTo(z2.getNummer());
			}
			return z1.getKategorie().getBezeichnung().compareTo(z2.getKategorie().getBezeichnung());
		}
	}
	
	/**
	 * Der RoomNumber Comparator sortiert die Zimmer anhand der Kategorie- Bezeichnung und Zimmernummer.
	 */
	public class RoomNumberComparatorA implements Comparator<IAZimmer> {

		@Override
		public int compare(IAZimmer z1, IAZimmer z2) {
			if (z1.getAKategorie().getBezeichnung() ==z2.getAKategorie().getBezeichnung()){
				return z1.getNummer().compareTo(z2.getNummer());
			}
			return z1.getAKategorie().getBezeichnung().compareTo(z2.getAKategorie().getBezeichnung());
		}
	}
	
	
	/**
	 * Der CountryName Comparator sortiert die Laender anhand der Bezeichnung.
	 */
	public class CountryNameComparator implements Comparator<ILand> {

		@Override
		public int compare(ILand l1, ILand l2) {
			return l1.getBezeichnung().compareTo(l2.getBezeichnung());
		}
	}
	
	/**
	 * Der ZusatzLeistungComparator sortiert die Leistungen anhand der Bezeichnung.
	 *
	 */
	public class ZusatzLeistungComparatorA implements Comparator<IALeistung> {

		@Override
		public int compare(IALeistung arg0, IALeistung arg1) {
			return arg0.getBezeichnung().compareTo(arg1.getBezeichnung());
		}
	}
}
