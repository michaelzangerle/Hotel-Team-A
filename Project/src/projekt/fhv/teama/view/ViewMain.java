package projekt.fhv.teama.view;

import java.awt.Dimension;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.*;


/**
 * Stellt das Hauptfenster für die Anwendung dar. Das gesamte UI wird über
 * eine BXML Beschreibung eingelesen und erstellt. Die einzelnen Properties
 * können via Annotation @BXML automatisch beim Deserialisieren instanziiert
 * werden.
 *
 * Der modulare Ansatz von Pivot mit BXML Includes erlaubt es in der Definitions-
 * Datei ViewMain.bxml include Files mit einzulesen und so den Aufbau der
 * Struktur dynamisch zu halten. Für die Architektur der Software ist vorgesehen,
 * die includes als UseCase Implementierungen einzubinden - daraus folgt ein sehr
 * flexibles und erweiterbares User Interface. 
 * 
 * Der Modulare Ansatz ist in dem BXML Files umgesetzt mit den include Dateien für den
 * Reservierungs und insbsondere den CheckIn Ablauf. (inc.checkInForm01.bxml...)
 * 
 * Aus terminlichen Überlegungen und Relevanz der Umsetzung für die Beurteilung 
 * wurde der Focus auf die Datenbank und Datenbankanbindung sowie Controller gesetzt,
 * weshalb die Umsetzung und das Testen des UI mehrheitlich hier in der ViewMain erfolgte.
 * 
 * Eine Aufteilung in die zughörige ViewCheckIn Klasse ist jedoch ohne großen Aufwand
 * möglich. Da auch das Framework Pivot diesen Ansatz vorsieht.
 *
 * @author Team A
 * @version 1.1
 */
public class ViewMain extends Window implements Application, Bindable {
	
	List<Component> checkInForms = new ArrayList<Component>();
	List<Component> textFields = new ArrayList<Component>();

	ViewController viewController = new ViewController();
	BXMLSerializer bxmlSerializer = new BXMLSerializer();
	
	private Window window = null;
	
	/**
	 * Controls für das Fenster festlegen. Die Felder werden bei Deserialisierung
	 * automatisch initialisiert.
	 * 
	 */

	
	/* Labels */
	@BXML Label lbReservationDetails;	@BXML Label lbLoginShow; @BXML Label smLBLastName;	@BXML Label smLBFirstName;	@BXML Label smLBGender; 
	@BXML Label smLBBirthdate;	@BXML Label smLBStreet;	@BXML Label smLBZip;	@BXML Label smLBCity;	@BXML Label smLBCountry;	@BXML Label smLBPhone;
	@BXML Label smLBMail;	@BXML Label smLBAccountNr;	@BXML Label smLBBankCodeNr; @BXML Label smLBIban; @BXML Label smLBBic; @BXML Label smLBArrival;
	@BXML Label smLBDeparture; @BXML Label smLBDepositType; @BXML Label smLBDepositNr; @BXML Label smLBTotalPrice; @BXML Label lbLoginName;
	
	/* Border Container = Forms */
	@BXML BoxPane mainContent;@BXML Border reservationForm01;@BXML Border checkInForm01;@BXML Border checkInForm02;@BXML Border checkInForm03;@BXML Border checkInForm04;
	@BXML Border occupationPreview;@BXML TabPane tabPLeftMain;
	
	
	/* Buttons */
	@BXML PushButton rf1PBtnCheckIn;
		
    
	@BXML TextInput tiLastName; @BXML TextInput tiFirstName; @BXML ButtonGroup bgGender; @BXML RadioButton rbMale; @BXML RadioButton rbFemale;
	@BXML TextInput tiStreet; @BXML TextInput tiCity; @BXML TextInput tiCountry;@BXML TextInput tiZip;@BXML TextInput tiPhone;@BXML TextInput tiMail;
	@BXML TextInput tiAccountNr;@BXML TextInput tiBankCodeNr;@BXML TextInput tiIban;@BXML TextInput tiBic;@BXML TextInput tiDepositNumber;
	
	@BXML Checkbox cbxShowAllRooms;
	
	@BXML PushButton cf1PBtnNext;@BXML PushButton cf2PBtnNext;@BXML	PushButton cf3PBtnNext;@BXML PushButton cf4PBtnFinish;@BXML PushButton cf1PBtnBack;
	@BXML PushButton cf2PBtnBack;@BXML PushButton cf3PBtnBack;@BXML PushButton cf4PBtnBack;@BXML PushButton cf1PBtnCancel;@BXML PushButton cf2PBtnCancel;
	@BXML PushButton cf3PBtnCancel;@BXML PushButton cf4PBtnCancel;

	
	/* ListViews, ListButtons and CalendarButtons */
	@BXML ListView lvAssignedRooms;@BXML ListView lvBookedRoomCategories;@BXML ListView lvReservationSearch;@BXML ListView lvArrivingSearch;@BXML ListView lvGuestSearch;
	@BXML ListButton lbtnGuests;@BXML ListButton lbtnAddresses;@BXML ListButton lbtnDepositType;@BXML CalendarButton cbBirthdate;@BXML CalendarButton cbArrival;
	@BXML CalendarButton cbDeparture;@BXML ListView smLVFinalRooms;@BXML ListView smLVHandedKeys;@BXML ListButton lbtnCountry;

