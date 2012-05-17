/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.data.model;

import roomanizer.teamb.service.integrate.IBHotel;

/**
 *
 * @author Florian
 */
public class Hotel implements IBHotel, IHotel {

    private Integer id;
    private String strasse;
    private String plz;
    private String ort;
    private String land;
    private String iban;
    private String bic;
    private String blz;
    private String knr;
    private String name;
    private String telefonnummer;
    private String faxnummer;
    private String chef;
    private String uid;
    private String fbn;
    private String email;
    private String rechnungen;

    public Hotel(Integer id, String strasse, String plz, String ort, String land, String iban, String bic, String blz, String knr, String name, String telefonnummer, String faxnummer, String chef, String uid, String fbn, String email) {
        this.id = id;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
        this.land = land;
        this.iban = iban;
        this.bic = bic;
        this.blz = blz;
        this.knr = knr;
        this.name = name;
        this.telefonnummer = telefonnummer;
        this.faxnummer = faxnummer;
        this.chef = chef;
        this.uid = uid;
        this.fbn = fbn;
        this.email = email;
        this.rechnungen = System.getProperty("user.home") + "//roomanizer//";
    }


	@Override
    public String getBic() {
        return bic;
    }

	@Override
    public void setBic(String bic) {
        this.bic = bic;
    }

	@Override
    public String getBlz() {
        return blz;
    }

	@Override
    public void setBlz(String blz) {
        this.blz = blz;
    }

	@Override
    public String getChef() {
        return chef;
    }

	@Override
    public void setChef(String chef) {
        this.chef = chef;
    }

	@Override
    public String getEmail() {
        return email;
    }

	@Override
    public void setEmail(String email) {
        this.email = email;
    }

	@Override
    public String getFbn() {
        return fbn;
    }

	@Override
    public void setFbn(String fbn) {
        this.fbn = fbn;
    }

	@Override
    public String getFaxnummer() {
        return faxnummer;
    }


	@Override
    public void setFaxnummer(String fnr) {
        this.faxnummer = fnr;
    }

	@Override
    public String getIban() {
        return iban;
    }


	@Override
    public void setIban(String iban) {
        this.iban = iban;
    }


	@Override
    public Integer getId() {
        return id;
    }

	@Override
    public void setId(Integer id) {
        this.id = id;
    }

	@Override
    public String getKontonummer() {
        return knr;
    }


	@Override
    public void setKontonummer(String knr) {
        this.knr = knr;
    }

	@Override
    public String getLand() {
        return land;
    }

	@Override
    public void setLand(String land) {
        this.land = land;
    }

	@Override
    public String getName() {
        return name;
    }

	@Override
    public void setName(String name) {
        this.name = name;
    }

	@Override
    public String getOrt() {
        return ort;
    }

	@Override
    public void setOrt(String ort) {
        this.ort = ort;
    }

	@Override
    public String getPlz() {
        return plz;
    }

	@Override
    public void setPlz(String plz) {
        this.plz = plz;
    }

	@Override
    public String getStrasse() {
        return strasse;
    }

	@Override
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

	@Override
    public String getTelefonummer() {
        return telefonnummer;
    }

	@Override
    public void setTelefonnummer(String tnr) {
        this.telefonnummer = tnr;
    }

	@Override
    public String getUid() {
        return uid;
    }

	@Override
    public void setUid(String uid) {
        this.uid = uid;
    }

	@Override
    public String getKnr() {
        return knr;
    }

	@Override
    public void setKnr(String knr) {
        this.knr = knr;
    }

	@Override
    public String getRechnungen() {
        return rechnungen;
    }

	@Override
    public void setRechnungen(String rechnungen) {
        this.rechnungen = rechnungen;
    }
}
