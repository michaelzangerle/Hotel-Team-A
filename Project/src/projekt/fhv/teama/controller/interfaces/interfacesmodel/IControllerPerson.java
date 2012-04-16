package projekt.fhv.teama.controller.interfaces.interfacesmodel;

import java.sql.Date;

public interface IControllerPerson {
	public void setVorname(String vorname);
	public String getVorname();
	public void setNachname(String nachname);
	public String getNachname();
	public void setGeschlecht(char geschlelcht);
	public String getGeschlecht();
	public void setStrasse(String strasse);
	public String getStrasse();
	public void setOrt(String ort);
	public String getOrt();
	public void setPlz(String plz);
	public String getPlz();
	public void setGeburtsdatum(Date gebDat);
	public Date getGeburtsdatum();
	public void setTelefonnummer(String telNr);
	public String getTelefonnummer();
	public void setEmail(String email);
	public String getEmail();
	public void setBic(String bic);
	public String getBic();
	public void setIban(String iban);
	public String getIban();
	public void setKontonummer(String ktoNr);
	public String getKontonummer();
	public void setBlz(String blz);
	public String getBlz();
	public void setLand(ILand land);
	public ILand getLand();
}