	/* TextInputs, RadioButtons and Checkboxes */
	
	@BXML Label rf1LBResNr;@BXML TextInput rf1TIName;@BXML TextInput rf1TIStreet;@BXML TextInput rfTICity;@BXML TextInput rf1TICountry;@BXML TextInput rfTIZip;
	@BXML TextInput rf1TIPhone;@BXML TextInput rf1TIEMail;@BXML CalendarButton rf1CBArrival;@BXML CalendarButton rf1CBDeparture; @BXML TextInput tiReservationSearch;
	@BXML TextInput tiArrivingSearch; @BXML TextInput tiGuestSearch;
	 
	/* Labels */
	@BXML Label lbProgress01;@BXML Label lbProgress02;@BXML	Label lbProgress03;@BXML Label lbProgress04;
	
	
	/* Processbar */
	@BXML Border progress;@BXML Meter meter;
	
	@BXML BoxPane bpAssignedRooms;
	@BXML BoxPane bpRoomsSummary;

	/** Ende - Controls initialisieren *********************************************/
	
	
	/**
	 * Die Methode startup() wird vom Interface Application vorgeschrieben
	 * und stellt den Einstiegspunkt für die Pivot Andwendung dar. Über den
	 * BXML Serialisierer wird das zugehörige Object eingelesen. Da die ViewMain
	 * Klasse von Window erbt kann diese anschließend über window.open geöffnet
	 * werden.
	 * 
	 * Unsere Anwendung wird allerdings über ApplicationStartUp gestartet, weshalb
	 * diese methode nicht implementiert sein muss.
	 * 
	 * @see org.apache.pivot.wtk.Application#startup(org.apache.pivot.wtk.Display, org.apache.pivot.collections.Map)
	 */
	@Override
	public void startup(Display display, Map<String, String> properties)
			throws Exception {
		
//		window = (Window) bxmlSerializer.readObject(ViewLogin.class,
//				"ViewMain.bxml");
//		display.getHostWindow().setMinimumSize(new Dimension(1024,600));
//		window.open(display);
	}
	
	/** 
	 * Wird durch das Application Interface benötigt. Aufruf erfolgt, wenn eine "suspended"
	 * Anwendung wieder aufgenommen wird.
	 * 
	 * @see org.apache.pivot.wtk.Application#resume()
	 */
	@Override
	public void resume() throws Exception {
	}

	/**
	 * Wird ausgeführt, wenn die  Anwendung heruntergefahren werden soll
	 * 
	 * @see org.apache.pivot.wtk.Application#shutdown(boolean)
	 */
	@Override
	public boolean shutdown(boolean arg0) throws Exception {
		return false;
	}

	/**
	 * Damit ist es möglich eine Anwendung auf "suspended" zu setzen
	 * 
	 * @see org.apache.pivot.wtk.Application#suspend()
	 */
	@Override
	public void suspend() throws Exception {
	}
	
	/** In dieser Methode des Application Interfaces wird das Hauptfenster
	 *  initialisiert. Hier werden die Starteinstellungen der Darstellung
	 *  angegeben und eingelesen.
	 * 
	 * @see org.apache.pivot.beans.Bindable#initialize(org.apache.pivot.collections.Map, java.net.URL, org.apache.pivot.util.Resources)
	 */
	@Override
	public void initialize(Map<String, Object> arg0, URL arg1, Resources arg2) {
		
	    Locale.setDefault(Locale.ENGLISH);		
	
		/** Zustände zum Programmstart initialisieren *********************************/
		
		reservationForm01.setVisible(true);
		checkInForm01.setVisible(false);
		checkInForm02.setVisible(false);
		checkInForm03.setVisible(false);
		checkInForm04.setVisible(false);
		
		
		/** Ende - Zustände zum Programmstart initialisieren **************************/
	}
	
	/**
	 * Gibt alle TextInput Felder zurück. Damit kann sich der Controller die
	 * TextFelder als Liste holen und durcharbeiten.
	 * 
	 * @return Liste mit TextInput Components
	 */
	public List<TextInput> getAllCheckInTextFields () {
		List<TextInput> components = (List<TextInput>) new LinkedList<TextInput>();
		components.add(tiFirstName);
		components.add(tiLastName);
		components.add(tiAccountNr);
		components.add(tiBankCodeNr);
		components.add(tiBic);
		components.add(tiCity);
		components.add(tiDepositNumber);
		components.add(tiIban);
		components.add(tiMail);
		components.add(tiPhone);
		components.add(tiStreet);
		components.add(tiZip);
		return components;
	}
	
