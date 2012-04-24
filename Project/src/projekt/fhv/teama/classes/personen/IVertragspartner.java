package projekt.fhv.teama.classes.personen;

import java.util.Set;

import projekt.fhv.teama.classes.IKontingent;
import projekt.fhv.teama.classes.IModel;
import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.classes.zimmer.IReservierung;

public interface IVertragspartner extends IModel {
	public void setName(String name);
	public String getName();
	
	public void setTelefonNummer(String telefonnummer);
	public String getTelefonNummer();
	
	public void setEmail(String email);
	public String getEmail();
	
	public void setKontodaten(IKontodaten kontodaten);
	public IKontodaten getKontodaten();
	
	public void addAdresse(IAdresse adresse);
	public Set<IAdresse> getAdressen();
	public void removeAdresse(IAdresse adresse);
	public void setAdressen(Set<IAdresse> adresse);
	
	public Set<IKontingent> getKontingente();
	public void setKontingente(Set<IKontingent> kontingent);
	public void addKontingent(IKontingent kontingent);
	public void removeKontingent(IKontingent kontingent);
	
	public Set<IReservierung> getReservierungen();
	public void setReservierungen(Set<IReservierung> reservierungen);
	public void addReservierung(IReservierung reservierung);
	public void removeReservierung(IReservierung reservierung);
	
	public IVertragspartnertyp getTyp();
	public void setTyp(IVertragspartnertyp typ);
}
