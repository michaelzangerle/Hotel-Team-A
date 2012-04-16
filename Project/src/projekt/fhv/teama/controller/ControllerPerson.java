package projekt.fhv.teama.controller;

import java.sql.Date;

import projekt.fhv.teama.controller.interfaces.IControllerPerson;
import projekt.fhv.teama.controller.interfaces.interfacesmodel.ILand;

public class ControllerPerson implements IControllerPerson {

	IControllerPerson controllerPerson=new ControllerPerson();
	
	private String vn;
	private String nn;
	private Character geschlecht;
	private String strasse;
	private String ort;

	private String plz;

	private Date gebDat;
	
	
	
	public ControllerPerson() {
		// TODO Auto-generated constructor stub
	
	}
	
	@Override
	public void setVorname(String vn) {
		this.vn = vn;
		

	}

	@Override
	public String getVorname() {
		return this.vn;
	}

	@Override
	public void setNachname(String nn) {
		this.nn = nn;
	}

	@Override
	public String getNachname() {
		return this.nn;
	}

	@Override
	public void setGeschlecht(Character geschlecht) {
		this.geschlecht = geschlecht;
		

	}

	@Override
	public Character getGeschlecht() {
		return this.geschlecht;
	}

	@Override
	public void setStrasse(String strasse) {
		this.strasse = strasse;

	}

	@Override
	public String getStrasse() {
		return this.strasse;
	}

	@Override
	public void setOrt(String ort) {
		this.ort = ort;
		// TODO Auto-generated method stub

	}

	@Override
	public String getOrt() {
		return this.ort;
	}

	@Override
	public void setPlz(String plz) {
		this.plz = plz;
		

	}

	@Override
	public String getPlz() {
		return this.plz;
	}

	@Override
	public void setGeburtsdatum(Date gebDat) {
		this.gebDat = gebDat;
		

	}

	@Override
	public Date getGeburtsdatum() {
		return this.gebDat;
	}

	@Override
	public void setTelefonnummer(String telNr) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTelefonnummer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBic(String bic) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getBic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIban(String iban) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getIban() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setKontonummer(String ktoNr) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getKontonummer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBlz(String blz) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getBlz() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLand(ILand land) {
		// TODO Auto-generated method stub

	}

	@Override
	public ILand getLand() {
		// TODO Auto-generated method stub
		return null;
	}

}