	/**
	 * Gibt alle für den CheckIn Vorgang wichtigen Labels an den
	 * Aufrufer zurück. Damit kann sich der CheckInController die
	 * Labels als Liste holen und durcharbeiten.
	 * 
	 * @return
	 */
	public List<Label> getAllCheckInLabels () {
		List<Label> components = new Vector<Label>();
		components.add(smLBLastName);
		components.add(smLBFirstName);
		components.add(smLBStreet);
		components.add(smLBZip);
		components.add(smLBCountry);
		components.add(smLBCity);
		components.add(smLBPhone);
		components.add(smLBMail);
		components.add(smLBAccountNr);
		components.add(smLBIban);
		components.add(smLBBic);
		components.add(smLBArrival);
		components.add(smLBDeparture);
		components.add(smLBDepositType);
		components.add(smLBDepositNr);
		components.add(smLBBankCodeNr);
		return components;
	}

	/**
	 * Hier folgen eine ganze Reihe von erstellten Listenern.
	 * Damit kann der Controller die bestehenden
	 * Componenten mit Listener versehen.
	 * 
	 * @return Component
	 */
	public ListView getLvReservationSearch() {
		return lvReservationSearch;
	}

	public void setLvReservationSearch(ListView lvReservationSearch) {
		this.lvReservationSearch = lvReservationSearch;
	}
	
	public void setLvReservationSearchListener(ListViewSelectionListener e) {
		lvReservationSearch.getListViewSelectionListeners().add(e);
	}
	
	public void setLvlvArrivingSearch(ListView lvArrivingSearch) {
		this.lvArrivingSearch = lvArrivingSearch;
	}

	public void setlvArrivingSearchListener(ListViewSelectionListener e) {
		lvArrivingSearch.getListViewSelectionListeners().add(e);
	}

	public void setlvGuestSearchListener(ListViewSelectionListener e) {
		lvGuestSearch.getListViewSelectionListeners().add(e);
	}
	
	public void setrf1PBtnCheckInListener(ButtonPressListener e) {
		rf1PBtnCheckIn.getButtonPressListeners().add(e);
	}
	
	public void setlbProgress01Listener (ComponentMouseButtonListener e) {
		lbProgress01.getComponentMouseButtonListeners().add(e);
	}
	
	public void setlbProgress02Listener (ComponentMouseButtonListener e) {
		lbProgress02.getComponentMouseButtonListeners().add(e);
	}
	
	public void setlbProgress03Listener (ComponentMouseButtonListener e) {
		lbProgress03.getComponentMouseButtonListeners().add(e);
	}
	
	public void setlbProgress04Listener (ComponentMouseButtonListener e) {
		lbProgress04.getComponentMouseButtonListeners().add(e);
	}
	
	public void setcf1PBtnNextListener (ButtonPressListener e) {
		cf1PBtnNext.getButtonPressListeners().add(e);
	}
	
	public void setcf2PBtnNextListener (ButtonPressListener e) {
		cf2PBtnNext.getButtonPressListeners().add(e);
	}
	
	public void setcf3PBtnNextListener (ButtonPressListener e) {
		cf3PBtnNext.getButtonPressListeners().add(e);
	}
	
	public void setcf4PBtnFinishListener (ButtonPressListener e) {
		cf4PBtnFinish.getButtonPressListeners().add(e);
	}
	
	public void setcf2PBtnBackListener(ButtonPressListener e) {
		cf2PBtnBack.getButtonPressListeners().add(e);
	}

	public void setcf3PBtnBackListener(ButtonPressListener e) {
		cf3PBtnBack.getButtonPressListeners().add(e);
	}
	
	public void setcf4PBtnBackListener(ButtonPressListener e) {
		cf4PBtnBack.getButtonPressListeners().add(e);
	}
	
	public void setlbtnGuestsListener (ListButtonSelectionListener e) {
		lbtnGuests.getListButtonSelectionListeners().add(e);
	}
	
	public void setlbtnAddressesListener(ListButtonSelectionListener e) {
		lbtnAddresses.getListButtonSelectionListeners().add(e);
	}
	
	public void setlvBookedRoomCategoriesListener(ListViewSelectionListener e) {
		lvBookedRoomCategories.getListViewSelectionListeners().add(e);
	}
	
	public void setlvAssignedRoomsListener(ListViewItemStateListener e) {
		lvAssignedRooms.getListViewItemStateListeners().add(e);
	}	
	
	public void setcbxShowAllRoomsListener(ButtonPressListener e) {
		cbxShowAllRooms.getButtonPressListeners().add(e);
	}
	
	public void setcbxShowAllRoomsListener(ButtonStateListener e) {
		cbxShowAllRooms.getButtonStateListeners().add(e);
	}

	public void settabPLeftMainListener(TabPaneSelectionListener e) {
		tabPLeftMain.getTabPaneSelectionListeners().add(e);
	}
}
