package projekt.fhv.teama.controller.usecasecontroller;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import projekt.fhv.teama.classes.Aufenthalt;
import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IReservierungsOption;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.classes.zimmer.Zimmer;
import projekt.fhv.teama.controller.ControllerReservierung;
import projekt.fhv.teama.controller.interfaces.IControllerAdresse;
import projekt.fhv.teama.controller.interfaces.IControllerAufenthalt;
import projekt.fhv.teama.controller.interfaces.IControllerGast;
import projekt.fhv.teama.controller.interfaces.IControllerKategorie;
import projekt.fhv.teama.controller.interfaces.IControllerKontodaten;
import projekt.fhv.teama.controller.interfaces.IControllerPfandTyp;
import projekt.fhv.teama.controller.interfaces.IControllerReservierung;
import projekt.fhv.teama.controller.interfaces.IControllerTeilreservierung;
import projekt.fhv.teama.controller.interfaces.IControllerZimmer;
import projekt.fhv.teama.controller.interfaces.IControllerZimmerstatus;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerCheckIn;
import projekt.fhv.teama.hibernate.dao.zimmer.IReservierungDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class ControllerCheckIn implements IControllerCheckIn {
	
	
	IControllerReservierung controllerReservierung;
	IControllerAufenthalt controllerAufenthalt;
	IControllerGast controllerGast;
	IControllerTeilreservierung controllerTeilreservierung;
	IControllerKategorie controllerKategorie;
	IControllerPfandTyp controllerPfandtyp;
	IControllerZimmer controllerZimmer;
	IControllerZimmerstatus controllerZimmerstatus;
	IControllerKontodaten controllerKontodaten;
	IControllerAdresse controllerAdresse;
	
	
	IAufenthalt aufenthalt=new Aufenthalt();
	
	//Variablen
	private boolean schluessel=false;
	private float preis=0.0f;
	private List<IZimmer> zimmer=new Vector<IZimmer>();
	private String pfandnummer;
	private List<IZimmer> zimmerFuerAktuellenAufenthalt;

	/**
	 * 
	 * Konstruktor
	 */
	public ControllerCheckIn() {
		
		controllerReservierung=new ControllerReservierung();
	}
	
	
	
	public List<IReservierung> getAllReservierungen()
	{
		return controllerReservierung.getAllReservierungen();
	}
	
	public void setAktuelleReservierung(IReservierung reservierung) 
	{
		controllerReservierung.setAktuelleReservierung(reservierung);
	}
	
	public IReservierung getAktuelleReservierung()
	{
		return controllerReservierung.getAktuelleReservierung();
	}
	
	
	public void setGast(IGast gast)
	{
		controllerGast.setAktuellGast(gast);
	}
	
	public IGast getGast()
	{
		return controllerGast.getAktuellGast();
	}
	
	
	
	//Änderungen am Gast
	
	public void setVorname(String vorname)
	{
		controllerGast.setVorname(vorname);
	}
	public void setNachname(String nachname)
	{
		controllerGast.setNachname(nachname);
		
	}
	public void setGeschlecht(char geschlecht)
	{
		controllerGast.setGeschlecht(geschlecht);
	}
	public void setGeburtsdatum(Date geburtsdatum)
	{
		controllerGast.setGeburtsdatum(geburtsdatum);
	}
	public void setEmail(String email)
	{
		controllerGast.setEmail(email);
	}
	public void setKontodaten(String kontonummer,String blz,String iban,String bic)
	{
		controllerGast.setKontodaten(kontonummer,blz,iban,bic);
	}
	public void setTelefonnummer(String telefonnummer)
	{
		controllerGast.setTelefonnummer(telefonnummer);
	}
	public void setNummer(String nummer)
	{
		controllerGast.setNummer(nummer);
	}
	public void setZimmer(IZimmer zimmer)
	{
		controllerGast.setZimmer(zimmer);
	}
	public void addAdresse(IAdresse adresse)
	{
		controllerGast.addAdresse(adresse);
	}
	public void removeAdresse(IAdresse adresse)
	{
		controllerGast.removeAdresse(adresse);
	}
	


	public void setVon(Date date)
	{
		controllerReservierung.setVon( date);
	}
	
	public void setBis(Date date)
	{
		controllerReservierung.setBis(date);
		
	}
	
	public void setPreis(float preis)
	{
		this.preis=preis;
	}
	
	public void setSchluessel(boolean schluesel)
	{
		this.schluessel=schluesel;
	}



	//Pfand
	
	public void setPfandNr(String pfandnummer)
	{
		this.pfandnummer=pfandnummer;
	}
	
	public List<IPfandtyp> getPfandtyps() throws NoDatabaseEntryFoundException
	{
		return controllerPfandtyp.getPfandtyps();
	}
	
	public void setAktuellerPfandTyp(IPfandtyp pfandtyp)
	{
		controllerPfandtyp.setAktuellerPfandTyp(pfandtyp);
	}
	public IPfandtyp getAktuellerPfandTyp()
	{
		return controllerPfandtyp.getAktuellerPFandtyp();
	}
	

	public List<IZimmer> getVerfügbareZimmerFürGegebeneKategorie(IKategorie k)throws NoDatabaseEntryFoundException
	{
		return controllerZimmer.getZimmerFürGegebeneKategorie(k);
	}
	
	
	
	
	public void saveAufenthalt(float preis,Date von,Date bis,boolean schluessel,IGast gast,IZimmer zimmer,IPfandtyp pfand,String pfandnummer)
	{
	
			controllerKontodaten.save(gast.getKontodaten());
			controllerZimmer.save(zimmer);
			for (IAdresse adr : gast.getAdressen()) {
				controllerAdresse.save(adr);
			}
			controllerAufenthalt.create(preis, von, bis, schluessel, gast, zimmer,pfand,pfandnummer);
		
	}
	

	
}